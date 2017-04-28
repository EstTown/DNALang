package ASTNodes.CommandNodes;

import AST.Visitor;

public class ForCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
