package SemanticAnalysis;

import AST.*;
import ASTNodes.BaseNode;
import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.ProgNode;

import java.util.ArrayList;


public class TypeChecker extends Visitor
{
    @Override
    public void Visit(ProgNode node)
    {
        /*
        ArrayList<BaseNode> list = new ArrayList<BaseNode>();
        BaseNode next = node.getLeftmostchild();
        if(next != null)
        {
            while(true)
            {
                list.add(next);
                if(next.getRightsibling() == null)
                {
                    break;
                }
                else
                {
                    next = next.getRightsibling();
                }
            }
        }
        for(BaseNode item : list)
        {
            ProgNode.ProcessNode(item);
        }
        */
        visitChildren(node);
    }

    @Override
    public void Visit(BlockNode node)
    {
        System.out.println(node.HasNotBeenChecked);
        if(node.HasNotBeenChecked)
        {
            visitChildren(node);
        }
    }
}
