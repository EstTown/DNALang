package Interfaces;

import ASTNodes.BaseNode;

public interface NodeInterface
{
    void Accept(ASTVisitor nodevisitor);
}
