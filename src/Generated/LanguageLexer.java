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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u01c2\b\1\4\2\t"+
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
		"\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f4\n\24\3\25\3\25\6\25\u00f8\n"+
		"\25\r\25\16\25\u00f9\3\25\3\25\3\25\3\25\6\25\u0100\n\25\r\25\16\25\u0101"+
		"\3\25\3\25\5\25\u0106\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0146\n\27"+
		"\3\30\3\30\3\31\3\31\7\31\u014c\n\31\f\31\16\31\u014f\13\31\3\32\3\32"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\38\38\38\38\38\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3:"+
		"\3:\3:\3:\3:\3:\2\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\2\61\31\63\32"+
		"\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_\60a\61c\62"+
		"e\63g\64i\65k\66m\67o8q9s:\3\2\t\6\2CCEEIIVV\6\2CCEEIIWW\b\2CCEKMPRVX"+
		"Y[[\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u01e1\2\3\3"+
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
		"%\u00e1\3\2\2\2\'\u00f3\3\2\2\2)\u0105\3\2\2\2+\u0107\3\2\2\2-\u0145\3"+
		"\2\2\2/\u0147\3\2\2\2\61\u0149\3\2\2\2\63\u0150\3\2\2\2\65\u0154\3\2\2"+
		"\2\67\u0156\3\2\2\29\u0158\3\2\2\2;\u015a\3\2\2\2=\u015c\3\2\2\2?\u015e"+
		"\3\2\2\2A\u0160\3\2\2\2C\u0162\3\2\2\2E\u0164\3\2\2\2G\u0166\3\2\2\2I"+
		"\u0168\3\2\2\2K\u016a\3\2\2\2M\u016d\3\2\2\2O\u0170\3\2\2\2Q\u0172\3\2"+
		"\2\2S\u0174\3\2\2\2U\u0177\3\2\2\2W\u0179\3\2\2\2Y\u017b\3\2\2\2[\u017e"+
		"\3\2\2\2]\u0181\3\2\2\2_\u0184\3\2\2\2a\u0186\3\2\2\2c\u0188\3\2\2\2e"+
		"\u018a\3\2\2\2g\u018c\3\2\2\2i\u0196\3\2\2\2k\u019c\3\2\2\2m\u01a1\3\2"+
		"\2\2o\u01a6\3\2\2\2q\u01b3\3\2\2\2s\u01ba\3\2\2\2uv\7k\2\2vw\7h\2\2w\4"+
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
		"\2\2\u00f4(\3\2\2\2\u00f5\u00f7\7$\2\2\u00f6\u00f8\5+\26\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fc\7$\2\2\u00fc\u0106\3\2\2\2\u00fd\u00ff\7$\2"+
		"\2\u00fe\u0100\5-\27\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7$\2\2\u0104"+
		"\u0106\3\2\2\2\u0105\u00f5\3\2\2\2\u0105\u00fd\3\2\2\2\u0106*\3\2\2\2"+
		"\u0107\u0108\t\4\2\2\u0108,\3\2\2\2\u0109\u010a\7C\2\2\u010a\u010b\7n"+
		"\2\2\u010b\u0146\7c\2\2\u010c\u010d\7E\2\2\u010d\u010e\7{\2\2\u010e\u0146"+
		"\7u\2\2\u010f\u0110\7C\2\2\u0110\u0111\7u\2\2\u0111\u0146\7r\2\2\u0112"+
		"\u0113\7I\2\2\u0113\u0114\7n\2\2\u0114\u0146\7w\2\2\u0115\u0116\7R\2\2"+
		"\u0116\u0117\7j\2\2\u0117\u0146\7g\2\2\u0118\u0119\7I\2\2\u0119\u011a"+
		"\7n\2\2\u011a\u0146\7{\2\2\u011b\u011c\7J\2\2\u011c\u011d\7k\2\2\u011d"+
		"\u0146\7u\2\2\u011e\u011f\7K\2\2\u011f\u0120\7n\2\2\u0120\u0146\7g\2\2"+
		"\u0121\u0122\7N\2\2\u0122\u0123\7{\2\2\u0123\u0146\7u\2\2\u0124\u0125"+
		"\7N\2\2\u0125\u0126\7g\2\2\u0126\u0146\7w\2\2\u0127\u0128\7O\2\2\u0128"+
		"\u0129\7g\2\2\u0129\u0146\7v\2\2\u012a\u012b\7C\2\2\u012b\u012c\7u\2\2"+
		"\u012c\u0146\7p\2\2\u012d\u012e\7R\2\2\u012e\u012f\7t\2\2\u012f\u0146"+
		"\7q\2\2\u0130\u0131\7I\2\2\u0131\u0132\7n\2\2\u0132\u0146\7p\2\2\u0133"+
		"\u0134\7C\2\2\u0134\u0135\7t\2\2\u0135\u0146\7i\2\2\u0136\u0137\7U\2\2"+
		"\u0137\u0138\7g\2\2\u0138\u0146\7t\2\2\u0139\u013a\7V\2\2\u013a\u013b"+
		"\7j\2\2\u013b\u0146\7t\2\2\u013c\u013d\7X\2\2\u013d\u013e\7c\2\2\u013e"+
		"\u0146\7n\2\2\u013f\u0140\7V\2\2\u0140\u0141\7t\2\2\u0141\u0146\7r\2\2"+
		"\u0142\u0143\7V\2\2\u0143\u0144\7{\2\2\u0144\u0146\7t\2\2\u0145\u0109"+
		"\3\2\2\2\u0145\u010c\3\2\2\2\u0145\u010f\3\2\2\2\u0145\u0112\3\2\2\2\u0145"+
		"\u0115\3\2\2\2\u0145\u0118\3\2\2\2\u0145\u011b\3\2\2\2\u0145\u011e\3\2"+
		"\2\2\u0145\u0121\3\2\2\2\u0145\u0124\3\2\2\2\u0145\u0127\3\2\2\2\u0145"+
		"\u012a\3\2\2\2\u0145\u012d\3\2\2\2\u0145\u0130\3\2\2\2\u0145\u0133\3\2"+
		"\2\2\u0145\u0136\3\2\2\2\u0145\u0139\3\2\2\2\u0145\u013c\3\2\2\2\u0145"+
		"\u013f\3\2\2\2\u0145\u0142\3\2\2\2\u0146.\3\2\2\2\u0147\u0148\t\5\2\2"+
		"\u0148\60\3\2\2\2\u0149\u014d\t\6\2\2\u014a\u014c\t\7\2\2\u014b\u014a"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\62\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0151\t\b\2\2\u0151\u0152\3\2\2"+
		"\2\u0152\u0153\b\32\2\2\u0153\64\3\2\2\2\u0154\u0155\7}\2\2\u0155\66\3"+
		"\2\2\2\u0156\u0157\7*\2\2\u01578\3\2\2\2\u0158\u0159\7]\2\2\u0159:\3\2"+
		"\2\2\u015a\u015b\7\177\2\2\u015b<\3\2\2\2\u015c\u015d\7+\2\2\u015d>\3"+
		"\2\2\2\u015e\u015f\7_\2\2\u015f@\3\2\2\2\u0160\u0161\7.\2\2\u0161B\3\2"+
		"\2\2\u0162\u0163\7<\2\2\u0163D\3\2\2\2\u0164\u0165\7=\2\2\u0165F\3\2\2"+
		"\2\u0166\u0167\7>\2\2\u0167H\3\2\2\2\u0168\u0169\7@\2\2\u0169J\3\2\2\2"+
		"\u016a\u016b\7>\2\2\u016b\u016c\7?\2\2\u016cL\3\2\2\2\u016d\u016e\7@\2"+
		"\2\u016e\u016f\7?\2\2\u016fN\3\2\2\2\u0170\u0171\7a\2\2\u0171P\3\2\2\2"+
		"\u0172\u0173\7#\2\2\u0173R\3\2\2\2\u0174\u0175\7(\2\2\u0175\u0176\7(\2"+
		"\2\u0176T\3\2\2\2\u0177\u0178\7/\2\2\u0178V\3\2\2\2\u0179\u017a\7?\2\2"+
		"\u017aX\3\2\2\2\u017b\u017c\7?\2\2\u017c\u017d\7?\2\2\u017dZ\3\2\2\2\u017e"+
		"\u017f\7#\2\2\u017f\u0180\7?\2\2\u0180\\\3\2\2\2\u0181\u0182\7~\2\2\u0182"+
		"\u0183\7~\2\2\u0183^\3\2\2\2\u0184\u0185\7\61\2\2\u0185`\3\2\2\2\u0186"+
		"\u0187\7-\2\2\u0187b\3\2\2\2\u0188\u0189\7,\2\2\u0189d\3\2\2\2\u018a\u018b"+
		"\7\'\2\2\u018bf\3\2\2\2\u018c\u018d\7e\2\2\u018d\u018e\7q\2\2\u018e\u018f"+
		"\7p\2\2\u018f\u0190\7v\2\2\u0190\u0191\7c\2\2\u0191\u0192\7k\2\2\u0192"+
		"\u0193\7p\2\2\u0193\u0194\7u\2\2\u0194\u0195\7<\2\2\u0195h\3\2\2\2\u0196"+
		"\u0197\7e\2\2\u0197\u0198\7q\2\2\u0198\u0199\7o\2\2\u0199\u019a\7r\2\2"+
		"\u019a\u019b\7<\2\2\u019bj\3\2\2\2\u019c\u019d\7t\2\2\u019d\u019e\7g\2"+
		"\2\u019e\u019f\7x\2\2\u019f\u01a0\7<\2\2\u01a0l\3\2\2\2\u01a1\u01a2\7"+
		"n\2\2\u01a2\u01a3\7g\2\2\u01a3\u01a4\7p\2\2\u01a4\u01a5\7<\2\2\u01a5n"+
		"\3\2\2\2\u01a6\u01a7\7r\2\2\u01a7\u01a8\7q\2\2\u01a8\u01a9\7u\2\2\u01a9"+
		"\u01aa\7k\2\2\u01aa\u01ab\7v\2\2\u01ab\u01ac\7k\2\2\u01ac\u01ad\7q\2\2"+
		"\u01ad\u01ae\7p\2\2\u01ae\u01af\7\"\2\2\u01af\u01b0\7q\2\2\u01b0\u01b1"+
		"\7h\2\2\u01b1\u01b2\7\"\2\2\u01b2p\3\2\2\2\u01b3\u01b4\7e\2\2\u01b4\u01b5"+
		"\7q\2\2\u01b5\u01b6\7w\2\2\u01b6\u01b7\7p\2\2\u01b7\u01b8\7v\2\2\u01b8"+
		"\u01b9\7\"\2\2\u01b9r\3\2\2\2\u01ba\u01bb\7t\2\2\u01bb\u01bc\7g\2\2\u01bc"+
		"\u01bd\7o\2\2\u01bd\u01be\7q\2\2\u01be\u01bf\7x\2\2\u01bf\u01c0\7g\2\2"+
		"\u01c0\u01c1\7\"\2\2\u01c1t\3\2\2\2\16\2\u00c3\u00ce\u00d3\u00d8\u00dd"+
		"\u00f3\u00f9\u0101\u0105\u0145\u014d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}