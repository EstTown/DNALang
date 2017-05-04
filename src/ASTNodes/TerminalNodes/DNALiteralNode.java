package ASTNodes.TerminalNodes;

import AST.Visitor;

public class DNALiteralNode extends TerminalNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
