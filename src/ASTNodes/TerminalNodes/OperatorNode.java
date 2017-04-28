package ASTNodes.TerminalNodes;

import AST.Visitor;

public class OperatorNode extends TerminalNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
