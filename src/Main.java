import java.io.*;

import java.io.FileInputStream;
import Compiler.*;

import ASTNodes.BaseNode;
import ASTNodes.CommandNodes.AssignCommandNode;
import ASTNodes.ExpressionNodes.AndNode;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.BoolLiteralNode;
import ASTNodes.TerminalNodes.IdentifierNode;
import Generated.LanguageLexer;
import Generated.LanguageParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import ParseInputs.*;


public class Main
{
    public static void main(String[] args)
    {

    	//Compile flag suggestions:
    	//dnalang input.txt -javaout	 	(compiles to java file)
		//dnalang input.txt -classout		(compiles the java to executable file)
		//dnalang input.txt 				(compiles and runs, per default)


        int number = 3;
        ParseTester parseTester = new ParseTester();
        //parseTester.ParseAllInputs(number);
        parseTester.ParseSpecificInput(number);

		OutputCompiler out = new OutputCompiler(args);
		out.CompileAndRun();

        /*
        ParseTreeGUI ptg = new ParseTreeGUI();
        ptg.Show(number); //specify input file by giving an integer
        */
    }
}