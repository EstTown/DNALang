package AST;

import ASTNodes.*;
import ASTNodes.BlockNodes.BlockNode;
import ASTNodes.CommandNodes.*;
import ASTNodes.DeclareFunctionNodes.DeclareFunctionNode;
import ASTNodes.DeclareVarNodes.DeclareArrayNode;
import ASTNodes.DeclareVarNodes.DeclareVarNode;
import Generated.*;
import ASTNodes.ExpressionNodes.*;
import ASTNodes.TerminalNodes.*;

import java.util.ArrayList;
import java.util.List;


public class ASTBuilder extends LanguageBaseVisitor<BaseNode>
{
    @Override
    public BaseNode visitProg(LanguageParser.ProgContext ctx)
    {
        //order?
        BaseNode ast = new ProgNode();

        int children = ctx.getChildCount();

		int funcCounter = 0;
		int declCounter = 0;
		int stmtCounter = 0;

		for(int i = 0; i < children; i++)
		{
			if (ctx.getChild(i) != null) {
				if (ctx.getChild(i).getClass().getSimpleName().equals("DeclarationsContext")) {
					ast.AddChild(visitDeclarations(ctx.declarations(declCounter)));
					declCounter++;
				}

				if (ctx.getChild(i).getClass().getSimpleName().equals("StatementsContext")) {
					ast.AddChild(visitStatements(ctx.statements(stmtCounter)));
					stmtCounter++;
				}

				if (ctx.getChild(i).getClass().getSimpleName().equals("FunctionsContext")) {
					ast.AddChild(visitFunctions(ctx.functions(funcCounter)));
					funcCounter++;
				}
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

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

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
			case LanguageLexer.EQEQ:
				node = new EqualNode();
				break;
            case LanguageLexer.NOTEQ:
                node = new NotEqualNode();
                break;
            case LanguageLexer.CONTAINS:
                node = new ContainsNode();
                break;
            case LanguageLexer.POSITION:
                node = new PositionNode();
                break;
            case LanguageLexer.COUNT:
                node = new CountNode();
                break;
            case LanguageLexer.REMOVE:
                node = new RemoveNode();
                break;
            default:
                node = new NullNode();
                break;
        }
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        node.AddChild(visit(ctx.left));
        node.AddChild(visit(ctx.right));

        return node;
    }

    @Override
    public BaseNode visitNumberExp(LanguageParser.NumberExpContext ctx)
    {
        IntegerLiteralNode node = new IntegerLiteralNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitDnaExp(LanguageParser.DnaExpContext ctx)
    {
        DNALiteralNode node = new DNALiteralNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitRnaExp(LanguageParser.RnaExpContext ctx)
    {
        RNALiteratalNode node = new RNALiteratalNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitCodonExp(LanguageParser.CodonExpContext ctx)
    {
        CodonLiteralNode node = new CodonLiteralNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitProteinExp(LanguageParser.ProteinExpContext ctx)
    {
        AminoLiteralNode node = new AminoLiteralNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitBoolExp(LanguageParser.BoolExpContext ctx)
    {
        BoolLiteralNode node = new BoolLiteralNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        node.content = ctx.getText();

        return node;
    }

    @Override
    public BaseNode visitVariableExp(LanguageParser.VariableExpContext ctx)
    {
        IdentifierNode node = new IdentifierNode();

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
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
        node.line = ctx.getStart().getLine();
        node.pos = ctx.getStart().getCharPositionInLine();

        node.spelling = visit(ctx.left).content.toString();
        node.AddChild(visit(ctx.right));

        return node;
    }

    @Override
    public BaseNode visitDclAssign(LanguageParser.DclAssignContext ctx)
    {
        DeclareVarNode node = new DeclareVarNode();

        node.content = ctx.TYPE();
        if(ctx.TYPE() != null)
        {
            node.content = ctx.TYPE();
            node.AddChild(visit(ctx.assignment()));
            node.spelling=node.getLeftmostchild().spelling;
        }
        else
        {
            node.AddChild(visit(ctx.arrtype));
            node.AddChild(visit(ctx.assignment()));
            node.spelling=node.getLeftmostchild().getRightsibling().spelling; //should be correct child
        }

        node.line = ctx.getStart().getLine();
        node.pos = ctx.getStart().getCharPositionInLine();
        return node;
    }

    @Override
    public BaseNode visitDeclareVariable(LanguageParser.DeclareVariableContext ctx)
    {
        DeclareVarNode node = new DeclareVarNode();
        if(ctx.TYPE() != null)
        {
            node.content = ctx.TYPE();
        }
        else
        {
            node.AddChild(visit(ctx.arrtype));
        }
        /*
        node.AddChild(visit(ctx.identifier()));     //we don't want to add the identifier as a child
        node.spelling = node.getLeftmostchild().content.toString();
        */

        node.spelling = visit(ctx.identifier()).content.toString();

        node.line = ctx.getStart().getLine();
        node.pos = ctx.getStart().getCharPositionInLine();
        return node;
    }

    @Override
    public BaseNode visitArraytype(LanguageParser.ArraytypeContext ctx)
    {
        DeclareArrayNode node = new DeclareArrayNode();
        node.content = ctx.TYPE();
        node.AddChild(visit(ctx.expression()));
        return node;
    }

    @Override
    public BaseNode visitIdentifier(LanguageParser.IdentifierContext ctx)
    {
        IdentifierNode node = new IdentifierNode();
        node.content = ctx.getText();
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

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
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        return node;
    }

    @Override
    public BaseNode visitIf(LanguageParser.IfContext ctx)
    {
        IfCommandNode node = new IfCommandNode();
        node.AddChild(visit(ctx.predicate));
        node.AddChild(visit(ctx.block()));
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        return node;
    }

    @Override
    public BaseNode visitIfelse(LanguageParser.IfelseContext ctx)
    {
        IfElseCommandNode node = new IfElseCommandNode();
		node.AddChild(visit(ctx.predicate));
        node.AddChild(visit(ctx.block(1)));
		node.AddChild(visit(ctx.block(0)));
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
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
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        return node;
    }


    @Override
    public BaseNode visitWhile(LanguageParser.WhileContext ctx)
    {
        WhileCommandNode node = new WhileCommandNode();

        node.AddChild(visit(ctx.predicate));

        node.AddChild(visit(ctx.block()));

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        return node;
    }

    @Override
    public BaseNode visitFunctioncallExp(LanguageParser.FunctioncallExpContext ctx)
    {
        return visit(ctx.functioncall());
    }

    @Override
    public BaseNode visitFunccall(LanguageParser.FunccallContext ctx)
    {
        CallCommandNode node = new CallCommandNode();
        node.AddChild(visit(ctx.identifier()));
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

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        return node;
    }

    @Override
    public BaseNode visitComplementary(LanguageParser.ComplementaryContext ctx)
    {
        BaseNode node;

        switch(ctx.op.getType())
        {
            case LanguageLexer.COMPLEMENTARY:
                node = new ComplementaryNode();
                break;
            case LanguageLexer.REVERSE:
                node = new ReverseNode();
                break;
            case LanguageLexer.LENGTH:
                node = new LengthNode();
                break;
            default:
                node = new NullNode();
                break;
        }
        node.AddChild(visit(ctx.expression()));

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

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
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

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
        node.content = ctx.TYPE().toString(); //type of this function

        //get formal parameters
        int children = ctx.getChildCount();
        int i;
        ArrayList<BaseNode> list = new ArrayList<>();
        BaseNode temp;
        for(i = 0; i < children ; i++)
        {
            if(ctx.declaration(i) != null)
            {
                temp = visit(ctx.declaration(i));
                node.AddChild(temp);
                list.add(temp);
            }
        }

        /*add formal parameters to the declarefunctionnode, so that we don't have to look at this nodes children,
        to find the formal parameters, when we want to put that information into the symbol table */


        for(BaseNode item : list)
        {
            node.AddParameters(item.content.toString(), item.getLeftmostchild().content.toString());
        }

        BaseNode temp2 = visit(ctx.funcname);
        node.AddChild(temp2);
        node.functionName = temp2.content.toString();

        node.AddChild(visit(ctx.block()));
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

		//find return types??

        return node;
    }

    @Override
    public BaseNode visitBlock(LanguageParser.BlockContext ctx)
    {
        BlockNode node = new BlockNode();

        int children = ctx.getChildCount();

		int declCounter = 0;
		int stmtCounter = 0;

		for(int i = 0; i < children; i++)
		{
			if (ctx.getChild(i) != null) {
				if (ctx.getChild(i).getClass().getSimpleName().equals("DeclarationsContext"))
				{
					node.AddChild(visitDeclarations(ctx.declarations(declCounter)));
					declCounter++;
				}

				if (ctx.getChild(i).getClass().getSimpleName().equals("StatementsContext")) {
					node.AddChild(visitStatements(ctx.statements(stmtCounter)));
					stmtCounter++;
				}
			}
		}

		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();

        return node;
    }

    @Override
    public BaseNode visitParensExp(LanguageParser.ParensExpContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public BaseNode visitConvertExp(LanguageParser.ConvertExpContext ctx) {
        ConvertNode node = new ConvertNode();
        node.content = ctx.TYPE();
        node.AddChild(visit(ctx.left));
		node.line = ctx.getStart().getLine();
		node.pos = ctx.getStart().getCharPositionInLine();
        return node;
    }
}
