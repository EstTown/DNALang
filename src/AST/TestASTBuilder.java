package AST;

import ASTNodes.BaseNode;
import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;

public class TestASTBuilder extends LanguageBaseVisitor<BaseNode>
{
    public static int Iterator = 0;
    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        ctx.accept(this);
        //System.out.println("Found prog"+ " " + Iterator);
        Iterator++;

        return null;
    }

    @Override
    public BaseNode visitStatements(LanguageParser.StatementsContext ctx)
    {
        //System.out.println("Found statementS"+ " " + Iterator);
        Iterator++;
        return null;
    }

    @Override
    public BaseNode visitStatement(LanguageParser.StatementContext ctx)
    {
        //System.out.println("Found statemenT"+ " " + Iterator);
        Iterator++;
        return null;
    }
}
