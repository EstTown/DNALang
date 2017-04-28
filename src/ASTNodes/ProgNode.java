package ASTNodes;

import AST.Visitor;
import Interfaces.ASTVisitor;

public class ProgNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
