package ASTNodes.CommandNodes;

import AST.Visitor;

public class CallCommandNode extends CommandNode
{
    public int ActualParameters;
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
