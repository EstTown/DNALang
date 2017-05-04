import java.io.*;

import java.io.FileInputStream;

import ASTNodes.BaseNode;
import ASTNodes.CommandNodes.AssignCommandNode;
import ASTNodes.ExpressionNodes.AndNode;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.IdentifierNode;
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
        /*
        ParseTester parseTester = new ParseTester();
        parseTester.ParseSpecificInput(6);
        */

        /*
        parseTester.ParseAllInputs(2);
        */

        ParseTester2 parseTester2 = new ParseTester2();
        parseTester2.ParseSpecificInput2(6);

        ParseTreeGUI ptg = new ParseTreeGUI();
        ptg.Show(6); //specify input file by giving an integer

        /*
        try {
            InputStream stream = new FileInputStream("InputFiles/Input3");
            ANTLRInputStream input = new ANTLRInputStream(stream);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            ParseTree tree = parser.prog();

            //AST.Builder builder = new AST.Builder();
            //builder.visit(tree);

            BaseNode ast = new ProgNode();
            ast.AddChild(new AndNode());
            ast.getLeftmostchild().AddChild(new IdentifierNode("bob"));
            ast.AddChild(new AssignCommandNode());

            ast.PrintTree();

            builder.AST.AddChild(new ParentNode("A"));
            builder.AST.AddChild(new ParentNode("B"));
            builder.AST.getLeftMostChild().rightSibling.castToParent().AddChild(new ParentNode("Martin"));
            builder.AST.getLeftMostChild().rightSibling.castToParent().getLeftMostChild().AddSibling(new LeafNode("Anders", 4543));

            builder.AST.PrintTree();


        }
        catch (Exception parser)
        {
            System.out.print("Other stuff failed!");
        }
        */
    }
}