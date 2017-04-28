package ASTNodes.TerminalNodes;

import AST.Visitor;

public class IdentifierNode extends TerminalNode
{
    public IdentifierNode(String spelling){
        this.spelling = spelling;
    }

    public void Accept(Visitor nodevisitor){
        nodevisitor.Visit(this);
    }
}
