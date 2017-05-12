package ASTNodes.BlockNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class BlockNode extends BaseNode
{
    public boolean HasNotBeenChecked = true;

    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
