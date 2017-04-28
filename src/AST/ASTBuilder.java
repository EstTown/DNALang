package AST;

import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;

public class ASTBuilder extends LanguageBaseVisitor<Object>
{
    @Override
    public Object visitOperator(LanguageParser.OperatorContext ctx)
    {
        System.out.println(ctx.getText()+"\n");


        return null;
    }
}
