/**
 * Created by frederik on 18/04/2017.
 */
import Node.*;
import org.antlr.runtime.tree.*;


public class BuildAstVisitor extends languageBaseVisitor<ExpressionNode>{

    public ExpressionNode VisitAssignment(languageParser.AssignmentContext context){
        return  visitAssignment(context);
    }

    public ExpressionNode VisitArrayType(languageParser.ArraytypeContext context){
        return visitArraytype(context);
    }

    public ExpressionNode VisitCompoundStatement(languageParser.CompoundstatementContext context){
        return visitCompoundstatement(context);
    }

    public ExpressionNode VisitDeclaration(languageParser.DeclarationContext context){
        return visitDeclaration(context);
    }

    public ExpressionNode VisitDeclarations(languageParser.DeclarationsContext context){
        return visitDeclarations(context);
    }

    public ExpressionNode VisitExpression(languageParser.ExpressionContext context){
        return visitExpression(context);
    }

    public ExpressionNode VisitFunction(languageParser.FunctionContext context){
        return visitFunction(context);
    }


}
