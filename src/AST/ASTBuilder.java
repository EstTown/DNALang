package AST;

import ASTNodes.CommandNodes.CallCommandNode;
import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;

public class ASTBuilder extends LanguageBaseVisitor<Object>
{
    @Override
    public Object visitOperator(LanguageParser.OperatorContext ctx)
    {

        return null;
    }
}
