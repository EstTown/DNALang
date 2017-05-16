package AST;

import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.googlejavaformat.java.Formatter;

import java.io.*;

public class CodeGenerator extends Visitor {

	private String codeDecl = "";
	private String codeMain = "";
	private String codeFuncs = "";

	public String codeAsFunc = "";
	public String codeCompFunc = "";
	public String codeRevFunc = "";
	public String codeLenFunc = "";
	public String codePosFunc = "";
	public String codeCountFunc = "";
	public String codeContainFunc = "";
	public String codeRemoveFunc = "";
	public String codeGetFunc = "";

	private Boolean infunction = false;

	private void emitToDecl(String str){
		codeDecl += str;
	}
	private void emitToMain(String str){
		codeMain += str;
	}
	private void emitToFunction(String str){
		codeFuncs += str;
	}

	public void makeFile(){
	    //Assemble parts of java file
        String code = "";
        code += "public class Main{";
        code += this.codeDecl;
        code += "public static void main(String[] args){";
        code += this.codeMain;
        code += "}";
        code += this.codeFuncs;
        code += "}";

        //Make it not look like shit - powered by Google
        String formattedSource = "";
        try {
            formattedSource = new Formatter().formatSource(code);
        } catch (Exception ex) {
            System.out.println("Google's Java formatter done fucked up.");
        }

        //Write code to file
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("src/Output/out.java"), "utf-8"));
            writer.write(formattedSource);
        } catch (Exception ex) {
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        //Eat cake
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

	@Override
	public void Visit(DeclareFunctionNode declareFunctionNode)
	{
		infunction = true;
		//Return type
		emitToFunction(declareFunctionNode.content.toString());
		emitToFunction(" ");
		//Identifier
		emitToFunction(declareFunctionNode.functionName);
		emitToFunction("(");
		declareFunctionNode.getLeftmostchild().Accept(this);
		getNext(declareFunctionNode.getLeftmostchild());
		//declareFunctionNode.getLeftmostchild().getRightsibling().Accept(this);
		infunction = false;
	}

	@Override
	public void Visit(DeclareVarNode varNode)
	{
		if (varNode.content != null) {
			if (infunction)
				emitToFunction(varNode.content + " ");
			else
				System.out.print(varNode.content + " ");
		}

		if (infunction)
			emitToFunction(varNode.spelling);
		else
			System.out.print(varNode.spelling);

		if (varNode.getLeftmostchild() != null)
			varNode.getLeftmostchild().Accept(this);

		if (varNode.getParent().getClass().getSimpleName().equals("BlockNode") && infunction)
			emitToFunction(";");
		else if	(infunction && !varNode.getRightsibling().getClass().getSimpleName().equals("BlockNode"))
			emitToFunction(", ");
		else
			System.out.println();
	}

	@Override
	public void Visit(DeclareArrayNode arrayNode){
		System.out.print(arrayNode.content);
		System.out.print("[");
		arrayNode.getLeftmostchild().Accept(this);
		System.out.print("];");
	}

	@Override
	public void Visit(BlockNode blockNode)
	{
		if (infunction){
			emitToFunction(")");
			emitToFunction("{");
			blockNode.getLeftmostchild().Accept(this);
			blockNodeHelper(blockNode.getLeftmostchild());
			emitToFunction("}");
		}
		else {
			System.out.print("{");
			blockNode.getLeftmostchild().Accept(this);
			blockNodeHelper(blockNode.getLeftmostchild());
			System.out.print("}");
		}
	}

	private void blockNodeHelper(BaseNode node)
	{
		if (node.getRightsibling() != null)
		{
			node.getRightsibling().Accept(this);
			blockNodeHelper(node.getRightsibling());
		}
	}

	@Override
	public void Visit(AssignCommandNode assignCommandNode)
	{
		//Identifier and equal symbol
		if (!assignCommandNode.getParent().getClass().getSimpleName().equals("DeclareVarNode"))
			assignCommandNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" = ");
		else
			System.out.print(" = ");
		//Right hand expression
		assignCommandNode.getLeftmostchild().getRightsibling().Accept(this);

		if (assignCommandNode.getParent().getClass().getSimpleName().equals("ForCommandNode")){
			System.out.print("; ");
		}
		else
			System.out.print(";");
	}

	@Override
	public void Visit(BreakCommandNode breakCommandNode)
	{
		System.out.print("break;");
	}

	@Override
	public void Visit(CallCommandNode callCommandNode)
	{
		callCommandNode.getLeftmostchild().Accept(this);
		System.out.print("(");
		callCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(");");
	}

	@Override
	public void Visit(ForCommandNode forCommandNode)
	{
		System.out.print("for (");
		forCommandNode.getLeftmostchild().Accept(this);
		forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print("; ");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
		System.out.print(")");
		forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{
		System.out.println();
		System.out.print("if (");
		//bool expression
		ifCommandNode.getLeftmostchild().Accept(this);
		System.out.print(")");

		//block
		if (ifCommandNode.getLeftmostchild().getRightsibling() != null)
			ifCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(IfElseCommandNode ifElseCommandNode)
	{
		System.out.println();
		System.out.print("if (");
		//bool expression
		ifElseCommandNode.getLeftmostchild().Accept(this);
		System.out.print(")");
		//block1
		getNext(ifElseCommandNode.getLeftmostchild().getRightsibling());
		System.out.print("else");
		//block2
		ifElseCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		System.out.print("print(");
		printCommandNode.getLeftmostchild().Accept(this);
		System.out.print(");");
	}

	@Override
	public void Visit(ReturnCommandNode returnCommandNode)
	{
		if (infunction) {
			emitToFunction("return ");
			returnCommandNode.getLeftmostchild().Accept(this);
			emitToFunction(";");
		}
		/*
		System.out.print("return");
		if (returnCommandNode.getLeftmostchild() != null) {
			System.out.print(" ");
			returnCommandNode.getLeftmostchild().Accept(this);
		}
		System.out.print("; \n");
		*/
	}

	@Override
	public void Visit(WhileCommandNode whileCommandNode)
	{
		if (infunction){
			emitToFunction("while (");
			whileCommandNode.getLeftmostchild().Accept(this);
			whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
/*
		System.out.println();
		System.out.print("while (");
		whileCommandNode.getLeftmostchild().Accept(this);
		whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		*/
	}

	@Override
	public void Visit(AminoLiteralNode aminoLiteralNode)
	{
		System.out.print(aminoLiteralNode.content);
	}

	@Override
	public void Visit(BoolLiteralNode boolLiteralNode)
	{
		System.out.print(boolLiteralNode.content);
	}

	@Override
	public void Visit(CodonLiteralNode codonLiteralNode)
	{
		System.out.print(codonLiteralNode.content);
	}

	@Override
	public void Visit(DNALiteralNode dnaLiteralNode)
	{
		System.out.print(dnaLiteralNode.content);
	}

	@Override
	public void Visit(IdentifierNode idNode)
	{
		if (infunction)
			emitToFunction(idNode.content.toString());
		//System.out.print(idNode.content);
	}

	@Override
	public void Visit(IntegerLiteralNode intNode)
	{
		if (infunction)
			emitToFunction(intNode.content.toString());
		else
			System.out.print(intNode.content);
	}

	@Override
	public void Visit(RNALiteratalNode rnaLiteratalNode)
	{
		System.out.print(rnaLiteratalNode.content);
	}

	@Override
	public void Visit(AndNode andNode)
	{
		andNode.getLeftmostchild().Accept(this);
		//System.out.print(" && ");
		if (infunction)
			emitToFunction(" && ");
		andNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ComparisonNode comparisonNode)
	{
		comparisonNode.getLeftmostchild().Accept(this);
		//System.out.print(" == ");
		if (infunction)
			emitToFunction(" == ");
		comparisonNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterOrEqualNode greaterOrEqualNode)
	{
		greaterOrEqualNode.getLeftmostchild().Accept(this);
		//System.out.print(" >= ");
		if (infunction)
			emitToFunction(" >= ");
		greaterOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterThanNode greaterThanNode)
	{
		greaterThanNode.getLeftmostchild().Accept(this);
		//System.out.print(" > ");
		if (infunction)
			emitToFunction(" > ");
		greaterThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessOrEqualNode lessOrEqualNode)
	{
		lessOrEqualNode.getLeftmostchild().Accept(this);
		//System.out.print(" <= ");
		if (infunction)
			emitToFunction(" <= ");
		lessOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessThanNode lessThanNode)
	{
		lessThanNode.getLeftmostchild().Accept(this);
		//System.out.print(" < ");
		if (infunction)
			emitToFunction(" < ");
		lessThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ModNode modNode)
	{
		modNode.getLeftmostchild().Accept(this);
		//System.out.print(" % ");
		if (infunction)
			emitToFunction(" % ");
		modNode.getLeftmostchild().getRightsibling().Accept(this);
		System.out.print(";");
	}

	@Override
	public void Visit(NotNode notNode){
		//System.out.print("!");
		if (infunction)
			emitToFunction("!");
		notNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		//System.out.print(" != ");
		if (infunction)
			emitToFunction(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(EqualNode equalNode)
	{
		equalNode.getLeftmostchild().Accept(this);
		//System.out.print(" == ");
		if (infunction)
			emitToFunction(" == ");
		equalNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
		//System.out.print(" || ");
		if (infunction)
			emitToFunction(" || ");
		getNextRightSibling(orNode.getLeftmostchild()).Accept(this);
	}

	@Override
	public void Visit(PlusNode plusNode)
	{
		if (infunction){
			emitToFunction("(");
			plusNode.getLeftmostchild().Accept(this);
			emitToFunction(" + ");
			getNextRightSibling(plusNode.getLeftmostchild()).Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(MinusNode minusNode)
	{
		if (infunction) {
			emitToFunction("(");
			minusNode.getLeftmostchild().Accept(this);
			emitToFunction(" - ");
			getNextRightSibling(minusNode.getLeftmostchild()).Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(MultNode multNode)
	{
		if (infunction) {
			emitToFunction("(");
			multNode.getLeftmostchild().Accept(this);
			emitToFunction(" * ");
			getNextRightSibling(multNode.getLeftmostchild()).Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(DivNode divNode)
	{
		if (infunction) {
			emitToFunction("(");
			divNode.getLeftmostchild().Accept(this);
			emitToFunction(" / ");
			getNextRightSibling(divNode.getLeftmostchild()).Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(ComplementaryNode complementaryNode){
		if (infunction) {
			emitToFunction("comp: ");
			emitToFunction("(");
			complementaryNode.getLeftmostchild().Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(ReverseNode reverseNode){
		if (infunction) {
			emitToFunction("rev: ");
			emitToFunction("(");
			reverseNode.getLeftmostchild().Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(LengthNode lengthNode){
		if (infunction) {
			emitToFunction("len: ");
			emitToFunction("(");
			lengthNode.getLeftmostchild().Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(ContainsNode containsNode){
		if (infunction){
			emitToFunction("(");
			containsNode.getLeftmostchild().Accept(this);
			emitToFunction(" contains: ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(CountNode countNode){
		if (infunction) {
			emitToFunction("count ");
			countNode.getLeftmostchild().Accept(this);
			emitToFunction(" in ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(";");
		}
	}

	@Override
	public void Visit(PositionNode positionNode){
		if (infunction) {
			emitToFunction("position of ");
			positionNode.getLeftmostchild().Accept(this);
			emitToFunction(" in ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(";");
		}
	}

	@Override
	public void Visit(RemoveNode removeNode){
		if (infunction) {
			emitToFunction("remove ");
			removeNode.getLeftmostchild().Accept(this);
			emitToFunction(" from ");
			removeNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(";");
		}
	}

	@Override
	public void Visit(ConvertNode convertNode){
		if (infunction) {
			convertNode.getLeftmostchild().Accept(this);
			emitToFunction(" as ");
			emitToFunction(convertNode.content.toString());
		}

	}

}