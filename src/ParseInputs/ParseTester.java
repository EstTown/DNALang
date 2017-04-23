package ParseInputs;

import Generated.*;

import java.io.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
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
            if (iterator == i){
                break;
            }
        }
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

                ParseTree tree = parser.prog();

                System.out.print(tree.toStringTree(parser)); //print tree as text
                System.out.print("\n");


            }
            catch (Exception parser)
            {
                System.out.print("Other stuff failed!");
            }
        }
    }
}
