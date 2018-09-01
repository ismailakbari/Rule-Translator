// Generated from RIFBLD.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RIFBLDParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RIFBLDVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#constshort}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstshort(@NotNull RIFBLDParser.ConstshortContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fact}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(@NotNull RIFBLDParser.FactContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(@NotNull RIFBLDParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull RIFBLDParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFormula(@NotNull RIFBLDParser.AndFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFormula(@NotNull RIFBLDParser.OrFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#const1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst1(@NotNull RIFBLDParser.Const1Context ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#irimeta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIrimeta(@NotNull RIFBLDParser.IrimetaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(@NotNull RIFBLDParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#angle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle(@NotNull RIFBLDParser.AngleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(@NotNull RIFBLDParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#symspace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymspace(@NotNull RIFBLDParser.SymspaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(@NotNull RIFBLDParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(@NotNull RIFBLDParser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#import1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImport1(@NotNull RIFBLDParser.Import1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code forall}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForall(@NotNull RIFBLDParser.ForallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code existsFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistsFormula(@NotNull RIFBLDParser.ExistsFormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomicFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicFormula(@NotNull RIFBLDParser.AtomicFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull RIFBLDParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(@NotNull RIFBLDParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#uniterm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniterm(@NotNull RIFBLDParser.UnitermContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(@NotNull RIFBLDParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#atomic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomic(@NotNull RIFBLDParser.AtomicContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#subclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubclass(@NotNull RIFBLDParser.SubclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#implies}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(@NotNull RIFBLDParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code externalFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalFormula(@NotNull RIFBLDParser.ExternalFormulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(@NotNull RIFBLDParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link RIFBLDParser#frame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrame(@NotNull RIFBLDParser.FrameContext ctx);
}