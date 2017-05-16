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
	public String codeAsFunc = "";
	public String codeCompFunc = "";
	public String codeRevFunc = "";
	public String codeLenFunc = "";
	public String codePosFunc = "";
	public String codeCountFunc = "";
	public String codeContainFunc = "";
	public String codeRemoveFunc = "";
	public String codeGetFunc = "";

	//Local variables
	private Boolean infunction = false;
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
        code += "public class Main{";
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
            System.out.println("Google's Java formatter done fucked up.");
        }

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
		//Right hand expression
		assignCommandNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(BreakCommandNode breakCommandNode)
	{

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

	}

	@Override
	public void Visit(IfElseCommandNode ifElseCommandNode)
	{

	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{

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

	}

	@Override
	public void Visit(BoolLiteralNode boolLiteralNode)
	{

	}

	@Override
	public void Visit(CodonLiteralNode codonLiteralNode)
	{

	}

	@Override
	public void Visit(DNALiteralNode dnaLiteralNode)
	{

	}

	@Override
	public void Visit(IdentifierNode idNode)
	{
		if (infunction)
			emitToFunction(idNode.content.toString());
	}

	@Override
	public void Visit(IntegerLiteralNode intNode)
	{
		if (infunction)
			emitToFunction(intNode.content.toString());
	}

	@Override
	public void Visit(RNALiteratalNode rnaLiteratalNode)
	{

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
		lessThanNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(ModNode modNode)
	{
		modNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" % ");
		modNode.getLeftmostchild().getRightsibling().Accept(this);
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

	}

	@Override
	public void Visit(ReverseNode reverseNode){

	}

	@Override
	public void Visit(LengthNode lengthNode){

	}

	@Override
	public void Visit(ContainsNode containsNode){

	}

	@Override
	public void Visit(CountNode countNode){

	}

	@Override
	public void Visit(PositionNode positionNode){

	}

	@Override
	public void Visit(RemoveNode removeNode){

	}

	@Override
	public void Visit(ConvertNode convertNode){

	}

}