package Compiler;

import AST.ASTBuilder;
import AST.CodeGenerator;
import ASTNodes.BaseNode;
import ASTNodes.Error;
import ASTNodes.ProgNode;
import Generated.LanguageLexer;
import Generated.LanguageParser;
import ParseInputs.CustomErrorStrategy;
import SemanticAnalysis.FunctionTableFiller;
import SemanticAnalysis.SymbolTableFiller;
import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;

import javax.tools.JavaFileObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Parser {

	public Parser(String[] args){
		this.args = args;
		if (this.args.length < 1) {
			System.out.println("Please provide a source file.");
			System.exit(1);
		}
		else{
			for(String str : args){
				if (str.equals("-showjava"))
					this.cf_makeJavaFile = true;
			}
		}
	}

	private boolean cf_makeJavaFile = false;

	private String[] args;

	public void Start(){
		try{
			//get file from argument 0
			File file = new File(args[0]);

			//Antlr4
			InputStream stream = new FileInputStream(file);
			ANTLRInputStream antlrStream = new ANTLRInputStream(stream);
			LanguageLexer lexer = new LanguageLexer(antlrStream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LanguageParser parser = new LanguageParser(tokens);

			//Building AST
			ASTBuilder astBuilder = new ASTBuilder();
			LanguageParser.ProgContext cst = parser.prog();

			if (parser.getNumberOfSyntaxErrors() != 0)
				System.exit(1);

			BaseNode ast;
			ast = astBuilder.visitProg(cst);
			//ast.PrintTree();  		-- used for debugging


			//Traverse the AST, filling the symboltable with function-declarations
			FunctionTableFiller functionTableFiller = new FunctionTableFiller();
			ast.Accept(functionTableFiller);

			//Traverse the AST, filling the symboltable
			SymbolTableFiller symbolTableFiller = new SymbolTableFiller();
			ast.Accept(symbolTableFiller);

			//Proceed to codegen and compile, if no errors were found.
			if (ProgNode.errorList.isEmpty()){
				//Run
				CodeGenerator codegen = new CodeGenerator();
				ast.Accept(codegen);

				//Make Java file
				codegen.makeFile(this.cf_makeJavaFile);

				//Get programcode
				//File source = codegen.source;
				JavaFileObject internalJavaFile = codegen.internalJavaFile;

				//Compile and run
				JavaC out = new JavaC(this.args, internalJavaFile);
				out.CompileAndRun();

			}
			else{
				//Print errors to user
				for (Error error : ProgNode.errorList){
					System.out.println(error.getMessage());
				}
			}

		}catch (IOException ex){
			System.out.println("Parser Error: " + ex.getMessage());
		}
	}

}
