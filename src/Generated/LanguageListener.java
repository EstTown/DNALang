package Generated;// Generated from C:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(LanguageParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(LanguageParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dclAssign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDclAssign(LanguageParser.DclAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dclAssign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDclAssign(LanguageParser.DclAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dcl}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDcl(LanguageParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dcl}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDcl(LanguageParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LanguageParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void enterArraytype(LanguageParser.ArraytypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#arraytype}.
	 * @param ctx the parse tree
	 */
	void exitArraytype(LanguageParser.ArraytypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterId(LanguageParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitId(LanguageParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#compoundstatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundstatement(LanguageParser.CompoundstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#compoundstatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundstatement(LanguageParser.CompoundstatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterIf(LanguageParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitIf(LanguageParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(LanguageParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelse}
	 * labeled alternative in {@link LanguageParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(LanguageParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterWhile(LanguageParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitWhile(LanguageParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void enterFor(LanguageParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link LanguageParser#iteration}.
	 * @param ctx the parse tree
	 */
	void exitFor(LanguageParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code func}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunc(LanguageParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code func}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunc(LanguageParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidfunc}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void enterVoidfunc(LanguageParser.VoidfuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidfunc}
	 * labeled alternative in {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void exitVoidfunc(LanguageParser.VoidfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTermExp(LanguageParser.TermExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTermExp(LanguageParser.TermExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleTerm}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSingleTerm(LanguageParser.SingleTermContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleTerm}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSingleTerm(LanguageParser.SingleTermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParensExp(LanguageParser.ParensExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParensExp(LanguageParser.ParensExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code break}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterBreak(LanguageParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code break}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitBreak(LanguageParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code return}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 */
	void enterReturn(LanguageParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code return}
	 * labeled alternative in {@link LanguageParser#jump}.
	 * @param ctx the parse tree
	 */
	void exitReturn(LanguageParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code print}
	 * labeled alternative in {@link LanguageParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void enterPrint(LanguageParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code print}
	 * labeled alternative in {@link LanguageParser#printstatement}.
	 * @param ctx the parse tree
	 */
	void exitPrint(LanguageParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(LanguageParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(LanguageParser.OperatorContext ctx);
}