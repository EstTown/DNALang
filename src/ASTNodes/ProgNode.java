package ASTNodes;

import AST.Visitor;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.TerminalNodes.IdentifierNode;
import ASTNodes.TerminalNodes.NullNode;
import Interfaces.ASTVisitor;
import SemanticAnalysis.TypeChecker;
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

    //THESE SHOULD BE PRIVATE
	private static Stack<Hashtable<String, BaseNode>> symbolTable = new Stack<Hashtable<String, BaseNode>>();
    public static List<Error> errorList = new ArrayList<>();

	public static BaseNode RetrieveSymbol(String name){
		Stack<Hashtable<String, BaseNode>> tmp = new Stack<Hashtable<String, BaseNode>>();
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

	public static void EnterSymbol(String name, BaseNode node){
		if (!symbolTable.peek().containsKey(name))
		{
			symbolTable.peek().put(name, node);
		}
		else
		{
			//do error
		}
	}

	public static void ClearSymbolTable()
	{
		symbolTable.clear();
	}

	public static void OpenScope()
    {
		symbolTable.push(new Hashtable<String, BaseNode>());
    }

	public static void CloseScope()
    {
		symbolTable.pop();
	}

	public static boolean DeclaredLocally(String name)
    {
        if(symbolTable.peek().get(name) != null){return true;}
        else{return false;}
    }


    public static ArrayList<BaseNode> GetListOfChildren(BaseNode node) {
		ArrayList<BaseNode> list = new ArrayList<BaseNode>();

		if (node.getLeftmostchild() != null) {
			BaseNode next = node.getLeftmostchild();
			while (true) {
				list.add(next);
				if (next.getRightsibling() == null) {
					break;
				}
				else
				{
					next = next.getRightsibling();
				}
			}
		}
		return list;
	}

	public static BaseNode GetDeclareFunctionParent(BaseNode node)
	{
		if(node.getParent() != null)
		{
			BaseNode next = node.getParent();
			while(true)
			{
				if(next.getClass().getSimpleName().equals("DeclareFunctionNode"))
				{
					return next;
				}
				else
				{
					next = next.getParent();
				}
			}
		}
		return null;
	}


    //this method builds the symbol table
    public static void ProcessNode(BaseNode node)
	{
		switch(node.getClass().getSimpleName())
		{
			case "BlockNode":
				ProgNode.OpenScope();
                break;
			//insert identifiers with their type also
			case "DeclareVarNode":
				if(!ProgNode.DeclaredLocally(node.spelling))
                {
                    ProgNode.EnterSymbol(node.spelling.toString(), node);
				}
                else
                {
                    errorList.add(new Error("Identifier \""+node.spelling+"\""+" already used", node.line, node.pos));
                }
				break;
			case "DeclareArrayNode":
				break;
			case "IdentifierNode":
			    BaseNode temp2 = ProgNode.RetrieveSymbol(node.content.toString());
				if(temp2 ==  null)
				{
					errorList.add(new Error("Undeclared symbol..\""+node.content+"\"", node.line, node.pos));
                }
                break;
			case "DeclareFunctionNode":
				DeclareFunctionNode temp3 = (DeclareFunctionNode) node;
				temp3.GiveCopyOfSymbolTable(ProgNode.symbolTable);
				//because of static scoping we need to remember what the variables were, at the time of declaring this function
				//but in our language, functions come before all statements, and therefore they are automatically statically scoped
				break;
            default:
                break;
		}
		for (BaseNode item : GetListOfChildren(node))
		{
			ProgNode.ProcessNode(item);
		}

		if (node.getClass().getSimpleName().equals("BlockNode") || node.getClass().getSimpleName().equals("ProgNode"))
		{
			TypeChecker typeChecker = new TypeChecker();
			node.Accept(typeChecker);
			if (node.getClass().getSimpleName().equals("BlockNode"))
			{
				BlockNode temp2 = (BlockNode) node;
				temp2.HasNotBeenChecked = false;
			}
			ProgNode.CloseScope();
		}
	}
}
