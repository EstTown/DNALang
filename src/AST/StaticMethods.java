package AST;

import ASTNodes.BaseNode;

//class does not have to be static (actually a class can't be static in java, unless it's nested)
//static method works as you would expect; it can be called anywhere.
public class StaticMethods
{
    public static int Add(int a, int b){return a+b;}

    public static BaseNode MakeNode(){


        return null;
    }
}
