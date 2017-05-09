package ASTNodes;

import AST.Visitor;
import Interfaces.ASTVisitor;
import com.sun.org.apache.xerces.internal.util.SymbolTable;
import ASTNodes.BlockNodes.*;

import java.util.*;

public class ProgNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }

	public static Stack<Hashtable<String, Object>> symbolTable = new Stack<Hashtable<String, Object>>();
    public static List<Error> errorList = new ArrayList<>();

	public static Object RetrieveSymbol(String name){
		Stack<Hashtable<String, Object>> tmp = new Stack<>();
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

	public static void EnterSymbol(String name, Object type){
		if (!symbolTable.peek().containsKey(name)){
			symbolTable.peek().put(name, type);
		}
	}

	public static void OpenScope(){
		symbolTable.add(new Hashtable<String, Object>());
	}

	public static void CloseScope(){
		symbolTable.pop();
	}

	public static boolean DeclaredLocally(String name){
        if(symbolTable.peek().get(name) != null){return true;}
        else{return false;}
    }

    public static void ProcessNode(BaseNode node){
		if (node.getClass().getSimpleName().equals("BlockNode"))
			ProgNode.OpenScope();

		if (node.getClass().getSimpleName().equals("DeclarationNode"))
			ProgNode.EnterSymbol(node.content.toString(), node.getClass());

		if (node.getClass().getSimpleName().equals("IdentifierNode")) {
			if (RetrieveSymbol(node.content.toString()) == null) {
				//Error
				errorList.add(new Error("Undeclared symbol.", node.line, node.pos));
			}
		}

		ArrayList<BaseNode> list = new ArrayList<BaseNode>();
		BaseNode next = node.getLeftmostchild();
		while(true){
			list.add(next);
			if(next.getRightsibling() == null)
				break;
			else
				next = next.getRightsibling();
		}
		Collections.reverse(list);
		for(BaseNode item : list)
		{
			ProgNode.ProcessNode(item);
		}

		if (node.getClass().getSimpleName().equals("BlockNode"))
			ProgNode.CloseScope();
	}

}
