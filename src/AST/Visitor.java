package AST;

import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNodes;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.*;
import ASTNodes.TerminalNodes.*;
import Interfaces.ASTVisitor;


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
}
