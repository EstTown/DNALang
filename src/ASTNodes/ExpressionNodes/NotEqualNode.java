package ASTNodes.ExpressionNodes;

import AST.Visitor;

public class NotEqualNode extends ExpressionNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
