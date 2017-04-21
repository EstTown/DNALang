import java.io.*;

import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import Generated.LanguageLexer;
import Generated.LanguageParser;
import com.sun.tools.internal.xjc.Language;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import ParseInputs.*;

public class Main
{
    public static void main(String[] args)
    {
        ParseTester parseTester = new ParseTester();
        parseTester.ParseAllInputs(2);
    }


}
