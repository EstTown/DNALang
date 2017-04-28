package ASTNodes;

import Interfaces.ASTVisitor;
import Interfaces.NodeInterface;

public class ProgNode implements NodeInterface
{
    public void Accept(ASTVisitor visitor){visitor.Visit(this);}
}
