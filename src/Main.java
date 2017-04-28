import java.io.*;
import AST.*;

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

        //ParseTester parseTester = new ParseTester();

        //parseTester.ParseAllInputs(3);

        //parseTester.ParseSpecificInput(3);


        ParseTreeGUI ptg = new ParseTreeGUI();
        ptg.Show();




        /*
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

            //System.out.println(builder.AST.name);
            builder.AST.AddChild(new LeafNode("leaf1", 452));
            builder.AST.getLeftMostChild().AddSibling(new ParentNode("parent1"));
            builder.AST.getLeftMostChild().rightSibling.castToParent().AddChild(new LeafNode("leaf2", 3423));

            //System.out.println(builder.AST.getLeftMostChild().rightSibling.castToParent().getLeftMostChild().name);
            builder.AST.PrintTree();

            //Adding a child, works wit leaf, but not with parent. Dunno why.... work in progress


        }
        catch (Exception parser)
        {
            System.out.print("Other stuff failed!");
        }
        */
    }
}