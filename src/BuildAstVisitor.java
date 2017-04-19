/**
 * Created by frederik on 18/04/2017.
 */
import Node.*;
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

    public ExpressionNode VisitDeclaration(LanguageParser.DeclarationContext context){
        return visitDeclaration(context);
    }

    public ExpressionNode VisitDeclarations(LanguageParser.DeclarationsContext context){
        return visitDeclarations(context);
    }

    public ExpressionNode VisitExpression(LanguageParser.ExpressionContext context){
        return visitExpression(context);
    }

    public ExpressionNode VisitFunction(LanguageParser.FunctionContext context){
        return visitFunction(context);
    }


}
