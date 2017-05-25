package AST;

import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.googlejavaformat.java.Formatter;
import Compiler.JavaSourceFromString;

import javax.tools.JavaFileObject;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeGenerator extends Visitor {

	//Local variables
	private Boolean infunction = false;
	private Boolean indecl = true;
	private String ps = "public static "; //snippet, likely used in many places

	public File source;
	public JavaFileObject internalJavaFile;

	//Parts
	private String codeDecl = "";
	private String codeMain = "";
	private String codeFuncs = "";

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

	private void readCustomFuncionTextFiles(){
		//ArrayList<String> results = new ArrayList<String>();
		//File[] files = new File("CustomFunctions").listFiles();

		//ClassLoader classLoader = getClass().getClassLoader();
		//File[] files = new File(classLoader.getResource("CustomFunctions").getPath()).listFiles();
		/*
		try {
			System.out.println(files.length + " lol");
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}

		for (File file : files) {
			try {
				byte[] bytes = Files.readAllBytes(Paths.get(file.getPath()));
				String str = new String(bytes, Charset.defaultCharset());
				codeFuncs += str;
			}catch (Exception ex){
				//System.out.println(ex.getMessage());
			}
		}
		*/

		String[] names = {"As", "Comp", "Contains", "Count", "Get", "Len", "Pos", "Remove", "Rev", "CustomPrint"};

		for (String name : names){
			InputStream x = getClass().getResourceAsStream("/CustomFunctions/" + name);
			try {
				String y = CharStreams.toString(new InputStreamReader(x, Charsets.UTF_8));
				codeFuncs += y;
			}catch (Exception ex){}
		}

	}


	//Putting it all together
	public void makeFile(boolean cf_makeJavaFile){
	    //Step 1
	    //Assemble parts of java file
		readCustomFuncionTextFiles();
		String code = "";
        //code += "package Output;";
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
            System.out.println("Formatter error: " + ex.getMessage());
			System.out.println(code);
        }


		//Make file
		if (cf_makeJavaFile == true) {
			try {
				File file = new File("out.java");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(formattedSource);
				fileWriter.flush();
				fileWriter.close();
				this.source = file;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//Make internal file representation
		internalJavaFile = new JavaSourceFromString("out", formattedSource);



		//Step 4
        //???

        //Step 5
        //Profit
	}

	//======================================

	@Override
	public void Visit(ProgNode progNode)
	{
		if (!progNode.getLeftmostchild().getClass().getSimpleName().equals("DeclareVarNode"))
			this.indecl = false;
		visitChildren(progNode);
	}

	private void getNext(BaseNode node)
	{
		if (node.getRightsibling() != null) {
			node.getRightsibling().Accept(this);

			//Set commas between params in functioncalls
			if (node.getParent().getClass().getSimpleName().equals("CallCommandNode")
					&& node.getRightsibling().getRightsibling() != null){

				if (infunction)
					emitToFunction(", ");
				else if (indecl)
					emitToDecl(", ");
				else
					emitToMain(", ");
			}

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
		emitToFunction(ps);
		if (declareFunctionNode.content.toString().equals("dna")
				|| declareFunctionNode.content.toString().equals("rna")
				|| declareFunctionNode.content.toString().equals("protein")
				|| declareFunctionNode.content.toString().equals("codon"))
			emitToFunction("String");
		else
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
		if (tmp.equals("bool"))
			tmp = "Boolean";


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
			if (!blockNode.getParent().getClass().getSimpleName().equals("IfElseCommandNode"))
				emitToFunction(")");
			emitToFunction("{");
			visitChildren(blockNode);
			emitToFunction("}");
		}
		else{
			if (!blockNode.getParent().getClass().getSimpleName().equals("IfElseCommandNode"))
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
		//We cant put this in the class (outter), needs to be in main
		if (assignCommandNode.getParent() != null &&
				assignCommandNode.getParent().getClass().getSimpleName().equals("ProgNode"))
			indecl = false;

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

		if (!assignCommandNode.getParent().getClass().getSimpleName().equals("ForCommandNode")) {
			if (infunction)
				emitToFunction(";");
			else if (!indecl)
				emitToMain(";");
		}
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
		if (infunction){
			//funcname
			callCommandNode.getLeftmostchild().Accept(this);
			//params
			emitToFunction("(");
			getNext(callCommandNode.getLeftmostchild().getRightsibling());
			emitToFunction(")");
		}
		else if (indecl){
			callCommandNode.getLeftmostchild().Accept(this);
			emitToDecl("(");
			getNext(callCommandNode.getLeftmostchild().getRightsibling());
			emitToDecl(")");
		}
		else{
			callCommandNode.getLeftmostchild().Accept(this);
			emitToMain("(");
			getNext(callCommandNode.getLeftmostchild().getRightsibling());
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ForCommandNode forCommandNode)
	{
		indecl = false;

		if (infunction){
			emitToFunction("for(");
			forCommandNode.getLeftmostchild().Accept(this);
			emitToFunction(";");
			forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(";");
			forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
			forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
		}
		else{
			emitToMain("for(");
			forCommandNode.getLeftmostchild().Accept(this);
			emitToMain(";");
			forCommandNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(";");
			forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
			forCommandNode.getLeftmostchild().getRightsibling().getRightsibling().getRightsibling().Accept(this);
		}
	}

	@Override
	public void Visit(IfCommandNode ifCommandNode)
	{
		indecl = false;

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
		indecl = false;

		if (infunction){
			emitToFunction("if (");
			//Expression
			ifElseCommandNode.getLeftmostchild().Accept(this);
			emitToFunction(")");
			//Block1
			ifElseCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
			emitToFunction("else");
			//Block2
			ifElseCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
		else {
			emitToMain("if (");
			ifElseCommandNode.getLeftmostchild().Accept(this);
			emitToMain(")");
			ifElseCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);
			emitToMain("else");
			ifElseCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
	}

	@Override
	public void Visit(PrintCommandNode printCommandNode)
	{
		indecl = false;

		int children = ProgNode.GetListOfChildren(printCommandNode).size();
		//System.out.println(children);
		if (children < 2) {
			if (infunction)
				emitToFunction("print(");
			else
				emitToMain("print(");

			visitChildren(printCommandNode);

			if (infunction)
				emitToFunction(");");
			else
				emitToMain(");");
		}
		else if (children == 2){
			if (infunction)
				emitToFunction("print(");
			else
				emitToMain("print(");

			//Visit first
			printCommandNode.getLeftmostchild().Accept(this);

			if (infunction)
				emitToFunction(", ");
			else
				emitToMain(", ");

			//Visit second
			printCommandNode.getLeftmostchild().getRightsibling().Accept(this);

			if (infunction)
				emitToFunction(");");
			else
				emitToMain(");");

		}
		else if (children == 3){
			if (infunction)
				emitToFunction("print(");
			else
				emitToMain("print(");

			//Visit first
			printCommandNode.getLeftmostchild().Accept(this);

			if (infunction)
				emitToFunction(", ");
			else
				emitToMain(", ");

			//Visit second
			printCommandNode.getLeftmostchild().getRightsibling().Accept(this);

			if (infunction)
				emitToFunction(", ");
			else
				emitToMain(", ");

			//Visit third
			printCommandNode.getLeftmostchild().getRightsibling().getRightsibling().Accept(this);

			//Print type
			if (infunction)
				emitToFunction(", \"" + printCommandNode.getLeftmostchild().type + "\"");
			else
				emitToMain(", \"" + printCommandNode.getLeftmostchild().type + "\"");

			if (infunction)
				emitToFunction(");");
			else
				emitToMain(");");

		}
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
		indecl = false;
		if (infunction){
			emitToFunction("while (");
			whileCommandNode.getLeftmostchild().Accept(this);
			whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
		else{
			emitToMain("while (");
			whileCommandNode.getLeftmostchild().Accept(this);
			whileCommandNode.getLeftmostchild().getRightsibling().Accept(this);
		}
	}

	@Override
	public void Visit(AminoLiteralNode aminoLiteralNode)
	{
		if (infunction)
			emitToFunction(aminoLiteralNode.content.toString());
		else if (indecl)
			emitToDecl(aminoLiteralNode.content.toString());
		else
			emitToMain(aminoLiteralNode.content.toString());
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
		else if (indecl)
			emitToDecl("!");
		else
			emitToMain("!");
		notNode.getLeftmostchild().Accept(this);
	}

	@Override
	public void Visit(NotEqualNode notEqualNode)
	{
		notEqualNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" != ");
		else if (indecl)
			emitToDecl(" != ");
		else
			emitToMain(" != ");
		notEqualNode.getLeftmostchild().getRightsibling().Accept(this);
	}

	@Override
	public void Visit(EqualNode equalNode)
	{
		if (equalNode.getLeftmostchild().type.equals("dna")
				|| equalNode.getLeftmostchild().type.equals("rna")
				|| equalNode.getLeftmostchild().type.equals("codon")
				|| equalNode.getLeftmostchild().type.equals("protein")) {

			equalNode.getLeftmostchild().Accept(this);
			if (infunction)
				emitToFunction(".equals(");
			else if (indecl)
				emitToDecl(".equals(");
			else
				emitToMain(".equals(");
			equalNode.getLeftmostchild().getRightsibling().Accept(this);
			if (infunction)
				emitToFunction(")");
			else if (indecl)
				emitToDecl(")");
			else
				emitToMain(")");
		}
		else{
			equalNode.getLeftmostchild().Accept(this);
			if (infunction)
				emitToFunction(" == ");
			else if (indecl)
				emitToDecl(" == ");
			else
				emitToMain(" == ");
			equalNode.getLeftmostchild().getRightsibling().Accept(this);
		}
	}

	@Override
	public void Visit(OrNode orNode)
	{
		orNode.getLeftmostchild().Accept(this);
		if (infunction)
			emitToFunction(" || ");
		else if (indecl)
			emitToDecl(" || ");
		else
			emitToMain(" || ");
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
			emitToFunction("comp(");
			visitChildren(complementaryNode);
			emitToFunction(")");
		}
		else if (indecl) {
			emitToDecl("comp(");
			visitChildren(complementaryNode);
			emitToDecl(")");
		}
		else{
			emitToMain("comp(");
			visitChildren(complementaryNode);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ReverseNode reverseNode){
		if (infunction){
			emitToFunction("rev(");
			visitChildren(reverseNode);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("rev(");
			visitChildren(reverseNode);
			emitToDecl(")");
		}
		else{
			emitToMain("rev(");
			visitChildren(reverseNode);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(LengthNode lengthNode){
		if (infunction){
			emitToFunction("len(");
			visitChildren(lengthNode);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("len(");
			visitChildren(lengthNode);
			emitToDecl(")");
		}
		else{
			emitToMain("len(");
			visitChildren(lengthNode);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ContainsNode containsNode){
		if (infunction){
			emitToFunction("contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("contains(");
			containsNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			containsNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(CountNode countNode){
		if (infunction){
			emitToFunction("count(");
			countNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("count(");
			countNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("count(");
			countNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			countNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(PositionNode positionNode){
		if (infunction){
			emitToFunction("pos(");
			positionNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("pos(");
			positionNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("pos(");
			positionNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			positionNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(RemoveNode removeNode){
		if (infunction){
			emitToFunction("remove(");
			removeNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			removeNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("remove(");
			removeNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			removeNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("remove(");
			removeNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			removeNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(ConvertNode convertNode){
		if (infunction){
			emitToFunction("as(");
			convertNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			emitToFunction("\"" + convertNode.content + "\"");
			//convertNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("as(");
			convertNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			emitToDecl("\"" + convertNode.content + "\"");
			//convertNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else{
			emitToMain("as(");
			convertNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			emitToMain("\"" + convertNode.content + "\"");
			//convertNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

	@Override
	public void Visit(GetNode getNode){
		if (infunction){
			emitToFunction("get(");
			getNode.getLeftmostchild().Accept(this);
			emitToFunction(", ");
			getNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToFunction(")");
		}
		else if (indecl){
			emitToDecl("get(");
			getNode.getLeftmostchild().Accept(this);
			emitToDecl(", ");
			getNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToDecl(")");
		}
		else {
			emitToMain("get(");
			getNode.getLeftmostchild().Accept(this);
			emitToMain(", ");
			getNode.getLeftmostchild().getRightsibling().Accept(this);
			emitToMain(")");
		}
	}

}