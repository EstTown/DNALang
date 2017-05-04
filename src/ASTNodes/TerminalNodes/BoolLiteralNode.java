package ASTNodes.TerminalNodes;

import AST.Visitor;

public class BoolLiteralNode extends TerminalNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
