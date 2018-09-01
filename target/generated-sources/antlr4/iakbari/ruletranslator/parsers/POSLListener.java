// Generated from POSL.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link POSLParser}.
 */
public interface POSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code atom_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterAtom_alt(@NotNull POSLParser.Atom_altContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atom_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitAtom_alt(@NotNull POSLParser.Atom_altContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(@NotNull POSLParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(@NotNull POSLParser.SymbolContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#role}.
	 * @param ctx the parse tree
	 */
	void enterRole(@NotNull POSLParser.RoleContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#role}.
	 * @param ctx the parse tree
	 */
	void exitRole(@NotNull POSLParser.RoleContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#skolem}.
	 * @param ctx the parse tree
	 */
	void enterSkolem(@NotNull POSLParser.SkolemContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#skolem}.
	 * @param ctx the parse tree
	 */
	void exitSkolem(@NotNull POSLParser.SkolemContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#oid}.
	 * @param ctx the parse tree
	 */
	void enterOid(@NotNull POSLParser.OidContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#oid}.
	 * @param ctx the parse tree
	 */
	void exitOid(@NotNull POSLParser.OidContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#slot}.
	 * @param ctx the parse tree
	 */
	void enterSlot(@NotNull POSLParser.SlotContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#slot}.
	 * @param ctx the parse tree
	 */
	void exitSlot(@NotNull POSLParser.SlotContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull POSLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull POSLParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#srest}.
	 * @param ctx the parse tree
	 */
	void enterSrest(@NotNull POSLParser.SrestContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#srest}.
	 * @param ctx the parse tree
	 */
	void exitSrest(@NotNull POSLParser.SrestContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#atoms}.
	 * @param ctx the parse tree
	 */
	void enterAtoms(@NotNull POSLParser.AtomsContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#atoms}.
	 * @param ctx the parse tree
	 */
	void exitAtoms(@NotNull POSLParser.AtomsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code srest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterSrest_alt(@NotNull POSLParser.Srest_altContext ctx);
	/**
	 * Exit a parse tree produced by the {@code srest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitSrest_alt(@NotNull POSLParser.Srest_altContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#pos}.
	 * @param ctx the parse tree
	 */
	void enterPos(@NotNull POSLParser.PosContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#pos}.
	 * @param ctx the parse tree
	 */
	void exitPos(@NotNull POSLParser.PosContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(@NotNull POSLParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(@NotNull POSLParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull POSLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull POSLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pos_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterPos_alt(@NotNull POSLParser.Pos_altContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pos_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitPos_alt(@NotNull POSLParser.Pos_altContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#prest}.
	 * @param ctx the parse tree
	 */
	void enterPrest(@NotNull POSLParser.PrestContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#prest}.
	 * @param ctx the parse tree
	 */
	void exitPrest(@NotNull POSLParser.PrestContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#plex}.
	 * @param ctx the parse tree
	 */
	void enterPlex(@NotNull POSLParser.PlexContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#plex}.
	 * @param ctx the parse tree
	 */
	void exitPlex(@NotNull POSLParser.PlexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slots_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterSlots_alt(@NotNull POSLParser.Slots_altContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slots_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitSlots_alt(@NotNull POSLParser.Slots_altContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#ind}.
	 * @param ctx the parse tree
	 */
	void enterInd(@NotNull POSLParser.IndContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#ind}.
	 * @param ctx the parse tree
	 */
	void exitInd(@NotNull POSLParser.IndContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(@NotNull POSLParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(@NotNull POSLParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#slotplex}.
	 * @param ctx the parse tree
	 */
	void enterSlotplex(@NotNull POSLParser.SlotplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#slotplex}.
	 * @param ctx the parse tree
	 */
	void exitSlotplex(@NotNull POSLParser.SlotplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#cterm}.
	 * @param ctx the parse tree
	 */
	void enterCterm(@NotNull POSLParser.CtermContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#cterm}.
	 * @param ctx the parse tree
	 */
	void exitCterm(@NotNull POSLParser.CtermContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(@NotNull POSLParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(@NotNull POSLParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#uri}.
	 * @param ctx the parse tree
	 */
	void enterUri(@NotNull POSLParser.UriContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#uri}.
	 * @param ctx the parse tree
	 */
	void exitUri(@NotNull POSLParser.UriContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#posplex}.
	 * @param ctx the parse tree
	 */
	void enterPosplex(@NotNull POSLParser.PosplexContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#posplex}.
	 * @param ctx the parse tree
	 */
	void exitPosplex(@NotNull POSLParser.PosplexContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull POSLParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull POSLParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#slots}.
	 * @param ctx the parse tree
	 */
	void enterSlots(@NotNull POSLParser.SlotsContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#slots}.
	 * @param ctx the parse tree
	 */
	void exitSlots(@NotNull POSLParser.SlotsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void enterPrest_alt(@NotNull POSLParser.Prest_altContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 */
	void exitPrest_alt(@NotNull POSLParser.Prest_altContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#ctor}.
	 * @param ctx the parse tree
	 */
	void enterCtor(@NotNull POSLParser.CtorContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#ctor}.
	 * @param ctx the parse tree
	 */
	void exitCtor(@NotNull POSLParser.CtorContext ctx);
	/**
	 * Enter a parse tree produced by {@link POSLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull POSLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link POSLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull POSLParser.AtomContext ctx);
}