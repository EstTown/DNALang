package ASTNodes.CommandNodes;

import AST.Visitor;

public class BreakCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
