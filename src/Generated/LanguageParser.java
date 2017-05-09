// Generated from C:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
package Generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TYPE=12, BOOL=13, INT=14, DNA=15, RNA=16, DNAsym=17, 
		RNAsym=18, CODON=19, PROTEIN=20, AMINOACIDSINGLE=21, AMINOACIDTRIPLE=22, 
		Word=23, WS=24, LCURLY=25, LPAREN=26, LBRACK=27, RCURLY=28, RPAREN=29, 
		RBRACK=30, COMMA=31, COLON=32, SEMI=33, LT=34, GT=35, LTEQ=36, GTEQ=37, 
		UNDERSCORE=38, NOT=39, AND=40, SUB=41, EQUAL=42, EQEQ=43, NOTEQ=44, OR=45, 
		DIV=46, ADD=47, MUL=48, MOD=49, CONTAINS=50, COMPLEMENTARY=51, REVERSE=52, 
		LENGTH=53, POSITION=54, COUNT=55, REMOVE=56;
	public static final int
		RULE_prog = 0, RULE_declarations = 1, RULE_declaration = 2, RULE_arraytype = 3, 
		RULE_identifier = 4, RULE_statements = 5, RULE_block = 6, RULE_statement = 7, 
		RULE_compoundstatement = 8, RULE_selection = 9, RULE_iteration = 10, RULE_functions = 11, 
		RULE_functiondeclaration = 12, RULE_assignment = 13, RULE_expression = 14, 
		RULE_functioncall = 15, RULE_jump = 16, RULE_printstatement = 17;
	public static final String[] ruleNames = {
		"prog", "declarations", "declaration", "arraytype", "identifier", "statements", 
		"block", "statement", "compoundstatement", "selection", "iteration", "functions", 
		"functiondeclaration", "assignment", "expression", "functioncall", "jump", 
		"printstatement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'void'", "'as'", "'in'", 
		"'from'", "'break'", "'return'", "'Print'", null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "'{'", "'('", "'['", "'}'", 
		"')'", "']'", "','", "':'", "';'", "'<'", "'>'", "'<='", "'>='", "'_'", 
		"'!'", "'&&'", "'-'", "'='", "'=='", "'!='", "'||'", "'/'", "'+'", "'*'", 
		"'%'", "'contains:'", "'comp:'", "'rev:'", "'len:'", "'position of '", 
		"'count '", "'remove '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"TYPE", "BOOL", "INT", "DNA", "RNA", "DNAsym", "RNAsym", "CODON", "PROTEIN", 
		"AMINOACIDSINGLE", "AMINOACIDTRIPLE", "Word", "WS", "LCURLY", "LPAREN", 
		"LBRACK", "RCURLY", "RPAREN", "RBRACK", "COMMA", "COLON", "SEMI", "LT", 
		"GT", "LTEQ", "GTEQ", "UNDERSCORE", "NOT", "AND", "SUB", "EQUAL", "EQEQ", 
		"NOTEQ", "OR", "DIV", "ADD", "MUL", "MOD", "CONTAINS", "COMPLEMENTARY", 
		"REVERSE", "LENGTH", "POSITION", "COUNT", "REMOVE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<DeclarationsContext> declarations() {
			return getRuleContexts(DeclarationsContext.class);
		}
		public DeclarationsContext declarations(int i) {
			return getRuleContext(DeclarationsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<FunctionsContext> functions() {
			return getRuleContexts(FunctionsContext.class);
		}
		public FunctionsContext functions(int i) {
			return getRuleContext(FunctionsContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << TYPE) | (1L << BOOL) | (1L << INT) | (1L << DNA) | (1L << RNA) | (1L << CODON) | (1L << PROTEIN) | (1L << Word) | (1L << LPAREN) | (1L << NOT) | (1L << COMPLEMENTARY) | (1L << REVERSE) | (1L << LENGTH) | (1L << POSITION) | (1L << COUNT) | (1L << REMOVE))) != 0)) {
				{
				setState(39);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					declarations();
					}
					break;
				case 2:
					{
					setState(37);
					statements();
					}
					break;
				case 3:
					{
					setState(38);
					functions();
					}
					break;
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			declaration();
			setState(45);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclareVariableContext extends DeclarationContext {
		public Token type;
		public ArraytypeContext arrtype;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(LanguageParser.TYPE, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public DeclareVariableContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclareVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclareVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclareVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DclAssignContext extends DeclarationContext {
		public Token type;
		public ArraytypeContext arrtype;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(LanguageParser.TYPE, 0); }
		public ArraytypeContext arraytype() {
			return getRuleContext(ArraytypeContext.class,0);
		}
		public DclAssignContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDclAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDclAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDclAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new DclAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(47);
					((DclAssignContext)_localctx).type = match(TYPE);
					}
					break;
				case 2:
					{
					setState(48);
					((DclAssignContext)_localctx).arrtype = arraytype();
					}
					break;
				}
				setState(51);
				assignment();
				}
				break;
			case 2:
				_localctx = new DeclareVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(52);
					((DeclareVariableContext)_localctx).type = match(TYPE);
					}
					break;
				case 2:
					{
					setState(53);
					((DeclareVariableContext)_localctx).arrtype = arraytype();
					}
					break;
				}
				setState(56);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArraytypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(LanguageParser.TYPE, 0); }
		public ArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraytype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterArraytype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitArraytype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitArraytype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraytypeContext arraytype() throws RecognitionException {
		ArraytypeContext _localctx = new ArraytypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arraytype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(TYPE);
			setState(60);
			match(LBRACK);
			setState(61);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Word() { return getToken(LanguageParser.Word, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(Word);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<DeclarationsContext> declarations() {
			return getRuleContexts(DeclarationsContext.class);
		}
		public DeclarationsContext declarations(int i) {
			return getRuleContext(DeclarationsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(67);
				declarations();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << BOOL) | (1L << INT) | (1L << DNA) | (1L << RNA) | (1L << CODON) | (1L << PROTEIN) | (1L << Word) | (1L << LPAREN) | (1L << NOT) | (1L << COMPLEMENTARY) | (1L << REVERSE) | (1L << LENGTH) | (1L << POSITION) | (1L << COUNT) | (1L << REMOVE))) != 0)) {
				{
				{
				setState(73);
				statements();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintstmtContext extends StatementContext {
		public PrintstatementContext printstatement() {
			return getRuleContext(PrintstatementContext.class,0);
		}
		public PrintstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterPrintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitPrintstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitPrintstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompoundstmtContext extends StatementContext {
		public CompoundstatementContext compoundstatement() {
			return getRuleContext(CompoundstatementContext.class,0);
		}
		public CompoundstmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCompoundstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCompoundstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCompoundstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				assignment();
				setState(80);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new CompoundstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				compoundstatement();
				}
				break;
			case 3:
				_localctx = new ExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				expression(0);
				setState(84);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new PrintstmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				printstatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundstatementContext extends ParserRuleContext {
		public IterationContext iteration() {
			return getRuleContext(IterationContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public JumpContext jump() {
			return getRuleContext(JumpContext.class,0);
		}
		public CompoundstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCompoundstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCompoundstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCompoundstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundstatementContext compoundstatement() throws RecognitionException {
		CompoundstatementContext _localctx = new CompoundstatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compoundstatement);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				iteration();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				selection();
				}
				break;
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				jump();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
	 
		public SelectionContext() { }
		public void copyFrom(SelectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfContext extends SelectionContext {
		public ExpressionContext predicate;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfContext(SelectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseContext extends SelectionContext {
		public ExpressionContext predicate;
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfelseContext(SelectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitIfelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selection);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(T__0);
				setState(95);
				match(LPAREN);
				setState(96);
				((IfContext)_localctx).predicate = expression(0);
				setState(97);
				match(RPAREN);
				setState(98);
				match(LCURLY);
				setState(99);
				block();
				setState(100);
				match(RCURLY);
				}
				break;
			case 2:
				_localctx = new IfelseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(T__0);
				setState(103);
				match(LPAREN);
				setState(104);
				((IfelseContext)_localctx).predicate = expression(0);
				setState(105);
				match(RPAREN);
				setState(106);
				match(LCURLY);
				setState(107);
				block();
				setState(108);
				match(RCURLY);
				setState(109);
				match(T__1);
				setState(110);
				match(LCURLY);
				setState(111);
				block();
				setState(112);
				match(RCURLY);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationContext extends ParserRuleContext {
		public IterationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration; }
	 
		public IterationContext() { }
		public void copyFrom(IterationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForContext extends IterationContext {
		public AssignmentContext iterator;
		public ExpressionContext predicate;
		public AssignmentContext increment;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForContext(IterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends IterationContext {
		public ExpressionContext predicate;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileContext(IterationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationContext iteration() throws RecognitionException {
		IterationContext _localctx = new IterationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_iteration);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__2);
				setState(117);
				match(LPAREN);
				setState(118);
				((WhileContext)_localctx).predicate = expression(0);
				setState(119);
				match(RPAREN);
				setState(120);
				match(LCURLY);
				setState(121);
				block();
				setState(122);
				match(RCURLY);
				}
				break;
			case T__3:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__3);
				setState(125);
				match(LPAREN);
				setState(126);
				((ForContext)_localctx).iterator = assignment();
				setState(127);
				match(SEMI);
				setState(128);
				((ForContext)_localctx).predicate = expression(0);
				setState(129);
				match(SEMI);
				setState(130);
				((ForContext)_localctx).increment = assignment();
				setState(131);
				match(RPAREN);
				setState(132);
				match(LCURLY);
				setState(133);
				block();
				setState(134);
				match(RCURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionsContext extends ParserRuleContext {
		public FunctiondeclarationContext functiondeclaration() {
			return getRuleContext(FunctiondeclarationContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			functiondeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctiondeclarationContext extends ParserRuleContext {
		public IdentifierContext funcname;
		public TerminalNode TYPE() { return getToken(LanguageParser.TYPE, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctiondeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functiondeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctiondeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctiondeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctiondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctiondeclarationContext functiondeclaration() throws RecognitionException {
		FunctiondeclarationContext _localctx = new FunctiondeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functiondeclaration);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(TYPE);
				setState(141);
				((FunctiondeclarationContext)_localctx).funcname = identifier();
				setState(142);
				match(LPAREN);
				setState(143);
				declaration();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(144);
					match(COMMA);
					setState(145);
					declaration();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				match(RPAREN);
				setState(152);
				match(LCURLY);
				setState(153);
				block();
				setState(154);
				match(RCURLY);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(T__4);
				setState(157);
				((FunctiondeclarationContext)_localctx).funcname = identifier();
				setState(158);
				match(LPAREN);
				setState(159);
				declaration();
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(160);
					match(COMMA);
					setState(161);
					declaration();
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
				match(RPAREN);
				setState(168);
				match(LCURLY);
				setState(169);
				block();
				setState(170);
				match(RCURLY);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext left;
		public Token op;
		public ExpressionContext right;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			((AssignmentContext)_localctx).left = identifier();
			setState(175);
			((AssignmentContext)_localctx).op = match(EQUAL);
			setState(176);
			((AssignmentContext)_localctx).right = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParensExpContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ParensExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterParensExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitParensExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitParensExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExpContext extends ExpressionContext {
		public ExpressionContext left;
		public Token op;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REMOVE() { return getToken(LanguageParser.REMOVE, 0); }
		public TerminalNode POSITION() { return getToken(LanguageParser.POSITION, 0); }
		public TerminalNode COUNT() { return getToken(LanguageParser.COUNT, 0); }
		public TerminalNode CONTAINS() { return getToken(LanguageParser.CONTAINS, 0); }
		public TerminalNode MUL() { return getToken(LanguageParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(LanguageParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(LanguageParser.MOD, 0); }
		public TerminalNode ADD() { return getToken(LanguageParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(LanguageParser.SUB, 0); }
		public TerminalNode LT() { return getToken(LanguageParser.LT, 0); }
		public TerminalNode GT() { return getToken(LanguageParser.GT, 0); }
		public TerminalNode LTEQ() { return getToken(LanguageParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(LanguageParser.GTEQ, 0); }
		public TerminalNode EQEQ() { return getToken(LanguageParser.EQEQ, 0); }
		public TerminalNode NOTEQ() { return getToken(LanguageParser.NOTEQ, 0); }
		public TerminalNode AND() { return getToken(LanguageParser.AND, 0); }
		public TerminalNode OR() { return getToken(LanguageParser.OR, 0); }
		public BinaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBinaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBinaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBinaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpContext extends ExpressionContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public NumberExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterNumberExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitNumberExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitNumberExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConvertExpContext extends ExpressionContext {
		public ExpressionContext left;
		public TerminalNode TYPE() { return getToken(LanguageParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConvertExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterConvertExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitConvertExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitConvertExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LanguageParser.NOT, 0); }
		public UnaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExpContext extends ExpressionContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BoolExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBoolExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DnaExpContext extends ExpressionContext {
		public TerminalNode DNA() { return getToken(LanguageParser.DNA, 0); }
		public DnaExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDnaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDnaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDnaExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableExpContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public VariableExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterVariableExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitVariableExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitVariableExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RnaExpContext extends ExpressionContext {
		public TerminalNode RNA() { return getToken(LanguageParser.RNA, 0); }
		public RnaExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterRnaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitRnaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitRnaExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctioncallExpContext extends ExpressionContext {
		public FunctioncallContext functioncall() {
			return getRuleContext(FunctioncallContext.class,0);
		}
		public FunctioncallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunctioncallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunctioncallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunctioncallExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CodonExpContext extends ExpressionContext {
		public TerminalNode CODON() { return getToken(LanguageParser.CODON, 0); }
		public CodonExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCodonExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCodonExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCodonExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProteinExpContext extends ExpressionContext {
		public TerminalNode PROTEIN() { return getToken(LanguageParser.PROTEIN, 0); }
		public ProteinExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterProteinExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitProteinExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitProteinExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new ParensExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(179);
				match(LPAREN);
				setState(180);
				expression(0);
				setState(181);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				((UnaryExpContext)_localctx).op = match(NOT);
				setState(184);
				expression(17);
				}
				break;
			case 3:
				{
				_localctx = new BinaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case POSITION:
				case COUNT:
					{
					setState(185);
					((BinaryExpContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==POSITION || _la==COUNT) ) {
						((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(186);
					((BinaryExpContext)_localctx).left = expression(0);
					setState(187);
					match(T__6);
					setState(188);
					((BinaryExpContext)_localctx).right = expression(0);
					}
					break;
				case REMOVE:
					{
					setState(190);
					((BinaryExpContext)_localctx).op = match(REMOVE);
					setState(191);
					((BinaryExpContext)_localctx).left = expression(0);
					setState(192);
					match(T__7);
					setState(193);
					((BinaryExpContext)_localctx).right = expression(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				_localctx = new FunctioncallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				functioncall();
				}
				break;
			case 5:
				{
				_localctx = new VariableExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				identifier();
				}
				break;
			case 6:
				{
				_localctx = new NumberExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(INT);
				}
				break;
			case 7:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new DnaExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(DNA);
				}
				break;
			case 9:
				{
				_localctx = new RnaExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(RNA);
				}
				break;
			case 10:
				{
				_localctx = new CodonExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				match(CODON);
				}
				break;
			case 11:
				{
				_localctx = new ProteinExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				match(PROTEIN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(208);
						((BinaryExpContext)_localctx).op = match(CONTAINS);
						setState(209);
						((BinaryExpContext)_localctx).right = expression(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(211);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DIV) | (1L << MUL) | (1L << MOD))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(212);
						((BinaryExpContext)_localctx).right = expression(15);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(214);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==SUB || _la==ADD) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						((BinaryExpContext)_localctx).right = expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(217);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LTEQ) | (1L << GTEQ))) != 0)) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						((BinaryExpContext)_localctx).right = expression(13);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(220);
						((BinaryExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQEQ || _la==NOTEQ) ) {
							((BinaryExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						((BinaryExpContext)_localctx).right = expression(12);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(223);
						((BinaryExpContext)_localctx).op = match(AND);
						setState(224);
						((BinaryExpContext)_localctx).right = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(226);
						((BinaryExpContext)_localctx).op = match(OR);
						setState(227);
						((BinaryExpContext)_localctx).right = expression(10);
						}
						break;
					case 8:
						{
						_localctx = new ConvertExpContext(new ExpressionContext(_parentctx, _parentState));
						((ConvertExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(229);
						match(T__5);
						setState(230);
						match(TYPE);
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctioncallContext extends ParserRuleContext {
		public FunctioncallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioncall; }
	 
		public FunctioncallContext() { }
		public void copyFrom(FunctioncallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunccallContext extends FunctioncallContext {
		public IdentifierContext funcname;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunccallContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterFunccall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitFunccall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitFunccall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComplementaryContext extends FunctioncallContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMPLEMENTARY() { return getToken(LanguageParser.COMPLEMENTARY, 0); }
		public TerminalNode REVERSE() { return getToken(LanguageParser.REVERSE, 0); }
		public TerminalNode LENGTH() { return getToken(LanguageParser.LENGTH, 0); }
		public ComplementaryContext(FunctioncallContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterComplementary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitComplementary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitComplementary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctioncallContext functioncall() throws RecognitionException {
		FunctioncallContext _localctx = new FunctioncallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functioncall);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLEMENTARY:
			case REVERSE:
			case LENGTH:
				_localctx = new ComplementaryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				((ComplementaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMPLEMENTARY) | (1L << REVERSE) | (1L << LENGTH))) != 0)) ) {
					((ComplementaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(237);
				match(LPAREN);
				setState(238);
				expression(0);
				setState(239);
				match(RPAREN);
				}
				break;
			case Word:
				_localctx = new FunccallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				((FunccallContext)_localctx).funcname = identifier();
				setState(242);
				match(LPAREN);
				{
				setState(243);
				expression(0);
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(244);
					match(COMMA);
					{
					setState(245);
					expression(0);
					}
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpContext extends ParserRuleContext {
		public JumpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump; }
	 
		public JumpContext() { }
		public void copyFrom(JumpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakContext extends JumpContext {
		public BreakContext(JumpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends JumpContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnContext(JumpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpContext jump() throws RecognitionException {
		JumpContext _localctx = new JumpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jump);
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new BreakContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(T__8);
				setState(256);
				match(SEMI);
				}
				break;
			case T__9:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(T__9);
				setState(258);
				expression(0);
				setState(259);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintstatementContext extends ParserRuleContext {
		public PrintstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstatement; }
	 
		public PrintstatementContext() { }
		public void copyFrom(PrintstatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintContext extends PrintstatementContext {
		public IdentifierContext left;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PrintContext(PrintstatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintstatementContext printstatement() throws RecognitionException {
		PrintstatementContext _localctx = new PrintstatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_printstatement);
		try {
			_localctx = new PrintContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__10);
			setState(264);
			match(LPAREN);
			setState(265);
			((PrintContext)_localctx).left = identifier();
			setState(266);
			match(RPAREN);
			setState(267);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0110\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\3\3\3\3\3\3\4\3\4\5\4"+
		"\64\n\4\3\4\3\4\3\4\5\49\n\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\7\bG\n\b\f\b\16\bJ\13\b\3\b\7\bM\n\b\f\b\16\bP\13\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\tZ\n\t\3\n\3\n\3\n\5\n_\n\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13u\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008b\n\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u0095\n\16\f\16\16\16\u0098\13\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00a5\n\16\f\16\16\16\u00a8"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00c6\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00d0\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u00ea\n\20\f\20\16\20\u00ed\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00f9\n\21\f\21\16\21\u00fc\13\21\3\21\3\21\5\21"+
		"\u0100\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0108\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\2\3\36\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$\2\b\3\289\4\2\60\60\62\63\4\2++\61\61\3\2$\'\3\2-.\3\2\65\67\2"+
		"\u0125\2+\3\2\2\2\4.\3\2\2\2\6;\3\2\2\2\b=\3\2\2\2\nA\3\2\2\2\fC\3\2\2"+
		"\2\16H\3\2\2\2\20Y\3\2\2\2\22^\3\2\2\2\24t\3\2\2\2\26\u008a\3\2\2\2\30"+
		"\u008c\3\2\2\2\32\u00ae\3\2\2\2\34\u00b0\3\2\2\2\36\u00cf\3\2\2\2 \u00ff"+
		"\3\2\2\2\"\u0107\3\2\2\2$\u0109\3\2\2\2&*\5\4\3\2\'*\5\f\7\2(*\5\30\r"+
		"\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2"+
		"\2\2-+\3\2\2\2./\5\6\4\2/\60\7#\2\2\60\5\3\2\2\2\61\64\7\16\2\2\62\64"+
		"\5\b\5\2\63\61\3\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65<\5\34\17\2\669\7"+
		"\16\2\2\679\5\b\5\28\66\3\2\2\28\67\3\2\2\29:\3\2\2\2:<\5\n\6\2;\63\3"+
		"\2\2\2;8\3\2\2\2<\7\3\2\2\2=>\7\16\2\2>?\7\35\2\2?@\7 \2\2@\t\3\2\2\2"+
		"AB\7\31\2\2B\13\3\2\2\2CD\5\20\t\2D\r\3\2\2\2EG\5\4\3\2FE\3\2\2\2GJ\3"+
		"\2\2\2HF\3\2\2\2HI\3\2\2\2IN\3\2\2\2JH\3\2\2\2KM\5\f\7\2LK\3\2\2\2MP\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2O\17\3\2\2\2PN\3\2\2\2QR\5\34\17\2RS\7#\2\2"+
		"SZ\3\2\2\2TZ\5\22\n\2UV\5\36\20\2VW\7#\2\2WZ\3\2\2\2XZ\5$\23\2YQ\3\2\2"+
		"\2YT\3\2\2\2YU\3\2\2\2YX\3\2\2\2Z\21\3\2\2\2[_\5\26\f\2\\_\5\24\13\2]"+
		"_\5\"\22\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\23\3\2\2\2`a\7\3\2\2ab\7\34"+
		"\2\2bc\5\36\20\2cd\7\37\2\2de\7\33\2\2ef\5\16\b\2fg\7\36\2\2gu\3\2\2\2"+
		"hi\7\3\2\2ij\7\34\2\2jk\5\36\20\2kl\7\37\2\2lm\7\33\2\2mn\5\16\b\2no\7"+
		"\36\2\2op\7\4\2\2pq\7\33\2\2qr\5\16\b\2rs\7\36\2\2su\3\2\2\2t`\3\2\2\2"+
		"th\3\2\2\2u\25\3\2\2\2vw\7\5\2\2wx\7\34\2\2xy\5\36\20\2yz\7\37\2\2z{\7"+
		"\33\2\2{|\5\16\b\2|}\7\36\2\2}\u008b\3\2\2\2~\177\7\6\2\2\177\u0080\7"+
		"\34\2\2\u0080\u0081\5\34\17\2\u0081\u0082\7#\2\2\u0082\u0083\5\36\20\2"+
		"\u0083\u0084\7#\2\2\u0084\u0085\5\34\17\2\u0085\u0086\7\37\2\2\u0086\u0087"+
		"\7\33\2\2\u0087\u0088\5\16\b\2\u0088\u0089\7\36\2\2\u0089\u008b\3\2\2"+
		"\2\u008av\3\2\2\2\u008a~\3\2\2\2\u008b\27\3\2\2\2\u008c\u008d\5\32\16"+
		"\2\u008d\31\3\2\2\2\u008e\u008f\7\16\2\2\u008f\u0090\5\n\6\2\u0090\u0091"+
		"\7\34\2\2\u0091\u0096\5\6\4\2\u0092\u0093\7!\2\2\u0093\u0095\5\6\4\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\37\2\2\u009a"+
		"\u009b\7\33\2\2\u009b\u009c\5\16\b\2\u009c\u009d\7\36\2\2\u009d\u00af"+
		"\3\2\2\2\u009e\u009f\7\7\2\2\u009f\u00a0\5\n\6\2\u00a0\u00a1\7\34\2\2"+
		"\u00a1\u00a6\5\6\4\2\u00a2\u00a3\7!\2\2\u00a3\u00a5\5\6\4\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00aa\7\37\2\2\u00aa\u00ab\7"+
		"\33\2\2\u00ab\u00ac\5\16\b\2\u00ac\u00ad\7\36\2\2\u00ad\u00af\3\2\2\2"+
		"\u00ae\u008e\3\2\2\2\u00ae\u009e\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b1"+
		"\5\n\6\2\u00b1\u00b2\7,\2\2\u00b2\u00b3\5\36\20\2\u00b3\35\3\2\2\2\u00b4"+
		"\u00b5\b\20\1\2\u00b5\u00b6\7\34\2\2\u00b6\u00b7\5\36\20\2\u00b7\u00b8"+
		"\7\37\2\2\u00b8\u00d0\3\2\2\2\u00b9\u00ba\7)\2\2\u00ba\u00d0\5\36\20\23"+
		"\u00bb\u00bc\t\2\2\2\u00bc\u00bd\5\36\20\2\u00bd\u00be\7\t\2\2\u00be\u00bf"+
		"\5\36\20\2\u00bf\u00c6\3\2\2\2\u00c0\u00c1\7:\2\2\u00c1\u00c2\5\36\20"+
		"\2\u00c2\u00c3\7\n\2\2\u00c3\u00c4\5\36\20\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00bb\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c6\u00d0\3\2\2\2\u00c7\u00d0\5 "+
		"\21\2\u00c8\u00d0\5\n\6\2\u00c9\u00d0\7\20\2\2\u00ca\u00d0\7\17\2\2\u00cb"+
		"\u00d0\7\21\2\2\u00cc\u00d0\7\22\2\2\u00cd\u00d0\7\25\2\2\u00ce\u00d0"+
		"\7\26\2\2\u00cf\u00b4\3\2\2\2\u00cf\u00b9\3\2\2\2\u00cf\u00c5\3\2\2\2"+
		"\u00cf\u00c7\3\2\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00ca"+
		"\3\2\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\u00eb\3\2\2\2\u00d1\u00d2\f\22\2\2\u00d2\u00d3\7"+
		"\64\2\2\u00d3\u00ea\5\36\20\23\u00d4\u00d5\f\20\2\2\u00d5\u00d6\t\3\2"+
		"\2\u00d6\u00ea\5\36\20\21\u00d7\u00d8\f\17\2\2\u00d8\u00d9\t\4\2\2\u00d9"+
		"\u00ea\5\36\20\20\u00da\u00db\f\16\2\2\u00db\u00dc\t\5\2\2\u00dc\u00ea"+
		"\5\36\20\17\u00dd\u00de\f\r\2\2\u00de\u00df\t\6\2\2\u00df\u00ea\5\36\20"+
		"\16\u00e0\u00e1\f\f\2\2\u00e1\u00e2\7*\2\2\u00e2\u00ea\5\36\20\r\u00e3"+
		"\u00e4\f\13\2\2\u00e4\u00e5\7/\2\2\u00e5\u00ea\5\36\20\f\u00e6\u00e7\f"+
		"\24\2\2\u00e7\u00e8\7\b\2\2\u00e8\u00ea\7\16\2\2\u00e9\u00d1\3\2\2\2\u00e9"+
		"\u00d4\3\2\2\2\u00e9\u00d7\3\2\2\2\u00e9\u00da\3\2\2\2\u00e9\u00dd\3\2"+
		"\2\2\u00e9\u00e0\3\2\2\2\u00e9\u00e3\3\2\2\2\u00e9\u00e6\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\37\3\2\2"+
		"\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\t\7\2\2\u00ef\u00f0\7\34\2\2\u00f0"+
		"\u00f1\5\36\20\2\u00f1\u00f2\7\37\2\2\u00f2\u0100\3\2\2\2\u00f3\u00f4"+
		"\5\n\6\2\u00f4\u00f5\7\34\2\2\u00f5\u00fa\5\36\20\2\u00f6\u00f7\7!\2\2"+
		"\u00f7\u00f9\5\36\20\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8"+
		"\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\7\37\2\2\u00fe\u0100\3\2\2\2\u00ff\u00ee\3\2\2\2\u00ff\u00f3\3"+
		"\2\2\2\u0100!\3\2\2\2\u0101\u0102\7\13\2\2\u0102\u0108\7#\2\2\u0103\u0104"+
		"\7\f\2\2\u0104\u0105\5\36\20\2\u0105\u0106\7#\2\2\u0106\u0108\3\2\2\2"+
		"\u0107\u0101\3\2\2\2\u0107\u0103\3\2\2\2\u0108#\3\2\2\2\u0109\u010a\7"+
		"\r\2\2\u010a\u010b\7\34\2\2\u010b\u010c\5\n\6\2\u010c\u010d\7\37\2\2\u010d"+
		"\u010e\7#\2\2\u010e%\3\2\2\2\27)+\638;HNY^t\u008a\u0096\u00a6\u00ae\u00c5"+
		"\u00cf\u00e9\u00eb\u00fa\u00ff\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}