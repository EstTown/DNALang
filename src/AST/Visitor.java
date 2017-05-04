package AST;

import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNodes;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import Interfaces.ASTVisitor;

/*
In general, it seems that it's best to let each visitor (prettyprinter, typechecker etc.)
decide how to traverse the AST instead of having code in each node for that purpose,
although it does seem like it would make sense to have it in each node, because
we probably want to traverse in the same way, which would mean copying some code.
On the other hand it seems more natural to encapsulate this concern in each visitor,
because they might want to traverse differently <- not sure about that.
*/


public abstract class Visitor<BaseNode> implements ASTVisitor<BaseNode>
{
    @Override
    public BaseNode Visit(BlockNode blockNode){return null;}


    @Override
    public void Visit(AssignCommandNode assignCommandNode)
    {

    }

    @Override
    public void Visit(BreakCommandNode breakCommandNode)
    {

    }

    @Override
    public void Visit(CallCommandNode callCommandNode)
    {

    }

    @Override
    public void Visit(ForCommandNode forCommandNode)
    {

    }

    @Override
    public void Visit(IfCommandNode ifCommandNode)
    {

    }

    @Override
    public void Visit(PrintCommandNode printCommandNode)
    {

    }

    @Override
    public void Visit(ReturnCommandNode returnCommandNode)
    {

    }

    @Override
    public void Visit(SequentialCommandNode sequentialCommandNode)
    {

    }

    @Override
    public void Visit(WhileCommandNode whileCommandNode)
    {

    }

    @Override
    public void Visit(DeclareFunctionNode declareFunctionNode)
    {

    }

    @Override
    public void Visit(DeclareVarNodes declareVarNodes)
    {

    }

    @Override
    public void Visit(AndNode andNode)
    {

    }

    @Override
    public void Visit(ComparisonNode comparisonNode)
    {

    }

    @Override
    public void Visit(DivNode divNode)
    {

    }

    @Override
    public void Visit(LessThanNode lessThanNode)
    {

    }

    @Override
    public void Visit(MinusNode minusNode)
    {

    }

    @Override
    public void Visit(MultNode multNode)
    {

    }

    @Override
    public void Visit(NotNode notNode)
    {

    }

    @Override
    public void Visit(OrNode orNode)
    {

    }

    @Override
    public void Visit(PlusNode plusNode)
    {

    }

    @Override
    public void Visit(IdentifierNode identifierNode)
    {

    }

    @Override
    public void Visit(IntegerLiteralNode integerLiteralNode)
    {

    }
    @Override
    public void Visit(NullNode nullNode)
    {

    }

    @Override
    public void Visit(OperatorNode operatorNode)
    {

    }

    @Override
    public void Visit(ProgNode progNode)
    {

    }

    @Override
    public void Visit(ModNode modNode)
    {

    }

    @Override
    public void Visit(NotEqualNode notEqualNode)
    {

    }

    @Override
    public void Visit(GreaterThanNode greaterThanNode)
    {

    }

    @Override
    public void Visit(LessOrEqualNode lessOrEqualNode)
    {

    }

    @Override
    public void Visit(GreaterOrEqualNode greaterOrEqualNode)
    {

    }

    @Override
    public void Visit(DNALiteralNode dnaLiteralNode)
    {

    }

    @Override
    public void Visit(AminoLiteralNode aminoLiteralNode)
    {

    }

    @Override
    public void Visit(CodonLiteralNode codonLiteralNode)
    {

    }

    @Override
    public void Visit(RNALiteratalNode rnaLiteratalNode)
    {

    }

    @Override
    public void Visit(BoolLiteralNode boolLiteralNode)
    {

    }
}
