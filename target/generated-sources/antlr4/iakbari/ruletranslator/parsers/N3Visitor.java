// Generated from N3.g4 by ANTLR 4.4

	package iakbari.ruletranslator.parsers;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link N3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface N3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_pathtail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_pathtail(@NotNull N3Parser.N3_pathtailContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g11}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG11(@NotNull N3Parser.G11Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_statements_optional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_statements_optional(@NotNull N3Parser.N3_statements_optionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_object(@NotNull N3Parser.N3_objectContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_literal(@NotNull N3Parser.N3_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_dtlang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_dtlang(@NotNull N3Parser.N3_dtlangContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_formulacontent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_formulacontent(@NotNull N3Parser.N3_formulacontentContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_pathlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_pathlist(@NotNull N3Parser.N3_pathlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_subject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_subject(@NotNull N3Parser.N3_subjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_node(@NotNull N3Parser.N3_nodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_symbol(@NotNull N3Parser.N3_symbolContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_existential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_existential(@NotNull N3Parser.N3_existentialContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_qname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_qname(@NotNull N3Parser.N3_qnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG0(@NotNull N3Parser.G0Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_statement(@NotNull N3Parser.N3_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_statementlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_statementlist(@NotNull N3Parser.N3_statementlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_declaration(@NotNull N3Parser.N3_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG1(@NotNull N3Parser.G1Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG2(@NotNull N3Parser.G2Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG3(@NotNull N3Parser.G3Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_universal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_universal(@NotNull N3Parser.N3_universalContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG4(@NotNull N3Parser.G4Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG5(@NotNull N3Parser.G5Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG6(@NotNull N3Parser.G6Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG8(@NotNull N3Parser.G8Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(@NotNull N3Parser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#g9}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG9(@NotNull N3Parser.G9Context ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_propertylist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_propertylist(@NotNull N3Parser.N3_propertylistContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_statementtail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_statementtail(@NotNull N3Parser.N3_statementtailContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_path(@NotNull N3Parser.N3_pathContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_objecttail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_objecttail(@NotNull N3Parser.N3_objecttailContext ctx);
	/**
	 * Visit a parse tree produced by {@link N3Parser#n3_verb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitN3_verb(@NotNull N3Parser.N3_verbContext ctx);
}