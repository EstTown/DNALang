package ASTNodes.CommandNodes;

import AST.Visitor;

public class PrintCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
