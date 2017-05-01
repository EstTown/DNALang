package AST;

import ASTNodes.*;
import ASTNodes.ExpressionNodes.ExpressionNode;
import ASTNodes.ExpressionNodes.PlusNode;
import ASTNodes.TerminalNodes.IntegerLiteralNode;
import ASTNodes.TerminalNodes.OperatorNode;
import ASTNodes.TerminalNodes.TerminalNode;
import Generated.*;



public class ASTBuilder extends LanguageBaseVisitor
{
    @Override
    public BaseNode visitBinaryExp(LanguageParser.BinaryExpContext ctx)
    {
        ExpressionNode node;

        switch(ctx.op.getType())
        {
            case LanguageLexer.ADD:
                node = new PlusNode();
                break;
            default:
                node = null;
                break;
        }
        //visitNumberExp(ctx.expression(0));

        return node;
    }
    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        //order?
        return visitStatements(ctx.statements(0));

    }

    @Override
    public BaseNode visitNumberExp(LanguageParser.NumberExpContext ctx)
    {
        return new IntegerLiteralNode();
    }

    @Override
    public BaseNode visitStatements(LanguageParser.StatementsContext ctx)
    {
        return visitStatement(ctx.statement());
    }

    @Override
    public BaseNode visitStatement(LanguageParser.StatementContext ctx)
    {
        return null;
    }
}