package AST;

import ASTNodes.*;
import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
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
        int i;

        for(i = 0; i < children; i++)
        {
            if(ctx.declarations(i) != null)
            {
                ast.AddChild(visitDeclarations(ctx.declarations(i)));
            }
        }
        for (i = 0; i < children; i++)
        {
            if(ctx.statements(i) != null)
            {
                ast.AddChild(visitStatements(ctx.statements(i)));
            }
        }
        for(i = 0; i < children; i++)
        {
            if(ctx.functions(i) != null)
            {
                ast.AddChild(visit(ctx.functions(i)));
            }
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

        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitDnaExp(LanguageParser.DnaExpContext ctx)
    {
        DNALiteralNode node = new DNALiteralNode();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitRnaExp(LanguageParser.RnaExpContext ctx)
    {
        RNALiteratalNode node = new RNALiteratalNode();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitCodonExp(LanguageParser.CodonExpContext ctx)
    {
        CodonLiteralNode node = new CodonLiteralNode();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitProteinExp(LanguageParser.ProteinExpContext ctx)
    {
        AminoLiteralNode node = new AminoLiteralNode();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitBoolExp(LanguageParser.BoolExpContext ctx)
    {
        BoolLiteralNode node = new BoolLiteralNode();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitVariableExp(LanguageParser.VariableExpContext ctx)
    {
        IdentifierNode node = new IdentifierNode();
        node.content = ctx.getText();

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
        DeclareVarNode node = new DeclareVarNode();

        node.content = ctx.TYPE();

        node.AddChild(visit(ctx.assignment()));

        return node;
    }

    @Override
    public BaseNode visitDeclareVariable(LanguageParser.DeclareVariableContext ctx)
    {
        DeclareVarNode node = new DeclareVarNode();

        node.content = ctx.TYPE();

        return node;
    }

    @Override
    public BaseNode visitIdentifier(LanguageParser.IdentifierContext ctx)
    {
        IdentifierNode node = new IdentifierNode();
        node.content = ctx.getText();

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
        node.AddChild(visit(ctx.block()));
        return node;
    }

    @Override
    public BaseNode visitIfelse(LanguageParser.IfelseContext ctx)
    {
        IfElseCommandNode node = new IfElseCommandNode();
        node.AddChild(visit(ctx.predicate));
        node.AddChild(visit(ctx.block(0)));
        node.AddChild(visit(ctx.block(1)));
        return node;
    }

    @Override
    public BaseNode visitFor(LanguageParser.ForContext ctx)
    {
        ForCommandNode node = new ForCommandNode();
        node.AddChild(visit(ctx.iterator));
        node.AddChild(visit(ctx.predicate));
        node.AddChild(visit(ctx.increment));
        node.AddChild(visit(ctx.block()));

        return node;
    }


    @Override
    public BaseNode visitWhile(LanguageParser.WhileContext ctx)
    {
        WhileCommandNode node = new WhileCommandNode();

        node.AddChild(visit(ctx.predicate));

        node.AddChild(visit(ctx.block()));

        return node;
    }

    @Override
    public BaseNode visitFunctioncallExp(LanguageParser.FunctioncallExpContext ctx)
    {
        return visit(ctx.functioncall());
    }

    @Override
    public BaseNode visitFunctioncall(LanguageParser.FunctioncallContext ctx)
    {
        CallCommandNode node = new CallCommandNode();
        node.AddChild(visit(ctx.funcname));

        int children = ctx.getChildCount();
        int i;

        for(i = 0; i < children; i++)
        {
            if(ctx.expression(i) != null)
            {
                node.AddChild(visit(ctx.expression(i)));
            }
        }
        return node;
    }

    @Override
    public BaseNode visitBreak(LanguageParser.BreakContext ctx)
    {
        return new BreakCommandNode();
    }

    @Override
    public BaseNode visitReturn(LanguageParser.ReturnContext ctx)
    {
        ReturnCommandNode node = new ReturnCommandNode();

        node.AddChild(visit(ctx.expression()));

        return node;
    }

    @Override
    public BaseNode visitFunctions(LanguageParser.FunctionsContext ctx)
    {
        return visit(ctx.functiondeclaration());
    }

    @Override
    public BaseNode visitFunctiondeclaration(LanguageParser.FunctiondeclarationContext ctx)
    {
        DeclareFunctionNode node = new DeclareFunctionNode();

        node.content = ctx.TYPE();

        node.AddChild(visit(ctx.funcname));

        //get formal parameters
        int children = ctx.getChildCount();
        int i;
        for(i = 0; i < children; i++)
        {
            if(ctx.declaration(i) != null)
            {
                node.AddChild(visit(ctx.declaration(i)));
            }
        }
        node.AddChild(visit(ctx.block()));
        node.AddChild(visit(ctx.jump()));

        return node;
    }

    @Override
    public BaseNode visitBlock(LanguageParser.BlockContext ctx)
    {
        BlockNode node = new BlockNode();

        int children = ctx.getChildCount();
        int i;

        for(i = 0; i < children; i++)
        {
            if(ctx.declarations(i) != null)
            {
                node.AddChild(visit(ctx.declarations(i)));
            }
        }
        for(i = 0; i < children; i++)
        {
            if(ctx.statements(i) != null)
            {
                node.AddChild(visit(ctx.statements(i)));
            }
        }
        return node;
    }
}
