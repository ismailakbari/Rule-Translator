// Generated from POSL.g4 by ANTLR 4.4

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
public class POSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PIPE=1, BANG=2, HAT=3, COLON=4, SEMI=5, LBRACK=6, RBRACK=7, LPAREN=8, 
		RPAREN=9, QMARK=10, COMMA=11, PERIOD=12, LBRACE=13, RBRACE=14, USCORE=15, 
		IMP=16, ARROW=17, URI=18, SYMBOL=19, QSYMBOL=20, COMMENT=21, MLCOMMENT=22, 
		WS=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'|'", "'!'", "'^'", "':'", "';'", "'['", "']'", "'('", "')'", 
		"'?'", "','", "'.'", "'{'", "'}'", "'_'", "':-'", "'->'", "URI", "SYMBOL", 
		"QSYMBOL", "COMMENT", "MLCOMMENT", "WS"
	};
	public static final int
		RULE_r = 0, RULE_clause = 1, RULE_atoms = 2, RULE_atom = 3, RULE_ps = 4, 
		RULE_oid = 5, RULE_prest = 6, RULE_srest = 7, RULE_posplex = 8, RULE_slotplex = 9, 
		RULE_pos = 10, RULE_slots = 11, RULE_slot = 12, RULE_term = 13, RULE_cterm = 14, 
		RULE_plex = 15, RULE_ctor = 16, RULE_rel = 17, RULE_role = 18, RULE_type = 19, 
		RULE_ind = 20, RULE_skolem = 21, RULE_var = 22, RULE_symbol = 23, RULE_uri = 24;
	public static final String[] ruleNames = {
		"r", "clause", "atoms", "atom", "ps", "oid", "prest", "srest", "posplex", 
		"slotplex", "pos", "slots", "slot", "term", "cterm", "plex", "ctor", "rel", 
		"role", "type", "ind", "skolem", "var", "symbol", "uri"
	};

	@Override
	public String getGrammarFileName() { return "POSL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public POSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitR(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SYMBOL || _la==QSYMBOL) {
				{
				{
				setState(50); clause();
				}
				}
				setState(55);
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

	public static class ClauseContext extends ParserRuleContext {
		public TerminalNode PERIOD() { return getToken(POSLParser.PERIOD, 0); }
		public TerminalNode IMP() { return getToken(POSLParser.IMP, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomsContext atoms() {
			return getRuleContext(AtomsContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56); atom();
			setState(59);
			_la = _input.LA(1);
			if (_la==IMP) {
				{
				setState(57); match(IMP);
				setState(58); atoms();
				}
			}

			setState(61); match(PERIOD);
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

	public static class AtomsContext extends ParserRuleContext {
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(POSLParser.COMMA); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(POSLParser.COMMA, i);
		}
		public AtomsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atoms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterAtoms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitAtoms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitAtoms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomsContext atoms() throws RecognitionException {
		AtomsContext _localctx = new AtomsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atoms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); atom();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(64); match(COMMA);
				setState(65); atom();
				}
				}
				setState(70);
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

	public static class AtomContext extends ParserRuleContext {
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public OidContext oid() {
			return getRuleContext(OidContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(POSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(POSLParser.RPAREN, 0); }
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); rel();
			setState(72); match(LPAREN);
			setState(74);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(73); oid();
				}
				break;
			}
			setState(77);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIPE) | (1L << BANG) | (1L << LBRACK) | (1L << QMARK) | (1L << USCORE) | (1L << URI) | (1L << SYMBOL) | (1L << QSYMBOL))) != 0)) {
				{
				setState(76); ps();
				}
			}

			setState(79); match(RPAREN);
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

	public static class PsContext extends ParserRuleContext {
		public PsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ps; }
	 
		public PsContext() { }
		public void copyFrom(PsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Atom_altContext extends PsContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public Atom_altContext(PsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterAtom_alt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitAtom_alt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitAtom_alt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Srest_altContext extends PsContext {
		public SrestContext srest() {
			return getRuleContext(SrestContext.class,0);
		}
		public Srest_altContext(PsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSrest_alt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSrest_alt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSrest_alt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Prest_altContext extends PsContext {
		public TerminalNode SEMI() { return getToken(POSLParser.SEMI, 0); }
		public SrestContext srest() {
			return getRuleContext(SrestContext.class,0);
		}
		public SlotsContext slots() {
			return getRuleContext(SlotsContext.class,0);
		}
		public PrestContext prest() {
			return getRuleContext(PrestContext.class,0);
		}
		public Prest_altContext(PsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPrest_alt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPrest_alt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPrest_alt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Pos_altContext extends PsContext {
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(POSLParser.SEMI, 0); }
		public SrestContext srest() {
			return getRuleContext(SrestContext.class,0);
		}
		public SlotsContext slots() {
			return getRuleContext(SlotsContext.class,0);
		}
		public PrestContext prest() {
			return getRuleContext(PrestContext.class,0);
		}
		public Pos_altContext(PsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPos_alt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPos_alt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPos_alt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Slots_altContext extends PsContext {
		public SlotsContext slots(int i) {
			return getRuleContext(SlotsContext.class,i);
		}
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(POSLParser.SEMI); }
		public SrestContext srest() {
			return getRuleContext(SrestContext.class,0);
		}
		public TerminalNode SEMI(int i) {
			return getToken(POSLParser.SEMI, i);
		}
		public List<SlotsContext> slots() {
			return getRuleContexts(SlotsContext.class);
		}
		public PrestContext prest() {
			return getRuleContext(PrestContext.class,0);
		}
		public Slots_altContext(PsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSlots_alt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSlots_alt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSlots_alt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PsContext ps() throws RecognitionException {
		PsContext _localctx = new PsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ps);
		int _la;
		try {
			setState(127);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new Pos_altContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81); pos();
				setState(83);
				_la = _input.LA(1);
				if (_la==PIPE) {
					{
					setState(82); prest();
					}
				}

				setState(87);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(85); match(SEMI);
					setState(86); slots();
					}
				}

				setState(90);
				_la = _input.LA(1);
				if (_la==BANG) {
					{
					setState(89); srest();
					}
				}

				}
				break;
			case 2:
				_localctx = new Slots_altContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92); slots();
				setState(115);
				switch (_input.LA(1)) {
				case PIPE:
				case BANG:
				case RBRACK:
				case RPAREN:
					{
					setState(98);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(93); prest();
						setState(96);
						_la = _input.LA(1);
						if (_la==SEMI) {
							{
							setState(94); match(SEMI);
							setState(95); slots();
							}
						}

						}
					}

					setState(101);
					_la = _input.LA(1);
					if (_la==BANG) {
						{
						setState(100); srest();
						}
					}

					}
					break;
				case SEMI:
					{
					setState(103); match(SEMI);
					setState(104); pos();
					setState(106);
					_la = _input.LA(1);
					if (_la==PIPE) {
						{
						setState(105); prest();
						}
					}

					setState(110);
					_la = _input.LA(1);
					if (_la==SEMI) {
						{
						setState(108); match(SEMI);
						setState(109); slots();
						}
					}

					setState(113);
					_la = _input.LA(1);
					if (_la==BANG) {
						{
						setState(112); srest();
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new Prest_altContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117); prest();
				setState(120);
				_la = _input.LA(1);
				if (_la==SEMI) {
					{
					setState(118); match(SEMI);
					setState(119); slots();
					}
				}

				setState(123);
				_la = _input.LA(1);
				if (_la==BANG) {
					{
					setState(122); srest();
					}
				}

				}
				break;
			case 4:
				_localctx = new Srest_altContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125); srest();
				}
				break;
			case 5:
				_localctx = new Atom_altContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(126); atom();
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

	public static class OidContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode HAT() { return getToken(POSLParser.HAT, 0); }
		public OidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterOid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitOid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitOid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OidContext oid() throws RecognitionException {
		OidContext _localctx = new OidContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_oid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); term();
			setState(130); match(HAT);
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

	public static class PrestContext extends ParserRuleContext {
		public PosplexContext posplex() {
			return getRuleContext(PosplexContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(POSLParser.PIPE, 0); }
		public PrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPrest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPrest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrestContext prest() throws RecognitionException {
		PrestContext _localctx = new PrestContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(PIPE);
			setState(135);
			switch (_input.LA(1)) {
			case QMARK:
				{
				setState(133); var();
				}
				break;
			case LBRACK:
				{
				setState(134); posplex();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SrestContext extends ParserRuleContext {
		public SlotplexContext slotplex() {
			return getRuleContext(SlotplexContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode BANG() { return getToken(POSLParser.BANG, 0); }
		public SrestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_srest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSrest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSrest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSrest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SrestContext srest() throws RecognitionException {
		SrestContext _localctx = new SrestContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_srest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(BANG);
			setState(140);
			switch (_input.LA(1)) {
			case QMARK:
				{
				setState(138); var();
				}
				break;
			case LBRACK:
				{
				setState(139); slotplex();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PosplexContext extends ParserRuleContext {
		public PosContext pos() {
			return getRuleContext(PosContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(POSLParser.RBRACK, 0); }
		public PrestContext prest() {
			return getRuleContext(PrestContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(POSLParser.LBRACK, 0); }
		public PosplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_posplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPosplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPosplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPosplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosplexContext posplex() throws RecognitionException {
		PosplexContext _localctx = new PosplexContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_posplex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(LBRACK);
			setState(144);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACK) | (1L << QMARK) | (1L << USCORE) | (1L << URI) | (1L << SYMBOL) | (1L << QSYMBOL))) != 0)) {
				{
				setState(143); pos();
				}
			}

			setState(147);
			_la = _input.LA(1);
			if (_la==PIPE) {
				{
				setState(146); prest();
				}
			}

			setState(149); match(RBRACK);
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

	public static class SlotplexContext extends ParserRuleContext {
		public SrestContext srest() {
			return getRuleContext(SrestContext.class,0);
		}
		public SlotsContext slots() {
			return getRuleContext(SlotsContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(POSLParser.RBRACK, 0); }
		public TerminalNode LBRACK() { return getToken(POSLParser.LBRACK, 0); }
		public SlotplexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slotplex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSlotplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSlotplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSlotplex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotplexContext slotplex() throws RecognitionException {
		SlotplexContext _localctx = new SlotplexContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_slotplex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151); match(LBRACK);
			setState(153);
			_la = _input.LA(1);
			if (_la==SYMBOL || _la==QSYMBOL) {
				{
				setState(152); slots();
				}
			}

			setState(156);
			_la = _input.LA(1);
			if (_la==BANG) {
				{
				setState(155); srest();
				}
			}

			setState(158); match(RBRACK);
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

	public static class PosContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(POSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(POSLParser.COMMA, i);
		}
		public PosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PosContext pos() throws RecognitionException {
		PosContext _localctx = new PosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); term();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(161); match(COMMA);
				setState(162); term();
				}
				}
				setState(167);
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

	public static class SlotsContext extends ParserRuleContext {
		public List<TerminalNode> SEMI() { return getTokens(POSLParser.SEMI); }
		public List<SlotContext> slot() {
			return getRuleContexts(SlotContext.class);
		}
		public TerminalNode SEMI(int i) {
			return getToken(POSLParser.SEMI, i);
		}
		public SlotContext slot(int i) {
			return getRuleContext(SlotContext.class,i);
		}
		public SlotsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slots; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSlots(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSlots(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSlots(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotsContext slots() throws RecognitionException {
		SlotsContext _localctx = new SlotsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_slots);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168); slot();
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169); match(SEMI);
					setState(170); slot();
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class SlotContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public RoleContext role() {
			return getRuleContext(RoleContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(POSLParser.ARROW, 0); }
		public SlotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSlot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSlot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSlot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlotContext slot() throws RecognitionException {
		SlotContext _localctx = new SlotContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_slot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176); role();
			setState(177); match(ARROW);
			setState(178); term();
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
		public CtermContext cterm() {
			return getRuleContext(CtermContext.class,0);
		}
		public IndContext ind() {
			return getRuleContext(IndContext.class,0);
		}
		public PlexContext plex() {
			return getRuleContext(PlexContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public SkolemContext skolem() {
			return getRuleContext(SkolemContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		try {
			setState(185);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); ind();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); var();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); cterm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183); skolem();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(184); plex();
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

	public static class CtermContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(POSLParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(POSLParser.RBRACK, 0); }
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(POSLParser.LBRACK, 0); }
		public CtorContext ctor() {
			return getRuleContext(CtorContext.class,0);
		}
		public CtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterCterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitCterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitCterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtermContext cterm() throws RecognitionException {
		CtermContext _localctx = new CtermContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); ctor();
			setState(188); match(LBRACK);
			setState(190);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIPE) | (1L << BANG) | (1L << LBRACK) | (1L << QMARK) | (1L << USCORE) | (1L << URI) | (1L << SYMBOL) | (1L << QSYMBOL))) != 0)) {
				{
				setState(189); ps();
				}
			}

			setState(192); match(RBRACK);
			setState(195);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(193); match(COLON);
				setState(194); type();
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

	public static class PlexContext extends ParserRuleContext {
		public TerminalNode RBRACK() { return getToken(POSLParser.RBRACK, 0); }
		public PsContext ps() {
			return getRuleContext(PsContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(POSLParser.LBRACK, 0); }
		public PlexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterPlex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitPlex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitPlex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlexContext plex() throws RecognitionException {
		PlexContext _localctx = new PlexContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_plex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(LBRACK);
			setState(199);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PIPE) | (1L << BANG) | (1L << LBRACK) | (1L << QMARK) | (1L << USCORE) | (1L << URI) | (1L << SYMBOL) | (1L << QSYMBOL))) != 0)) {
				{
				setState(198); ps();
				}
			}

			setState(201); match(RBRACK);
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

	public static class CtorContext extends ParserRuleContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public CtorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterCtor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitCtor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitCtor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtorContext ctor() throws RecognitionException {
		CtorContext _localctx = new CtorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ctor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); symbol();
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

	public static class RelContext extends ParserRuleContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205); symbol();
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

	public static class RoleContext extends ParserRuleContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public RoleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterRole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitRole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitRole(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleContext role() throws RecognitionException {
		RoleContext _localctx = new RoleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_role);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207); symbol();
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

	public static class TypeContext extends ParserRuleContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); symbol();
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

	public static class IndContext extends ParserRuleContext {
		public UriContext uri() {
			return getRuleContext(UriContext.class,0);
		}
		public TerminalNode COLON() { return getToken(POSLParser.COLON, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterInd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitInd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitInd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndContext ind() throws RecognitionException {
		IndContext _localctx = new IndContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			switch (_input.LA(1)) {
			case SYMBOL:
			case QSYMBOL:
				{
				setState(211); symbol();
				setState(213);
				_la = _input.LA(1);
				if (_la==URI) {
					{
					setState(212); uri();
					}
				}

				}
				break;
			case URI:
				{
				setState(215); uri();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(220);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(218); match(COLON);
				setState(219); type();
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

	public static class SkolemContext extends ParserRuleContext {
		public TerminalNode USCORE() { return getToken(POSLParser.USCORE, 0); }
		public TerminalNode COLON() { return getToken(POSLParser.COLON, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SkolemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skolem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSkolem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSkolem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSkolem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkolemContext skolem() throws RecognitionException {
		SkolemContext _localctx = new SkolemContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_skolem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222); match(USCORE);
			setState(224);
			_la = _input.LA(1);
			if (_la==SYMBOL || _la==QSYMBOL) {
				{
				setState(223); symbol();
				}
			}

			setState(228);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(226); match(COLON);
				setState(227); type();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode QMARK() { return getToken(POSLParser.QMARK, 0); }
		public TerminalNode COLON() { return getToken(POSLParser.COLON, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(QMARK);
			setState(232);
			_la = _input.LA(1);
			if (_la==SYMBOL || _la==QSYMBOL) {
				{
				setState(231); symbol();
				}
			}

			setState(236);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(234); match(COLON);
				setState(235); type();
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

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode QSYMBOL() { return getToken(POSLParser.QSYMBOL, 0); }
		public TerminalNode SYMBOL() { return getToken(POSLParser.SYMBOL, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitSymbol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_la = _input.LA(1);
			if ( !(_la==SYMBOL || _la==QSYMBOL) ) {
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

	public static class UriContext extends ParserRuleContext {
		public TerminalNode URI() { return getToken(POSLParser.URI, 0); }
		public UriContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uri; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).enterUri(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof POSLListener ) ((POSLListener)listener).exitUri(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof POSLVisitor ) return ((POSLVisitor<? extends T>)visitor).visitUri(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UriContext uri() throws RecognitionException {
		UriContext _localctx = new UriContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_uri);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240); match(URI);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00f5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\5\3>\n\3\3\3\3\3"+
		"\3\4\3\4\3\4\7\4E\n\4\f\4\16\4H\13\4\3\5\3\5\3\5\5\5M\n\5\3\5\5\5P\n\5"+
		"\3\5\3\5\3\6\3\6\5\6V\n\6\3\6\3\6\5\6Z\n\6\3\6\5\6]\n\6\3\6\3\6\3\6\3"+
		"\6\5\6c\n\6\5\6e\n\6\3\6\5\6h\n\6\3\6\3\6\3\6\5\6m\n\6\3\6\3\6\5\6q\n"+
		"\6\3\6\5\6t\n\6\5\6v\n\6\3\6\3\6\3\6\5\6{\n\6\3\6\5\6~\n\6\3\6\3\6\5\6"+
		"\u0082\n\6\3\7\3\7\3\7\3\b\3\b\3\b\5\b\u008a\n\b\3\t\3\t\3\t\5\t\u008f"+
		"\n\t\3\n\3\n\5\n\u0093\n\n\3\n\5\n\u0096\n\n\3\n\3\n\3\13\3\13\5\13\u009c"+
		"\n\13\3\13\5\13\u009f\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u00a6\n\f\f\f\16"+
		"\f\u00a9\13\f\3\r\3\r\3\r\7\r\u00ae\n\r\f\r\16\r\u00b1\13\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17\u00bc\n\17\3\20\3\20\3\20\5\20"+
		"\u00c1\n\20\3\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\5\21\u00ca\n\21\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\5\26\u00d8"+
		"\n\26\3\26\5\26\u00db\n\26\3\26\3\26\5\26\u00df\n\26\3\27\3\27\5\27\u00e3"+
		"\n\27\3\27\3\27\5\27\u00e7\n\27\3\30\3\30\5\30\u00eb\n\30\3\30\3\30\5"+
		"\30\u00ef\n\30\3\31\3\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\2\3\3\2\25\26\u0106\2\67\3\2\2\2\4:\3\2"+
		"\2\2\6A\3\2\2\2\bI\3\2\2\2\n\u0081\3\2\2\2\f\u0083\3\2\2\2\16\u0086\3"+
		"\2\2\2\20\u008b\3\2\2\2\22\u0090\3\2\2\2\24\u0099\3\2\2\2\26\u00a2\3\2"+
		"\2\2\30\u00aa\3\2\2\2\32\u00b2\3\2\2\2\34\u00bb\3\2\2\2\36\u00bd\3\2\2"+
		"\2 \u00c7\3\2\2\2\"\u00cd\3\2\2\2$\u00cf\3\2\2\2&\u00d1\3\2\2\2(\u00d3"+
		"\3\2\2\2*\u00da\3\2\2\2,\u00e0\3\2\2\2.\u00e8\3\2\2\2\60\u00f0\3\2\2\2"+
		"\62\u00f2\3\2\2\2\64\66\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2"+
		"\2\678\3\2\2\28\3\3\2\2\29\67\3\2\2\2:=\5\b\5\2;<\7\22\2\2<>\5\6\4\2="+
		";\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7\16\2\2@\5\3\2\2\2AF\5\b\5\2BC\7\r\2"+
		"\2CE\5\b\5\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\7\3\2\2\2HF\3\2"+
		"\2\2IJ\5$\23\2JL\7\n\2\2KM\5\f\7\2LK\3\2\2\2LM\3\2\2\2MO\3\2\2\2NP\5\n"+
		"\6\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\13\2\2R\t\3\2\2\2SU\5\26\f\2TV"+
		"\5\16\b\2UT\3\2\2\2UV\3\2\2\2VY\3\2\2\2WX\7\7\2\2XZ\5\30\r\2YW\3\2\2\2"+
		"YZ\3\2\2\2Z\\\3\2\2\2[]\5\20\t\2\\[\3\2\2\2\\]\3\2\2\2]\u0082\3\2\2\2"+
		"^u\5\30\r\2_b\5\16\b\2`a\7\7\2\2ac\5\30\r\2b`\3\2\2\2bc\3\2\2\2ce\3\2"+
		"\2\2d_\3\2\2\2de\3\2\2\2eg\3\2\2\2fh\5\20\t\2gf\3\2\2\2gh\3\2\2\2hv\3"+
		"\2\2\2ij\7\7\2\2jl\5\26\f\2km\5\16\b\2lk\3\2\2\2lm\3\2\2\2mp\3\2\2\2n"+
		"o\7\7\2\2oq\5\30\r\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rt\5\20\t\2sr\3\2\2"+
		"\2st\3\2\2\2tv\3\2\2\2ud\3\2\2\2ui\3\2\2\2v\u0082\3\2\2\2wz\5\16\b\2x"+
		"y\7\7\2\2y{\5\30\r\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|~\5\20\t\2}|\3\2\2"+
		"\2}~\3\2\2\2~\u0082\3\2\2\2\177\u0082\5\20\t\2\u0080\u0082\5\b\5\2\u0081"+
		"S\3\2\2\2\u0081^\3\2\2\2\u0081w\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\13\3\2\2\2\u0083\u0084\5\34\17\2\u0084\u0085\7\5\2\2\u0085"+
		"\r\3\2\2\2\u0086\u0089\7\3\2\2\u0087\u008a\5.\30\2\u0088\u008a\5\22\n"+
		"\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\17\3\2\2\2\u008b\u008e"+
		"\7\4\2\2\u008c\u008f\5.\30\2\u008d\u008f\5\24\13\2\u008e\u008c\3\2\2\2"+
		"\u008e\u008d\3\2\2\2\u008f\21\3\2\2\2\u0090\u0092\7\b\2\2\u0091\u0093"+
		"\5\26\f\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2"+
		"\u0094\u0096\5\16\b\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0098\7\t\2\2\u0098\23\3\2\2\2\u0099\u009b\7\b\2\2\u009a"+
		"\u009c\5\30\r\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3"+
		"\2\2\2\u009d\u009f\5\20\t\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\7\t\2\2\u00a1\25\3\2\2\2\u00a2\u00a7\5\34\17"+
		"\2\u00a3\u00a4\7\r\2\2\u00a4\u00a6\5\34\17\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\27\3\2\2"+
		"\2\u00a9\u00a7\3\2\2\2\u00aa\u00af\5\32\16\2\u00ab\u00ac\7\7\2\2\u00ac"+
		"\u00ae\5\32\16\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\31\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b3\5&\24\2\u00b3\u00b4\7\23\2\2\u00b4\u00b5\5\34\17\2\u00b5\33\3\2"+
		"\2\2\u00b6\u00bc\5*\26\2\u00b7\u00bc\5.\30\2\u00b8\u00bc\5\36\20\2\u00b9"+
		"\u00bc\5,\27\2\u00ba\u00bc\5 \21\2\u00bb\u00b6\3\2\2\2\u00bb\u00b7\3\2"+
		"\2\2\u00bb\u00b8\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\35\3\2\2\2\u00bd\u00be\5\"\22\2\u00be\u00c0\7\b\2\2\u00bf\u00c1\5\n\6"+
		"\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5"+
		"\7\t\2\2\u00c3\u00c4\7\6\2\2\u00c4\u00c6\5(\25\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\37\3\2\2\2\u00c7\u00c9\7\b\2\2\u00c8\u00ca\5\n\6"+
		"\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc"+
		"\7\t\2\2\u00cc!\3\2\2\2\u00cd\u00ce\5\60\31\2\u00ce#\3\2\2\2\u00cf\u00d0"+
		"\5\60\31\2\u00d0%\3\2\2\2\u00d1\u00d2\5\60\31\2\u00d2\'\3\2\2\2\u00d3"+
		"\u00d4\5\60\31\2\u00d4)\3\2\2\2\u00d5\u00d7\5\60\31\2\u00d6\u00d8\5\62"+
		"\32\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00db\5\62\32\2\u00da\u00d5\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3"+
		"\2\2\2\u00dc\u00dd\7\6\2\2\u00dd\u00df\5(\25\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df+\3\2\2\2\u00e0\u00e2\7\21\2\2\u00e1\u00e3\5\60\31"+
		"\2\u00e2\u00e1\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e5"+
		"\7\6\2\2\u00e5\u00e7\5(\25\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"-\3\2\2\2\u00e8\u00ea\7\f\2\2\u00e9\u00eb\5\60\31\2\u00ea\u00e9\3\2\2"+
		"\2\u00ea\u00eb\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ed\7\6\2\2\u00ed\u00ef"+
		"\5(\25\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef/\3\2\2\2\u00f0"+
		"\u00f1\t\2\2\2\u00f1\61\3\2\2\2\u00f2\u00f3\7\24\2\2\u00f3\63\3\2\2\2"+
		"\'\67=FLOUY\\bdglpsuz}\u0081\u0089\u008e\u0092\u0095\u009b\u009e\u00a7"+
		"\u00af\u00bb\u00c0\u00c5\u00c9\u00d7\u00da\u00de\u00e2\u00e6\u00ea\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}