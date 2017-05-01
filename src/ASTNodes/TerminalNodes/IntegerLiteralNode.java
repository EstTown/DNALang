package ASTNodes.TerminalNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class IntegerLiteralNode extends BaseNode
{

    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
