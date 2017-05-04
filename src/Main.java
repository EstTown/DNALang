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
        ParseTester2 parseTester2 = new ParseTester2();
        parseTester2.ParseSpecificInput2(6);


        ParseTreeGUI ptg = new ParseTreeGUI();
        ptg.Show(6); //specify input file by giving an integer
    }
}