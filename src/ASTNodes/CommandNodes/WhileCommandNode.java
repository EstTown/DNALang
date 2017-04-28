package ASTNodes.CommandNodes;

import AST.Visitor;

public class WhileCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
