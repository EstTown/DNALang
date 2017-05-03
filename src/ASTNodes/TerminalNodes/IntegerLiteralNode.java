package ASTNodes.TerminalNodes;

import AST.Visitor;
import ASTNodes.BaseNode;

public class IntegerLiteralNode extends TerminalNode
{
    //field for storing values
    private int value;
    public int getValue(){return this.value;}
    public void setValue(int value){this.value = value;}

    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
