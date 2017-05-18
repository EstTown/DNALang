package Interfaces;

import ASTNodes.BaseNode;
import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.ProgNode;
import ASTNodes.TerminalNodes.*;

//not used right now

public interface ASTVisitor<T>
{
    //needs a visit method for each type of node
    void Visit(BlockNode node);

    void Visit(AssignCommandNode node);
    void Visit(BreakCommandNode node);
    void Visit(CallCommandNode node);
    void Visit(ForCommandNode node);
    void Visit(IfCommandNode node);
    void Visit(IfElseCommandNode node);
    void Visit(PrintCommandNode node);
    void Visit(ReturnCommandNode node);
    void Visit(SequentialCommandNode node);
    void Visit(WhileCommandNode node);

    void Visit(DeclareFunctionNode node);

    void Visit(DeclareArrayNode node);
    void Visit(DeclareVarNode node);

    void Visit(AndNode node);
    void Visit(ComparisonNode node);
    void Visit(ComplementaryNode node);
    void Visit(ContainsNode node);
    void Visit(ConvertNode node);
    void Visit(CountNode node);
    void Visit(DivNode node);
    void Visit(GetNode node);
    void Visit(GreaterOrEqualNode node);
    void Visit(GreaterThanNode node);
    void Visit(LengthNode node);
    void Visit(LessOrEqualNode node);
    void Visit(LessThanNode node);
    void Visit(MinusNode node);
    void Visit(ModNode node);
    void Visit(MultNode node);
    void Visit(NotEqualNode node);
    void Visit(EqualNode node);
    void Visit(NotNode node);
    void Visit(OrNode node);
    void Visit(PlusNode node);
    void Visit(PositionNode node);
    void Visit(RemoveNode node);
    void Visit(ReverseNode node);

    void Visit(AminoLiteralNode node);
    void Visit(BoolLiteralNode node);
    void Visit(CodonLiteralNode node);
    void Visit(DNALiteralNode node);
    void Visit(IdentifierNode node);
    void Visit(IntegerLiteralNode node);
    void Visit(NullNode node);
    void Visit(OperatorNode node);
    void Visit(RNALiteratalNode node);

    void Visit(BaseNode node);
    void Visit(ProgNode node);
}