package ASTNodes;

import AST.Visitor;
import Interfaces.ASTVisitor;

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

	public static Stack<Hashtable<String, BaseNode>> symbolTable;
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

	public static Hashtable NewScope(){
		symbolTable.add(new Hashtable<String, BaseNode>());
		return symbolTable.peek();
	}


}
