package ASTNodes;

import AST.Visitor;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.TerminalNodes.IdentifierNode;
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

	public static Stack<Hashtable<String, BaseNode>> symbolTable = new Stack<Hashtable<String, BaseNode>>();
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

	public static void OpenScope()
    {
		symbolTable.add(new Hashtable<String, BaseNode>());
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


    //this method is supposed to build the symbol table
    public static void ProcessNode(BaseNode node)
	{
		switch(node.getClass().getSimpleName())
		{
			case "BlockNode":
                ProgNode.OpenScope();
				break;
			case "DeclareVarNode":	//insert identifiers with their type also
                //if (ProgNode.RetrieveSymbol(node.spelling) == null)
                if(!ProgNode.DeclaredLocally(node.spelling))
                {
                    ProgNode.EnterSymbol(node.spelling.toString(), node);
                }
                else
                {
                    errorList.add(new Error("Identifier \""+node.spelling+"\""+" already used", node.line, node.pos));
                }
				break;
			case "IdentifierNode":
			    BaseNode temp = ProgNode.RetrieveSymbol(node.content.toString());
                if(temp ==  null)
				{
					errorList.add(new Error("Undeclared symbol..\""+node.content+"\"", node.line, node.pos));
                }
                break;
			case "DeclareFunctionNode":
				DeclareFunctionNode temp2 = (DeclareFunctionNode) node;
				temp2.GiveCopyOfSymbolTable(ProgNode.symbolTable);
				//because of static scoping we need to remember what the  variables were, at the time of declararing this function
				break;
            default:
                break;
		}

		ArrayList<BaseNode> list = new ArrayList<BaseNode>();

		if(node.getLeftmostchild() != null) {
			BaseNode next = node.getLeftmostchild();
			while (true) {
				list.add(next);
				if (next.getRightsibling() == null)
					break;
				else
					next = next.getRightsibling();
			}

			for (BaseNode item : list) {
				ProgNode.ProcessNode(item);
			}

			//maybe add prognode to this case. //that should do it
			if (node.getClass().getSimpleName().equals("BlockNode") || node.getClass().getSimpleName().equals("ProgNode"))
			{
			    //typecheck here?

				TypeChecker typeChecker = new TypeChecker();
				node.Accept(typeChecker);


				if(node.getClass().getSimpleName().equals("BlockNode"))
				{
					BlockNode temp = (BlockNode)node;
					temp.HasNotBeenChecked = false;
				}
                ProgNode.CloseScope();
            }
		}
	}
}