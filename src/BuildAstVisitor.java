
import Generated.LanguageBaseVisitor;
import Generated.LanguageParser;
import Node.*;


public class BuildAstVisitor extends LanguageBaseVisitor<ExpressionNode>
{

    public ExpressionNode VisitAssignment(LanguageParser.AssignmentContext context){
        return  visitAssignment(context);
    }

    public ExpressionNode VisitArrayType(LanguageParser.ArraytypeContext context){
        return visitArraytype(context);
    }

    public ExpressionNode VisitCompoundStatement(LanguageParser.CompoundstatementContext context){
        return visitCompoundstatement(context);
    }
}
