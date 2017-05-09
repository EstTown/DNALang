package ASTNodes;

import AST.Visitor;
import Interfaces.ASTVisitor;
import com.sun.org.apache.xerces.internal.util.SymbolTable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class ProgNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }

	public static Stack<Hashtable<String, BaseNode>> symbolTable = new Stack<Hashtable<String, BaseNode>>();
    public static List<Error> errorList = new ArrayList<>();

	public static BaseNode RetrieveSymbol(String name){
		Stack<Hashtable<String, BaseNode>> tmp = new Stack<>();
		tmp.addAll(symbolTable);

		//Look through every layer of the stack
		while(!tmp.empty()){
			if (tmp.peek().containsKey(name)){
				return tmp.peek().get(name);
			}
			else{
				tmp.pop();
			}
		}

		return null;
	}

	public static void EnterSymbol(String name, BaseNode type){
		if (!symbolTable.peek().containsKey(name)){
			symbolTable.peek().put(name, type);
		}
	}

	public static void OpenScope(){
		symbolTable.add(new Hashtable<String, BaseNode>());
	}
	public static void CloseScope()
	{
		symbolTable.pop();
	}
}
