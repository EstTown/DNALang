package AST;

import ASTNodes.*;
import ASTNodes.CommandNodes.*;
import Generated.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.TerminalNodes.*;



public class ASTBuilder extends LanguageBaseVisitor<BaseNode>
{
    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        //order?
        BaseNode ast = new ProgNode();

        int children = ctx.getChildCount();
        for (int i = 0; i < children; i++)
        {
            ast.AddChild(visitStatements(ctx.statements(i)));
        }


        return ast;
    }

    @Override
    public BaseNode visitStatements(LanguageParser.StatementsContext ctx)
    {
        return visit(ctx.statement());
    }

    @Override
    public BaseNode visitAssign(LanguageParser.AssignContext ctx)
    {
        return visit(ctx.assignment());
    }

    @Override
    public BaseNode visitExpr(LanguageParser.ExprContext ctx)
    {
        return visit(ctx.expression());
    }

    @Override
    public BaseNode visitUnaryExp(LanguageParser.UnaryExpContext ctx)
    {
        BaseNode node;
        switch(ctx.op.getType())
        {
            case LanguageLexer.NOT:
                node = new NotNode();
                break;
            default:
                node = new NullNode();
                break;
        }
        node.AddChild(visit(ctx.expression()));

        return node;
    }

    @Override
    public BaseNode visitBinaryExp(LanguageParser.BinaryExpContext ctx)
    {
        BaseNode node;
        switch (ctx.op.getType())
        {
            case LanguageLexer.ADD:
                node = new PlusNode();
                break;
            case LanguageLexer.SUB:
                node = new MinusNode();
                break;
            case LanguageLexer.MUL:
                node = new MultNode();
                break;
            case LanguageLexer.DIV:
                node = new DivNode();
                break;
            case LanguageLexer.MOD:
                node = new ModNode();
                break;
            case LanguageLexer.LT:
                node = new LessThanNode();
                break;
            case LanguageLexer.GT:
                node = new GreaterThanNode();
                break;
            case LanguageLexer.GTEQ:
                node = new GreaterOrEqualNode();
                break;
            case LanguageLexer.LTEQ:
                node = new LessOrEqualNode();
                break;
            case LanguageLexer.AND:
                node = new AndNode();
                break;
            case LanguageLexer.OR:
                node = new OrNode();
                break;
            case LanguageLexer.NOTEQ:
                node = new NotEqualNode();
                break;
            default:
                node = new NullNode();
                break;
        }
        node.AddChild(visit(ctx.left));
        node.AddChild(visit(ctx.right));

        return node;
    }

    @Override
    public BaseNode visitNumberExp(LanguageParser.NumberExpContext ctx)
    {
        IntegerLiteralNode node = new IntegerLiteralNode();

        node.setValue(ctx.getText());

        return node;
    }

    @Override
    public BaseNode visitDnaExp(LanguageParser.DnaExpContext ctx)
    {
        DNALiteralNode node = new DNALiteralNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitRnaExp(LanguageParser.RnaExpContext ctx)
    {
        RNALiteratalNode node = new RNALiteratalNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitCodonExp(LanguageParser.CodonExpContext ctx)
    {
        CodonLiteralNode node = new CodonLiteralNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitProteinExp(LanguageParser.ProteinExpContext ctx)
    {
        AminoLiteralNode node = new AminoLiteralNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitBoolExp(LanguageParser.BoolExpContext ctx)
    {
        BoolLiteralNode node = new BoolLiteralNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitVariableExp(LanguageParser.VariableExpContext ctx)
    {
        IdentifierNode node = new IdentifierNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitDeclarations(LanguageParser.DeclarationsContext ctx)
    {
        return visit(ctx.declaration());
    }


    @Override
    public BaseNode visitAssignment(LanguageParser.AssignmentContext ctx)
    {
        BaseNode node;
        switch(ctx.op.getType())
        {
            case LanguageLexer.EQUAL:
                node = new AssignCommandNode();
                break;
            default:
                node = new NullNode();
                break;
        }

        node.AddChild(visit(ctx.left));
        node.AddChild(visit(ctx.right));

        return node;
    }

    @Override
    public BaseNode visitDclAssign(LanguageParser.DclAssignContext ctx)
    {
        return super.visitDclAssign(ctx);
    }

    @Override
    public BaseNode visitDeclareVariable(LanguageParser.DeclareVariableContext ctx)
    {
        return super.visitDeclareVariable(ctx);
    }

    @Override
    public BaseNode visitIdentifier(LanguageParser.IdentifierContext ctx)
    {
        IdentifierNode node = new IdentifierNode();
        node.spelling = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitCompoundstmt(LanguageParser.CompoundstmtContext ctx)
    {
        return visit(ctx.compoundstatement());
    }

    /*
    @Override
    public BaseNode visitCompoundstatement(LanguageParser.CompoundstatementContext ctx)
    {
        return null;
    }
    */

    @Override
    public BaseNode visitPrintstmt(LanguageParser.PrintstmtContext ctx)
    {
        return visit(ctx.printstatement());
    }

    @Override
    public BaseNode visitPrint(LanguageParser.PrintContext ctx)
    {
        PrintCommandNode node = new PrintCommandNode();
        node.AddChild(visit(ctx.left));

        return node;
    }

    @Override
    public BaseNode visitIf(LanguageParser.IfContext ctx)
    {
        IfCommandNode node = new IfCommandNode();

        node.AddChild(visit(ctx.predicate));

        int children = ctx.getChildCount();
        int i;

        for(i = 0; i < children; i++)
        {
            LanguageParser.DeclarationsContext childContext = ctx.declarations(i);
            if(childContext != null)
            {
                node.AddChild(visitDeclarations(ctx.declarations(i)));
            }
        }
        for (i = 0; i < children; i++)
        {
            LanguageParser.StatementsContext childContext = ctx.statements(i);
            if(childContext != null)
            {
                node.AddChild(visitStatements(ctx.statements(i)));
            }
        }

        return node;
    }

    @Override
    public BaseNode visitIfelse(LanguageParser.IfelseContext ctx)
    {
        IfElseCommandNode node = new IfElseCommandNode();
        node.AddChild(visit(ctx.predicate));

        int children = ctx.getChildCount();
        int i;
        for(i = 0; i < children; i++)
        {
            LanguageParser.DeclarationsContext childContext = ctx.declarations(i);
            if(childContext != null)
            {
                node.AddChild(visit(ctx.declarations(i)));
            }
        }
        for (i = 0; i < children; i++)
        {
            LanguageParser.StatementsContext childContext = ctx.statements(i);
            if(childContext != null)
            {
                node.AddChild(visit(ctx.statements(i)));
            }
        }



        return node;
    }

    @Override
    public BaseNode visitFor(LanguageParser.ForContext ctx)
    {



        return new NullNode();
    }

    @Override
    public BaseNode visitWhile(LanguageParser.WhileContext ctx) {
        return super.visitWhile(ctx);
    }

    @Override
    public BaseNode visitFunctioncallExp(LanguageParser.FunctioncallExpContext ctx)
    {

        return new NullNode();
    }
}
