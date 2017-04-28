package ASTNodes.DeclareVarNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class DeclareVarNodes extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
