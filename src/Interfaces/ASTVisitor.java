package Interfaces;

import Nodes.*;

public interface ASTVisitor
{
    //needs a visit method for each type of node
    void Visit(NodeInterface node);

}
