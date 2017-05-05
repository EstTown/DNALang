import java.io.*;

import java.io.FileInputStream;

import ASTNodes.BaseNode;
import ASTNodes.CommandNodes.AssignCommandNode;
import ASTNodes.ExpressionNodes.AndNode;
import ASTNodes.ProgNode;
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
        ParseTester parseTester = new ParseTester();
        parseTester.ParseAllInputs(13);

        //parseTester.ParseSpecificInput(10);

        /*
        ParseTreeGUI ptg = new ParseTreeGUI();
        ptg.Show(10); //specify input file by giving an integer
        */
    }
}