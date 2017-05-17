package AST;

import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import com.google.googlejavaformat.java.Formatter;

import java.io.*;

public class CodeGenerator extends Visitor {

    //Parts
	private String codeDecl = "";
	private String codeMain = "";
	private String codeFuncs = "";

	//Custom methods - (always included in compiled java-file)
	private String codeAsFunc = "";
	private String codeCompFunc = "";
	private String codeRevFunc = "";
	private String codeLenFunc = "";
	private String codePosFunc = "";
	private String codeCountFunc = "";
	private String codeContainFunc = "";
	private String codeRemoveFunc = "";
	private String codeGetFunc = "";

	//Local variables
	private Boolean infunction = false;
	private Boolean indecl = true;
	private String ps = "public static "; //snippet, likely used in many places

    //Emitters - just a simpler way to add stuff
	private void emitToDecl(String str){
		codeDecl += str;
	}
	private void emitToMain(String str){
		codeMain += str;
	}
	private void emitToFunction(String str){
		codeFuncs += str;
	}

	//Putting it all together
	public void makeFile(){
	    //Step 1
	    //Assemble parts of java file
        String code = "";
        code += "package Output;";
        code += "import java.util.*;";
        code += "public class out{";
        code += codeDecl;
        code += "public static void main(String[] args){";
        code += codeMain;
        code += "}";
        code += codeFuncs;
        code += "}";

        //Step 2
        //Make it not look like shit - powered by Google
        String formattedSource = "";
        try {
            formattedSource = new Formatter().formatSource(code);
        } catch (Exception ex) {
            System.out.println("Google's Java formatter done fucked up." + ex.getMessage());
        }

		System.out.println(code);

        //Step 3
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

        //Step 4
        //???

        //Step 5
        //Profit
	}

	//======================================

	@Override
	public void Visit(ProgNode progNode)
	{
		visitChildren(progNode);
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
		indecl = false;
		infunction = true;
		//Return type
		emitToFunction("public ");
		emitToFunction(declareFunctionNode.content.toString());
		emitToFunction(" ");
		//Identifier
		emitToFunction(declareFunctionNode.functionName);
		emitToFunction("(");
		//Params & block
		visitChildren(declareFunctionNode);
		infunction = false;
	}

	@Override
	public void Visit(DeclareVarNode varNode)
	{
		//Convert our types to String
		String tmp = varNode.content.toString();
		if (tmp.equals("dna") || tmp.equals("rna") || tmp.equals("protein") ||
				tmp.equals("codon"))
			tmp = "String";


		if (varNode.content != null) {
			if (infunction)
				emitToFunction(tmp + " ");
			else if (indecl)
				emitToDecl(ps + tmp + " ");
			else
				emitToMain(tmp + " ");
		}

		if (infunction)
			emitToFunction(varNode.spelling);
		else if (indecl)
			emitToDecl(varNode.spelling);
		else
			emitToMain(varNode.spelling);

		if (varNode.getLeftmostchild() != null)
			varNode.getLeftmostchild().Accept(this);

		if (varNode.getParent().getClass().getSimpleName().equals("BlockNode") && infunction)
			emitToFunction("");
		else if	(infunction && !varNode.getRightsibling().getClass().getSimpleName().equals("BlockNode"))
			emitToFunction(", ");

		if (!infunction && indecl)
			emitToDecl(";");

	}

	@Override
	public void Visit(DeclareArrayNode arrayNode){
	}

	@Override
	public void Visit(BlockNode blockNode)
	{
		if (infunction){
			emitToFunction(")");
			emitToFunction("{");
			visitChildren(blockNode);
			emitToFunction("}");
		}
		else{
			emitToMain(")");
			emitToMain("{");
			visitChildren(blockNode);
			emitToMain("}");
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
		else if (indecl)
			emitToDecl(" = ");
		else
			emitToMain(" = ");
		//Right hand expression
		assignCommandNode.getLeftmostchild().getRightsibling().Accept(this);

		if (infunction)
			emitToFunction(";");
		else if (!indecl)
			emitToMain(";");
	}

	@Override
	public void Visit(BreakCommandNode breakCommandNode)
	{
		if (infunction)
			emitToFunction("break;");
		else
			emitToMain("break;");
	}

	@Override
	public void Visit(CallCommandNode callCommandNode)
	{

	}

	@Override
	public void Visit(ForCommandNode forCommandNode)
	{

	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{
		if (infunction){
			emitToFunction("if (");
			visitChildren(ifCommandNode);
		}
		else {
			emitToMain("if (");
			visitChildren(ifCommandNode);
		}
	}

	@Override
	public void Visit(IfElseCommandNode ifElseCommandNode)
	{

	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		if (infunction)
			emitToFunction("System.out.println(");
		else
			emitToMain("System.out.println(");

		visitChildren(printCommandNode);

		if (infunction)
			emitToFunction(");");
		else
			emitToMain(");");
	}

	@Override
	public void Visit(ReturnCommandNode returnCommandNode)
	{
		if (infunction) {
			emitToFunction("return ");
			returnCommandNode.getLeftmostchild().Accept(this);
			emitToFunction(";");
		}
	}

	@Override
	public void Visit(WhileCommandNode whileCommandNode)
	{
		if (infunction){
			emitToFunction("while (");
			whileCommandNode.getLeftmostchild().Accept(this);
			whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
	}

	@Override
	public void Visit(AminoLiteralNode aminoLiteralNode)
	{
		if (infunction)
			emitToFunction('"' + aminoLiteralNode.content.toString() + '"');
		else if (indecl)
			emitToDecl('"' + aminoLiteralNode.content.toString() + '"');
		else
			emitToMain('"' + aminoLiteralNode.content.toString() + '"');
	}

	@Override
	public void Visit(BoolLiteralNode boolLiteralNode)
	{
		if (infunction)
			emitToFunction(boolLiteralNode.content.toString());
		else if (indecl)
			emitToDecl(boolLiteralNode.content.toString());
		else
			emitToMain(boolLiteralNode.content.toString());
	}

	@Override
	public void Visit(CodonLiteralNode codonLiteralNode)
	{
		if (infunction)
			emitToFunction('"' + codonLiteralNode.content.toString() + '"');
		else if (indecl)
			emitToDecl('"' + codonLiteralNode.content.toString() + '"');
		else
			emitToMain('"' + codonLiteralNode.content.toString() + '"');
	}

	@Override
	public void Visit(DNALiteralNode dnaLiteralNode)
	{
		if (infunction)
			emitToFunction('"' + dnaLiteralNode.content.toString() + '"');
		else if (indecl)
			emitToDecl('"' + dnaLiteralNode.content.toString() + '"');
		else
			emitToMain('"' + dnaLiteralNode.content.toString() + '"');
	}

	@Override
	public void Visit(IdentifierNode idNode)
	{
		if (infunction)
			emitToFunction(idNode.content.toString());
		else if (indecl)
			emitToDecl(idNode.content.toString());
		else
			emitToMain(idNode.content.toString());
	}

	@Override
	public void Visit(IntegerLiteralNode intNode)
	{
		if (infunction)
			emitToFunction(intNode.content.toString());
		else if (indecl)
			emitToDecl(intNode.content.toString());
		else
			emitToMain(intNode.content.toString());
	}

	@Override
	public void Visit(RNALiteratalNode rnaLiteratalNode)
	{
		if (infunction)
			emitToFunction('"' + rnaLiteratalNode.content.toString() + '"');
		else if (indecl)
			emitToDecl('"' + rnaLiteratalNode.content.toString() + '"');
		else
			emitToMain('"' + rnaLiteratalNode.content.toString() + '"');
	}

	@Override
	public void Visit(AndNode andNode)
	{
		andNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" && ");
		andNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ComparisonNode comparisonNode)
	{
		comparisonNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" == ");
		comparisonNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterOrEqualNode greaterOrEqualNode)
	{
		greaterOrEqualNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" >= ");
		greaterOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(GreaterThanNode greaterThanNode)
	{
		greaterThanNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" > ");
		greaterThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessOrEqualNode lessOrEqualNode)
	{
		lessOrEqualNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" <= ");
		lessOrEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(LessThanNode lessThanNode)
	{
		lessThanNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" < ");
		else
			emitToMain(" < ");
		lessThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ModNode modNode)
	{
		if (infunction) {
			emitToFunction("(");
			modNode.getLeftmostchild().Accept(this);
			emitToFunction(" % ");
			modNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("(");
			modNode.getLeftmostchild().Accept(this);
			emitToDecl(" % ");
			modNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("(");
			modNode.getLeftmostchild().Accept(this);
			emitToMain(" % ");
			modNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}

	}

	@Override
	public void Visit(NotNode notNode){
		if (infunction)
			emitToFunction("!");
		notNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(EqualNode equalNode)
	{
		equalNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" == ");
		equalNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
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
		else if (indecl) {
			emitToDecl("(");
			plusNode.getLeftmostchild().Accept(this);
			emitToDecl(" + ");
			getNextRightSibling(plusNode.getLeftmostchild()).Accept(this);
			emitToDecl(")");
		}
		else {
			emitToMain("(");
			plusNode.getLeftmostchild().Accept(this);
			emitToMain(" + ");
			getNextRightSibling(plusNode.getLeftmostchild()).Accept(this);
			emitToMain(")");
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
		else if (indecl){
			emitToDecl("(");
			minusNode.getLeftmostchild().Accept(this);
			emitToDecl(" - ");
			getNextRightSibling(minusNode.getLeftmostchild()).Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("(");
			minusNode.getLeftmostchild().Accept(this);
			emitToMain(" - ");
			getNextRightSibling(minusNode.getLeftmostchild()).Accept(this);
			emitToMain(")");
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
		else if (indecl){
			emitToDecl("(");
			multNode.getLeftmostchild().Accept(this);
			emitToDecl(" * ");
			getNextRightSibling(multNode.getLeftmostchild()).Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("(");
			multNode.getLeftmostchild().Accept(this);
			emitToMain(" * ");
			getNextRightSibling(multNode.getLeftmostchild()).Accept(this);
			emitToMain(")");
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
		else if (indecl){
			emitToDecl("(");
			divNode.getLeftmostchild().Accept(this);
			emitToDecl(" / ");
			getNextRightSibling(divNode.getLeftmostchild()).Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("(");
			divNode.getLeftmostchild().Accept(this);
			emitToMain(" / ");
			getNextRightSibling(divNode.getLeftmostchild()).Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ComplementaryNode complementaryNode){
		if (infunction){
			emitToFunction("Comp(");
			visitChildren(complementaryNode);
			emitToFunction(")");
		}
		else if (indecl) {
			emitToDecl("Comp(");
			visitChildren(complementaryNode);
			emitToDecl(")");
		}
		else{
			emitToMain("Comp(");
			visitChildren(complementaryNode);
			emitToDecl(")");
		}
	}

	@Override
	public void Visit(ReverseNode reverseNode){
		if (infunction){
			emitToFunction("Rev(");
			visitChildren(reverseNode);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("Rev(");
			visitChildren(reverseNode);
			emitToDecl(")");
		}
		else{
			emitToMain("Rev(");
			visitChildren(reverseNode);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(LengthNode lengthNode){
		if (infunction){
			emitToFunction("Len(");
			visitChildren(lengthNode);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("Len(");
			visitChildren(lengthNode);
			emitToDecl(")");
		}
		else{
			emitToMain("Len(");
			visitChildren(lengthNode);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ContainsNode containsNode){
		if (infunction){
			emitToFunction("Contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("Contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("Contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(CountNode countNode){
		if (infunction){
			emitToFunction("Count(");
			countNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("Count(");
			countNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("Count(");
			countNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(PositionNode positionNode){
		if (infunction){
			emitToFunction("Pos(");
			positionNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToFunction("Pos(");
			positionNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
	}

	@Override
	public void Visit(RemoveNode removeNode){

	}

	@Override
	public void Visit(ConvertNode convertNode){

	}

}