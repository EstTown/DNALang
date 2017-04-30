package AST;

import ASTNodes.CommandNodes.CallCommandNode;
import ASTNodes.ProgNode;
import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;

/*

public class ASTBuilder extends LanguageBaseVisitor<Object>
{
    @Override
    public Object visitOperator(LanguageParser.OperatorContext ctx)
    {

        return null;
    }

    @Override
    public Object visitTermExp(LanguageParser.TermExpContext ctx)
    {

        String a = ctx.term().getChild(0).getText();


        return super.visitTermExp(ctx);


        System.out.println("FOUND TERM");
        return null;
    }

    @Override
    public Object visitProg(LanguageParser.ProgContext ctx)
    {


        return super.visitProg(ctx);
    }

}
*/