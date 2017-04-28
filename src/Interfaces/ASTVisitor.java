package Interfaces;

import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.*;

//not used right now

public interface ASTVisitor
{
    //needs a visit method for each type of node
    void Visit(BlockNode blockNode);

    void Visit(AssignCommandNode assignCommandNode);
    void Visit(BreakCommandNode breakCommandNode);
    void Visit(CallCommandNode callCommandNode);
    void Visit(ForCommandNode forCommandNode);
    void Visit(IfCommandNode ifCommandNode);
    void Visit(PrintCommandNode printCommandNode);
    void Visit(ReturnCommandNode returnCommandNode);
    void Visit(SequentialCommandNode sequentialCommandNode);
    void Visit(WhileCommandNode whileCommandNode);

    void Visit(DeclareFunctionNode declareFunctionNode);

    void Visit(DeclareVarNodes declareVarNodes);

    void Visit(AndNode andNode);
    void Visit(ComparisonNode comparisonNode);
    void Visit(DivNode divNode);
    void Visit(LessThanNode lessThanNode);
    void Visit(MinusNode minusNode);
    void Visit(MultNode multNode);
    void Visit(NotNode notNode);
    void Visit(OrNode orNode);
    void Visit(PlusNode plusNode);

    void Visit(IdentifierNode identifierNode);
    void Visit(IntegerLiteralNode integerLiteralNode);
    void Visit(OperatorNode operatorNode);

    void Visit(ProgNode progNode);
}
