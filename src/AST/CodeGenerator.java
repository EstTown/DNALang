package AST;

import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;

import java.io.*;

public class CodeGenerator extends Visitor {

	public String codeMain = "";
	public String codeFuncs = "";

	public String codeAsFunc = "";
	public String codeCompFunc = "";
	public String codeRevFunc = "";
	public String codeLenFunc = "";
	public String codePosFunc = "";
	public String codeCountFunc = "";
	public String codeContainFunc = "";
	public String codeRemoveFunc = "";
	public String codeGetFunc = "";

	public void emit(String str){
		codeMain += str;
	}

	public void emitFunction(String str){
		codeFuncs += str;
	}


	public void makeFile(){
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("src/Output/out.java"), "utf-8"));

			writer.write("public class Main\n{\npublic static void main(String[] args)\n{\n");
			writer.write(this.codeMain);
			writer.write("}\n " + codeFuncs + "\n}");
		} catch (IOException ex) {
			// report
		} finally {
			try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}

	@Override
	public void Visit(ProgNode progNode)
	{
		progNode.getLeftmostchild().Accept(this); //this visits child node. Dunno how work
		getNext(progNode.getLeftmostchild());
	}

	private void getNext(BaseNode node)
	{
		if (node.getRightsibling() != null) {
			node.getRightsibling().Accept(this);
			getNext(node.getRightsibling());
		}
	}

	private BaseNode getNextRightSibling(BaseNode node)
	{
		if (node.getRightsibling() != null) {
			return node.getRightsibling();
		}
		else
			return getNextRightSibling(node.getRightsibling());
	}

	//region Block Nodes
	@Override
	public void Visit(BlockNode blockNode)
	{
		if (blockNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode")){
			emitFunction("{\n");
			blockNode.getLeftmostchild().Accept(this);
			blockNodeHelper(blockNode.getLeftmostchild());
			emitFunction("\n}");
		}
		else {
			emit("{\n");
			blockNode.getLeftmostchild().Accept(this);
			blockNodeHelper(blockNode.getLeftmostchild());
			emit("\n}");
		}
	}

	private void blockNodeHelper(BaseNode node)
	{
		if (node.getRightsibling()!= null)
		{
			node.getRightsibling().Accept(this);
			blockNodeHelper(node.getRightsibling());
		}
	}

	//endregion

	//region DeclareFunction Nodes
	@Override
	public void Visit(DeclareFunctionNode declareFunctionNode)
	{
		//Return type
		//emit("public ");
		emitFunction(declareFunctionNode.content.toString());
		emitFunction(" ");
		//Identifier
		declareFunctionNode.getLeftmostchild().Accept(this);
		emitFunction("(");
		getNext(declareFunctionNode.getLeftmostchild().getRightsibling());
		emitFunction(")");
		declareFunctionNode.getLeftmostchild().getRightsibling().Accept(this);
		//declareFunctionNode.getLeftmostchild().getRightsibling()
	}
	//endregion

	//region DeclareVar Nodes
	@Override
	public void Visit(DeclareVarNode varNode)
	{
		//Type
		if (varNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode") ||
				varNode.getParent().getParent().getClass().getSimpleName().equals("DeclareFunctionNode")) {
			emitFunction(varNode.content + " ");
			emitFunction(varNode.spelling);
		}
		else {
			emit(varNode.content + " ");
			emit(varNode.spelling);
		}

		if (varNode.getParent().getClass().getSimpleName().equals("BlockNode")){
			if (varNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode"))
			emit(";\n");
		}
		else if (varNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode")){
			if (varNode.getRightsibling() != null)
				emitFunction(", ");
		}
		else
			emit("\n");
	}
	//endregion

	//region Command Nodes
	@Override
	public void Visit(AssignCommandNode assignCommandNode)
	{
		//Identifier and equal symbol
		assignCommandNode.getLeftmostchild().Accept(this);
		emit(" = ");
		//Right hand expression
		assignCommandNode.getLeftmostchild().getRightsibling().Accept(this);

		if (assignCommandNode.getParent().getClass().getSimpleName().equals("ForCommandNode")){
			emit("; ");
		}
		else
			emit(";\n");
	}

	@Override
	public void Visit(BreakCommandNode breakCommandNode)
	{
		emit("break;");
	}

	@Override
	public void Visit(CallCommandNode callCommandNode)
	{
		callCommandNode.getLeftmostchild().Accept(this);
		emit("(");
		callCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		emit("); \n");
	}

	@Override
	public void Visit(ForCommandNode forCommandNode)
	{
		emit("for (");
		forCommandNode.getLeftmostchild().Accept(this);
		forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		emit("; ");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
		emit(")");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{
		emit("\n");
		emit("if (");
		//bool expression
		ifCommandNode.getLeftmostchild().Accept(this);
		emit(")");

		//block
		if (ifCommandNode.getLeftmostchild().getRightsibling() != null)
			ifCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfElseCommandNode ifElseCommandNode)
	{
		emit("\n");
		emit("if (");
		//bool expression
		ifElseCommandNode.getLeftmostchild().Accept(this);
		emit(") \n");
		//block1
		getNext(ifElseCommandNode.getLeftmostchild().getRightsibling());
		emit("\nelse\n");
		//block2
		ifElseCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		emit("System.out.println(");
		printCommandNode.getLeftmostchild().Accept(this);
		emit("); \n");
	}

	@Override
	public void Visit(ReturnCommandNode returnCommandNode)
	{
		emit("return");
		if (returnCommandNode.getLeftmostchild() != null) {
			emit(" ");
			returnCommandNode.getLeftmostchild().Accept(this);
		}
		emit("; \n");
	}

	@Override
	public void Visit(WhileCommandNode whileCommandNode)
	{
		emit("\n");
		emit("while (");
		whileCommandNode.getLeftmostchild().Accept(this);
		whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}
	//endregion

	//region Terminal Nodes
	@Override
	public void Visit(AminoLiteralNode aminoLiteralNode)
	{
		emit(aminoLiteralNode.content.toString());
	}

	@Override
	public void Visit(BoolLiteralNode boolLiteralNode)
	{
		emit(boolLiteralNode.content.toString());
	}

	@Override
	public void Visit(CodonLiteralNode codonLiteralNode)
	{
		emit(codonLiteralNode.content.toString());
	}

	@Override
	public void Visit(DNALiteralNode dnaLiteralNode)
	{
		emit(dnaLiteralNode.content.toString());
	}

	@Override
	public void Visit(IdentifierNode idNode)
	{
		if (idNode.getParent().getClass().getSimpleName().equals("DeclareFunctionNode"))
			emitFunction(idNode.content.toString());
		else
			emit(idNode.content.toString());
	}

	@Override
	public void Visit(IntegerLiteralNode intNode)
	{
		emit(intNode.content.toString());
	}

	@Override
	public void Visit(RNALiteratalNode rnaLiteratalNode)
	{
		emit(rnaLiteratalNode.content.toString());
	}
	//endregion

	//region Expression Nodes
	@Override
	public void Visit(AndNode andNode)
	{
		andNode.getLeftmostchild().Accept(this);
		emit(" && ");
		andNode.getLeftmostchild().getRightsibling().Accept(this);
	}


	@Override
	public void Visit(ComparisonNode comparisonNode)
	{
		comparisonNode.getLeftmostchild().Accept(this);
		emit(" == ");
		comparisonNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterOrEqualNode greaterOrEqualNode)
	{
		greaterOrEqualNode.getLeftmostchild().Accept(this);
		emit(" >= ");
		greaterOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterThanNode greaterThanNode)
	{
		greaterThanNode.getLeftmostchild().Accept(this);
		emit(" > ");
		greaterThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessOrEqualNode lessOrEqualNode)
	{
		lessOrEqualNode.getLeftmostchild().Accept(this);
		emit(" <= ");
		lessOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessThanNode lessThanNode)
	{
		lessThanNode.getLeftmostchild().Accept(this);
		emit(" < ");
		lessThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ModNode modNode)
	{
		modNode.getLeftmostchild().Accept(this);
		emit(" % ");
		modNode.getLeftmostchild().getRightsibling().Accept(this);
		emit(";\n");
	}

	@Override
	public void Visit(NotNode notNode){
		emit("!");
		notNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		emit(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(EqualNode equalNode)
	{
		equalNode.getLeftmostchild().Accept(this);
		emit(" == ");
		equalNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
		emit(" || ");
		getNextRightSibling(orNode.getLeftmostchild()).Accept(this);
	}

	@Override
	public void Visit(PlusNode plusNode)
	{
		emit("(");
		plusNode.getLeftmostchild().Accept(this);
		emit(" + ");
		//plusNode.getLeftmostchild().getRightsibling().Accept(this);
		getNextRightSibling(plusNode.getLeftmostchild()).Accept(this);
		//System.out.print(";\n");
		emit(")");
	}

	@Override
	public void Visit(MinusNode minusNode)
	{
		emit("(");
		minusNode.getLeftmostchild().Accept(this);
		emit(" - ");
		getNextRightSibling(minusNode.getLeftmostchild()).Accept(this);
		emit(")");
	}

	@Override
	public void Visit(MultNode multNode)
	{
		emit("(");
		multNode.getLeftmostchild().Accept(this);
		emit(" * ");
		getNextRightSibling(multNode.getLeftmostchild()).Accept(this);
		emit(")");
	}

	@Override
	public void Visit(DivNode divNode)
	{
		emit("(");
		divNode.getLeftmostchild().Accept(this);
		emit(" / ");
		getNextRightSibling(divNode.getLeftmostchild()).Accept(this);
		emit(")");
	}

	@Override
	public void Visit(ComplementaryNode complementaryNode){
		emit("comp: ");
		complementaryNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(ReverseNode reverseNode){
		emit("rev: ");
		reverseNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(LengthNode lengthNode){
		emit("len: ");
		lengthNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(ContainsNode containsNode){
		containsNode.getLeftmostchild().Accept(this);
		emit(" contains: ");
		containsNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(CountNode countNode){
		emit("count ");
		countNode.getLeftmostchild().Accept(this);
		emit(" in ");
		countNode.getLeftmostchild().getRightsibling().Accept(this);
		emit(";\n");
	}

	@Override
	public void Visit(PositionNode positionNode){
		emit("position of ");
		positionNode.getLeftmostchild().Accept(this);
		emit(" in ");
		positionNode.getLeftmostchild().getRightsibling().Accept(this);
		emit(";\n");
	}

	@Override
	public void Visit(RemoveNode removeNode){
		emit("remove ");
		removeNode.getLeftmostchild().Accept(this);
		emit(" from ");
		removeNode.getLeftmostchild().getRightsibling().Accept(this);
		emit(";\n");
	}

	@Override
	public void Visit(ConvertNode convertNode){
		convertNode.getLeftmostchild().Accept(this);
		emit(" as ");
		System.out.print(convertNode.content);

	}



	//endregion
}