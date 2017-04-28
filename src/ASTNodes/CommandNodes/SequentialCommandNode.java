package ASTNodes.CommandNodes;

import AST.Visitor;

public class SequentialCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
