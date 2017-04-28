package ASTNodes.ExpressionNodes;

import AST.Visitor;

public class DivNode extends ExpressionNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
