package ASTNodes.CommandNodes;

import AST.Visitor;

public class IfElseCommandNode extends CommandNode
{
    @Override
    public void Accept(Visitor nodevisitor) {
        nodevisitor.Visit(this);
    }
}
