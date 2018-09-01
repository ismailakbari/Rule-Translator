package iakbari.ruletranslator.translator;

import java.util.LinkedList;
import java.util.Queue;

import iakbari.ruletranslator.parsers.RIFBLDBaseVisitor;
import iakbari.ruletranslator.parsers.RIFBLDParser;
import iakbari.ruletranslator.parsers.RIFBLDParser.ImpliesContext;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;


public class MyRIFBLDBaseVisitor extends RIFBLDBaseVisitor<Value> {
	
	public int rule_count = 0;
	public int fact_count = 0;
	public Utils util = new Utils();
	public Value value;
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitClause(@NotNull RIFBLDParser.ClauseContext ctx) { 
		/*
		if(ctx.implies()!=null)
			System.out.println("clause has implies");
		if(ctx.atomic()!=null)
			System.out.println("clause has atomic");
		System.out.println("clause parent="+ctx.getParent().getClass().getName());
		*/
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitImport1(@NotNull RIFBLDParser.Import1Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitConstshort(@NotNull RIFBLDParser.ConstshortContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitFact(@NotNull RIFBLDParser.FactContext ctx) { 
		
		fact_count ++ ;
	
		return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitPrefix(@NotNull RIFBLDParser.PrefixContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitDocument(@NotNull RIFBLDParser.DocumentContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitForall(@NotNull RIFBLDParser.ForallContext ctx) { 
		
		rule_count ++ ; //ctx.getTokens(arg0)
		//System.out.println(ctx.getClass().getName() + " has "+ ctx.Var().size() + " vars.");		
		
		
		return null;
		//return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitList(@NotNull RIFBLDParser.ListContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitEqual(@NotNull RIFBLDParser.EqualContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitUniterm(@NotNull RIFBLDParser.UnitermContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitConst1(@NotNull RIFBLDParser.Const1Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitR(@NotNull RIFBLDParser.RContext ctx) {
		//return visitDocument(ctx.document());
		return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitIrimeta(@NotNull RIFBLDParser.IrimetaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitAtomic(@NotNull RIFBLDParser.AtomicContext ctx) {
		value = new Value(ctx);		
		return value;
		
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitMember(@NotNull RIFBLDParser.MemberContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitSubclass(@NotNull RIFBLDParser.SubclassContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitAngle(@NotNull RIFBLDParser.AngleContext ctx) { return visitChildren(ctx); }
	//---------------------visit formula----------------------------------
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitAndFormula(@NotNull RIFBLDParser.AndFormulaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitOrFormula(@NotNull RIFBLDParser.OrFormulaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitExistsFormula(@NotNull RIFBLDParser.ExistsFormulaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitAtomicFormula(@NotNull RIFBLDParser.AtomicFormulaContext ctx) {
		
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitExternalFormula(@NotNull RIFBLDParser.ExternalFormulaContext ctx) { return visitChildren(ctx); }
	//---------------------end of visit formula----------------------------------
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitTerm(@NotNull RIFBLDParser.TermContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitImplies(@NotNull RIFBLDParser.ImpliesContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitSymspace(@NotNull RIFBLDParser.SymspaceContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitBase(@NotNull RIFBLDParser.BaseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitGroup(@NotNull RIFBLDParser.GroupContext ctx) { 
		
		//Queue<String> head_tokens = new LinkedList<String>();
		
		Queue<VarsValues> bindings = new LinkedList<VarsValues>();
		ParseTree  body, childr; //childr = child of group that is a rule
		ImpliesContext implies;
		//List<AtomicContext> head = new ArrayList<AtomicContext>();
		
		//find rules
		int childCount =ctx.getChildCount();
		for(int i=0; i<childCount ; i++){
			childr = ctx.getChild(i) ;
			if(childr instanceof RIFBLDParser.ForallContext){
				//read rule body (antecedent)
				implies = ((RIFBLDParser.ForallContext) childr).clause().implies();
				body = implies.formula();
				
				bindings = util.bindFormula(body, bindings);
				///System.out.println(util.bindingstoString(bindings));
				//remove the repeated bindings from the list 
				//bindings = util.trimBindings(bindings);
				//System.out.println(util.bindingstoString(bindings));
				//ADD NEW FACTS (if there is any) TO THE KB
				util.addNewFacts(bindings, implies);
				//update no of children of Group element
				childCount =ctx.getChildCount();
				
				///System.out.println("updated group size="+ctx.getChildCount()+"|updated group="+ util.getTokens(ctx).toString());
				//clear the bindings after done with a rule
				bindings.clear();
			}//if formula
				
		}//for
		return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Value visitFrame(@NotNull RIFBLDParser.FrameContext ctx) { return visitChildren(ctx); }

}
