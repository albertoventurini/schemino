// Generated from com/albertoventurini/schemino/parser/Schemino.g4 by ANTLR 4.7.1
package com.albertoventurini.schemino.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScheminoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DEFINE=8, LAMBDA=9, 
		BOOLEAN=10, LONG=11, SYMBOL=12, SYMBOL_HEAD=13, SYMBOL_REST=14, STRING=15, 
		EQUALS=16, TAILREC=17, COMMENT=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DEFINE", "LAMBDA", 
		"BOOLEAN", "LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "EQUALS", 
		"TAILREC", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'=>'", "'''", "'('", "')'", "'{'", "'}'", "'define'", "'lambda'", 
		null, null, null, null, null, null, "'=='", "'@tailrec'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "DEFINE", "LAMBDA", "BOOLEAN", 
		"LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "EQUALS", "TAILREC", 
		"COMMENT", "WS"
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


	public ScheminoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Schemino.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13P\n\13\3\f\5\fS\n"+
		"\f\3\f\6\fV\n\f\r\f\16\fW\3\f\5\f[\n\f\3\r\3\r\7\r_\n\r\f\r\16\rb\13\r"+
		"\3\16\3\16\3\17\3\17\5\17h\n\17\3\20\3\20\3\20\3\20\7\20n\n\20\f\20\16"+
		"\20q\13\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\7\23\u0083\n\23\f\23\16\23\u0086\13\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\u0084\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7"+
		"\3\2\62;\4\2NNnn\t\2,-//\61\61>>@@C\\c|\3\2$$\5\2\13\f\17\17\"\"\2\u0097"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7.\3\2\2\2\t\60\3\2"+
		"\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17\66\3\2\2\2\218\3\2\2\2\23?\3\2\2\2"+
		"\25O\3\2\2\2\27R\3\2\2\2\31\\\3\2\2\2\33c\3\2\2\2\35g\3\2\2\2\37i\3\2"+
		"\2\2!t\3\2\2\2#w\3\2\2\2%\u0080\3\2\2\2\'\u008b\3\2\2\2)*\7<\2\2*\4\3"+
		"\2\2\2+,\7?\2\2,-\7@\2\2-\6\3\2\2\2./\7)\2\2/\b\3\2\2\2\60\61\7*\2\2\61"+
		"\n\3\2\2\2\62\63\7+\2\2\63\f\3\2\2\2\64\65\7}\2\2\65\16\3\2\2\2\66\67"+
		"\7\177\2\2\67\20\3\2\2\289\7f\2\29:\7g\2\2:;\7h\2\2;<\7k\2\2<=\7p\2\2"+
		"=>\7g\2\2>\22\3\2\2\2?@\7n\2\2@A\7c\2\2AB\7o\2\2BC\7d\2\2CD\7f\2\2DE\7"+
		"c\2\2E\24\3\2\2\2FG\7v\2\2GH\7t\2\2HI\7w\2\2IP\7g\2\2JK\7h\2\2KL\7c\2"+
		"\2LM\7n\2\2MN\7u\2\2NP\7g\2\2OF\3\2\2\2OJ\3\2\2\2P\26\3\2\2\2QS\7/\2\2"+
		"RQ\3\2\2\2RS\3\2\2\2SU\3\2\2\2TV\t\2\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2"+
		"WX\3\2\2\2XZ\3\2\2\2Y[\t\3\2\2ZY\3\2\2\2Z[\3\2\2\2[\30\3\2\2\2\\`\5\33"+
		"\16\2]_\5\35\17\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\32\3\2\2\2"+
		"b`\3\2\2\2cd\t\4\2\2d\34\3\2\2\2eh\5\33\16\2fh\4\62;\2ge\3\2\2\2gf\3\2"+
		"\2\2h\36\3\2\2\2io\7$\2\2jn\n\5\2\2kl\7^\2\2ln\7$\2\2mj\3\2\2\2mk\3\2"+
		"\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7$\2\2s \3\2"+
		"\2\2tu\7?\2\2uv\7?\2\2v\"\3\2\2\2wx\7B\2\2xy\7v\2\2yz\7c\2\2z{\7k\2\2"+
		"{|\7n\2\2|}\7t\2\2}~\7g\2\2~\177\7e\2\2\177$\3\2\2\2\u0080\u0084\7=\2"+
		"\2\u0081\u0083\13\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0087\u0088\7\f\2\2\u0088\u0089\3\2\2\2\u0089\u008a\b\23\2\2\u008a"+
		"&\3\2\2\2\u008b\u008c\t\6\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\24\2\2"+
		"\u008e(\3\2\2\2\f\2ORWZ`gmo\u0084\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}