import java.io.*;

import java.io.FileInputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Created by Ruben on 18-04-2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        //stuff
        //String a = "sadkjasdkj";
        //char[] b = new char[]{'g', 'd', 'h', 'h'};

        try{
            InputStream stream = new FileInputStream("Input");

            ANTLRInputStream input = new ANTLRInputStream(stream);

            LanguageLexer lexer = new LanguageLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            LanguageParser parser = new LanguageParser(tokens);

            ParseTree tree = parser.prog();

            System.out.print(tree.toStringTree(parser)); //print tree as text
        }
        catch(Exception parser){
            System.out.print("Didn't work!");
        }

    }
}
