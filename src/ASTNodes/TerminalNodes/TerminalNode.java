package ASTNodes.TerminalNodes;

import ASTNodes.BaseNode;
import Interfaces.ASTVisitor;

public abstract class TerminalNode extends BaseNode
{
    public String GetType()
    {
        String a = this.getClass().getSimpleName();

        return a;
    }
}
