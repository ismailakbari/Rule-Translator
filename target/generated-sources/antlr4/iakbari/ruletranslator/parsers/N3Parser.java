// Generated from N3.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class N3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, N3_NUMERICLITERAL=26, RATIONAL=27, DECIMAL=28, DOUBLE=29, INTEGER=30, 
		UNSIGNEDINT=31, N3_LANGCODE=32, N3_STRING=33, N3_VARIABLE=34, PREFIX=35, 
		BARENAME=36, N3_EXPLICITURI=37, WS=38, COMMENT=39;
	public static final String[] tokenNames = {
		"<INVALID>", "'@keywords'", "'@forAll'", "'^^'", "';'", "'{'", "'='", 
		"'}'", "'^'", "'<='", "'@this'", "'('", "','", "'@is'", "'.'", "'@of'", 
		"'['", "']'", "'=>'", "'@a'", "'!'", "'@forSome'", "'@has'", "')'", "'@prefix'", 
		"'@base'", "N3_NUMERICLITERAL", "RATIONAL", "DECIMAL", "DOUBLE", "INTEGER", 
		"UNSIGNEDINT", "N3_LANGCODE", "N3_STRING", "N3_VARIABLE", "PREFIX", "BARENAME", 
		"N3_EXPLICITURI", "WS", "COMMENT"
	};
	public static final int
		RULE_r = 0, RULE_g0 = 1, RULE_n3_declaration = 2, RULE_g8 = 3, RULE_g11 = 4, 
		RULE_g1 = 5, RULE_n3_universal = 6, RULE_g6 = 7, RULE_g9 = 8, RULE_g2 = 9, 
		RULE_n3_existential = 10, RULE_n3_statements_optional = 11, RULE_n3_statement = 12, 
		RULE_n3_subject = 13, RULE_n3_path = 14, RULE_n3_node = 15, RULE_n3_pathtail = 16, 
		RULE_n3_formulacontent = 17, RULE_g3 = 18, RULE_g4 = 19, RULE_g5 = 20, 
		RULE_n3_statementlist = 21, RULE_n3_statementtail = 22, RULE_n3_propertylist = 23, 
		RULE_n3_verb = 24, RULE_n3_object = 25, RULE_n3_objecttail = 26, RULE_n3_pathlist = 27, 
		RULE_n3_symbol = 28, RULE_n3_qname = 29, RULE_n3_literal = 30, RULE_n3_dtlang = 31;
	public static final String[] ruleNames = {
		"r", "g0", "n3_declaration", "g8", "g11", "g1", "n3_universal", "g6", 
		"g9", "g2", "n3_existential", "n3_statements_optional", "n3_statement", 
		"n3_subject", "n3_path", "n3_node", "n3_pathtail", "n3_formulacontent", 
		"g3", "g4", "g5", "n3_statementlist", "n3_statementtail", "n3_propertylist", 
		"n3_verb", "n3_object", "n3_objecttail", "n3_pathlist", "n3_symbol", "n3_qname", 
		"n3_literal", "n3_dtlang"
	};

	@Override
	public String getGrammarFileName() { return "N3.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public N3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(N3Parser.EOF, 0); }
		public G0Context g0() {
			return getRuleContext(G0Context.class,0);
		}
		public G2Context g2() {
			return getRuleContext(G2Context.class,0);
		}
		public G1Context g1() {
			return getRuleContext(G1Context.class,0);
		}
		public N3_statements_optionalContext n3_statements_optional() {
			return getRuleContext(N3_statements_optionalContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); g0();
			setState(65); g1();
			setState(66); g2();
			setState(67); n3_statements_optional();
			setState(68); match(EOF);
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

	public static class G0Context extends ParserRuleContext {
		public N3_declarationContext n3_declaration(int i) {
			return getRuleContext(N3_declarationContext.class,i);
		}
		public List<N3_declarationContext> n3_declaration() {
			return getRuleContexts(N3_declarationContext.class);
		}
		public G0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG0(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G0Context g0() throws RecognitionException {
		G0Context _localctx = new G0Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_g0);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__1) | (1L << T__0))) != 0)) {
				{
				{
				setState(70); n3_declaration();
				}
				}
				setState(75);
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

	public static class N3_declarationContext extends ParserRuleContext {
		public TerminalNode PREFIX() { return getToken(N3Parser.PREFIX, 0); }
		public G8Context g8() {
			return getRuleContext(G8Context.class,0);
		}
		public TerminalNode N3_EXPLICITURI() { return getToken(N3Parser.N3_EXPLICITURI, 0); }
		public N3_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_declarationContext n3_declaration() throws RecognitionException {
		N3_declarationContext _localctx = new N3_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_n3_declaration);
		try {
			setState(85);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76); match(T__1);
				setState(77); match(PREFIX);
				setState(78); match(N3_EXPLICITURI);
				setState(79); match(T__11);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); match(T__24);
				setState(81); g8();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(82); match(T__0);
				setState(83); match(N3_EXPLICITURI);
				setState(84); match(T__11);
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

	public static class G8Context extends ParserRuleContext {
		public TerminalNode BARENAME() { return getToken(N3Parser.BARENAME, 0); }
		public G11Context g11() {
			return getRuleContext(G11Context.class,0);
		}
		public G8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG8(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG8(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G8Context g8() throws RecognitionException {
		G8Context _localctx = new G8Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_g8);
		try {
			setState(90);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(87); match(T__11);
				}
				break;
			case BARENAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); match(BARENAME);
				setState(89); g11();
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

	public static class G11Context extends ParserRuleContext {
		public TerminalNode BARENAME() { return getToken(N3Parser.BARENAME, 0); }
		public G11Context g11() {
			return getRuleContext(G11Context.class,0);
		}
		public G11Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g11; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG11(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG11(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG11(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G11Context g11() throws RecognitionException {
		G11Context _localctx = new G11Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_g11);
		try {
			setState(96);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(92); match(T__11);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(93); match(T__13);
				setState(94); match(BARENAME);
				setState(95); g11();
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

	public static class G1Context extends ParserRuleContext {
		public N3_universalContext n3_universal() {
			return getRuleContext(N3_universalContext.class,0);
		}
		public G1Context g1() {
			return getRuleContext(G1Context.class,0);
		}
		public G1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G1Context g1() throws RecognitionException {
		G1Context _localctx = new G1Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_g1);
		try {
			setState(102);
			switch (_input.LA(1)) {
			case EOF:
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case T__4:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(99); n3_universal();
				setState(100); g1();
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

	public static class N3_universalContext extends ParserRuleContext {
		public G6Context g6() {
			return getRuleContext(G6Context.class,0);
		}
		public N3_universalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_universal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_universal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_universal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_universal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_universalContext n3_universal() throws RecognitionException {
		N3_universalContext _localctx = new N3_universalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_n3_universal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(T__23);
			setState(105); g6();
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

	public static class G6Context extends ParserRuleContext {
		public G9Context g9() {
			return getRuleContext(G9Context.class,0);
		}
		public N3_symbolContext n3_symbol() {
			return getRuleContext(N3_symbolContext.class,0);
		}
		public G6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG6(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G6Context g6() throws RecognitionException {
		G6Context _localctx = new G6Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_g6);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); match(T__11);
				}
				break;
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 2);
				{
				setState(108); n3_symbol();
				setState(109); g9();
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

	public static class G9Context extends ParserRuleContext {
		public G9Context g9() {
			return getRuleContext(G9Context.class,0);
		}
		public N3_symbolContext n3_symbol() {
			return getRuleContext(N3_symbolContext.class,0);
		}
		public G9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g9; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG9(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG9(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG9(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G9Context g9() throws RecognitionException {
		G9Context _localctx = new G9Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_g9);
		try {
			setState(118);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(113); match(T__11);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(114); match(T__13);
				setState(115); n3_symbol();
				setState(116); g9();
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

	public static class G2Context extends ParserRuleContext {
		public N3_existentialContext n3_existential() {
			return getRuleContext(N3_existentialContext.class,0);
		}
		public G2Context g2() {
			return getRuleContext(G2Context.class,0);
		}
		public G2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G2Context g2() throws RecognitionException {
		G2Context _localctx = new G2Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_g2);
		try {
			setState(124);
			switch (_input.LA(1)) {
			case EOF:
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); n3_existential();
				setState(122); g2();
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

	public static class N3_existentialContext extends ParserRuleContext {
		public G6Context g6() {
			return getRuleContext(G6Context.class,0);
		}
		public N3_existentialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_existential; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_existential(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_existential(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_existential(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_existentialContext n3_existential() throws RecognitionException {
		N3_existentialContext _localctx = new N3_existentialContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_n3_existential);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); match(T__4);
			setState(127); g6();
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

	public static class N3_statements_optionalContext extends ParserRuleContext {
		public N3_statementContext n3_statement() {
			return getRuleContext(N3_statementContext.class,0);
		}
		public N3_statements_optionalContext n3_statements_optional() {
			return getRuleContext(N3_statements_optionalContext.class,0);
		}
		public N3_statements_optionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_statements_optional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_statements_optional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_statements_optional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_statements_optional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_statements_optionalContext n3_statements_optional() throws RecognitionException {
		N3_statements_optionalContext _localctx = new N3_statements_optionalContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_n3_statements_optional);
		try {
			setState(134);
			switch (_input.LA(1)) {
			case EOF:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 2);
				{
				setState(130); n3_statement();
				setState(131); match(T__11);
				setState(132); n3_statements_optional();
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

	public static class N3_statementContext extends ParserRuleContext {
		public N3_subjectContext n3_subject() {
			return getRuleContext(N3_subjectContext.class,0);
		}
		public N3_propertylistContext n3_propertylist() {
			return getRuleContext(N3_propertylistContext.class,0);
		}
		public N3_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_statementContext n3_statement() throws RecognitionException {
		N3_statementContext _localctx = new N3_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_n3_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); n3_subject();
			setState(137); n3_propertylist();
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

	public static class N3_subjectContext extends ParserRuleContext {
		public N3_pathContext n3_path() {
			return getRuleContext(N3_pathContext.class,0);
		}
		public N3_subjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_subject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_subject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_subject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_subject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_subjectContext n3_subject() throws RecognitionException {
		N3_subjectContext _localctx = new N3_subjectContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_n3_subject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); n3_path();
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

	public static class N3_pathContext extends ParserRuleContext {
		public N3_nodeContext n3_node() {
			return getRuleContext(N3_nodeContext.class,0);
		}
		public N3_pathtailContext n3_pathtail() {
			return getRuleContext(N3_pathtailContext.class,0);
		}
		public N3_pathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_path(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_path(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_path(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_pathContext n3_path() throws RecognitionException {
		N3_pathContext _localctx = new N3_pathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_n3_path);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); n3_node();
			setState(142); n3_pathtail();
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

	public static class N3_nodeContext extends ParserRuleContext {
		public N3_formulacontentContext n3_formulacontent() {
			return getRuleContext(N3_formulacontentContext.class,0);
		}
		public N3_literalContext n3_literal() {
			return getRuleContext(N3_literalContext.class,0);
		}
		public N3_pathlistContext n3_pathlist() {
			return getRuleContext(N3_pathlistContext.class,0);
		}
		public N3_propertylistContext n3_propertylist() {
			return getRuleContext(N3_propertylistContext.class,0);
		}
		public N3_symbolContext n3_symbol() {
			return getRuleContext(N3_symbolContext.class,0);
		}
		public TerminalNode N3_VARIABLE() { return getToken(N3Parser.N3_VARIABLE, 0); }
		public TerminalNode N3_NUMERICLITERAL() { return getToken(N3Parser.N3_NUMERICLITERAL, 0); }
		public N3_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_node(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_node(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_nodeContext n3_node() throws RecognitionException {
		N3_nodeContext _localctx = new N3_nodeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_n3_node);
		try {
			setState(161);
			switch (_input.LA(1)) {
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				setState(144); n3_symbol();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(145); match(T__20);
				setState(146); n3_formulacontent();
				setState(147); match(T__18);
				}
				break;
			case N3_VARIABLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(149); match(N3_VARIABLE);
				}
				break;
			case N3_NUMERICLITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(150); match(N3_NUMERICLITERAL);
				}
				break;
			case N3_STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(151); n3_literal();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(152); match(T__9);
				setState(153); n3_propertylist();
				setState(154); match(T__8);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 7);
				{
				setState(156); match(T__14);
				setState(157); n3_pathlist();
				setState(158); match(T__2);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 8);
				{
				setState(160); match(T__15);
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

	public static class N3_pathtailContext extends ParserRuleContext {
		public N3_pathContext n3_path() {
			return getRuleContext(N3_pathContext.class,0);
		}
		public N3_pathtailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_pathtail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_pathtail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_pathtail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_pathtail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_pathtailContext n3_pathtail() throws RecognitionException {
		N3_pathtailContext _localctx = new N3_pathtailContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_n3_pathtail);
		try {
			setState(168);
			switch (_input.LA(1)) {
			case T__21:
			case T__20:
			case T__19:
			case T__18:
			case T__16:
			case T__15:
			case T__14:
			case T__13:
			case T__12:
			case T__11:
			case T__10:
			case T__9:
			case T__8:
			case T__7:
			case T__6:
			case T__3:
			case T__2:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); match(T__5);
				setState(165); n3_path();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(166); match(T__17);
				setState(167); n3_path();
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

	public static class N3_formulacontentContext extends ParserRuleContext {
		public G4Context g4() {
			return getRuleContext(G4Context.class,0);
		}
		public G3Context g3() {
			return getRuleContext(G3Context.class,0);
		}
		public G5Context g5() {
			return getRuleContext(G5Context.class,0);
		}
		public N3_statementlistContext n3_statementlist() {
			return getRuleContext(N3_statementlistContext.class,0);
		}
		public N3_formulacontentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_formulacontent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_formulacontent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_formulacontent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_formulacontent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_formulacontentContext n3_formulacontent() throws RecognitionException {
		N3_formulacontentContext _localctx = new N3_formulacontentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_n3_formulacontent);
		try {
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171); g3();
				setState(172); g4();
				setState(173); g5();
				setState(174); n3_statementlist();
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

	public static class G3Context extends ParserRuleContext {
		public G3Context g3() {
			return getRuleContext(G3Context.class,0);
		}
		public N3_declarationContext n3_declaration() {
			return getRuleContext(N3_declarationContext.class,0);
		}
		public G3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G3Context g3() throws RecognitionException {
		G3Context _localctx = new G3Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_g3);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case T__23:
			case T__20:
			case T__18:
			case T__15:
			case T__14:
			case T__9:
			case T__4:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__24:
			case T__1:
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(179); n3_declaration();
				setState(180); g3();
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

	public static class G4Context extends ParserRuleContext {
		public G4Context g4() {
			return getRuleContext(G4Context.class,0);
		}
		public N3_universalContext n3_universal() {
			return getRuleContext(N3_universalContext.class,0);
		}
		public G4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG4(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G4Context g4() throws RecognitionException {
		G4Context _localctx = new G4Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_g4);
		try {
			setState(188);
			switch (_input.LA(1)) {
			case T__20:
			case T__18:
			case T__15:
			case T__14:
			case T__9:
			case T__4:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(185); n3_universal();
				setState(186); g4();
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

	public static class G5Context extends ParserRuleContext {
		public N3_existentialContext n3_existential() {
			return getRuleContext(N3_existentialContext.class,0);
		}
		public G5Context g5() {
			return getRuleContext(G5Context.class,0);
		}
		public G5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_g5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterG5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitG5(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitG5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final G5Context g5() throws RecognitionException {
		G5Context _localctx = new G5Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_g5);
		try {
			setState(194);
			switch (_input.LA(1)) {
			case T__20:
			case T__18:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(191); n3_existential();
				setState(192); g5();
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

	public static class N3_statementlistContext extends ParserRuleContext {
		public N3_statementContext n3_statement() {
			return getRuleContext(N3_statementContext.class,0);
		}
		public N3_statementtailContext n3_statementtail() {
			return getRuleContext(N3_statementtailContext.class,0);
		}
		public N3_statementlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_statementlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_statementlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_statementlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_statementlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_statementlistContext n3_statementlist() throws RecognitionException {
		N3_statementlistContext _localctx = new N3_statementlistContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_n3_statementlist);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 2);
				{
				setState(197); n3_statement();
				setState(198); n3_statementtail();
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

	public static class N3_statementtailContext extends ParserRuleContext {
		public N3_statementlistContext n3_statementlist() {
			return getRuleContext(N3_statementlistContext.class,0);
		}
		public N3_statementtailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_statementtail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_statementtail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_statementtail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_statementtail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_statementtailContext n3_statementtail() throws RecognitionException {
		N3_statementtailContext _localctx = new N3_statementtailContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_n3_statementtail);
		try {
			setState(205);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(203); match(T__11);
				setState(204); n3_statementlist();
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

	public static class N3_propertylistContext extends ParserRuleContext {
		public N3_verbContext n3_verb() {
			return getRuleContext(N3_verbContext.class,0);
		}
		public N3_objectContext n3_object() {
			return getRuleContext(N3_objectContext.class,0);
		}
		public N3_propertylistContext n3_propertylist() {
			return getRuleContext(N3_propertylistContext.class,0);
		}
		public N3_objecttailContext n3_objecttail() {
			return getRuleContext(N3_objecttailContext.class,0);
		}
		public N3_propertylistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_propertylist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_propertylist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_propertylist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_propertylist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_propertylistContext n3_propertylist() throws RecognitionException {
		N3_propertylistContext _localctx = new N3_propertylistContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_n3_propertylist);
		int _la;
		try {
			setState(215);
			switch (_input.LA(1)) {
			case T__18:
			case T__11:
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__20:
			case T__19:
			case T__16:
			case T__15:
			case T__14:
			case T__12:
			case T__9:
			case T__7:
			case T__6:
			case T__3:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 2);
				{
				setState(208); n3_verb();
				setState(209); n3_object();
				setState(210); n3_objecttail();
				setState(213);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(211); match(T__21);
					setState(212); n3_propertylist();
					}
				}

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

	public static class N3_verbContext extends ParserRuleContext {
		public N3_pathContext n3_path() {
			return getRuleContext(N3_pathContext.class,0);
		}
		public N3_verbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_verb; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_verb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_verb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_verb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_verbContext n3_verb() throws RecognitionException {
		N3_verbContext _localctx = new N3_verbContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_n3_verb);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				setState(217); n3_path();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(218); match(T__3);
				setState(219); n3_path();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(220); match(T__12);
				setState(221); n3_path();
				setState(222); match(T__10);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(224); match(T__6);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(225); match(T__19);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 6);
				{
				setState(226); match(T__7);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				setState(227); match(T__16);
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

	public static class N3_objectContext extends ParserRuleContext {
		public N3_pathContext n3_path() {
			return getRuleContext(N3_pathContext.class,0);
		}
		public N3_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_object(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_object(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_objectContext n3_object() throws RecognitionException {
		N3_objectContext _localctx = new N3_objectContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_n3_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); n3_path();
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

	public static class N3_objecttailContext extends ParserRuleContext {
		public N3_objectContext n3_object() {
			return getRuleContext(N3_objectContext.class,0);
		}
		public N3_objecttailContext n3_objecttail() {
			return getRuleContext(N3_objecttailContext.class,0);
		}
		public N3_objecttailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_objecttail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_objecttail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_objecttail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_objecttail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_objecttailContext n3_objecttail() throws RecognitionException {
		N3_objecttailContext _localctx = new N3_objecttailContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_n3_objecttail);
		try {
			setState(237);
			switch (_input.LA(1)) {
			case T__21:
			case T__18:
			case T__11:
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(233); match(T__13);
				setState(234); n3_object();
				setState(235); n3_objecttail();
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

	public static class N3_pathlistContext extends ParserRuleContext {
		public N3_pathContext n3_path() {
			return getRuleContext(N3_pathContext.class,0);
		}
		public N3_pathlistContext n3_pathlist() {
			return getRuleContext(N3_pathlistContext.class,0);
		}
		public N3_pathlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_pathlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_pathlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_pathlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_pathlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_pathlistContext n3_pathlist() throws RecognitionException {
		N3_pathlistContext _localctx = new N3_pathlistContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_n3_pathlist);
		try {
			setState(243);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__20:
			case T__15:
			case T__14:
			case T__9:
			case N3_NUMERICLITERAL:
			case N3_STRING:
			case N3_VARIABLE:
			case PREFIX:
			case BARENAME:
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 2);
				{
				setState(240); n3_path();
				setState(241); n3_pathlist();
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

	public static class N3_symbolContext extends ParserRuleContext {
		public N3_qnameContext n3_qname() {
			return getRuleContext(N3_qnameContext.class,0);
		}
		public TerminalNode N3_EXPLICITURI() { return getToken(N3Parser.N3_EXPLICITURI, 0); }
		public N3_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_symbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_symbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_symbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_symbolContext n3_symbol() throws RecognitionException {
		N3_symbolContext _localctx = new N3_symbolContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_n3_symbol);
		try {
			setState(247);
			switch (_input.LA(1)) {
			case N3_EXPLICITURI:
				enterOuterAlt(_localctx, 1);
				{
				setState(245); match(N3_EXPLICITURI);
				}
				break;
			case PREFIX:
			case BARENAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(246); n3_qname();
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

	public static class N3_qnameContext extends ParserRuleContext {
		public TerminalNode PREFIX() { return getToken(N3Parser.PREFIX, 0); }
		public TerminalNode BARENAME() { return getToken(N3Parser.BARENAME, 0); }
		public N3_qnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_qname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_qname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_qname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_qname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_qnameContext n3_qname() throws RecognitionException {
		N3_qnameContext _localctx = new N3_qnameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_n3_qname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if (_la==PREFIX) {
				{
				setState(249); match(PREFIX);
				}
			}

			setState(252); match(BARENAME);
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

	public static class N3_literalContext extends ParserRuleContext {
		public TerminalNode N3_STRING() { return getToken(N3Parser.N3_STRING, 0); }
		public N3_dtlangContext n3_dtlang() {
			return getRuleContext(N3_dtlangContext.class,0);
		}
		public N3_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_literalContext n3_literal() throws RecognitionException {
		N3_literalContext _localctx = new N3_literalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_n3_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(N3_STRING);
			setState(256);
			_la = _input.LA(1);
			if (_la==T__22 || _la==N3_LANGCODE) {
				{
				setState(255); n3_dtlang();
				}
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

	public static class N3_dtlangContext extends ParserRuleContext {
		public TerminalNode N3_LANGCODE() { return getToken(N3Parser.N3_LANGCODE, 0); }
		public N3_symbolContext n3_symbol() {
			return getRuleContext(N3_symbolContext.class,0);
		}
		public N3_dtlangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_n3_dtlang; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).enterN3_dtlang(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof N3Listener ) ((N3Listener)listener).exitN3_dtlang(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof N3Visitor ) return ((N3Visitor<? extends T>)visitor).visitN3_dtlang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final N3_dtlangContext n3_dtlang() throws RecognitionException {
		N3_dtlangContext _localctx = new N3_dtlangContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_n3_dtlang);
		try {
			setState(261);
			switch (_input.LA(1)) {
			case N3_LANGCODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(258); match(N3_LANGCODE);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(259); match(T__22);
				setState(260); n3_symbol();
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\3\7\3J\n\3\f\3\16\3M\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\5\3\5\3\5\5\5]\n\5\3\6\3\6\3\6\3\6\5"+
		"\6c\n\6\3\7\3\7\3\7\3\7\5\7i\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tr\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\5\ny\n\n\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00a4\n\21\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00ab\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00b3\n\23\3\24\3\24\3"+
		"\24\3\24\5\24\u00b9\n\24\3\25\3\25\3\25\3\25\5\25\u00bf\n\25\3\26\3\26"+
		"\3\26\3\26\5\26\u00c5\n\26\3\27\3\27\3\27\3\27\5\27\u00cb\n\27\3\30\3"+
		"\30\3\30\5\30\u00d0\n\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00d8\n\31"+
		"\5\31\u00da\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u00e7\n\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u00f0\n\34\3"+
		"\35\3\35\3\35\3\35\5\35\u00f6\n\35\3\36\3\36\5\36\u00fa\n\36\3\37\5\37"+
		"\u00fd\n\37\3\37\3\37\3 \3 \5 \u0103\n \3!\3!\3!\5!\u0108\n!\3!\2\2\""+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\2"+
		"\u0110\2B\3\2\2\2\4K\3\2\2\2\6W\3\2\2\2\b\\\3\2\2\2\nb\3\2\2\2\fh\3\2"+
		"\2\2\16j\3\2\2\2\20q\3\2\2\2\22x\3\2\2\2\24~\3\2\2\2\26\u0080\3\2\2\2"+
		"\30\u0088\3\2\2\2\32\u008a\3\2\2\2\34\u008d\3\2\2\2\36\u008f\3\2\2\2 "+
		"\u00a3\3\2\2\2\"\u00aa\3\2\2\2$\u00b2\3\2\2\2&\u00b8\3\2\2\2(\u00be\3"+
		"\2\2\2*\u00c4\3\2\2\2,\u00ca\3\2\2\2.\u00cf\3\2\2\2\60\u00d9\3\2\2\2\62"+
		"\u00e6\3\2\2\2\64\u00e8\3\2\2\2\66\u00ef\3\2\2\28\u00f5\3\2\2\2:\u00f9"+
		"\3\2\2\2<\u00fc\3\2\2\2>\u0100\3\2\2\2@\u0107\3\2\2\2BC\5\4\3\2CD\5\f"+
		"\7\2DE\5\24\13\2EF\5\30\r\2FG\7\2\2\3G\3\3\2\2\2HJ\5\6\4\2IH\3\2\2\2J"+
		"M\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\5\3\2\2\2MK\3\2\2\2NO\7\32\2\2OP\7%\2\2"+
		"PQ\7\'\2\2QX\7\20\2\2RS\7\3\2\2SX\5\b\5\2TU\7\33\2\2UV\7\'\2\2VX\7\20"+
		"\2\2WN\3\2\2\2WR\3\2\2\2WT\3\2\2\2X\7\3\2\2\2Y]\7\20\2\2Z[\7&\2\2[]\5"+
		"\n\6\2\\Y\3\2\2\2\\Z\3\2\2\2]\t\3\2\2\2^c\7\20\2\2_`\7\16\2\2`a\7&\2\2"+
		"ac\5\n\6\2b^\3\2\2\2b_\3\2\2\2c\13\3\2\2\2di\3\2\2\2ef\5\16\b\2fg\5\f"+
		"\7\2gi\3\2\2\2hd\3\2\2\2he\3\2\2\2i\r\3\2\2\2jk\7\4\2\2kl\5\20\t\2l\17"+
		"\3\2\2\2mr\7\20\2\2no\5:\36\2op\5\22\n\2pr\3\2\2\2qm\3\2\2\2qn\3\2\2\2"+
		"r\21\3\2\2\2sy\7\20\2\2tu\7\16\2\2uv\5:\36\2vw\5\22\n\2wy\3\2\2\2xs\3"+
		"\2\2\2xt\3\2\2\2y\23\3\2\2\2z\177\3\2\2\2{|\5\26\f\2|}\5\24\13\2}\177"+
		"\3\2\2\2~z\3\2\2\2~{\3\2\2\2\177\25\3\2\2\2\u0080\u0081\7\27\2\2\u0081"+
		"\u0082\5\20\t\2\u0082\27\3\2\2\2\u0083\u0089\3\2\2\2\u0084\u0085\5\32"+
		"\16\2\u0085\u0086\7\20\2\2\u0086\u0087\5\30\r\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0089\31\3\2\2\2\u008a\u008b\5\34\17"+
		"\2\u008b\u008c\5\60\31\2\u008c\33\3\2\2\2\u008d\u008e\5\36\20\2\u008e"+
		"\35\3\2\2\2\u008f\u0090\5 \21\2\u0090\u0091\5\"\22\2\u0091\37\3\2\2\2"+
		"\u0092\u00a4\5:\36\2\u0093\u0094\7\7\2\2\u0094\u0095\5$\23\2\u0095\u0096"+
		"\7\t\2\2\u0096\u00a4\3\2\2\2\u0097\u00a4\7$\2\2\u0098\u00a4\7\34\2\2\u0099"+
		"\u00a4\5> \2\u009a\u009b\7\22\2\2\u009b\u009c\5\60\31\2\u009c\u009d\7"+
		"\23\2\2\u009d\u00a4\3\2\2\2\u009e\u009f\7\r\2\2\u009f\u00a0\58\35\2\u00a0"+
		"\u00a1\7\31\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\7\f\2\2\u00a3\u0092\3"+
		"\2\2\2\u00a3\u0093\3\2\2\2\u00a3\u0097\3\2\2\2\u00a3\u0098\3\2\2\2\u00a3"+
		"\u0099\3\2\2\2\u00a3\u009a\3\2\2\2\u00a3\u009e\3\2\2\2\u00a3\u00a2\3\2"+
		"\2\2\u00a4!\3\2\2\2\u00a5\u00ab\3\2\2\2\u00a6\u00a7\7\26\2\2\u00a7\u00ab"+
		"\5\36\20\2\u00a8\u00a9\7\n\2\2\u00a9\u00ab\5\36\20\2\u00aa\u00a5\3\2\2"+
		"\2\u00aa\u00a6\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab#\3\2\2\2\u00ac\u00b3"+
		"\3\2\2\2\u00ad\u00ae\5&\24\2\u00ae\u00af\5(\25\2\u00af\u00b0\5*\26\2\u00b0"+
		"\u00b1\5,\27\2\u00b1\u00b3\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad\3\2"+
		"\2\2\u00b3%\3\2\2\2\u00b4\u00b9\3\2\2\2\u00b5\u00b6\5\6\4\2\u00b6\u00b7"+
		"\5&\24\2\u00b7\u00b9\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9"+
		"\'\3\2\2\2\u00ba\u00bf\3\2\2\2\u00bb\u00bc\5\16\b\2\u00bc\u00bd\5(\25"+
		"\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3\2\2\2\u00be\u00bb\3\2\2\2\u00bf)"+
		"\3\2\2\2\u00c0\u00c5\3\2\2\2\u00c1\u00c2\5\26\f\2\u00c2\u00c3\5*\26\2"+
		"\u00c3\u00c5\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5+\3"+
		"\2\2\2\u00c6\u00cb\3\2\2\2\u00c7\u00c8\5\32\16\2\u00c8\u00c9\5.\30\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb-\3\2\2\2"+
		"\u00cc\u00d0\3\2\2\2\u00cd\u00ce\7\20\2\2\u00ce\u00d0\5,\27\2\u00cf\u00cc"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0/\3\2\2\2\u00d1\u00da\3\2\2\2\u00d2"+
		"\u00d3\5\62\32\2\u00d3\u00d4\5\64\33\2\u00d4\u00d7\5\66\34\2\u00d5\u00d6"+
		"\7\6\2\2\u00d6\u00d8\5\60\31\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2"+
		"\u00d8\u00da\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9\u00d2\3\2\2\2\u00da\61"+
		"\3\2\2\2\u00db\u00e7\5\36\20\2\u00dc\u00dd\7\30\2\2\u00dd\u00e7\5\36\20"+
		"\2\u00de\u00df\7\17\2\2\u00df\u00e0\5\36\20\2\u00e0\u00e1\7\21\2\2\u00e1"+
		"\u00e7\3\2\2\2\u00e2\u00e7\7\25\2\2\u00e3\u00e7\7\b\2\2\u00e4\u00e7\7"+
		"\24\2\2\u00e5\u00e7\7\13\2\2\u00e6\u00db\3\2\2\2\u00e6\u00dc\3\2\2\2\u00e6"+
		"\u00de\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e5\3\2\2\2\u00e7\63\3\2\2\2\u00e8\u00e9\5\36\20\2\u00e9"+
		"\65\3\2\2\2\u00ea\u00f0\3\2\2\2\u00eb\u00ec\7\16\2\2\u00ec\u00ed\5\64"+
		"\33\2\u00ed\u00ee\5\66\34\2\u00ee\u00f0\3\2\2\2\u00ef\u00ea\3\2\2\2\u00ef"+
		"\u00eb\3\2\2\2\u00f0\67\3\2\2\2\u00f1\u00f6\3\2\2\2\u00f2\u00f3\5\36\20"+
		"\2\u00f3\u00f4\58\35\2\u00f4\u00f6\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f2"+
		"\3\2\2\2\u00f69\3\2\2\2\u00f7\u00fa\7\'\2\2\u00f8\u00fa\5<\37\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa;\3\2\2\2\u00fb\u00fd\7%\2\2\u00fc"+
		"\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7&"+
		"\2\2\u00ff=\3\2\2\2\u0100\u0102\7#\2\2\u0101\u0103\5@!\2\u0102\u0101\3"+
		"\2\2\2\u0102\u0103\3\2\2\2\u0103?\3\2\2\2\u0104\u0108\7\"\2\2\u0105\u0106"+
		"\7\5\2\2\u0106\u0108\5:\36\2\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0108"+
		"A\3\2\2\2\34KW\\bhqx~\u0088\u00a3\u00aa\u00b2\u00b8\u00be\u00c4\u00ca"+
		"\u00cf\u00d7\u00d9\u00e6\u00ef\u00f5\u00f9\u00fc\u0102\u0107";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}