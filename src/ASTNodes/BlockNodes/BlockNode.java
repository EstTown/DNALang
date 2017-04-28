package ASTNodes.BlockNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class BlockNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
