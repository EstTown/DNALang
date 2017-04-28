package AST;

import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;

public class TestASTBuilder extends LanguageBaseVisitor<Object>
{
    public static int Iterator = 0;
    @Override
    public Object visitProg(LanguageParser.ProgContext ctx)
    {
        //System.out.println("Found prog"+ " " + Iterator);
        Iterator++;
        return null;
    }

    @Override
    public Object visitStatements(LanguageParser.StatementsContext ctx)
    {
        //System.out.println("Found statementS"+ " " + Iterator);
        Iterator++;
        return null;
    }

    @Override
    public Object visitStatement(LanguageParser.StatementContext ctx)
    {
        //System.out.println("Found statemenT"+ " " + Iterator);
        Iterator++;
        return null;
    }


}
