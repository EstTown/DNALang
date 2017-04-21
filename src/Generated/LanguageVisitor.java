package Generated;// Generated from C:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LanguageParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(LanguageParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dclAssign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDclAssign(LanguageParser.DclAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dcl}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcl(LanguageParser.DclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(LanguageParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(LanguageParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#compoundstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundstatement(LanguageParser.CompoundstatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(LanguageParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelse(LanguageParser.IfelseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(LanguageParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(LanguageParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(LanguageParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidfunc}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidfunc(LanguageParser.VoidfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermExp(LanguageParser.TermExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleTerm}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTerm(LanguageParser.SingleTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExp(LanguageParser.ParensExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LanguageParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code break}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(LanguageParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(LanguageParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LanguageParser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(LanguageParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(LanguageParser.OperatorContext ctx);
}