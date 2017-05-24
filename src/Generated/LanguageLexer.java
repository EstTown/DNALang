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
		T__9=10, TYPE=11, BOOL=12, INT=13, DNA=14, RNA=15, DNAsym=16, RNAsym=17, 
		CODON=18, PROTEIN=19, AMINOACIDSINGLE=20, AMINOACIDTRIPLE=21, Word=22, 
		WS=23, LCURLY=24, LPAREN=25, LBRACK=26, RCURLY=27, RPAREN=28, RBRACK=29, 
		COMMA=30, COLON=31, SEMI=32, LT=33, GT=34, LTEQ=35, GTEQ=36, UNDERSCORE=37, 
		NOT=38, AND=39, SUB=40, EQUAL=41, EQEQ=42, NOTEQ=43, OR=44, DIV=45, ADD=46, 
		MUL=47, MOD=48, CONTAINS=49, COMPLEMENTARY=50, REVERSE=51, LENGTH=52, 
		POSITION=53, COUNT=54, REMOVE=55;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "TYPE", "BOOL", "INT", "DNA", "RNA", "DNAsym", "RNAsym", "CODON", 
		"PROTEIN", "AMINOACIDSINGLE", "AMINOACIDTRIPLE", "Digit", "Word", "WS", 
		"LCURLY", "LPAREN", "LBRACK", "RCURLY", "RPAREN", "RBRACK", "COMMA", "COLON", 
		"SEMI", "LT", "GT", "LTEQ", "GTEQ", "UNDERSCORE", "NOT", "AND", "SUB", 
		"EQUAL", "EQEQ", "NOTEQ", "OR", "DIV", "ADD", "MUL", "MOD", "CONTAINS", 
		"COMPLEMENTARY", "REVERSE", "LENGTH", "POSITION", "COUNT", "REMOVE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'else'", "'while'", "'for'", "'as'", "'in'", "'from'", 
		"'break'", "'return'", "'Print'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "'{'", "'('", "'['", "'}'", 
		"')'", "']'", "','", "':'", "';'", "'<'", "'>'", "'<='", "'>='", "'_'", 
		"'!'", "'&&'", "'-'", "'='", "'=='", "'!='", "'||'", "'/'", "'+'", "'*'", 
		"'%'", "' contains '", "'comp:'", "'rev:'", "'len:'", "'position of '", 
		"'count '", "'remove '"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
		"BOOL", "INT", "DNA", "RNA", "DNAsym", "RNAsym", "CODON", "PROTEIN", "AMINOACIDSINGLE", 
		"AMINOACIDTRIPLE", "Word", "WS", "LCURLY", "LPAREN", "LBRACK", "RCURLY", 
		"RPAREN", "RBRACK", "COMMA", "COLON", "SEMI", "LT", "GT", "LTEQ", "GTEQ", 
		"UNDERSCORE", "NOT", "AND", "SUB", "EQUAL", "EQEQ", "NOTEQ", "OR", "DIV", 
		"ADD", "MUL", "MOD", "CONTAINS", "COMPLEMENTARY", "REVERSE", "LENGTH", 
		"POSITION", "COUNT", "REMOVE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u01bc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bd"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\16\6\16\u00cb"+
		"\n\16\r\16\16\16\u00cc\3\17\6\17\u00d0\n\17\r\17\16\17\u00d1\3\20\6\20"+
		"\u00d5\n\20\r\20\16\20\u00d6\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ed"+
		"\n\23\3\24\3\24\6\24\u00f1\n\24\r\24\16\24\u00f2\3\24\3\24\3\24\3\24\6"+
		"\24\u00f9\n\24\r\24\16\24\u00fa\3\24\3\24\5\24\u00ff\n\24\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u013f\n\26\3\27\3\27\3\30\3\30\7\30\u0145\n\30"+
		"\f\30\16\30\u0148\13\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3"+
		"%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3."+
		"\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\39"+
		"\39\39\39\2\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\2/\30\61\31\63\32\65\33\67"+
		"\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62e\63g\64"+
		"i\65k\66m\67o8q9\3\2\t\6\2CCEEIIVV\6\2CCEEIIWW\b\2CCEKMPRVXY[[\3\2\62"+
		";\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u01db\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\3s"+
		"\3\2\2\2\5v\3\2\2\2\7{\3\2\2\2\t\u0081\3\2\2\2\13\u0085\3\2\2\2\r\u0088"+
		"\3\2\2\2\17\u008b\3\2\2\2\21\u0090\3\2\2\2\23\u0096\3\2\2\2\25\u009d\3"+
		"\2\2\2\27\u00bc\3\2\2\2\31\u00c7\3\2\2\2\33\u00ca\3\2\2\2\35\u00cf\3\2"+
		"\2\2\37\u00d4\3\2\2\2!\u00d8\3\2\2\2#\u00da\3\2\2\2%\u00ec\3\2\2\2\'\u00fe"+
		"\3\2\2\2)\u0100\3\2\2\2+\u013e\3\2\2\2-\u0140\3\2\2\2/\u0142\3\2\2\2\61"+
		"\u0149\3\2\2\2\63\u014d\3\2\2\2\65\u014f\3\2\2\2\67\u0151\3\2\2\29\u0153"+
		"\3\2\2\2;\u0155\3\2\2\2=\u0157\3\2\2\2?\u0159\3\2\2\2A\u015b\3\2\2\2C"+
		"\u015d\3\2\2\2E\u015f\3\2\2\2G\u0161\3\2\2\2I\u0163\3\2\2\2K\u0166\3\2"+
		"\2\2M\u0169\3\2\2\2O\u016b\3\2\2\2Q\u016d\3\2\2\2S\u0170\3\2\2\2U\u0172"+
		"\3\2\2\2W\u0174\3\2\2\2Y\u0177\3\2\2\2[\u017a\3\2\2\2]\u017d\3\2\2\2_"+
		"\u017f\3\2\2\2a\u0181\3\2\2\2c\u0183\3\2\2\2e\u0185\3\2\2\2g\u0190\3\2"+
		"\2\2i\u0196\3\2\2\2k\u019b\3\2\2\2m\u01a0\3\2\2\2o\u01ad\3\2\2\2q\u01b4"+
		"\3\2\2\2st\7k\2\2tu\7h\2\2u\4\3\2\2\2vw\7g\2\2wx\7n\2\2xy\7u\2\2yz\7g"+
		"\2\2z\6\3\2\2\2{|\7y\2\2|}\7j\2\2}~\7k\2\2~\177\7n\2\2\177\u0080\7g\2"+
		"\2\u0080\b\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7q\2\2\u0083\u0084\7"+
		"t\2\2\u0084\n\3\2\2\2\u0085\u0086\7c\2\2\u0086\u0087\7u\2\2\u0087\f\3"+
		"\2\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a\16\3\2\2\2\u008b\u008c"+
		"\7h\2\2\u008c\u008d\7t\2\2\u008d\u008e\7q\2\2\u008e\u008f\7o\2\2\u008f"+
		"\20\3\2\2\2\u0090\u0091\7d\2\2\u0091\u0092\7t\2\2\u0092\u0093\7g\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7m\2\2\u0095\22\3\2\2\2\u0096\u0097\7t\2\2\u0097"+
		"\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099\u009a\7w\2\2\u009a\u009b\7t\2\2"+
		"\u009b\u009c\7p\2\2\u009c\24\3\2\2\2\u009d\u009e\7R\2\2\u009e\u009f\7"+
		"t\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7v\2\2\u00a2\26"+
		"\3\2\2\2\u00a3\u00a4\7f\2\2\u00a4\u00a5\7p\2\2\u00a5\u00bd\7c\2\2\u00a6"+
		"\u00a7\7t\2\2\u00a7\u00a8\7p\2\2\u00a8\u00bd\7c\2\2\u00a9\u00aa\7e\2\2"+
		"\u00aa\u00ab\7q\2\2\u00ab\u00ac\7f\2\2\u00ac\u00ad\7q\2\2\u00ad\u00bd"+
		"\7p\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7q\2\2\u00b1"+
		"\u00b2\7v\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7k\2\2\u00b4\u00bd\7p\2\2"+
		"\u00b5\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7\u00bd\7v\2\2\u00b8\u00b9"+
		"\7d\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bd\7n\2\2\u00bc"+
		"\u00a3\3\2\2\2\u00bc\u00a6\3\2\2\2\u00bc\u00a9\3\2\2\2\u00bc\u00ae\3\2"+
		"\2\2\u00bc\u00b5\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd\30\3\2\2\2\u00be\u00bf"+
		"\7v\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c8\7g\2\2\u00c2"+
		"\u00c3\7h\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7n\2\2\u00c5\u00c6\7u\2\2"+
		"\u00c6\u00c8\7g\2\2\u00c7\u00be\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c8\32\3"+
		"\2\2\2\u00c9\u00cb\5-\27\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\34\3\2\2\2\u00ce\u00d0\5!\21"+
		"\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\36\3\2\2\2\u00d3\u00d5\5#\22\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7 \3\2\2\2"+
		"\u00d8\u00d9\t\2\2\2\u00d9\"\3\2\2\2\u00da\u00db\t\3\2\2\u00db$\3\2\2"+
		"\2\u00dc\u00dd\7*\2\2\u00dd\u00de\5!\21\2\u00de\u00df\7.\2\2\u00df\u00e0"+
		"\5!\21\2\u00e0\u00e1\7.\2\2\u00e1\u00e2\5!\21\2\u00e2\u00e3\7+\2\2\u00e3"+
		"\u00ed\3\2\2\2\u00e4\u00e5\7*\2\2\u00e5\u00e6\5#\22\2\u00e6\u00e7\7.\2"+
		"\2\u00e7\u00e8\5#\22\2\u00e8\u00e9\7.\2\2\u00e9\u00ea\5#\22\2\u00ea\u00eb"+
		"\7+\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00dc\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ed"+
		"&\3\2\2\2\u00ee\u00f0\7$\2\2\u00ef\u00f1\5)\25\2\u00f0\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2"+
		"\2\2\u00f4\u00f5\7$\2\2\u00f5\u00ff\3\2\2\2\u00f6\u00f8\7$\2\2\u00f7\u00f9"+
		"\5+\26\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7$\2\2\u00fd\u00ff\3\2"+
		"\2\2\u00fe\u00ee\3\2\2\2\u00fe\u00f6\3\2\2\2\u00ff(\3\2\2\2\u0100\u0101"+
		"\t\4\2\2\u0101*\3\2\2\2\u0102\u0103\7C\2\2\u0103\u0104\7n\2\2\u0104\u013f"+
		"\7c\2\2\u0105\u0106\7E\2\2\u0106\u0107\7{\2\2\u0107\u013f\7u\2\2\u0108"+
		"\u0109\7C\2\2\u0109\u010a\7u\2\2\u010a\u013f\7r\2\2\u010b\u010c\7I\2\2"+
		"\u010c\u010d\7n\2\2\u010d\u013f\7w\2\2\u010e\u010f\7R\2\2\u010f\u0110"+
		"\7j\2\2\u0110\u013f\7g\2\2\u0111\u0112\7I\2\2\u0112\u0113\7n\2\2\u0113"+
		"\u013f\7{\2\2\u0114\u0115\7J\2\2\u0115\u0116\7k\2\2\u0116\u013f\7u\2\2"+
		"\u0117\u0118\7K\2\2\u0118\u0119\7n\2\2\u0119\u013f\7g\2\2\u011a\u011b"+
		"\7N\2\2\u011b\u011c\7{\2\2\u011c\u013f\7u\2\2\u011d\u011e\7N\2\2\u011e"+
		"\u011f\7g\2\2\u011f\u013f\7w\2\2\u0120\u0121\7O\2\2\u0121\u0122\7g\2\2"+
		"\u0122\u013f\7v\2\2\u0123\u0124\7C\2\2\u0124\u0125\7u\2\2\u0125\u013f"+
		"\7p\2\2\u0126\u0127\7R\2\2\u0127\u0128\7t\2\2\u0128\u013f\7q\2\2\u0129"+
		"\u012a\7I\2\2\u012a\u012b\7n\2\2\u012b\u013f\7p\2\2\u012c\u012d\7C\2\2"+
		"\u012d\u012e\7t\2\2\u012e\u013f\7i\2\2\u012f\u0130\7U\2\2\u0130\u0131"+
		"\7g\2\2\u0131\u013f\7t\2\2\u0132\u0133\7V\2\2\u0133\u0134\7j\2\2\u0134"+
		"\u013f\7t\2\2\u0135\u0136\7X\2\2\u0136\u0137\7c\2\2\u0137\u013f\7n\2\2"+
		"\u0138\u0139\7V\2\2\u0139\u013a\7t\2\2\u013a\u013f\7r\2\2\u013b\u013c"+
		"\7V\2\2\u013c\u013d\7{\2\2\u013d\u013f\7t\2\2\u013e\u0102\3\2\2\2\u013e"+
		"\u0105\3\2\2\2\u013e\u0108\3\2\2\2\u013e\u010b\3\2\2\2\u013e\u010e\3\2"+
		"\2\2\u013e\u0111\3\2\2\2\u013e\u0114\3\2\2\2\u013e\u0117\3\2\2\2\u013e"+
		"\u011a\3\2\2\2\u013e\u011d\3\2\2\2\u013e\u0120\3\2\2\2\u013e\u0123\3\2"+
		"\2\2\u013e\u0126\3\2\2\2\u013e\u0129\3\2\2\2\u013e\u012c\3\2\2\2\u013e"+
		"\u012f\3\2\2\2\u013e\u0132\3\2\2\2\u013e\u0135\3\2\2\2\u013e\u0138\3\2"+
		"\2\2\u013e\u013b\3\2\2\2\u013f,\3\2\2\2\u0140\u0141\t\5\2\2\u0141.\3\2"+
		"\2\2\u0142\u0146\t\6\2\2\u0143\u0145\t\7\2\2\u0144\u0143\3\2\2\2\u0145"+
		"\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\60\3\2\2"+
		"\2\u0148\u0146\3\2\2\2\u0149\u014a\t\b\2\2\u014a\u014b\3\2\2\2\u014b\u014c"+
		"\b\31\2\2\u014c\62\3\2\2\2\u014d\u014e\7}\2\2\u014e\64\3\2\2\2\u014f\u0150"+
		"\7*\2\2\u0150\66\3\2\2\2\u0151\u0152\7]\2\2\u01528\3\2\2\2\u0153\u0154"+
		"\7\177\2\2\u0154:\3\2\2\2\u0155\u0156\7+\2\2\u0156<\3\2\2\2\u0157\u0158"+
		"\7_\2\2\u0158>\3\2\2\2\u0159\u015a\7.\2\2\u015a@\3\2\2\2\u015b\u015c\7"+
		"<\2\2\u015cB\3\2\2\2\u015d\u015e\7=\2\2\u015eD\3\2\2\2\u015f\u0160\7>"+
		"\2\2\u0160F\3\2\2\2\u0161\u0162\7@\2\2\u0162H\3\2\2\2\u0163\u0164\7>\2"+
		"\2\u0164\u0165\7?\2\2\u0165J\3\2\2\2\u0166\u0167\7@\2\2\u0167\u0168\7"+
		"?\2\2\u0168L\3\2\2\2\u0169\u016a\7a\2\2\u016aN\3\2\2\2\u016b\u016c\7#"+
		"\2\2\u016cP\3\2\2\2\u016d\u016e\7(\2\2\u016e\u016f\7(\2\2\u016fR\3\2\2"+
		"\2\u0170\u0171\7/\2\2\u0171T\3\2\2\2\u0172\u0173\7?\2\2\u0173V\3\2\2\2"+
		"\u0174\u0175\7?\2\2\u0175\u0176\7?\2\2\u0176X\3\2\2\2\u0177\u0178\7#\2"+
		"\2\u0178\u0179\7?\2\2\u0179Z\3\2\2\2\u017a\u017b\7~\2\2\u017b\u017c\7"+
		"~\2\2\u017c\\\3\2\2\2\u017d\u017e\7\61\2\2\u017e^\3\2\2\2\u017f\u0180"+
		"\7-\2\2\u0180`\3\2\2\2\u0181\u0182\7,\2\2\u0182b\3\2\2\2\u0183\u0184\7"+
		"\'\2\2\u0184d\3\2\2\2\u0185\u0186\7\"\2\2\u0186\u0187\7e\2\2\u0187\u0188"+
		"\7q\2\2\u0188\u0189\7p\2\2\u0189\u018a\7v\2\2\u018a\u018b\7c\2\2\u018b"+
		"\u018c\7k\2\2\u018c\u018d\7p\2\2\u018d\u018e\7u\2\2\u018e\u018f\7\"\2"+
		"\2\u018ff\3\2\2\2\u0190\u0191\7e\2\2\u0191\u0192\7q\2\2\u0192\u0193\7"+
		"o\2\2\u0193\u0194\7r\2\2\u0194\u0195\7<\2\2\u0195h\3\2\2\2\u0196\u0197"+
		"\7t\2\2\u0197\u0198\7g\2\2\u0198\u0199\7x\2\2\u0199\u019a\7<\2\2\u019a"+
		"j\3\2\2\2\u019b\u019c\7n\2\2\u019c\u019d\7g\2\2\u019d\u019e\7p\2\2\u019e"+
		"\u019f\7<\2\2\u019fl\3\2\2\2\u01a0\u01a1\7r\2\2\u01a1\u01a2\7q\2\2\u01a2"+
		"\u01a3\7u\2\2\u01a3\u01a4\7k\2\2\u01a4\u01a5\7v\2\2\u01a5\u01a6\7k\2\2"+
		"\u01a6\u01a7\7q\2\2\u01a7\u01a8\7p\2\2\u01a8\u01a9\7\"\2\2\u01a9\u01aa"+
		"\7q\2\2\u01aa\u01ab\7h\2\2\u01ab\u01ac\7\"\2\2\u01acn\3\2\2\2\u01ad\u01ae"+
		"\7e\2\2\u01ae\u01af\7q\2\2\u01af\u01b0\7w\2\2\u01b0\u01b1\7p\2\2\u01b1"+
		"\u01b2\7v\2\2\u01b2\u01b3\7\"\2\2\u01b3p\3\2\2\2\u01b4\u01b5\7t\2\2\u01b5"+
		"\u01b6\7g\2\2\u01b6\u01b7\7o\2\2\u01b7\u01b8\7q\2\2\u01b8\u01b9\7x\2\2"+
		"\u01b9\u01ba\7g\2\2\u01ba\u01bb\7\"\2\2\u01bbr\3\2\2\2\16\2\u00bc\u00c7"+
		"\u00cc\u00d1\u00d6\u00ec\u00f2\u00fa\u00fe\u013e\u0146\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}