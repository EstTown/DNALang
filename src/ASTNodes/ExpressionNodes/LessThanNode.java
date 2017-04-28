package ASTNodes.ExpressionNodes;

import AST.Visitor;

public class LessThanNode extends ExpressionNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
