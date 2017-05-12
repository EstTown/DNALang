// Generated from E:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
package Generated;
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
	 * Visit a parse tree produced by the {@code declareVariable}
	 * labeled alternative in {@link LanguageParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareVariable(LanguageParser.DeclareVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#arraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraytype(LanguageParser.ArraytypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compoundstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundstmt(LanguageParser.CompoundstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printstmt}
	 * labeled alternative in {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintstmt(LanguageParser.PrintstmtContext ctx);
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
	 * Visit a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#functiondeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctiondeclaration(LanguageParser.FunctiondeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(LanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExp(LanguageParser.ParensExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExp(LanguageParser.BinaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExp(LanguageParser.NumberExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code convertExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConvertExp(LanguageParser.ConvertExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(LanguageParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(LanguageParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDnaExp(LanguageParser.DnaExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableExp(LanguageParser.VariableExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rnaExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRnaExp(LanguageParser.RnaExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functioncallExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncallExp(LanguageParser.FunctioncallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codonExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodonExp(LanguageParser.CodonExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code proteinExp}
	 * labeled alternative in {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProteinExp(LanguageParser.ProteinExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code complementary}
	 * labeled alternative in {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplementary(LanguageParser.ComplementaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funccall}
	 * labeled alternative in {@link LanguageParser#functioncall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunccall(LanguageParser.FunccallContext ctx);
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
}