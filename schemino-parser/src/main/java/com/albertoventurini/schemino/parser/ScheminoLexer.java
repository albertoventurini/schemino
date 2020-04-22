// Generated from com/albertoventurini/schemino/parser/Schemino.g4 by ANTLR 4.8
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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, DEFINE=6, LAMBDA=7, BOOLEAN=8, 
		LONG=9, SYMBOL=10, SYMBOL_HEAD=11, SYMBOL_REST=12, STRING=13, COMMENT=14, 
		WS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "DEFINE", "LAMBDA", "BOOLEAN", 
			"LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "COMMENT", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "'('", "')'", "'{'", "'}'", "'define'", "'lambda'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "DEFINE", "LAMBDA", "BOOLEAN", "LONG", 
			"SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tC\n\t\3\n\5\nF\n\n\3\n\6"+
		"\nI\n\n\r\n\16\nJ\3\n\5\nN\n\n\3\13\3\13\7\13R\n\13\f\13\16\13U\13\13"+
		"\3\f\3\f\3\r\3\r\5\r[\n\r\3\16\3\16\3\16\3\16\7\16a\n\16\f\16\16\16d\13"+
		"\16\3\16\3\16\3\17\3\17\7\17j\n\17\f\17\16\17m\13\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3k\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\7\3\2\62;\4\2NNnn\b\2,-//\61"+
		"\61>@C\\c|\3\2$$\5\2\13\f\17\17\"\"\2~\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3"+
		"\2\2\2\r+\3\2\2\2\17\62\3\2\2\2\21B\3\2\2\2\23E\3\2\2\2\25O\3\2\2\2\27"+
		"V\3\2\2\2\31Z\3\2\2\2\33\\\3\2\2\2\35g\3\2\2\2\37r\3\2\2\2!\"\7)\2\2\""+
		"\4\3\2\2\2#$\7*\2\2$\6\3\2\2\2%&\7+\2\2&\b\3\2\2\2\'(\7}\2\2(\n\3\2\2"+
		"\2)*\7\177\2\2*\f\3\2\2\2+,\7f\2\2,-\7g\2\2-.\7h\2\2./\7k\2\2/\60\7p\2"+
		"\2\60\61\7g\2\2\61\16\3\2\2\2\62\63\7n\2\2\63\64\7c\2\2\64\65\7o\2\2\65"+
		"\66\7d\2\2\66\67\7f\2\2\678\7c\2\28\20\3\2\2\29:\7v\2\2:;\7t\2\2;<\7w"+
		"\2\2<C\7g\2\2=>\7h\2\2>?\7c\2\2?@\7n\2\2@A\7u\2\2AC\7g\2\2B9\3\2\2\2B"+
		"=\3\2\2\2C\22\3\2\2\2DF\7/\2\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2GI\t\2\2\2"+
		"HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\t\3\2\2ML\3\2\2\2"+
		"MN\3\2\2\2N\24\3\2\2\2OS\5\27\f\2PR\5\31\r\2QP\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2T\26\3\2\2\2US\3\2\2\2VW\t\4\2\2W\30\3\2\2\2X[\5\27\f\2"+
		"Y[\4\62;\2ZX\3\2\2\2ZY\3\2\2\2[\32\3\2\2\2\\b\7$\2\2]a\n\5\2\2^_\7^\2"+
		"\2_a\7$\2\2`]\3\2\2\2`^\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2"+
		"\2db\3\2\2\2ef\7$\2\2f\34\3\2\2\2gk\7=\2\2hj\13\2\2\2ih\3\2\2\2jm\3\2"+
		"\2\2kl\3\2\2\2ki\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\f\2\2op\3\2\2\2pq\b\17"+
		"\2\2q\36\3\2\2\2rs\t\6\2\2st\3\2\2\2tu\b\20\2\2u \3\2\2\2\f\2BEJMSZ`b"+
		"k\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}