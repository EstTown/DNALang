package ParseInputs;

import Generated.LanguageLexer;
import Generated.LanguageParser;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseTreeGUI {

    public void Show()
    {
        try
        {
            InputStream stream = new FileInputStream("InputFiles/Input5");

            ANTLRInputStream input = new ANTLRInputStream(stream);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);
            ParseTree tree = parser.prog();
            List<String> ruleNames = new ArrayList<String>(Arrays.asList(LanguageParser.ruleNames));
            TreeViewer view = new TreeViewer(ruleNames, tree);
            view.open();

        }
        catch(IOException stream){
            System.out.println("Something failed\n");
        }
    }
}
