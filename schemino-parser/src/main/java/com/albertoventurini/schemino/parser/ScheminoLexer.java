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
		EQUALS=16, COMMENT=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DEFINE", "LAMBDA", 
		"BOOLEAN", "LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "EQUALS", 
		"COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'=>'", "'''", "'('", "')'", "'{'", "'}'", "'define'", "'lambda'", 
		null, null, null, null, null, null, "'=='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "DEFINE", "LAMBDA", "BOOLEAN", 
		"LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "EQUALS", "COMMENT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13N\n\13\3\f\5\fQ\n\f\3\f\6\f"+
		"T\n\f\r\f\16\fU\3\f\5\fY\n\f\3\r\3\r\7\r]\n\r\f\r\16\r`\13\r\3\16\3\16"+
		"\3\17\3\17\5\17f\n\17\3\20\3\20\3\20\3\20\7\20l\n\20\f\20\16\20o\13\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\7\22x\n\22\f\22\16\22{\13\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3y\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\3\2"+
		"\62;\4\2NNnn\t\2,-//\61\61>>@@C\\c|\3\2$$\5\2\13\f\17\17\"\"\2\u008c\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7,\3\2\2\2\t.\3\2\2\2\13\60\3\2\2"+
		"\2\r\62\3\2\2\2\17\64\3\2\2\2\21\66\3\2\2\2\23=\3\2\2\2\25M\3\2\2\2\27"+
		"P\3\2\2\2\31Z\3\2\2\2\33a\3\2\2\2\35e\3\2\2\2\37g\3\2\2\2!r\3\2\2\2#u"+
		"\3\2\2\2%\u0080\3\2\2\2\'(\7<\2\2(\4\3\2\2\2)*\7?\2\2*+\7@\2\2+\6\3\2"+
		"\2\2,-\7)\2\2-\b\3\2\2\2./\7*\2\2/\n\3\2\2\2\60\61\7+\2\2\61\f\3\2\2\2"+
		"\62\63\7}\2\2\63\16\3\2\2\2\64\65\7\177\2\2\65\20\3\2\2\2\66\67\7f\2\2"+
		"\678\7g\2\289\7h\2\29:\7k\2\2:;\7p\2\2;<\7g\2\2<\22\3\2\2\2=>\7n\2\2>"+
		"?\7c\2\2?@\7o\2\2@A\7d\2\2AB\7f\2\2BC\7c\2\2C\24\3\2\2\2DE\7v\2\2EF\7"+
		"t\2\2FG\7w\2\2GN\7g\2\2HI\7h\2\2IJ\7c\2\2JK\7n\2\2KL\7u\2\2LN\7g\2\2M"+
		"D\3\2\2\2MH\3\2\2\2N\26\3\2\2\2OQ\7/\2\2PO\3\2\2\2PQ\3\2\2\2QS\3\2\2\2"+
		"RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WY\t\3\2\2"+
		"XW\3\2\2\2XY\3\2\2\2Y\30\3\2\2\2Z^\5\33\16\2[]\5\35\17\2\\[\3\2\2\2]`"+
		"\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\32\3\2\2\2`^\3\2\2\2ab\t\4\2\2b\34\3\2"+
		"\2\2cf\5\33\16\2df\4\62;\2ec\3\2\2\2ed\3\2\2\2f\36\3\2\2\2gm\7$\2\2hl"+
		"\n\5\2\2ij\7^\2\2jl\7$\2\2kh\3\2\2\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3"+
		"\2\2\2np\3\2\2\2om\3\2\2\2pq\7$\2\2q \3\2\2\2rs\7?\2\2st\7?\2\2t\"\3\2"+
		"\2\2uy\7=\2\2vx\13\2\2\2wv\3\2\2\2x{\3\2\2\2yz\3\2\2\2yw\3\2\2\2z|\3\2"+
		"\2\2{y\3\2\2\2|}\7\f\2\2}~\3\2\2\2~\177\b\22\2\2\177$\3\2\2\2\u0080\u0081"+
		"\t\6\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\23\2\2\u0083&\3\2\2\2\f\2M"+
		"PUX^ekmy\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}