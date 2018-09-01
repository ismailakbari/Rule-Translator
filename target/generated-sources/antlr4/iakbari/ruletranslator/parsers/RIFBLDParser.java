// Generated from RIFBLD.g4 by ANTLR 4.4

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
public class RIFBLDParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__23=1, T__22=2, T__21=3, T__20=4, T__19=5, T__18=6, T__17=7, T__16=8, 
		T__15=9, T__14=10, T__13=11, T__12=12, T__11=13, T__10=14, T__9=15, T__8=16, 
		T__7=17, T__6=18, T__5=19, T__4=20, T__3=21, T__2=22, T__1=23, T__0=24, 
		Var=25, IRICONST=26, UNICODE=27, UNICODESTRING=28, ANGLEBRACKIRI=29, NCName=30, 
		CURIE=31, NumericLiteral=32, WS=33;
	public static final String[] tokenNames = {
		"<INVALID>", "':-'", "'->'", "'Exists'", "'Group'", "'Document'", "'^^'", 
		"'['", "'*)'", "'And'", "'Base'", "'|'", "'##'", "']'", "'='", "'List'", 
		"'Or'", "'(*'", "'#'", "'Forall'", "'Import'", "'Prefix'", "'('", "')'", 
		"'External'", "Var", "IRICONST", "UNICODE", "UNICODESTRING", "ANGLEBRACKIRI", 
		"NCName", "CURIE", "NumericLiteral", "WS"
	};
	public static final int
		RULE_r = 0, RULE_document = 1, RULE_base = 2, RULE_prefix = 3, RULE_import1 = 4, 
		RULE_angle = 5, RULE_group = 6, RULE_rule1 = 7, RULE_clause = 8, RULE_implies = 9, 
		RULE_formula = 10, RULE_atomic = 11, RULE_equal = 12, RULE_member = 13, 
		RULE_subclass = 14, RULE_irimeta = 15, RULE_frame = 16, RULE_term = 17, 
		RULE_list = 18, RULE_uniterm = 19, RULE_const1 = 20, RULE_constshort = 21, 
		RULE_symspace = 22;
	public static final String[] ruleNames = {
		"r", "document", "base", "prefix", "import1", "angle", "group", "rule1", 
		"clause", "implies", "formula", "atomic", "equal", "member", "subclass", 
		"irimeta", "frame", "term", "list", "uniterm", "const1", "constshort", 
		"symspace"
	};

	@Override
	public String getGrammarFileName() { return "RIFBLD.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RIFBLDParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RIFBLDParser.EOF, 0); }
		public DocumentContext document() {
			return getRuleContext(DocumentContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); document();
			setState(47); match(EOF);
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

	public static class DocumentContext extends ParserRuleContext {
		public BaseContext base() {
			return getRuleContext(BaseContext.class,0);
		}
		public PrefixContext prefix(int i) {
			return getRuleContext(PrefixContext.class,i);
		}
		public List<Import1Context> import1() {
			return getRuleContexts(Import1Context.class);
		}
		public Import1Context import1(int i) {
			return getRuleContext(Import1Context.class,i);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public List<PrefixContext> prefix() {
			return getRuleContexts(PrefixContext.class);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_document);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(49); irimeta();
				}
			}

			setState(52); match(T__19);
			setState(53); match(T__2);
			setState(55);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(54); base();
				}
			}

			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(57); prefix();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63); import1();
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(70);
			_la = _input.LA(1);
			if (_la==T__20 || _la==T__7) {
				{
				setState(69); group();
				}
			}

			setState(72); match(T__1);
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

	public static class BaseContext extends ParserRuleContext {
		public TerminalNode ANGLEBRACKIRI() { return getToken(RIFBLDParser.ANGLEBRACKIRI, 0); }
		public BaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseContext base() throws RecognitionException {
		BaseContext _localctx = new BaseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_base);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(T__14);
			setState(75); match(T__2);
			setState(76); match(ANGLEBRACKIRI);
			setState(77); match(T__1);
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

	public static class PrefixContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(RIFBLDParser.NCName, 0); }
		public TerminalNode ANGLEBRACKIRI() { return getToken(RIFBLDParser.ANGLEBRACKIRI, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(T__3);
			setState(80); match(T__2);
			setState(81); match(NCName);
			setState(82); match(ANGLEBRACKIRI);
			setState(83); match(T__1);
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

	public static class Import1Context extends ParserRuleContext {
		public List<AngleContext> angle() {
			return getRuleContexts(AngleContext.class);
		}
		public AngleContext angle(int i) {
			return getRuleContext(AngleContext.class,i);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public Import1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterImport1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitImport1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitImport1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import1Context import1() throws RecognitionException {
		Import1Context _localctx = new Import1Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_import1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(85); irimeta();
				}
			}

			setState(88); match(T__4);
			setState(89); match(T__2);
			setState(90); angle();
			setState(92);
			_la = _input.LA(1);
			if (_la==ANGLEBRACKIRI) {
				{
				setState(91); angle();
				}
			}

			setState(94); match(T__1);
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

	public static class AngleContext extends ParserRuleContext {
		public TerminalNode ANGLEBRACKIRI() { return getToken(RIFBLDParser.ANGLEBRACKIRI, 0); }
		public AngleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterAngle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitAngle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitAngle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngleContext angle() throws RecognitionException {
		AngleContext _localctx = new AngleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_angle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(ANGLEBRACKIRI);
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

	public static class GroupContext extends ParserRuleContext {
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public Rule1Context rule1(int i) {
			return getRuleContext(Rule1Context.class,i);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public List<Rule1Context> rule1() {
			return getRuleContexts(Rule1Context.class);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_group);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(98); irimeta();
				}
			}

			setState(101); match(T__20);
			setState(102); match(T__2);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__15) | (1L << T__9) | (1L << T__7) | (1L << T__5) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
				{
				setState(105);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(103); rule1();
					}
					break;
				case 2:
					{
					setState(104); group();
					}
					break;
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110); match(T__1);
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

	public static class Rule1Context extends ParserRuleContext {
		public Rule1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule1; }
	 
		public Rule1Context() { }
		public void copyFrom(Rule1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactContext extends Rule1Context {
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public FactContext(Rule1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitFact(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForallContext extends Rule1Context {
		public TerminalNode Var(int i) {
			return getToken(RIFBLDParser.Var, i);
		}
		public ClauseContext clause() {
			return getRuleContext(ClauseContext.class,0);
		}
		public List<TerminalNode> Var() { return getTokens(RIFBLDParser.Var); }
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public ForallContext(Rule1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterForall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitForall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitForall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rule1Context rule1() throws RecognitionException {
		Rule1Context _localctx = new Rule1Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_rule1);
		int _la;
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ForallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(113);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(112); irimeta();
					}
				}

				setState(115); match(T__5);
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116); match(Var);
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Var );
				setState(121); match(T__2);
				setState(122); clause();
				setState(123); match(T__1);
				}
				}
				break;
			case 2:
				_localctx = new FactContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125); clause();
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

	public static class ClauseContext extends ParserRuleContext {
		public ImpliesContext implies() {
			return getRuleContext(ImpliesContext.class,0);
		}
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_clause);
		try {
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); implies();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); atomic();
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

	public static class ImpliesContext extends ParserRuleContext {
		public AtomicContext atomic(int i) {
			return getRuleContext(AtomicContext.class,i);
		}
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public List<AtomicContext> atomic() {
			return getRuleContexts(AtomicContext.class);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public ImpliesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implies; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterImplies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitImplies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitImplies(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpliesContext implies() throws RecognitionException {
		ImpliesContext _localctx = new ImpliesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_implies);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(132); irimeta();
				}
				break;
			}
			setState(145);
			switch (_input.LA(1)) {
			case T__9:
			case T__7:
			case T__0:
			case Var:
			case IRICONST:
			case UNICODE:
			case UNICODESTRING:
			case ANGLEBRACKIRI:
			case NCName:
			case CURIE:
			case NumericLiteral:
				{
				setState(135); atomic();
				}
				break;
			case T__15:
				{
				setState(136); match(T__15);
				setState(137); match(T__2);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(138); atomic();
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144); match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(147); match(T__23);
			setState(148); formula();
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

	public static class FormulaContext extends ParserRuleContext {
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
	 
		public FormulaContext() { }
		public void copyFrom(FormulaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public AndFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterAndFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitAndFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitAndFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrFormulaContext extends FormulaContext {
		public List<FormulaContext> formula() {
			return getRuleContexts(FormulaContext.class);
		}
		public FormulaContext formula(int i) {
			return getRuleContext(FormulaContext.class,i);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public OrFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterOrFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitOrFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitOrFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsFormulaContext extends FormulaContext {
		public FormulaContext formula() {
			return getRuleContext(FormulaContext.class,0);
		}
		public TerminalNode Var(int i) {
			return getToken(RIFBLDParser.Var, i);
		}
		public List<TerminalNode> Var() { return getTokens(RIFBLDParser.Var); }
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public ExistsFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterExistsFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitExistsFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitExistsFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomicFormulaContext extends FormulaContext {
		public AtomicContext atomic() {
			return getRuleContext(AtomicContext.class,0);
		}
		public AtomicFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterAtomicFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitAtomicFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitAtomicFormula(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExternalFormulaContext extends FormulaContext {
		public UnitermContext uniterm() {
			return getRuleContext(UnitermContext.class,0);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public ExternalFormulaContext(FormulaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterExternalFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitExternalFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitExternalFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formula);
		int _la;
		try {
			setState(196);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new AndFormulaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(150); irimeta();
					}
				}

				setState(153); match(T__15);
				setState(154); match(T__2);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__15) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(155); formula();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161); match(T__1);
				}
				break;
			case 2:
				_localctx = new OrFormulaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(162); irimeta();
					}
				}

				setState(165); match(T__8);
				setState(166); match(T__2);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__15) | (1L << T__9) | (1L << T__8) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(167); formula();
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173); match(T__1);
				}
				break;
			case 3:
				_localctx = new ExistsFormulaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(174); irimeta();
					}
				}

				setState(177); match(T__21);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178); match(Var);
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==Var );
				setState(183); match(T__2);
				setState(184); formula();
				setState(185); match(T__1);
				}
				break;
			case 4:
				_localctx = new AtomicFormulaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(187); atomic();
				}
				break;
			case 5:
				_localctx = new ExternalFormulaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(189);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(188); irimeta();
					}
				}

				setState(191); match(T__0);
				setState(192); match(T__2);
				setState(193); uniterm();
				setState(194); match(T__1);
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

	public static class AtomicContext extends ParserRuleContext {
		public UnitermContext uniterm() {
			return getRuleContext(UnitermContext.class,0);
		}
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public SubclassContext subclass() {
			return getRuleContext(SubclassContext.class,0);
		}
		public MemberContext member() {
			return getRuleContext(MemberContext.class,0);
		}
		public FrameContext frame() {
			return getRuleContext(FrameContext.class,0);
		}
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public AtomicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterAtomic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitAtomic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitAtomic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicContext atomic() throws RecognitionException {
		AtomicContext _localctx = new AtomicContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atomic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(198); irimeta();
				}
				break;
			}
			setState(206);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(201); equal();
				}
				break;
			case 2:
				{
				setState(202); member();
				}
				break;
			case 3:
				{
				setState(203); subclass();
				}
				break;
			case 4:
				{
				setState(204); uniterm();
				}
				break;
			case 5:
				{
				setState(205); frame();
				}
				break;
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

	public static class EqualContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); term();
			setState(209); match(T__10);
			setState(210); term();
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

	public static class MemberContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public MemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberContext member() throws RecognitionException {
		MemberContext _localctx = new MemberContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_member);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); term();
			setState(213); match(T__6);
			setState(214); term();
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

	public static class SubclassContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public SubclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterSubclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitSubclass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitSubclass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubclassContext subclass() throws RecognitionException {
		SubclassContext _localctx = new SubclassContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); term();
			setState(217); match(T__12);
			setState(218); term();
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

	public static class IrimetaContext extends ParserRuleContext {
		public TerminalNode IRICONST() { return getToken(RIFBLDParser.IRICONST, 0); }
		public FrameContext frame(int i) {
			return getRuleContext(FrameContext.class,i);
		}
		public List<FrameContext> frame() {
			return getRuleContexts(FrameContext.class);
		}
		public IrimetaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_irimeta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterIrimeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitIrimeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitIrimeta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IrimetaContext irimeta() throws RecognitionException {
		IrimetaContext _localctx = new IrimetaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_irimeta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220); match(T__7);
			setState(222);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(221); match(IRICONST);
				}
				break;
			}
			setState(234);
			switch (_input.LA(1)) {
			case T__9:
			case T__7:
			case T__0:
			case Var:
			case IRICONST:
			case UNICODE:
			case UNICODESTRING:
			case ANGLEBRACKIRI:
			case NCName:
			case CURIE:
			case NumericLiteral:
				{
				setState(224); frame();
				}
				break;
			case T__15:
				{
				setState(225); match(T__15);
				setState(226); match(T__2);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(227); frame();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233); match(T__1);
				}
				break;
			case T__16:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(236); match(T__16);
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

	public static class FrameContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public FrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameContext frame() throws RecognitionException {
		FrameContext _localctx = new FrameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_frame);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238); term();
			setState(239); match(T__17);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
				{
				{
				setState(240); term();
				setState(241); match(T__22);
				setState(242); term();
				}
				}
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(249); match(T__11);
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

	public static class TermContext extends ParserRuleContext {
		public UnitermContext uniterm() {
			return getRuleContext(UnitermContext.class,0);
		}
		public Const1Context const1() {
			return getRuleContext(Const1Context.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode Var() { return getToken(RIFBLDParser.Var, 0); }
		public IrimetaContext irimeta() {
			return getRuleContext(IrimetaContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(251); irimeta();
				}
			}

			setState(263);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(254); const1();
				}
				break;
			case 2:
				{
				setState(255); match(Var);
				}
				break;
			case 3:
				{
				setState(256); uniterm();
				}
				break;
			case 4:
				{
				setState(257); list();
				}
				break;
			case 5:
				{
				setState(258); match(T__0);
				setState(259); match(T__2);
				setState(260); uniterm();
				setState(261); match(T__1);
				}
				break;
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

	public static class ListContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_list);
		int _la;
		try {
			setState(285);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265); match(T__9);
				setState(266); match(T__2);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(267); term();
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(273); match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274); match(T__9);
				setState(275); match(T__2);
				setState(277); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(276); term();
					}
					}
					setState(279); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0) );
				setState(281); match(T__13);
				setState(282); term();
				setState(283); match(T__1);
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

	public static class UnitermContext extends ParserRuleContext {
		public List<TerminalNode> NCName() { return getTokens(RIFBLDParser.NCName); }
		public TerminalNode NCName(int i) {
			return getToken(RIFBLDParser.NCName, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public Const1Context const1() {
			return getRuleContext(Const1Context.class,0);
		}
		public UnitermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterUniterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitUniterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitUniterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitermContext uniterm() throws RecognitionException {
		UnitermContext _localctx = new UnitermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_uniterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); const1();
			{
			setState(288); match(T__2);
			setState(303);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__0) | (1L << Var) | (1L << IRICONST) | (1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) {
					{
					{
					setState(289); term();
					}
					}
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NCName) {
					{
					{
					setState(295); match(NCName);
					setState(296); match(T__22);
					setState(297); term();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(305); match(T__1);
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

	public static class Const1Context extends ParserRuleContext {
		public TerminalNode IRICONST() { return getToken(RIFBLDParser.IRICONST, 0); }
		public TerminalNode UNICODESTRING() { return getToken(RIFBLDParser.UNICODESTRING, 0); }
		public SymspaceContext symspace() {
			return getRuleContext(SymspaceContext.class,0);
		}
		public ConstshortContext constshort() {
			return getRuleContext(ConstshortContext.class,0);
		}
		public Const1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterConst1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitConst1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitConst1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const1Context const1() throws RecognitionException {
		Const1Context _localctx = new Const1Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_const1);
		try {
			setState(312);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307); match(IRICONST);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308); match(UNICODESTRING);
				setState(309); match(T__18);
				setState(310); symspace();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311); constshort();
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

	public static class ConstshortContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(RIFBLDParser.NCName, 0); }
		public TerminalNode UNICODESTRING() { return getToken(RIFBLDParser.UNICODESTRING, 0); }
		public TerminalNode NumericLiteral() { return getToken(RIFBLDParser.NumericLiteral, 0); }
		public TerminalNode CURIE() { return getToken(RIFBLDParser.CURIE, 0); }
		public TerminalNode UNICODE() { return getToken(RIFBLDParser.UNICODE, 0); }
		public TerminalNode ANGLEBRACKIRI() { return getToken(RIFBLDParser.ANGLEBRACKIRI, 0); }
		public ConstshortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constshort; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterConstshort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitConstshort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitConstshort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstshortContext constshort() throws RecognitionException {
		ConstshortContext _localctx = new ConstshortContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constshort);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNICODE) | (1L << UNICODESTRING) | (1L << ANGLEBRACKIRI) | (1L << NCName) | (1L << CURIE) | (1L << NumericLiteral))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class SymspaceContext extends ParserRuleContext {
		public TerminalNode CURIE() { return getToken(RIFBLDParser.CURIE, 0); }
		public TerminalNode ANGLEBRACKIRI() { return getToken(RIFBLDParser.ANGLEBRACKIRI, 0); }
		public SymspaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symspace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).enterSymspace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RIFBLDListener ) ((RIFBLDListener)listener).exitSymspace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RIFBLDVisitor ) return ((RIFBLDVisitor<? extends T>)visitor).visitSymspace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymspaceContext symspace() throws RecognitionException {
		SymspaceContext _localctx = new SymspaceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_symspace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			_la = _input.LA(1);
			if ( !(_la==ANGLEBRACKIRI || _la==CURIE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u0141\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\3\5\3\65\n\3\3\3\3\3\3\3\5\3:\n\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3"+
		"\7\3C\n\3\f\3\16\3F\13\3\3\3\5\3I\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\5\6Y\n\6\3\6\3\6\3\6\3\6\5\6_\n\6\3\6\3\6\3\7"+
		"\3\7\3\b\5\bf\n\b\3\b\3\b\3\b\3\b\7\bl\n\b\f\b\16\bo\13\b\3\b\3\b\3\t"+
		"\5\tt\n\t\3\t\3\t\6\tx\n\t\r\t\16\ty\3\t\3\t\3\t\3\t\3\t\5\t\u0081\n\t"+
		"\3\n\3\n\5\n\u0085\n\n\3\13\5\13\u0088\n\13\3\13\3\13\3\13\3\13\7\13\u008e"+
		"\n\13\f\13\16\13\u0091\13\13\3\13\5\13\u0094\n\13\3\13\3\13\3\13\3\f\5"+
		"\f\u009a\n\f\3\f\3\f\3\f\7\f\u009f\n\f\f\f\16\f\u00a2\13\f\3\f\3\f\5\f"+
		"\u00a6\n\f\3\f\3\f\3\f\7\f\u00ab\n\f\f\f\16\f\u00ae\13\f\3\f\3\f\5\f\u00b2"+
		"\n\f\3\f\3\f\6\f\u00b6\n\f\r\f\16\f\u00b7\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00c0\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c7\n\f\3\r\5\r\u00ca\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\5\r\u00d1\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\5\21\u00e1\n\21\3\21\3\21\3\21\3\21\7\21\u00e7"+
		"\n\21\f\21\16\21\u00ea\13\21\3\21\5\21\u00ed\n\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u00f7\n\22\f\22\16\22\u00fa\13\22\3\22\3\22"+
		"\3\23\5\23\u00ff\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u010a\n\23\3\24\3\24\3\24\7\24\u010f\n\24\f\24\16\24\u0112\13\24\3\24"+
		"\3\24\3\24\3\24\6\24\u0118\n\24\r\24\16\24\u0119\3\24\3\24\3\24\3\24\5"+
		"\24\u0120\n\24\3\25\3\25\3\25\7\25\u0125\n\25\f\25\16\25\u0128\13\25\3"+
		"\25\3\25\3\25\7\25\u012d\n\25\f\25\16\25\u0130\13\25\5\25\u0132\n\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\5\26\u013b\n\26\3\27\3\27\3\30\3\30"+
		"\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\3\2\35"+
		"\"\4\2\37\37!!\u015c\2\60\3\2\2\2\4\64\3\2\2\2\6L\3\2\2\2\bQ\3\2\2\2\n"+
		"X\3\2\2\2\fb\3\2\2\2\16e\3\2\2\2\20\u0080\3\2\2\2\22\u0084\3\2\2\2\24"+
		"\u0087\3\2\2\2\26\u00c6\3\2\2\2\30\u00c9\3\2\2\2\32\u00d2\3\2\2\2\34\u00d6"+
		"\3\2\2\2\36\u00da\3\2\2\2 \u00de\3\2\2\2\"\u00f0\3\2\2\2$\u00fe\3\2\2"+
		"\2&\u011f\3\2\2\2(\u0121\3\2\2\2*\u013a\3\2\2\2,\u013c\3\2\2\2.\u013e"+
		"\3\2\2\2\60\61\5\4\3\2\61\62\7\2\2\3\62\3\3\2\2\2\63\65\5 \21\2\64\63"+
		"\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\7\2\2\679\7\30\2\28:\5\6"+
		"\4\298\3\2\2\29:\3\2\2\2:>\3\2\2\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2\2><\3\2"+
		"\2\2>?\3\2\2\2?D\3\2\2\2@>\3\2\2\2AC\5\n\6\2BA\3\2\2\2CF\3\2\2\2DB\3\2"+
		"\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2GI\5\16\b\2HG\3\2\2\2HI\3\2\2\2IJ\3"+
		"\2\2\2JK\7\31\2\2K\5\3\2\2\2LM\7\f\2\2MN\7\30\2\2NO\7\37\2\2OP\7\31\2"+
		"\2P\7\3\2\2\2QR\7\27\2\2RS\7\30\2\2ST\7 \2\2TU\7\37\2\2UV\7\31\2\2V\t"+
		"\3\2\2\2WY\5 \21\2XW\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\7\26\2\2[\\\7\30\2"+
		"\2\\^\5\f\7\2]_\5\f\7\2^]\3\2\2\2^_\3\2\2\2_`\3\2\2\2`a\7\31\2\2a\13\3"+
		"\2\2\2bc\7\37\2\2c\r\3\2\2\2df\5 \21\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2g"+
		"h\7\6\2\2hm\7\30\2\2il\5\20\t\2jl\5\16\b\2ki\3\2\2\2kj\3\2\2\2lo\3\2\2"+
		"\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\31\2\2q\17\3\2\2\2rt\5"+
		" \21\2sr\3\2\2\2st\3\2\2\2tu\3\2\2\2uw\7\25\2\2vx\7\33\2\2wv\3\2\2\2x"+
		"y\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\30\2\2|}\5\22\n\2}~\7\31\2"+
		"\2~\u0081\3\2\2\2\177\u0081\5\22\n\2\u0080s\3\2\2\2\u0080\177\3\2\2\2"+
		"\u0081\21\3\2\2\2\u0082\u0085\5\24\13\2\u0083\u0085\5\30\r\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0083\3\2\2\2\u0085\23\3\2\2\2\u0086\u0088\5 \21\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0093\3\2\2\2\u0089\u0094\5\30"+
		"\r\2\u008a\u008b\7\13\2\2\u008b\u008f\7\30\2\2\u008c\u008e\5\30\r\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\7\31\2\2\u0093"+
		"\u0089\3\2\2\2\u0093\u008a\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\3"+
		"\2\2\u0096\u0097\5\26\f\2\u0097\25\3\2\2\2\u0098\u009a\5 \21\2\u0099\u0098"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\13\2\2"+
		"\u009c\u00a0\7\30\2\2\u009d\u009f\5\26\f\2\u009e\u009d\3\2\2\2\u009f\u00a2"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a3\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00c7\7\31\2\2\u00a4\u00a6\5 \21\2\u00a5\u00a4\3"+
		"\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\22\2\2\u00a8"+
		"\u00ac\7\30\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00c7\7\31\2\2\u00b0\u00b2\5 \21\2\u00b1\u00b0\3"+
		"\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\7\5\2\2\u00b4"+
		"\u00b6\7\33\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\30\2\2\u00ba"+
		"\u00bb\5\26\f\2\u00bb\u00bc\7\31\2\2\u00bc\u00c7\3\2\2\2\u00bd\u00c7\5"+
		"\30\r\2\u00be\u00c0\5 \21\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\7\32\2\2\u00c2\u00c3\7\30\2\2\u00c3\u00c4\5"+
		"(\25\2\u00c4\u00c5\7\31\2\2\u00c5\u00c7\3\2\2\2\u00c6\u0099\3\2\2\2\u00c6"+
		"\u00a5\3\2\2\2\u00c6\u00b1\3\2\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00bf\3\2"+
		"\2\2\u00c7\27\3\2\2\2\u00c8\u00ca\5 \21\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00d0\3\2\2\2\u00cb\u00d1\5\32\16\2\u00cc\u00d1\5\34\17"+
		"\2\u00cd\u00d1\5\36\20\2\u00ce\u00d1\5(\25\2\u00cf\u00d1\5\"\22\2\u00d0"+
		"\u00cb\3\2\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d0\u00cf\3\2\2\2\u00d1\31\3\2\2\2\u00d2\u00d3\5$\23\2\u00d3\u00d4"+
		"\7\20\2\2\u00d4\u00d5\5$\23\2\u00d5\33\3\2\2\2\u00d6\u00d7\5$\23\2\u00d7"+
		"\u00d8\7\24\2\2\u00d8\u00d9\5$\23\2\u00d9\35\3\2\2\2\u00da\u00db\5$\23"+
		"\2\u00db\u00dc\7\16\2\2\u00dc\u00dd\5$\23\2\u00dd\37\3\2\2\2\u00de\u00e0"+
		"\7\23\2\2\u00df\u00e1\7\34\2\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2"+
		"\u00e1\u00ec\3\2\2\2\u00e2\u00ed\5\"\22\2\u00e3\u00e4\7\13\2\2\u00e4\u00e8"+
		"\7\30\2\2\u00e5\u00e7\5\"\22\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8"+
		"\3\2\2\2\u00eb\u00ed\7\31\2\2\u00ec\u00e2\3\2\2\2\u00ec\u00e3\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\n\2\2\u00ef!\3"+
		"\2\2\2\u00f0\u00f1\5$\23\2\u00f1\u00f8\7\t\2\2\u00f2\u00f3\5$\23\2\u00f3"+
		"\u00f4\7\4\2\2\u00f4\u00f5\5$\23\2\u00f5\u00f7\3\2\2\2\u00f6\u00f2\3\2"+
		"\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9"+
		"\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7\17\2\2\u00fc#\3\2\2\2"+
		"\u00fd\u00ff\5 \21\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0109"+
		"\3\2\2\2\u0100\u010a\5*\26\2\u0101\u010a\7\33\2\2\u0102\u010a\5(\25\2"+
		"\u0103\u010a\5&\24\2\u0104\u0105\7\32\2\2\u0105\u0106\7\30\2\2\u0106\u0107"+
		"\5(\25\2\u0107\u0108\7\31\2\2\u0108\u010a\3\2\2\2\u0109\u0100\3\2\2\2"+
		"\u0109\u0101\3\2\2\2\u0109\u0102\3\2\2\2\u0109\u0103\3\2\2\2\u0109\u0104"+
		"\3\2\2\2\u010a%\3\2\2\2\u010b\u010c\7\21\2\2\u010c\u0110\7\30\2\2\u010d"+
		"\u010f\5$\23\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113"+
		"\u0120\7\31\2\2\u0114\u0115\7\21\2\2\u0115\u0117\7\30\2\2\u0116\u0118"+
		"\5$\23\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\r\2\2\u011c\u011d\5$"+
		"\23\2\u011d\u011e\7\31\2\2\u011e\u0120\3\2\2\2\u011f\u010b\3\2\2\2\u011f"+
		"\u0114\3\2\2\2\u0120\'\3\2\2\2\u0121\u0122\5*\26\2\u0122\u0131\7\30\2"+
		"\2\u0123\u0125\5$\23\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0132\3\2\2\2\u0128\u0126\3\2\2\2\u0129"+
		"\u012a\7 \2\2\u012a\u012b\7\4\2\2\u012b\u012d\5$\23\2\u012c\u0129\3\2"+
		"\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0126\3\2\2\2\u0131\u012e\3\2"+
		"\2\2\u0132\u0133\3\2\2\2\u0133\u0134\7\31\2\2\u0134)\3\2\2\2\u0135\u013b"+
		"\7\34\2\2\u0136\u0137\7\36\2\2\u0137\u0138\7\b\2\2\u0138\u013b\5.\30\2"+
		"\u0139\u013b\5,\27\2\u013a\u0135\3\2\2\2\u013a\u0136\3\2\2\2\u013a\u0139"+
		"\3\2\2\2\u013b+\3\2\2\2\u013c\u013d\t\2\2\2\u013d-\3\2\2\2\u013e\u013f"+
		"\t\3\2\2\u013f/\3\2\2\2*\649>DHX^ekmsy\u0080\u0084\u0087\u008f\u0093\u0099"+
		"\u00a0\u00a5\u00ac\u00b1\u00b7\u00bf\u00c6\u00c9\u00d0\u00e0\u00e8\u00ec"+
		"\u00f8\u00fe\u0109\u0110\u0119\u011f\u0126\u012e\u0131\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}