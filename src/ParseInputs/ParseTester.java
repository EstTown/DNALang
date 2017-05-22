package ParseInputs;
import AST.*;
import ASTNodes.BaseNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.Error;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.IdentifierNode;
import ASTNodes.TerminalNodes.IntegerLiteralNode;
import Generated.*;

import java.io.*;

import SemanticAnalysis.FunctionTableFiller;
import SemanticAnalysis.SymbolTableFiller;
import SemanticAnalysis.TypeChecker;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Generated.*;

public class ParseTester
{
    public void ParseAllInputs(int i){
        List<String> allInputs = new ArrayList<String>();

        int iterator = 1;
        while(true)
        {
            String str = "InputFiles/Input" + Integer.toString(iterator);
            allInputs.add(str);
            iterator++;
            if (iterator == i+1){
                break;
            }
        }
        iterator = 1;
        for(String item : allInputs)
        {
            try
            {
                //This would not work, if "InputFiles" was a "package". It has to be a folder
                InputStream stream = new FileInputStream(item);

                ANTLRInputStream input = new ANTLRInputStream(stream);

                LanguageLexer lexer = new LanguageLexer(input);

                CommonTokenStream tokens = new CommonTokenStream(lexer);

                LanguageParser parser = new LanguageParser(tokens);

                System.out.println("Program " + Integer.toString(iterator));
                //stackoverflow guide, uses "parser.compileUnit();", but that one is the same as "parser.prog();" in our case
                LanguageParser.ProgContext cst = parser.prog();
                iterator++;

                BaseNode ast;
                ASTBuilder astBuilder = new ASTBuilder();
                ast = astBuilder.visitProg(cst);

                //ast.PrintTree();

                FunctionTableFiller functionTableFiller = new FunctionTableFiller();
                ast.Accept(functionTableFiller);

                SymbolTableFiller symbolTableFiller = new SymbolTableFiller();
                ast.Accept(symbolTableFiller);


                //notify user of errors
                Collections.reverse(ProgNode.errorList);
                for (Error error : ProgNode.errorList){
                    System.out.println(error.getMessage());
                }
                //we should obviously clear error list AND symboltable for each run.
                ProgNode.ClearSymbolTable();
                ProgNode.errorList.clear();
            }
            catch (Exception parser)
            {
                System.out.print("Other stuff failed!");
            }
        }
    }
    public void ParseSpecificInput(int i)
    {
        try {
            String str = "InputFiles/Input" + Integer.toString(i);
            //This would not work, if "InputFiles" was a "package". It has to be a folder
            InputStream stream = new FileInputStream(str);
            ANTLRInputStream input = new ANTLRInputStream(stream);

            LanguageLexer lexer = new LanguageLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            LanguageParser parser = new LanguageParser(tokens);
            //stackoverflow guide, uses "parser.compileUnit();", but that one is the same as "parser.prog();" in our case
            //ParseTree tree = parser.prog();
            //TestASTBuilder testAstBuilder = new TestASTBuilder();
            //tree.accept(testAstBuilder);

            ASTBuilder astBuilder = new ASTBuilder();
            LanguageParser.ProgContext cst = parser.prog();

            BaseNode ast;
            ast = astBuilder.visitProg(cst);
            ast.PrintTree();


            //PrettyPrinter pretty = new PrettyPrinter();
            //ast.Accept(pretty);



            FunctionTableFiller functionTableFiller = new FunctionTableFiller();
            ast.Accept(functionTableFiller);


            SymbolTableFiller symbolTableFiller = new SymbolTableFiller();
            ast.Accept(symbolTableFiller);



            //notify user of errors
            //Collections.reverse(ProgNode.errorList); //errors get added in reverse direction
			for (Error error : ProgNode.errorList){
				System.out.println(error.getMessage());
			}

            //if(ProgNode.errorList.isEmpty()) {

                CodeGenerator gen = new CodeGenerator();
                ast.Accept(gen);
                gen.makeFile(true);



            //}
        }
        catch (IOException parser)
        {
            System.out.print("Other stuff failed!");
        }
    }
}
