// Generated from POSL.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class POSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PIPE=1, BANG=2, HAT=3, COLON=4, SEMI=5, LBRACK=6, RBRACK=7, LPAREN=8, 
		RPAREN=9, QMARK=10, COMMA=11, PERIOD=12, LBRACE=13, RBRACE=14, USCORE=15, 
		IMP=16, ARROW=17, URI=18, SYMBOL=19, QSYMBOL=20, COMMENT=21, MLCOMMENT=22, 
		WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'"
	};
	public static final String[] ruleNames = {
		"PIPE", "BANG", "HAT", "COLON", "SEMI", "LBRACK", "RBRACK", "LPAREN", 
		"RPAREN", "QMARK", "COMMA", "PERIOD", "LBRACE", "RBRACE", "USCORE", "IMP", 
		"ARROW", "URI", "SYMBOL", "QSYMBOL", "COMMENT", "MLCOMMENT", "WS"
	};


	public POSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "POSL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\6\23X\n\23\r\23\16\23Y\3\23\3\23\3\24\5\24_"+
		"\n\24\3\24\3\24\7\24c\n\24\f\24\16\24f\13\24\3\25\3\25\7\25j\n\25\f\25"+
		"\16\25m\13\25\3\25\3\25\3\26\3\26\7\26s\n\26\f\26\16\26v\13\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\7\27~\n\27\f\27\16\27\u0081\13\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u008c\n\30\3\30\3\30\2\2\31\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\t\t\2%%\'(/<AAC\\aac|\6\2&&\62;"+
		"C\\c|\b\2&&\60\60\62;C\\aac|\3\2$$\3\2\f\f\3\2\'\'\4\2\13\13\"\"\u0096"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;"+
		"\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31"+
		"G\3\2\2\2\33I\3\2\2\2\35K\3\2\2\2\37M\3\2\2\2!O\3\2\2\2#R\3\2\2\2%U\3"+
		"\2\2\2\'^\3\2\2\2)g\3\2\2\2+p\3\2\2\2-y\3\2\2\2/\u008b\3\2\2\2\61\62\7"+
		"~\2\2\62\4\3\2\2\2\63\64\7#\2\2\64\6\3\2\2\2\65\66\7`\2\2\66\b\3\2\2\2"+
		"\678\7<\2\28\n\3\2\2\29:\7=\2\2:\f\3\2\2\2;<\7]\2\2<\16\3\2\2\2=>\7_\2"+
		"\2>\20\3\2\2\2?@\7*\2\2@\22\3\2\2\2AB\7+\2\2B\24\3\2\2\2CD\7A\2\2D\26"+
		"\3\2\2\2EF\7.\2\2F\30\3\2\2\2GH\7\60\2\2H\32\3\2\2\2IJ\7}\2\2J\34\3\2"+
		"\2\2KL\7\177\2\2L\36\3\2\2\2MN\7a\2\2N \3\2\2\2OP\7<\2\2PQ\7/\2\2Q\"\3"+
		"\2\2\2RS\7/\2\2ST\7@\2\2T$\3\2\2\2UW\7>\2\2VX\t\2\2\2WV\3\2\2\2XY\3\2"+
		"\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\7@\2\2\\&\3\2\2\2]_\7/\2\2^]\3\2"+
		"\2\2^_\3\2\2\2_`\3\2\2\2`d\t\3\2\2ac\t\4\2\2ba\3\2\2\2cf\3\2\2\2db\3\2"+
		"\2\2de\3\2\2\2e(\3\2\2\2fd\3\2\2\2gk\7$\2\2hj\n\5\2\2ih\3\2\2\2jm\3\2"+
		"\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7$\2\2o*\3\2\2\2pt\7\'"+
		"\2\2qs\n\6\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2"+
		"\2\2wx\b\26\2\2x,\3\2\2\2yz\7\61\2\2z{\7\'\2\2{\177\3\2\2\2|~\n\7\2\2"+
		"}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0082\u0083\7\'\2\2\u0083\u0084\7\61\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\b\27\2\2\u0086.\3\2\2\2\u0087\u008c\t\b\2\2"+
		"\u0088\u0089\7\17\2\2\u0089\u008c\7\f\2\2\u008a\u008c\7\f\2\2\u008b\u0087"+
		"\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\b\30\2\2\u008e\60\3\2\2\2\n\2Y^dkt\177\u008b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}