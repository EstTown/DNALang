import java.io.*;

import java.io.FileInputStream;

import Generated.LanguageLexer;
import Generated.LanguageParser;
import Nodes.LeafNode;
import Nodes.Node;
import Nodes.ParentNode;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import ParseInputs.*;


public class Main
{
    public static void main(String[] args)
    {
        ParseTester parseTester = new ParseTester();
        parseTester.ParseAllInputs(2);

        ParseTreeGUI ptg = new ParseTreeGUI();
        //ptg.Show();


        try {
            InputStream stream = new FileInputStream("InputFiles/Input3");
            ANTLRInputStream input = new ANTLRInputStream(stream);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            ParseTree tree = parser.prog();

            AST.Builder builder = new AST.Builder();
            builder.visit(tree);
            //builder.AST.PrintTree();

            System.out.println(builder.AST.name);
            builder.AST.AddChild(new LeafNode("leaf", 452));
            builder.AST.getLeftMostChild().AddSibling(new LeafNode("dsjfsdofsd", 7845));

            System.out.println(builder.AST.getLeftMostChild().rightSibling.name);
            /*builder.AST.leftMostLeaf.AddSibling(new LeafNode("leafnode", 3424));
            builder.AST.leftMostLeaf.rightSibling.AddSibling(new ParentNode("leafnodesibling"));

            System.out.println(builder.AST.leftMostLeaf.rightSibling.rightSibling.name);
            System.out.println(builder.AST.leftMostLeaf);
            */


        }
        catch (Exception parser)
        {
            System.out.print("Other stuff failed!");
        }



    }
}