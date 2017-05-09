// Generated from C:/Stuff/Dropbox/ProgrammingProjects/JavaProjects/DNALang/grammar\Language.g4 by ANTLR 4.7
package Generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LanguageLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "TYPE", "BOOL", "INT", "DNA", "RNA", "DNAsym", "RNAsym", 
		"CODON", "PROTEIN", "AMINOACIDSINGLE", "AMINOACIDTRIPLE", "Digit", "Word", 
		"WS", "LCURLY", "LPAREN", "LBRACK", "RCURLY", "RPAREN", "RBRACK", "COMMA", 
		"COLON", "SEMI", "LT", "GT", "LTEQ", "GTEQ", "UNDERSCORE", "NOT", "AND", 
		"SUB", "EQUAL", "EQEQ", "NOTEQ", "OR", "DIV", "ADD", "MUL", "MOD", "CONTAINS", 
		"COMPLEMENTARY", "REVERSE", "LENGTH", "POSITION", "COUNT", "REMOVE"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u0234\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00cf\n\16\3\17\6\17\u00d2\n\17\r\17\16\17\u00d3\3\20"+
		"\6\20\u00d7\n\20\r\20\16\20\u00d8\3\21\6\21\u00dc\n\21\r\21\16\21\u00dd"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f4\n\24\3\25\6\25\u00f7\n\25\r"+
		"\25\16\25\u00f8\3\25\6\25\u00fc\n\25\r\25\16\25\u00fd\5\25\u0100\n\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u013e\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u01b8\n\27\3\30\3\30\3\31\3\31\7\31\u01be\n\31\f\31\16\31\u01c1"+
		"\13\31\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61"+
		"\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67"+
		"\3\67\3\67\3\67\38\38\38\38\38\38\38\38\38\38\38\38\38\39\39\39\39\39"+
		"\39\39\3:\3:\3:\3:\3:\3:\3:\3:\2\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\2\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-"+
		"[.]/_\60a\61c\62e\63g\64i\65k\66m\67o8q9s:\3\2\b\6\2CCEEIIVV\6\2CCEEI"+
		"IWW\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u0266\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2"+
		"\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q"+
		"\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5x\3\2\2\2\7}\3\2\2\2\t\u0083\3\2\2\2\13"+
		"\u0087\3\2\2\2\r\u008c\3\2\2\2\17\u008f\3\2\2\2\21\u0092\3\2\2\2\23\u0097"+
		"\3\2\2\2\25\u009d\3\2\2\2\27\u00a4\3\2\2\2\31\u00c3\3\2\2\2\33\u00ce\3"+
		"\2\2\2\35\u00d1\3\2\2\2\37\u00d6\3\2\2\2!\u00db\3\2\2\2#\u00df\3\2\2\2"+
		"%\u00e1\3\2\2\2\'\u00f3\3\2\2\2)\u00ff\3\2\2\2+\u013d\3\2\2\2-\u01b7\3"+
		"\2\2\2/\u01b9\3\2\2\2\61\u01bb\3\2\2\2\63\u01c2\3\2\2\2\65\u01c6\3\2\2"+
		"\2\67\u01c8\3\2\2\29\u01ca\3\2\2\2;\u01cc\3\2\2\2=\u01ce\3\2\2\2?\u01d0"+
		"\3\2\2\2A\u01d2\3\2\2\2C\u01d4\3\2\2\2E\u01d6\3\2\2\2G\u01d8\3\2\2\2I"+
		"\u01da\3\2\2\2K\u01dc\3\2\2\2M\u01df\3\2\2\2O\u01e2\3\2\2\2Q\u01e4\3\2"+
		"\2\2S\u01e6\3\2\2\2U\u01e9\3\2\2\2W\u01eb\3\2\2\2Y\u01ed\3\2\2\2[\u01f0"+
		"\3\2\2\2]\u01f3\3\2\2\2_\u01f6\3\2\2\2a\u01f8\3\2\2\2c\u01fa\3\2\2\2e"+
		"\u01fc\3\2\2\2g\u01fe\3\2\2\2i\u0208\3\2\2\2k\u020e\3\2\2\2m\u0213\3\2"+
		"\2\2o\u0218\3\2\2\2q\u0225\3\2\2\2s\u022c\3\2\2\2uv\7k\2\2vw\7h\2\2w\4"+
		"\3\2\2\2xy\7g\2\2yz\7n\2\2z{\7u\2\2{|\7g\2\2|\6\3\2\2\2}~\7y\2\2~\177"+
		"\7j\2\2\177\u0080\7k\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\b"+
		"\3\2\2\2\u0083\u0084\7h\2\2\u0084\u0085\7q\2\2\u0085\u0086\7t\2\2\u0086"+
		"\n\3\2\2\2\u0087\u0088\7x\2\2\u0088\u0089\7q\2\2\u0089\u008a\7k\2\2\u008a"+
		"\u008b\7f\2\2\u008b\f\3\2\2\2\u008c\u008d\7c\2\2\u008d\u008e\7u\2\2\u008e"+
		"\16\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\20\3\2\2\2\u0092"+
		"\u0093\7h\2\2\u0093\u0094\7t\2\2\u0094\u0095\7q\2\2\u0095\u0096\7o\2\2"+
		"\u0096\22\3\2\2\2\u0097\u0098\7d\2\2\u0098\u0099\7t\2\2\u0099\u009a\7"+
		"g\2\2\u009a\u009b\7c\2\2\u009b\u009c\7m\2\2\u009c\24\3\2\2\2\u009d\u009e"+
		"\7t\2\2\u009e\u009f\7g\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\7w\2\2\u00a1"+
		"\u00a2\7t\2\2\u00a2\u00a3\7p\2\2\u00a3\26\3\2\2\2\u00a4\u00a5\7R\2\2\u00a5"+
		"\u00a6\7t\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7v\2\2"+
		"\u00a9\30\3\2\2\2\u00aa\u00ab\7f\2\2\u00ab\u00ac\7p\2\2\u00ac\u00c4\7"+
		"c\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7p\2\2\u00af\u00c4\7c\2\2\u00b0\u00b1"+
		"\7e\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7f\2\2\u00b3\u00b4\7q\2\2\u00b4"+
		"\u00c4\7p\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7q\2\2"+
		"\u00b8\u00b9\7v\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7k\2\2\u00bb\u00c4"+
		"\7p\2\2\u00bc\u00bd\7k\2\2\u00bd\u00be\7p\2\2\u00be\u00c4\7v\2\2\u00bf"+
		"\u00c0\7d\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c4\7n\2\2"+
		"\u00c3\u00aa\3\2\2\2\u00c3\u00ad\3\2\2\2\u00c3\u00b0\3\2\2\2\u00c3\u00b5"+
		"\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\32\3\2\2\2\u00c5"+
		"\u00c6\7v\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7w\2\2\u00c8\u00cf\7g\2\2"+
		"\u00c9\u00ca\7h\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd"+
		"\7u\2\2\u00cd\u00cf\7g\2\2\u00ce\u00c5\3\2\2\2\u00ce\u00c9\3\2\2\2\u00cf"+
		"\34\3\2\2\2\u00d0\u00d2\5/\30\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\36\3\2\2\2\u00d5\u00d7"+
		"\5#\22\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9 \3\2\2\2\u00da\u00dc\5%\23\2\u00db\u00da\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\"\3"+
		"\2\2\2\u00df\u00e0\t\2\2\2\u00e0$\3\2\2\2\u00e1\u00e2\t\3\2\2\u00e2&\3"+
		"\2\2\2\u00e3\u00e4\7*\2\2\u00e4\u00e5\5#\22\2\u00e5\u00e6\7.\2\2\u00e6"+
		"\u00e7\5#\22\2\u00e7\u00e8\7.\2\2\u00e8\u00e9\5#\22\2\u00e9\u00ea\7+\2"+
		"\2\u00ea\u00f4\3\2\2\2\u00eb\u00ec\7*\2\2\u00ec\u00ed\5%\23\2\u00ed\u00ee"+
		"\7.\2\2\u00ee\u00ef\5%\23\2\u00ef\u00f0\7.\2\2\u00f0\u00f1\5%\23\2\u00f1"+
		"\u00f2\7+\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00e3\3\2\2\2\u00f3\u00eb\3\2"+
		"\2\2\u00f4(\3\2\2\2\u00f5\u00f7\5+\26\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u0100\3\2\2\2\u00fa"+
		"\u00fc\5-\27\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\u0100\3\2\2\2\u00ff\u00f6\3\2\2\2\u00ff"+
		"\u00fb\3\2\2\2\u0100*\3\2\2\2\u0101\u0102\7$\2\2\u0102\u0103\7C\2\2\u0103"+
		"\u013e\7$\2\2\u0104\u0105\7$\2\2\u0105\u0106\7E\2\2\u0106\u013e\7$\2\2"+
		"\u0107\u0108\7$\2\2\u0108\u0109\7F\2\2\u0109\u013e\7$\2\2\u010a\u010b"+
		"\7$\2\2\u010b\u010c\7G\2\2\u010c\u013e\7$\2\2\u010d\u010e\7$\2\2\u010e"+
		"\u010f\7H\2\2\u010f\u013e\7$\2\2\u0110\u0111\7$\2\2\u0111\u0112\7I\2\2"+
		"\u0112\u013e\7$\2\2\u0113\u0114\7$\2\2\u0114\u0115\7J\2\2\u0115\u013e"+
		"\7$\2\2\u0116\u0117\7$\2\2\u0117\u0118\7K\2\2\u0118\u013e\7$\2\2\u0119"+
		"\u011a\7$\2\2\u011a\u011b\7M\2\2\u011b\u013e\7$\2\2\u011c\u011d\7$\2\2"+
		"\u011d\u011e\7N\2\2\u011e\u013e\7$\2\2\u011f\u0120\7$\2\2\u0120\u0121"+
		"\7O\2\2\u0121\u013e\7$\2\2\u0122\u0123\7$\2\2\u0123\u0124\7P\2\2\u0124"+
		"\u013e\7$\2\2\u0125\u0126\7$\2\2\u0126\u0127\7R\2\2\u0127\u013e\7$\2\2"+
		"\u0128\u0129\7$\2\2\u0129\u012a\7S\2\2\u012a\u013e\7$\2\2\u012b\u012c"+
		"\7$\2\2\u012c\u012d\7T\2\2\u012d\u013e\7$\2\2\u012e\u012f\7$\2\2\u012f"+
		"\u0130\7U\2\2\u0130\u013e\7$\2\2\u0131\u0132\7$\2\2\u0132\u0133\7V\2\2"+
		"\u0133\u013e\7$\2\2\u0134\u0135\7$\2\2\u0135\u0136\7X\2\2\u0136\u013e"+
		"\7$\2\2\u0137\u0138\7$\2\2\u0138\u0139\7Y\2\2\u0139\u013e\7$\2\2\u013a"+
		"\u013b\7$\2\2\u013b\u013c\7[\2\2\u013c\u013e\7$\2\2\u013d\u0101\3\2\2"+
		"\2\u013d\u0104\3\2\2\2\u013d\u0107\3\2\2\2\u013d\u010a\3\2\2\2\u013d\u010d"+
		"\3\2\2\2\u013d\u0110\3\2\2\2\u013d\u0113\3\2\2\2\u013d\u0116\3\2\2\2\u013d"+
		"\u0119\3\2\2\2\u013d\u011c\3\2\2\2\u013d\u011f\3\2\2\2\u013d\u0122\3\2"+
		"\2\2\u013d\u0125\3\2\2\2\u013d\u0128\3\2\2\2\u013d\u012b\3\2\2\2\u013d"+
		"\u012e\3\2\2\2\u013d\u0131\3\2\2\2\u013d\u0134\3\2\2\2\u013d\u0137\3\2"+
		"\2\2\u013d\u013a\3\2\2\2\u013e,\3\2\2\2\u013f\u0140\7$\2\2\u0140\u0141"+
		"\7C\2\2\u0141\u0142\7n\2\2\u0142\u0143\7c\2\2\u0143\u0144\3\2\2\2\u0144"+
		"\u01b8\7$\2\2\u0145\u0146\7$\2\2\u0146\u0147\7E\2\2\u0147\u0148\7{\2\2"+
		"\u0148\u0149\7u\2\2\u0149\u014a\3\2\2\2\u014a\u01b8\7$\2\2\u014b\u014c"+
		"\7$\2\2\u014c\u014d\7C\2\2\u014d\u014e\7u\2\2\u014e\u014f\7r\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u01b8\7$\2\2\u0151\u0152\7$\2\2\u0152\u0153\7I\2"+
		"\2\u0153\u0154\7n\2\2\u0154\u0155\7w\2\2\u0155\u0156\3\2\2\2\u0156\u01b8"+
		"\7$\2\2\u0157\u0158\7$\2\2\u0158\u0159\7R\2\2\u0159\u015a\7j\2\2\u015a"+
		"\u015b\7g\2\2\u015b\u015c\3\2\2\2\u015c\u01b8\7$\2\2\u015d\u015e\7$\2"+
		"\2\u015e\u015f\7I\2\2\u015f\u0160\7n\2\2\u0160\u0161\7{\2\2\u0161\u0162"+
		"\3\2\2\2\u0162\u01b8\7$\2\2\u0163\u0164\7$\2\2\u0164\u0165\7J\2\2\u0165"+
		"\u0166\7k\2\2\u0166\u0167\7u\2\2\u0167\u0168\3\2\2\2\u0168\u01b8\7$\2"+
		"\2\u0169\u016a\7$\2\2\u016a\u016b\7K\2\2\u016b\u016c\7n\2\2\u016c\u016d"+
		"\7g\2\2\u016d\u016e\3\2\2\2\u016e\u01b8\7$\2\2\u016f\u0170\7$\2\2\u0170"+
		"\u0171\7N\2\2\u0171\u0172\7{\2\2\u0172\u0173\7u\2\2\u0173\u0174\3\2\2"+
		"\2\u0174\u01b8\7$\2\2\u0175\u0176\7$\2\2\u0176\u0177\7N\2\2\u0177\u0178"+
		"\7g\2\2\u0178\u0179\7w\2\2\u0179\u017a\3\2\2\2\u017a\u01b8\7$\2\2\u017b"+
		"\u017c\7$\2\2\u017c\u017d\7O\2\2\u017d\u017e\7g\2\2\u017e\u017f\7v\2\2"+
		"\u017f\u0180\3\2\2\2\u0180\u01b8\7$\2\2\u0181\u0182\7$\2\2\u0182\u0183"+
		"\7C\2\2\u0183\u0184\7u\2\2\u0184\u0185\7p\2\2\u0185\u0186\3\2\2\2\u0186"+
		"\u01b8\7$\2\2\u0187\u0188\7$\2\2\u0188\u0189\7R\2\2\u0189\u018a\7t\2\2"+
		"\u018a\u018b\7q\2\2\u018b\u018c\3\2\2\2\u018c\u01b8\7$\2\2\u018d\u018e"+
		"\7$\2\2\u018e\u018f\7I\2\2\u018f\u0190\7n\2\2\u0190\u0191\7p\2\2\u0191"+
		"\u0192\3\2\2\2\u0192\u01b8\7$\2\2\u0193\u0194\7$\2\2\u0194\u0195\7C\2"+
		"\2\u0195\u0196\7t\2\2\u0196\u0197\7i\2\2\u0197\u0198\3\2\2\2\u0198\u01b8"+
		"\7$\2\2\u0199\u019a\7$\2\2\u019a\u019b\7U\2\2\u019b\u019c\7g\2\2\u019c"+
		"\u019d\7t\2\2\u019d\u019e\3\2\2\2\u019e\u01b8\7$\2\2\u019f\u01a0\7$\2"+
		"\2\u01a0\u01a1\7V\2\2\u01a1\u01a2\7j\2\2\u01a2\u01a3\7t\2\2\u01a3\u01a4"+
		"\3\2\2\2\u01a4\u01b8\7$\2\2\u01a5\u01a6\7$\2\2\u01a6\u01a7\7X\2\2\u01a7"+
		"\u01a8\7c\2\2\u01a8\u01a9\7n\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01b8\7$\2"+
		"\2\u01ab\u01ac\7$\2\2\u01ac\u01ad\7V\2\2\u01ad\u01ae\7t\2\2\u01ae\u01af"+
		"\7r\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b8\7$\2\2\u01b1\u01b2\7$\2\2\u01b2"+
		"\u01b3\7V\2\2\u01b3\u01b4\7{\2\2\u01b4\u01b5\7t\2\2\u01b5\u01b6\3\2\2"+
		"\2\u01b6\u01b8\7$\2\2\u01b7\u013f\3\2\2\2\u01b7\u0145\3\2\2\2\u01b7\u014b"+
		"\3\2\2\2\u01b7\u0151\3\2\2\2\u01b7\u0157\3\2\2\2\u01b7\u015d\3\2\2\2\u01b7"+
		"\u0163\3\2\2\2\u01b7\u0169\3\2\2\2\u01b7\u016f\3\2\2\2\u01b7\u0175\3\2"+
		"\2\2\u01b7\u017b\3\2\2\2\u01b7\u0181\3\2\2\2\u01b7\u0187\3\2\2\2\u01b7"+
		"\u018d\3\2\2\2\u01b7\u0193\3\2\2\2\u01b7\u0199\3\2\2\2\u01b7\u019f\3\2"+
		"\2\2\u01b7\u01a5\3\2\2\2\u01b7\u01ab\3\2\2\2\u01b7\u01b1\3\2\2\2\u01b8"+
		".\3\2\2\2\u01b9\u01ba\t\4\2\2\u01ba\60\3\2\2\2\u01bb\u01bf\t\5\2\2\u01bc"+
		"\u01be\t\6\2\2\u01bd\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2"+
		"\2\2\u01bf\u01c0\3\2\2\2\u01c0\62\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3"+
		"\t\7\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\b\32\2\2\u01c5\64\3\2\2\2\u01c6"+
		"\u01c7\7}\2\2\u01c7\66\3\2\2\2\u01c8\u01c9\7*\2\2\u01c98\3\2\2\2\u01ca"+
		"\u01cb\7]\2\2\u01cb:\3\2\2\2\u01cc\u01cd\7\177\2\2\u01cd<\3\2\2\2\u01ce"+
		"\u01cf\7+\2\2\u01cf>\3\2\2\2\u01d0\u01d1\7_\2\2\u01d1@\3\2\2\2\u01d2\u01d3"+
		"\7.\2\2\u01d3B\3\2\2\2\u01d4\u01d5\7<\2\2\u01d5D\3\2\2\2\u01d6\u01d7\7"+
		"=\2\2\u01d7F\3\2\2\2\u01d8\u01d9\7>\2\2\u01d9H\3\2\2\2\u01da\u01db\7@"+
		"\2\2\u01dbJ\3\2\2\2\u01dc\u01dd\7>\2\2\u01dd\u01de\7?\2\2\u01deL\3\2\2"+
		"\2\u01df\u01e0\7@\2\2\u01e0\u01e1\7?\2\2\u01e1N\3\2\2\2\u01e2\u01e3\7"+
		"a\2\2\u01e3P\3\2\2\2\u01e4\u01e5\7#\2\2\u01e5R\3\2\2\2\u01e6\u01e7\7("+
		"\2\2\u01e7\u01e8\7(\2\2\u01e8T\3\2\2\2\u01e9\u01ea\7/\2\2\u01eaV\3\2\2"+
		"\2\u01eb\u01ec\7?\2\2\u01ecX\3\2\2\2\u01ed\u01ee\7?\2\2\u01ee\u01ef\7"+
		"?\2\2\u01efZ\3\2\2\2\u01f0\u01f1\7#\2\2\u01f1\u01f2\7?\2\2\u01f2\\\3\2"+
		"\2\2\u01f3\u01f4\7~\2\2\u01f4\u01f5\7~\2\2\u01f5^\3\2\2\2\u01f6\u01f7"+
		"\7\61\2\2\u01f7`\3\2\2\2\u01f8\u01f9\7-\2\2\u01f9b\3\2\2\2\u01fa\u01fb"+
		"\7,\2\2\u01fbd\3\2\2\2\u01fc\u01fd\7\'\2\2\u01fdf\3\2\2\2\u01fe\u01ff"+
		"\7e\2\2\u01ff\u0200\7q\2\2\u0200\u0201\7p\2\2\u0201\u0202\7v\2\2\u0202"+
		"\u0203\7c\2\2\u0203\u0204\7k\2\2\u0204\u0205\7p\2\2\u0205\u0206\7u\2\2"+
		"\u0206\u0207\7<\2\2\u0207h\3\2\2\2\u0208\u0209\7e\2\2\u0209\u020a\7q\2"+
		"\2\u020a\u020b\7o\2\2\u020b\u020c\7r\2\2\u020c\u020d\7<\2\2\u020dj\3\2"+
		"\2\2\u020e\u020f\7t\2\2\u020f\u0210\7g\2\2\u0210\u0211\7x\2\2\u0211\u0212"+
		"\7<\2\2\u0212l\3\2\2\2\u0213\u0214\7n\2\2\u0214\u0215\7g\2\2\u0215\u0216"+
		"\7p\2\2\u0216\u0217\7<\2\2\u0217n\3\2\2\2\u0218\u0219\7r\2\2\u0219\u021a"+
		"\7q\2\2\u021a\u021b\7u\2\2\u021b\u021c\7k\2\2\u021c\u021d\7v\2\2\u021d"+
		"\u021e\7k\2\2\u021e\u021f\7q\2\2\u021f\u0220\7p\2\2\u0220\u0221\7\"\2"+
		"\2\u0221\u0222\7q\2\2\u0222\u0223\7h\2\2\u0223\u0224\7\"\2\2\u0224p\3"+
		"\2\2\2\u0225\u0226\7e\2\2\u0226\u0227\7q\2\2\u0227\u0228\7w\2\2\u0228"+
		"\u0229\7p\2\2\u0229\u022a\7v\2\2\u022a\u022b\7\"\2\2\u022br\3\2\2\2\u022c"+
		"\u022d\7t\2\2\u022d\u022e\7g\2\2\u022e\u022f\7o\2\2\u022f\u0230\7q\2\2"+
		"\u0230\u0231\7x\2\2\u0231\u0232\7g\2\2\u0232\u0233\7\"\2\2\u0233t\3\2"+
		"\2\2\17\2\u00c3\u00ce\u00d3\u00d8\u00dd\u00f3\u00f8\u00fd\u00ff\u013d"+
		"\u01b7\u01bf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}