/**
 * Created by frederik on 18/04/2017.
 */
import Node.*;
//import Generated.*;
import org.antlr.runtime.tree.*;


public class BuildAstVisitor extends LanguageBaseVisitor<ExpressionNode>{

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
