package ASTNodes.DeclareVarNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class DeclareVarNode extends BaseNode
{
    @Override
    public void Accept(Visitor nodevisitor) {
        nodevisitor.Visit(this);
    }
}
