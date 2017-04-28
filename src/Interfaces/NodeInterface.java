package Interfaces;

import AST.Visitor;
import ASTNodes.BaseNode;

public interface NodeInterface
{
    void Accept(Visitor nodevisitor);
}
