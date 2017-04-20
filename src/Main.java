import java.io.*;

import java.io.FileInputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import ParseInputs.*;

public class Main
{
    public static void main(String[] args)
    {
        ParseTester parseTester = new ParseTester();
        parseTester.ParseAllInputs(2);
    }
}
