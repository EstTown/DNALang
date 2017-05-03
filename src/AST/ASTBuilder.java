package AST;

import ASTNodes.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.TerminalNodes.*;
import Generated.*;
import org.antlr.v4.runtime.Token;

public class ASTBuilder extends LanguageBaseVisitor<BaseNode>
{
    /*
    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        //order?
        BaseNode ast = new ProgNode();
        ast.AddChild(visitStatements(ctx.statements(0)));
        return ast;
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
        //Token token = ctx.op.getType();
        System.out.println(ctx.op.getType());
        try
        {
            switch (ctx.op.getType())
            {
                case LanguageLexer.ADD:
                    node = new PlusNode();
                    break;
                case LanguageLexer.SUB:
                    node = new MinusNode();
                    break;
                case LanguageLexer.MUL:
                    node = new MultNode();
                    break;
                case LanguageLexer.DIV:
                    node = new DivNode();
                    break;
                case LanguageLexer.INT:
                    node = new IntegerLiteralNode();
                    break;
                default:
                    node = new NullNode();
                    break;
                //considering this is a null node, then something probably went wrong
                //not sure if error message here or in a later phase
            }
        }
        catch(NullPointerException e)
        {
            NullNode node1 = new NullNode();
            return node1;
        }
        node.AddChild(visitExpression(ctx.left));
        node.AddChild(visitExpression(ctx.right));

        return node;
    }
    */
}