// Generated from language.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link languageParser}.
 */
public interface languageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link languageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(languageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(languageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(languageParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(languageParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(languageParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(languageParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void enterArraytype(languageParser.ArraytypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void exitArraytype(languageParser.ArraytypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(languageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(languageParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(languageParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(languageParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(languageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(languageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#compoundstatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundstatement(languageParser.CompoundstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#compoundstatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundstatement(languageParser.CompoundstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(languageParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(languageParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterIteration(languageParser.IterationContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitIteration(languageParser.IterationContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(languageParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(languageParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(languageParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(languageParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(languageParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(languageParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(languageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(languageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(languageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(languageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(languageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(languageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterJump(languageParser.JumpContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitJump(languageParser.JumpContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintstatement(languageParser.PrintstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintstatement(languageParser.PrintstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link languageParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(languageParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link languageParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(languageParser.OperatorContext ctx);
}