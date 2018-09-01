/**
 * 
 */
package iakbari.ruletranslator.translator;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import iakbari.ruletranslator.parsers.RIFBLDBaseVisitor;
import iakbari.ruletranslator.parsers.RIFBLDParser.AndFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.AngleContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.AtomicContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.AtomicFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.BaseContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ClauseContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.Const1Context;
import iakbari.ruletranslator.parsers.RIFBLDParser.ConstshortContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.DocumentContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.EqualContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ExistsFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ExternalFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FactContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ForallContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FrameContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.GroupContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ImpliesContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.Import1Context;
import iakbari.ruletranslator.parsers.RIFBLDParser.IrimetaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ListContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.MemberContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.OrFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.PrefixContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.RContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.SubclassContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.SymspaceContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.TermContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.UnitermContext;

/**
 * @author Ismail Akbari
 *
 */
public class FormatReasoningResult extends RIFBLDBaseVisitor<String> {

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitConstshort(iakbari.ruletranslator.parsers.RIFBLDParser.ConstshortContext)
	 */
	@Override
	public String visitConstshort(ConstshortContext ctx) {
		 
		return super.visitConstshort(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitFact(iakbari.ruletranslator.parsers.RIFBLDParser.FactContext)
	 */
	@Override
	public String visitFact(FactContext ctx) {
		 
		return super.visitFact(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitPrefix(iakbari.ruletranslator.parsers.RIFBLDParser.PrefixContext)
	 */
	@Override
	public String visitPrefix(PrefixContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrefix(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitDocument(iakbari.ruletranslator.parsers.RIFBLDParser.DocumentContext)
	 */
	@Override
	public String visitDocument(DocumentContext ctx) {
		 
		return super.visitDocument(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitAndFormula(iakbari.ruletranslator.parsers.RIFBLDParser.AndFormulaContext)
	 */
	@Override
	public String visitAndFormula(AndFormulaContext ctx) {
		 
		return super.visitAndFormula(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitOrFormula(iakbari.ruletranslator.parsers.RIFBLDParser.OrFormulaContext)
	 */
	@Override
	public String visitOrFormula(OrFormulaContext ctx) {
		 
		return super.visitOrFormula(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitConst1(iakbari.ruletranslator.parsers.RIFBLDParser.Const1Context)
	 */
	@Override
	public String visitConst1(Const1Context ctx) {
		 
		return super.visitConst1(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitIrimeta(iakbari.ruletranslator.parsers.RIFBLDParser.IrimetaContext)
	 */
	@Override
	public String visitIrimeta(IrimetaContext ctx) {
		 
		return super.visitIrimeta(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitMember(iakbari.ruletranslator.parsers.RIFBLDParser.MemberContext)
	 */
	@Override
	public String visitMember(MemberContext ctx) {
		 
		return super.visitMember(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitAngle(iakbari.ruletranslator.parsers.RIFBLDParser.AngleContext)
	 */
	@Override
	public String visitAngle(AngleContext ctx) {
		 
		return super.visitAngle(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitTerm(iakbari.ruletranslator.parsers.RIFBLDParser.TermContext)
	 */
	@Override
	public String visitTerm(TermContext ctx) {
		 
		return super.visitTerm(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitSymspace(iakbari.ruletranslator.parsers.RIFBLDParser.SymspaceContext)
	 */
	@Override
	public String visitSymspace(SymspaceContext ctx) {
		 
		return super.visitSymspace(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitGroup(iakbari.ruletranslator.parsers.RIFBLDParser.GroupContext)
	 */
	@Override
	public String visitGroup(GroupContext ctx) {
		 
		return super.visitGroup(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitClause(iakbari.ruletranslator.parsers.RIFBLDParser.ClauseContext)
	 */
	@Override
	public String visitClause(ClauseContext ctx) {
		 
		return super.visitClause(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitImport1(iakbari.ruletranslator.parsers.RIFBLDParser.Import1Context)
	 */
	@Override
	public String visitImport1(Import1Context ctx) {
		 
		return super.visitImport1(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitForall(iakbari.ruletranslator.parsers.RIFBLDParser.ForallContext)
	 */
	@Override
	public String visitForall(ForallContext ctx) {
		 
		return super.visitForall(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitExistsFormula(iakbari.ruletranslator.parsers.RIFBLDParser.ExistsFormulaContext)
	 */
	@Override
	public String visitExistsFormula(ExistsFormulaContext ctx) {
		 
		return super.visitExistsFormula(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitAtomicFormula(iakbari.ruletranslator.parsers.RIFBLDParser.AtomicFormulaContext)
	 */
	@Override
	public String visitAtomicFormula(AtomicFormulaContext ctx) {
		 
		return super.visitAtomicFormula(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitList(iakbari.ruletranslator.parsers.RIFBLDParser.ListContext)
	 */
	@Override
	public String visitList(ListContext ctx) {
		 
		return super.visitList(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitEqual(iakbari.ruletranslator.parsers.RIFBLDParser.EqualContext)
	 */
	@Override
	public String visitEqual(EqualContext ctx) {
		 
		return super.visitEqual(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitUniterm(iakbari.ruletranslator.parsers.RIFBLDParser.UnitermContext)
	 */
	@Override
	public String visitUniterm(UnitermContext ctx) {
		 
		return super.visitUniterm(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitR(iakbari.ruletranslator.parsers.RIFBLDParser.RContext)
	 */
	@Override
	public String visitR(RContext ctx) {
		 
		//System.out.println(ctx.toString());
		return super.visitR(ctx);
		
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitAtomic(iakbari.ruletranslator.parsers.RIFBLDParser.AtomicContext)
	 */
	@Override
	public String visitAtomic(AtomicContext ctx) {
		 
		return super.visitAtomic(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitSubclass(iakbari.ruletranslator.parsers.RIFBLDParser.SubclassContext)
	 */
	@Override
	public String visitSubclass(SubclassContext ctx) {
		 
		return super.visitSubclass(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitImplies(iakbari.ruletranslator.parsers.RIFBLDParser.ImpliesContext)
	 */
	@Override
	public String visitImplies(ImpliesContext ctx) {
		 
		return super.visitImplies(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitExternalFormula(iakbari.ruletranslator.parsers.RIFBLDParser.ExternalFormulaContext)
	 */
	@Override
	public String visitExternalFormula(ExternalFormulaContext ctx) {
		 
		return super.visitExternalFormula(ctx);
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitBase(iakbari.ruletranslator.parsers.RIFBLDParser.BaseContext)
	 */
	@Override
	public String visitBase(BaseContext ctx) {
		 
		return super.visitBase(ctx)+"\n";
	}

	/* (non-Javadoc)
	 * @see iakbari.ruletranslator.parsers.RIFBLDBaseVisitor#visitFrame(iakbari.ruletranslator.parsers.RIFBLDParser.FrameContext)
	 */
	@Override
	public String visitFrame(FrameContext ctx) {
		 
		return super.visitFrame(ctx);
	}
	/** by default visit method returns null. so to fix this issue we override the 2 following methods
	* these 2 methods are in AbstractParseTreeVisitor<T> class which BaseVisitor<T> extends.
	* 
	* The generated parse tree visitor extends AbstractParseTreeVisitor, which has two methods which 
	* would be helpful to override to get the result you are looking for.
	* Firstly, AbstractParseTreeVisitor#defaultResult() returns the default result for every node 
	* in the parse tree you visit. By default, it returns null.
	* Second, AbstractParseTreeVisitor#aggregateResult(T,T) aggregates the last node's 
	* visited result with the total result so far.
	* 
	*/
	
	@Override public String defaultResult(){
		return "";
	}
	
	@Override public String aggregateResult(String aggregate, String nextResult){
		if (aggregate == null) {
	        return nextResult;
	    }

	    if (nextResult == null) {
	        return aggregate;
	    }
	    StringBuilder sb = new StringBuilder(aggregate);
		sb.append(nextResult + " ");
	    /*
	    StringBuilder sb = new StringBuilder();
	   
	    if(nextResult.trim().matches("[\\(\\)\\[\\]]")) //any of ( ) [ ] characters.
	    	sb.append(aggregate.trim() + nextResult);
	    else
	    	if(nextResult.trim().equalsIgnoreCase("Group"))
	    		sb.append(aggregate + "\r\n" + nextResult + " ");
	    	else
	    		sb.append(aggregate + nextResult + " ");
	    */		
	    return sb.toString();
	}
	
	
	@Override public String visitChildren(RuleNode node){
		//String result = defaultResult();
		String result = "";
		int n = node.getChildCount();
		for (int i=0; i<n; i++) {
			if (!shouldVisitNextChild(node, result)) {
				break;
			}

			ParseTree c = node.getChild(i);
			String childResult = c.accept(this);
			result = aggregateResult(result, childResult);
		}

		return result;
		
	}
	
	@Override public String visitTerminal(TerminalNode node){
		String s = node.getText();
		//if(node instanceof N3_qnameContext)
			//return "prefix " + node.getText();
		if(s.charAt(0) == ':')
			s = "local" + s;
		//return node.getText();
		return s;
	}
	
	

}
