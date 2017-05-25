import ParseInputs.*;
import Compiler.*;

public class Main
{
    public static void main(String[] args)
    {
/*
    	int number = 3;
        ParseTester parseTester = new ParseTester();
        //parseTester.ParseAllInputs(number);
        parseTester.ParseSpecificInput(number);
*/
        //ParseTreeGUI ptg = new ParseTreeGUI();
        //ptg.Show(number); //specify input file by giving an integer

		//NO REMOVE THIS
		//This is what we use in the end, to kick the whole thing off!
		Parser compiler = new Parser(args);
		compiler.Start();
	}
}