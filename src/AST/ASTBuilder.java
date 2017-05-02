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

    static int counter = 0;

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
        ProgNode node2 = new ProgNode();
        try
        {
            switch (ctx.op.getType())
            {
                case LanguageLexer.ADD:
                    node = new PlusNode();
                    break;
                case LanguageLexer.INT:
                    node = new IntegerLiteralNode();
                    break;
                default:
                    //node = null;
                    return node2;
                //break;
            }
        }
        catch(NullPointerException e)
        {
            ProgNode node1 = new ProgNode();
            return node1;
        }

        BaseNode left;
        node.AddChild(visitExpression(ctx.left));

        return node;
    }
}