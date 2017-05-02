package ASTNodes.TerminalNodes;

import AST.Visitor;

/**
 * Created by Ruben on 02.05.2017.
 */
public class NullNode extends TerminalNode
{
    @Override
    public void Accept(Visitor nodevisitor)
    {
        nodevisitor.Visit(this);
    }
}
