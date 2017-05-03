package ASTNodes.ExpressionNodes;

import AST.Visitor;

public class LessOrEqualNode extends ExpressionNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
