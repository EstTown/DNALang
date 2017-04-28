package Interfaces;

import ASTNodes.BlockNodes.*;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.*;
import ASTNodes.DeclareVarNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.TerminalNodes.*;

public interface ASTVisitor
{
    //needs a visit method for each type of node
    void Visit(AssignCommandNode assignCommandNode);
    void Visit(BreakCommandNode breakCommandNode);
    void Visit(CallCommandNode callCommandNode);
    void Visit(ForCommandNode forCommandNode);
    void Visit(IfCommandNode ifCommandNode);


}
