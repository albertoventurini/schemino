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
		T__0=1, T__1=2, T__2=3, DEFINE=4, LAMBDA=5, BOOLEAN=6, LONG=7, SYMBOL=8, 
		STRING=9, COMMENT=10, WS=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "DEFINE", "LAMBDA", "BOOLEAN", "LONG", "SYMBOL", 
			"STRING", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "'('", "')'", "'define'", "'lambda'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "DEFINE", "LAMBDA", "BOOLEAN", "LONG", "SYMBOL", 
			"STRING", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\rb\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\67\n\7"+
		"\3\b\5\b:\n\b\3\b\6\b=\n\b\r\b\16\b>\3\b\5\bB\n\b\3\t\6\tE\n\t\r\t\16"+
		"\tF\3\n\3\n\3\n\3\n\7\nM\n\n\f\n\16\nP\13\n\3\n\3\n\3\13\3\13\7\13V\n"+
		"\13\f\13\16\13Y\13\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3W\2\r\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\7\3\2\62;\4\2NNnn\b"+
		"\2,-//\61\61>@C\\c|\3\2$$\5\2\13\f\17\17\"\"\2i\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5\33\3\2"+
		"\2\2\7\35\3\2\2\2\t\37\3\2\2\2\13&\3\2\2\2\r\66\3\2\2\2\179\3\2\2\2\21"+
		"D\3\2\2\2\23H\3\2\2\2\25S\3\2\2\2\27^\3\2\2\2\31\32\7)\2\2\32\4\3\2\2"+
		"\2\33\34\7*\2\2\34\6\3\2\2\2\35\36\7+\2\2\36\b\3\2\2\2\37 \7f\2\2 !\7"+
		"g\2\2!\"\7h\2\2\"#\7k\2\2#$\7p\2\2$%\7g\2\2%\n\3\2\2\2&\'\7n\2\2\'(\7"+
		"c\2\2()\7o\2\2)*\7d\2\2*+\7f\2\2+,\7c\2\2,\f\3\2\2\2-.\7v\2\2./\7t\2\2"+
		"/\60\7w\2\2\60\67\7g\2\2\61\62\7h\2\2\62\63\7c\2\2\63\64\7n\2\2\64\65"+
		"\7u\2\2\65\67\7g\2\2\66-\3\2\2\2\66\61\3\2\2\2\67\16\3\2\2\28:\7/\2\2"+
		"98\3\2\2\29:\3\2\2\2:<\3\2\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2"+
		">?\3\2\2\2?A\3\2\2\2@B\t\3\2\2A@\3\2\2\2AB\3\2\2\2B\20\3\2\2\2CE\t\4\2"+
		"\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\22\3\2\2\2HN\7$\2\2IM\n\5"+
		"\2\2JK\7^\2\2KM\7$\2\2LI\3\2\2\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2"+
		"\2OQ\3\2\2\2PN\3\2\2\2QR\7$\2\2R\24\3\2\2\2SW\7=\2\2TV\13\2\2\2UT\3\2"+
		"\2\2VY\3\2\2\2WX\3\2\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\f\2\2[\\\3"+
		"\2\2\2\\]\b\13\2\2]\26\3\2\2\2^_\t\6\2\2_`\3\2\2\2`a\b\f\2\2a\30\3\2\2"+
		"\2\13\2\669>AFLNW\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}