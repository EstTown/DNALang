import java.io.*;

import java.io.FileInputStream;

import Generated.LanguageLexer;
import Generated.LanguageParser;
import Nodes.LeafNode;
import Nodes.Node;
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

            builder.AST.AddChild(new Node("child1"));
            builder.AST.leftmostChild.AddChild(new Node("child1child"));
            builder.AST.leftmostChild.leftmostChild.AddChild(new Node("leaf1", 7));

            builder.AST.AddChild(new Node("sibling of child1"));

            System.out.println(builder.AST.leftmostChild.name);
            System.out.println(builder.AST.leftmostChild.leftmostChild.name);
            System.out.println(builder.AST.leftmostChild.leftmostChild.leftmostChild.name + " " + builder.AST.leftmostChild.leftmostChild.leftmostChild.content);
            System.out.println(builder.AST.leftmostChild.rightSibling.name);

            //Note to SELF!
            //This shit works!
            //BUT! It's possibly to add a child to a leaf, and parents can contain content
            //This needs to be fixed somehow

        }
        catch (Exception parser)
        {
            System.out.print("Other stuff failed!");
        }



    }
}
