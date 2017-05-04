package ParseInputs;

import AST.*;
import ASTNodes.BaseNode;
import Generated.LanguageLexer;
import Generated.LanguageParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParseTester2
{
    public void ParseSpecificInput2(int i)
    {
        try
        {
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

            ASTBuilder2 astBuilder2 = new ASTBuilder2();
            LanguageParser.ProgContext cst = parser.prog();

            BaseNode ast;
            ast = astBuilder2.visitProg(cst);
            ast.PrintTree();

            /*
            PrettyPrinter prettyPrinter = new PrettyPrinter();
            ast.Accept(prettyPrinter);
            */
        }
        catch (IOException parser)
        {
            System.out.print("Other stuff failed!");
        }
    }
}
