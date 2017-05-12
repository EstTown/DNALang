package ASTNodes.DeclareFunctionNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

import java.util.*;

public class DeclareFunctionNode extends BaseNode
{
    public DeclareFunctionNode()
    {
        this.listOfParameters = new ArrayList<FormalParameters>();
        this.localSymbolTable = new Stack<Hashtable<String, BaseNode>>();
    }
    public String functionName;
    public Stack<Hashtable<String, BaseNode>> localSymbolTable;

    public void GiveCopyOfSymbolTable(Stack<Hashtable<String, BaseNode>> symbolTable)
    {
        this.localSymbolTable.addAll(symbolTable); //copy of how the symbol table looked, when this function was declared
    }

    public class FormalParameters{
        private String parameterType;
        private String parameterName;

        private FormalParameters(String type, String name)
        {
            this.parameterType = type;
            this.parameterName = name;
        }
        public String GetParameterType(){return this.parameterType;}
        public String GetParameterName(){return this.parameterName;}
    }
    public ArrayList<FormalParameters> listOfParameters;

    public void AddParameters(String type, String name)
    {
        FormalParameters temp = new FormalParameters(type, name);
        this.listOfParameters.add(temp);
    }

    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
