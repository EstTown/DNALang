package ASTNodes.ExpressionNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class PlusNode extends ExpressionNode
{
    public PlusNode(){


    }


    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
