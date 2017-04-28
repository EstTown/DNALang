package ASTNodes.DeclareFunctionNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class DeclareFunctionNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
