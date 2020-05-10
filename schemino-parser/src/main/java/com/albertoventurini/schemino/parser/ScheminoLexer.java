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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, DEFINE=9, 
		LAMBDA=10, BOOLEAN=11, LONG=12, SYMBOL=13, SYMBOL_HEAD=14, SYMBOL_REST=15, 
		STRING=16, EQUALS=17, TAILREC=18, COMMENT=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DEFINE", 
		"LAMBDA", "BOOLEAN", "LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", 
		"EQUALS", "TAILREC", "COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'=>'", "'['", "']'", "'('", "')'", "'{'", "'}'", "'define'", 
		"'lambda'", null, null, null, null, null, null, "'=='", "'@tailrec'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "DEFINE", "LAMBDA", 
		"BOOLEAN", "LONG", "SYMBOL", "SYMBOL_HEAD", "SYMBOL_REST", "STRING", "EQUALS", 
		"TAILREC", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0093\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fT"+
		"\n\f\3\r\5\rW\n\r\3\r\6\rZ\n\r\r\r\16\r[\3\r\5\r_\n\r\3\16\3\16\7\16c"+
		"\n\16\f\16\16\16f\13\16\3\17\3\17\3\20\3\20\5\20l\n\20\3\21\3\21\3\21"+
		"\3\21\7\21r\n\21\f\21\16\21u\13\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\7\24\u0087\n\24\f\24\16"+
		"\24\u008a\13\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\u0088\2\26\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26\3\2\7\3\2\62;\4\2NNnn\t\2,-//\61\61>>@@C\\c|"+
		"\3\2$$\5\2\13\f\17\17\"\"\2\u009b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\3+\3\2\2\2\5-\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r\66"+
		"\3\2\2\2\178\3\2\2\2\21:\3\2\2\2\23<\3\2\2\2\25C\3\2\2\2\27S\3\2\2\2\31"+
		"V\3\2\2\2\33`\3\2\2\2\35g\3\2\2\2\37k\3\2\2\2!m\3\2\2\2#x\3\2\2\2%{\3"+
		"\2\2\2\'\u0084\3\2\2\2)\u008f\3\2\2\2+,\7<\2\2,\4\3\2\2\2-.\7?\2\2./\7"+
		"@\2\2/\6\3\2\2\2\60\61\7]\2\2\61\b\3\2\2\2\62\63\7_\2\2\63\n\3\2\2\2\64"+
		"\65\7*\2\2\65\f\3\2\2\2\66\67\7+\2\2\67\16\3\2\2\289\7}\2\29\20\3\2\2"+
		"\2:;\7\177\2\2;\22\3\2\2\2<=\7f\2\2=>\7g\2\2>?\7h\2\2?@\7k\2\2@A\7p\2"+
		"\2AB\7g\2\2B\24\3\2\2\2CD\7n\2\2DE\7c\2\2EF\7o\2\2FG\7d\2\2GH\7f\2\2H"+
		"I\7c\2\2I\26\3\2\2\2JK\7v\2\2KL\7t\2\2LM\7w\2\2MT\7g\2\2NO\7h\2\2OP\7"+
		"c\2\2PQ\7n\2\2QR\7u\2\2RT\7g\2\2SJ\3\2\2\2SN\3\2\2\2T\30\3\2\2\2UW\7/"+
		"\2\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2XZ\t\2\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2"+
		"\2\2[\\\3\2\2\2\\^\3\2\2\2]_\t\3\2\2^]\3\2\2\2^_\3\2\2\2_\32\3\2\2\2`"+
		"d\5\35\17\2ac\5\37\20\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\34\3"+
		"\2\2\2fd\3\2\2\2gh\t\4\2\2h\36\3\2\2\2il\5\35\17\2jl\4\62;\2ki\3\2\2\2"+
		"kj\3\2\2\2l \3\2\2\2ms\7$\2\2nr\n\5\2\2op\7^\2\2pr\7$\2\2qn\3\2\2\2qo"+
		"\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7$\2\2w\""+
		"\3\2\2\2xy\7?\2\2yz\7?\2\2z$\3\2\2\2{|\7B\2\2|}\7v\2\2}~\7c\2\2~\177\7"+
		"k\2\2\177\u0080\7n\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083"+
		"\7e\2\2\u0083&\3\2\2\2\u0084\u0088\7=\2\2\u0085\u0087\13\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\f\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008e\b\24\2\2\u008e(\3\2\2\2\u008f\u0090\t\6\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0092\b\25\2\2\u0092*\3\2\2\2\f\2SV[^dkqs\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}