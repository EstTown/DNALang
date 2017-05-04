package ASTNodes.TerminalNodes;

import AST.Visitor;

public class CodonLiteralNode extends TerminalNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
