package AST;

import ASTNodes.ExpressionNodes.MultNode;
import ASTNodes.ExpressionNodes.PlusNode;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.DNALiteralNode;

public class PrettyPrinter extends Visitor
{
    @Override
    public void Visit(DNALiteralNode dnaLiteralNode)
    {
        System.out.println("This was my input: "+dnaLiteralNode.spelling);
    }

    @Override
    public void Visit(ProgNode progNode)
    {
        progNode.getLeftmostchild().Accept(this); //this visits child node. Dunno how work
        System.out.println("We are at a prognode/root");

    }

    @Override
    public void Visit(PlusNode plusNode)
    {
        plusNode.getLeftmostchild().Accept(this);
        System.out.println("+");
        //plusNode.getLeftmostchild().getRightsibling().Accept(this); //this does not work
    }

}
