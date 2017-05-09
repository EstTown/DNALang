package AST;

import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareArrayNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import Interfaces.ASTVisitor;

import java.util.ArrayList;
import java.util.Collections;

/*
In general, it seems that it's best to let each visitor (prettyprinter, typechecker etc.)
decide how to traverse the AST instead of having code in each node for that purpose,
although it does seem like it would make sense to have it in each node, because
we probably want to traverse in the same way, which would mean copying some code.
On the other hand it seems more natural to encapsulate this concern in each visitor,
because they might want to traverse differently <- not sure about that.
*/


public abstract class Visitor implements ASTVisitor
{
    public void visitChildren(BaseNode node)
    {
        ArrayList<BaseNode> list = new ArrayList<BaseNode>();

        //get all children of node and put into list
        BaseNode next = node.getLeftmostchild();
        while(true)
        {
            list.add(next);
            if(next.getRightsibling() == null)
            {
                break;
            }
            else
            {
                next = next.getRightsibling();
            }
        }
        Collections.reverse(list);
        //visit all children
        for(BaseNode item : list)
        {
            item.Accept(this);
        }
    }

    @Override
    public void Visit(BlockNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(AssignCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(BreakCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(CallCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ForCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(IfCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(PrintCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ReturnCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(SequentialCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(WhileCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(DeclareFunctionNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(DeclareVarNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(AndNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ComparisonNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(DivNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(LessThanNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(MinusNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(MultNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(NotNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(OrNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(PlusNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(IdentifierNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(IntegerLiteralNode node)
    {
        visitChildren(node);
    }
    @Override
    public void Visit(NullNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(OperatorNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ProgNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ModNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(NotEqualNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(EqualNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(GreaterThanNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(LessOrEqualNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(GreaterOrEqualNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(DNALiteralNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(AminoLiteralNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(CodonLiteralNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(RNALiteratalNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(BoolLiteralNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(IfElseCommandNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ConvertNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ComplementaryNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(LengthNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ReverseNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(ContainsNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(CountNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(PositionNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(RemoveNode node)
    {
        visitChildren(node);
    }

    @Override
    public void Visit(BaseNode node) { visitChildren(node);    }

    @Override
    public void Visit(DeclareArrayNode node) {visitChildren(node); }
}
