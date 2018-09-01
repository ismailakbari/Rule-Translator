// Generated from POSL.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link POSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface POSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code atom_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom_alt(@NotNull POSLParser.Atom_altContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(@NotNull POSLParser.SymbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#role}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRole(@NotNull POSLParser.RoleContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#skolem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkolem(@NotNull POSLParser.SkolemContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#oid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOid(@NotNull POSLParser.OidContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#slot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlot(@NotNull POSLParser.SlotContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull POSLParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#srest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSrest(@NotNull POSLParser.SrestContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#atoms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtoms(@NotNull POSLParser.AtomsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code srest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSrest_alt(@NotNull POSLParser.Srest_altContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#pos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos(@NotNull POSLParser.PosContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(@NotNull POSLParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull POSLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pos_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPos_alt(@NotNull POSLParser.Pos_altContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#prest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrest(@NotNull POSLParser.PrestContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#plex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlex(@NotNull POSLParser.PlexContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slots_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlots_alt(@NotNull POSLParser.Slots_altContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#ind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInd(@NotNull POSLParser.IndContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(@NotNull POSLParser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#slotplex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotplex(@NotNull POSLParser.SlotplexContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#cterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCterm(@NotNull POSLParser.CtermContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(@NotNull POSLParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#uri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUri(@NotNull POSLParser.UriContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#posplex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosplex(@NotNull POSLParser.PosplexContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(@NotNull POSLParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#slots}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlots(@NotNull POSLParser.SlotsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prest_alt}
	 * labeled alternative in {@link POSLParser#ps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrest_alt(@NotNull POSLParser.Prest_altContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#ctor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor(@NotNull POSLParser.CtorContext ctx);
	/**
	 * Visit a parse tree produced by {@link POSLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(@NotNull POSLParser.AtomContext ctx);
}