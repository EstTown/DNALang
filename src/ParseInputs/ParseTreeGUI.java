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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseTreeGUI {

    public static void Show(ANTLRInputStream code)
    {
        LanguageLexer lexer = new LanguageLexer(code);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LanguageParser parser = new LanguageParser(tokens);
        ParseTree tree = parser.prog();
        List<String> ruleNames = new ArrayList<String>(Arrays.asList(LanguageParser.ruleNames));
        TreeViewer view = new TreeViewer(ruleNames, tree);
        view.open();
    }
}
