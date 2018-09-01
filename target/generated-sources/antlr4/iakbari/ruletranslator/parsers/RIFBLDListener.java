// Generated from RIFBLD.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RIFBLDParser}.
 */
public interface RIFBLDListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#constshort}.
	 * @param ctx the parse tree
	 */
	void enterConstshort(@NotNull RIFBLDParser.ConstshortContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#constshort}.
	 * @param ctx the parse tree
	 */
	void exitConstshort(@NotNull RIFBLDParser.ConstshortContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fact}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 */
	void enterFact(@NotNull RIFBLDParser.FactContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fact}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 */
	void exitFact(@NotNull RIFBLDParser.FactContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(@NotNull RIFBLDParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(@NotNull RIFBLDParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull RIFBLDParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull RIFBLDParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAndFormula(@NotNull RIFBLDParser.AndFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAndFormula(@NotNull RIFBLDParser.AndFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterOrFormula(@NotNull RIFBLDParser.OrFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitOrFormula(@NotNull RIFBLDParser.OrFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#const1}.
	 * @param ctx the parse tree
	 */
	void enterConst1(@NotNull RIFBLDParser.Const1Context ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#const1}.
	 * @param ctx the parse tree
	 */
	void exitConst1(@NotNull RIFBLDParser.Const1Context ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#irimeta}.
	 * @param ctx the parse tree
	 */
	void enterIrimeta(@NotNull RIFBLDParser.IrimetaContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#irimeta}.
	 * @param ctx the parse tree
	 */
	void exitIrimeta(@NotNull RIFBLDParser.IrimetaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(@NotNull RIFBLDParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(@NotNull RIFBLDParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#angle}.
	 * @param ctx the parse tree
	 */
	void enterAngle(@NotNull RIFBLDParser.AngleContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#angle}.
	 * @param ctx the parse tree
	 */
	void exitAngle(@NotNull RIFBLDParser.AngleContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(@NotNull RIFBLDParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(@NotNull RIFBLDParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#symspace}.
	 * @param ctx the parse tree
	 */
	void enterSymspace(@NotNull RIFBLDParser.SymspaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#symspace}.
	 * @param ctx the parse tree
	 */
	void exitSymspace(@NotNull RIFBLDParser.SymspaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(@NotNull RIFBLDParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(@NotNull RIFBLDParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(@NotNull RIFBLDParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(@NotNull RIFBLDParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#import1}.
	 * @param ctx the parse tree
	 */
	void enterImport1(@NotNull RIFBLDParser.Import1Context ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#import1}.
	 * @param ctx the parse tree
	 */
	void exitImport1(@NotNull RIFBLDParser.Import1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code forall}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 */
	void enterForall(@NotNull RIFBLDParser.ForallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forall}
	 * labeled alternative in {@link RIFBLDParser#rule1}.
	 * @param ctx the parse tree
	 */
	void exitForall(@NotNull RIFBLDParser.ForallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existsFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExistsFormula(@NotNull RIFBLDParser.ExistsFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existsFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExistsFormula(@NotNull RIFBLDParser.ExistsFormulaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomicFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAtomicFormula(@NotNull RIFBLDParser.AtomicFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomicFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAtomicFormula(@NotNull RIFBLDParser.AtomicFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(@NotNull RIFBLDParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(@NotNull RIFBLDParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(@NotNull RIFBLDParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(@NotNull RIFBLDParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#uniterm}.
	 * @param ctx the parse tree
	 */
	void enterUniterm(@NotNull RIFBLDParser.UnitermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#uniterm}.
	 * @param ctx the parse tree
	 */
	void exitUniterm(@NotNull RIFBLDParser.UnitermContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull RIFBLDParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull RIFBLDParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#atomic}.
	 * @param ctx the parse tree
	 */
	void enterAtomic(@NotNull RIFBLDParser.AtomicContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#atomic}.
	 * @param ctx the parse tree
	 */
	void exitAtomic(@NotNull RIFBLDParser.AtomicContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#subclass}.
	 * @param ctx the parse tree
	 */
	void enterSubclass(@NotNull RIFBLDParser.SubclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#subclass}.
	 * @param ctx the parse tree
	 */
	void exitSubclass(@NotNull RIFBLDParser.SubclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#implies}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull RIFBLDParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#implies}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull RIFBLDParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code externalFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterExternalFormula(@NotNull RIFBLDParser.ExternalFormulaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code externalFormula}
	 * labeled alternative in {@link RIFBLDParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitExternalFormula(@NotNull RIFBLDParser.ExternalFormulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#base}.
	 * @param ctx the parse tree
	 */
	void enterBase(@NotNull RIFBLDParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#base}.
	 * @param ctx the parse tree
	 */
	void exitBase(@NotNull RIFBLDParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link RIFBLDParser#frame}.
	 * @param ctx the parse tree
	 */
	void enterFrame(@NotNull RIFBLDParser.FrameContext ctx);
	/**
	 * Exit a parse tree produced by {@link RIFBLDParser#frame}.
	 * @param ctx the parse tree
	 */
	void exitFrame(@NotNull RIFBLDParser.FrameContext ctx);
}