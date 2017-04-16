// Generated from language.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link languageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface languageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link languageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(languageParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(languageParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(languageParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(languageParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(languageParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(languageParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(languageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#compoundstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundstatement(languageParser.CompoundstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(languageParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#iteration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration(languageParser.IterationContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(languageParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(languageParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(languageParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(languageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(languageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(languageParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#jump}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump(languageParser.JumpContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#printstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstatement(languageParser.PrintstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link languageParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(languageParser.OperatorContext ctx);
}