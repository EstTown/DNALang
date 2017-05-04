// Generated from C:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
package Generated;
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
	 * Enter a parse tree produced by the {@code declareVariable}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclareVariable(LanguageParser.DeclareVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declareVariable}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclareVariable(LanguageParser.DeclareVariableContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LanguageParser.IdentifierContext ctx);
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
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LanguageParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compoundstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundstmt(LanguageParser.CompoundstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compoundstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundstmt(LanguageParser.CompoundstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintstmt(LanguageParser.PrintstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintstmt(LanguageParser.PrintstmtContext ctx);
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
	 * Enter a parse tree produced by {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(LanguageParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(LanguageParser.FunctioncallContext ctx);
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
	 * Enter a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExp(LanguageParser.NumberExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExp(LanguageParser.NumberExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExp(LanguageParser.BinaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExp(LanguageParser.BinaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(LanguageParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(LanguageParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(LanguageParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(LanguageParser.BoolExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDnaExp(LanguageParser.DnaExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDnaExp(LanguageParser.DnaExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariableExp(LanguageParser.VariableExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariableExp(LanguageParser.VariableExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRnaExp(LanguageParser.RnaExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRnaExp(LanguageParser.RnaExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functioncallExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncallExp(LanguageParser.FunctioncallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functioncallExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncallExp(LanguageParser.FunctioncallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codonExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCodonExp(LanguageParser.CodonExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codonExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCodonExp(LanguageParser.CodonExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code proteinExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterProteinExp(LanguageParser.ProteinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code proteinExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitProteinExp(LanguageParser.ProteinExpContext ctx);
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
}