package ASTNodes.ExpressionNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class PlusNode extends ExpressionNode
{
    public PlusNode(){

    }
    public PlusNode(BaseNode exp1, BaseNode exp2)
    {
        this.AddChild(exp1);
        this.AddChild(exp2);
    }


    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
