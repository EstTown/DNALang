package AST;

import ASTNodes.*;
import ASTNodes.ExpressionNodes.ExpressionNode;
import ASTNodes.ExpressionNodes.PlusNode;
import ASTNodes.TerminalNodes.IntegerLiteralNode;
import ASTNodes.TerminalNodes.OperatorNode;
import ASTNodes.TerminalNodes.TerminalNode;
import Generated.*;
import org.antlr.v4.runtime.tree.RuleNode;


public class ASTBuilder extends LanguageBaseVisitor
{

    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        //order?
        return visitStatements(ctx.statements(0));
    }

    @Override
    public BaseNode visitStatements(LanguageParser.StatementsContext ctx)
    {
        return visitStatement(ctx.statement());
    }

    @Override
    public BaseNode visitStatement(LanguageParser.StatementContext ctx)
    {
        return visitExpression(ctx.expression());
    }

    @Override
    public BaseNode visitExpression(LanguageParser.ExpressionContext ctx)
    {
        BaseNode node;
        switch (ctx.op.getType())
        {
            case LanguageLexer.ADD:
                node = new PlusNode();
                break;
            case LanguageLexer.INT:
                node = new IntegerLiteralNode();
                break;
            default:
                node = null;
                return node;
                //break;
        }
        int a = ctx.getChildCount();
        System.out.println(a);

        /*
        switch(a)
        {
            case 0:
                break;
            case 1:
                left = visitExpression(ctx.expression(0));
                break;
            case 3:
                left = visitExpression(ctx.expression(0));
                right = visitExpression(ctx.expression(2));
                break;
            default:
                break;
        }
        */
        System.out.println(ctx.getChild(0).getChildCount());
        System.out.println(ctx.getChild(1).getChildCount());
        System.out.println(ctx.getChild(2).getChildCount());
        //visit(ctx.getChild(0));

        return node;
    }
}