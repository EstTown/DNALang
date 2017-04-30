package AST;

import ASTNodes.*;
import ASTNodes.ExpressionNodes.ExpressionNode;
import ASTNodes.ExpressionNodes.PlusNode;
import Generated.*;

import java.io.NotActiveException;


public class ASTBuilder<BaseNode> extends LanguageBaseVisitor<BaseNode>
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

                break;
        }



        return null; //should return node
    }
}
