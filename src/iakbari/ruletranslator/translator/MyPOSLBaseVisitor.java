package iakbari.ruletranslator.translator;

import iakbari.ruletranslator.parsers.POSLBaseVisitor;
import iakbari.ruletranslator.parsers.POSLParser;
import iakbari.ruletranslator.parsers.POSLParser.AtomContext;
import iakbari.ruletranslator.parsers.POSLParser.Atom_altContext;
import iakbari.ruletranslator.parsers.POSLParser.Pos_altContext;
import iakbari.ruletranslator.parsers.POSLParser.SlotContext;
import iakbari.ruletranslator.parsers.POSLParser.TermContext;
import iakbari.ruletranslator.parsers.POSLParser.VarContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * 
 * @author iakbari
 *  A term in POSL can be either an ind, var, cterm, skolem, or plex (see POSL grammar POSL.g4).
 *  Since ind, var, skolem, and cterm can have types (e.g. var:  QMARK (symbol)? (COLON type)?; see POSL grammar )
 *  they will converted to a unary predicate with the type as the predicate name and
 *  the term as the predicate argument. In other owrds, they will be converted to a uniterm in RIF-BLD.
 *  For example the teaches(?t:teacher "Math") in POSL will be converted to teaches(teacher(?t) "Math").
 *  since the member atom can not be a predicate argument in RIF-BLD, converting the above atom to 
 *  'teaches(?t#teacher "Math")' is not syntactically correct. However, the above atom can be also converted 
 *  to two following atoms:
 *  teaches(?t "Math") teacher(?t)
 *  Therefore, while converting a POSL term to a RIF-BLD term, 
 *  whenever the term has a type, it will be converted to a uniary predicate.
 *  see {@link #visitCterm}, {@link #visitInd}, {@link #visitSkolem}, and {@link #visitVar}.     
 */
public class MyPOSLBaseVisitor extends POSLBaseVisitor<String> {

	public MyPOSLBaseVisitor() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAtom_alt(@NotNull POSLParser.Atom_altContext ctx) { 
		//System.out.println("in atom_alt");
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSrest_alt(@NotNull POSLParser.Srest_altContext ctx) { 
		//System.out.println("in srest_alt");
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPos_alt(@NotNull POSLParser.Pos_altContext ctx) { 
		//System.out.println("in pos_alt");
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSlots_alt(@NotNull POSLParser.Slots_altContext ctx) {
		//System.out.println("in slots_alt");
		return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrest_alt(@NotNull POSLParser.Prest_altContext ctx) {
		//System.out.println("in prest_alt");
		return visitChildren(ctx); }
	//-----------------------------------------------------------------------------------
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSymbol(@NotNull POSLParser.SymbolContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//@Override public String visitPs(@NotNull POSLParser.PsContext ctx) { return visitChildren(ctx); }
	public String visitPs(@NotNull POSLParser.PsContext ctx) { 
		//System.out.println("in Ps. #children= "+ ctx.getChildCount() +"|"+ ctx.getClass().getSimpleName());
		 
		if(ctx instanceof POSLParser.Atom_altContext)
			return visitAtom_alt((POSLParser.Atom_altContext)ctx);
		
		if(ctx instanceof POSLParser.Srest_altContext)
			return visitSrest_alt((POSLParser.Srest_altContext)ctx);
		
		if(ctx instanceof POSLParser.Pos_altContext)
			return visitPos_alt((POSLParser.Pos_altContext)ctx);
		
		if(ctx instanceof POSLParser.Slots_altContext)
			return visitSlots_alt((POSLParser.Slots_altContext)ctx);
		
		if(ctx instanceof POSLParser.Prest_altContext)
			return visitPrest_alt((POSLParser.Prest_altContext)ctx);
		
		//return visitChildren(ctx);
		return null;
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRole(@NotNull POSLParser.RoleContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * skolem : USCORE (symbol)? (COLON type)? ;
	 * type is converted to unary predicate.
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSkolem(@NotNull POSLParser.SkolemContext ctx) { 
		String s="";
		s = "_" ; //s = POSLLexer.USCORE ;
		if(ctx.symbol()!=null)
			s+= visitSymbol(ctx.symbol());
		if(ctx.type()!=null)
			s= visitType(ctx.type()) + "(" + s + ")" ;
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * oid : term HAT ;// oid : term '^' ;
	 * oid is translated to irimeta for an atom. this irimeta will be 
	 * irimeta of an atomic formula in RIF: 
  	 * irimeta  : '(*' IRICONST? (frame | 'And' '(' frame* ')')? '*)'	;
  	 * atomic   : irimeta? ( equal | member | subclass | uniterm | frame)	;
  	 * uniterm  : const1 ('(' (term* | (NCName '->' term)*) ')')	;
	 * 
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitOid(@NotNull POSLParser.OidContext ctx) { 
		return visitTerm(ctx.term());
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * slot : role ARROW term ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSlot(@NotNull POSLParser.SlotContext ctx) {	
		return visitRole(ctx.role()) + " " + visitTerminal(ctx.ARROW()) +  " " + visitTerm(ctx.term()) ;
		//return visitChildren(ctx); 		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitType(@NotNull POSLParser.TypeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * srest : BANG (var | slotplex) ; BANG is !
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSrest(@NotNull POSLParser.SrestContext ctx) { 
		if(ctx.var()!=null)
			return visitVar(ctx.var());
		return visitSlotplex(ctx.slotplex());
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * atoms : atom (COMMA atom)* ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAtoms(@NotNull POSLParser.AtomsContext ctx) { 
		String s="";
		int i;
		//check if atoms has more than 1 atom child
		if(ctx.getChildCount()>1){ //ctx has more than 1 atom 
			s+="\r\nAnd(\r\n" ;
			for(i=0; i<ctx.getChildCount(); i++)
				if(ctx.getChild(i) instanceof AtomContext)
					s+= "\t"+visitAtom((AtomContext)ctx.getChild(i))+"\r\n";
			//s = s.substring(0, s.length()-2);
			s+=")";
			return s;
		}	
		return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * pos : term (COMMA term)* ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPos(@NotNull POSLParser.PosContext ctx) { 
		String s = "";
		for(int i=0; i<ctx.getChildCount(); i++){
			ParseTree child = ctx.getChild(i);
			if(child instanceof TermContext)
				s+=" " + visitTerm((TermContext)child);
		}
		return s;	
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitRel(@NotNull POSLParser.RelContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * term : ind | var | cterm | skolem | plex ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitTerm(@NotNull POSLParser.TermContext ctx) { 
		return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 *	prest : PIPE (var | posplex) ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrest(@NotNull POSLParser.PrestContext ctx) {
		if(ctx.var()!=null)
			return visitVar(ctx.var());
		return visitPosplex(ctx.posplex()); 
		
	}
	/**
	 * {@inheritDoc}
	 * plex can be positional, slotted or positional/slotted.
	 * plex is a special case of cterm (cterm without ctor or constrcutor name) 
	 * example:
	 * stakepair[MM,SS] is a plex version of stakepair[MM,SS] positional cterm.
	 * so to translate plex , it is first converted to cterm by adding "plex" literal to the beginning of the plex
	 * plex and cterms are converted to regular atoms (brackets to parenthesis).
	 * In other words stakepair[MM,SS] is as treated stakepair(MM,SS).
	 * plex : LBRACK (ps)? RBRACK ;
	 * is converted to:
	 * plex : 'plex' '(' (ps)? ')' ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPlex(@NotNull POSLParser.PlexContext ctx) { 
		if(ctx.ps()==null)
			return "";
		String s="";
		s = "plex(" + visitPs(ctx.ps()) + ")" ;
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * ind : (symbol (uri)? | uri) (COLON type)? ;
	 * type is converted to unary predicate
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitInd(@NotNull POSLParser.IndContext ctx) { 
		String s="";
		if(ctx.symbol()!=null)
			s+= visitSymbol(ctx.symbol());
		if(ctx.uri()!=null)
			s+= visitUri(ctx.uri());
		if(ctx.type()!=null)
			s= visitType(ctx.type())  + "(" + s + ")" ; 
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * first it needs to be determined if clause is a fact or a rule by checking ':-' availability in clause
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitClause(@NotNull POSLParser.ClauseContext ctx) {
		String s="" ;
		//check if clause is a fact or a rule
		
		if (ctx.IMP()!=null){ //rule
						
			Set<String> vars = getVars(ctx);
			s = "Forall";
			for(String v: vars)
				s+= " "+ v;
			s+= "(\r\n" ;
			String head = visitAtom(ctx.atom());
			String body = visitAtoms(ctx.atoms());
			s+= head +" :- " +body ; //rif rule
			s+="\r\n)\r\n";
			return s;
		}
		//fact
		s += visitAtom(ctx.atom()) + "\r\n" ;
		return s;
		//return visitChildren(ctx); 
		
	}
	
	/**
	 * {@inheritDoc}
	 * plex and cterms are converted to regular positional atoms (brackets to parenthesis)
	 * slotplex will be converted to uniterm. 'slotplex' constant is added to change
	 * slotted plex to slotted cterm 
	 * slotplex : LBRACK (slots)? (srest)? RBRACK ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSlotplex(@NotNull POSLParser.SlotplexContext ctx) {
		String s="";
		s = "slotplex(";
		if(ctx.slots() != null)
			s+= visitSlots(ctx.slots());
		s+=" " ;
		if(ctx.srest() !=null)
			s+= visitSrest(ctx.srest());
		s+=")";
		if(s.equalsIgnoreCase("( )")) //if slotplex had none of slots or srest
				s=""; 
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * cterm or complex term can be positional, slotted or positional/slotted.
	 * plex is a special case of cterm (cterm without ctor or constrcutor name)
	 * example:
	 * stakepair[MM,SS] is a positional cterm. cterms are treated same as regular atoms. in other
	 * words stakepair[MM,SS] is as treated stakepair(MM,SS).
	 * cterm : ctor LBRACK (ps)? RBRACK (COLON type)? ;
	 * type is converted to unary predicate
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCterm(@NotNull POSLParser.CtermContext ctx) { 
		String s="";
		s = visitCtor(ctx.ctor()) + "(";
		if(ctx.ps()!=null)
			s+= visitPs(ctx.ps());
		s+=")" ;
		if(ctx.type()!=null)
			s+= visitType(ctx.type())  + "(" + s + ")" ;
			//s+= POSLLexer.COLON + visitType(ctx.type());  	
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * var : QMARK (symbol)? (COLON type)? ;
	 * type is converted to class membership. Since variable in
	 * RIF can not be a member (of a class) then if a var here had a type, 
	 * it will be converted to a uniary predicate with the var as argument and the
	 * type as the predicate's name.
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVar(@NotNull POSLParser.VarContext ctx) {	
		String s="?";
		if(ctx.symbol()!=null)
			s+= visitSymbol(ctx.symbol());
		
		if(ctx.type()!=null)
			s= visitType(ctx.type()) + "(" + s + ")" ; 
		return s;
		//return visitChildren(ctx); 		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitUri(@NotNull POSLParser.UriContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * plex and cterms add converted to regular positional atoms (brackets to parenthesis)
	 * posplex : LBRACK (pos)? (prest)? RBRACK ;
	 * posplex will be converted to uniterm. 'posplex' constant is added to change
	 * positional plex to positional cterm  
	 * in RIF:
	 * 		uniterm: const1 ('(' (term* | (NCName '->' term)*) ')')	;
	 * example:
	 * [Jack, John] regarding stakeholders[Jack, John].
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPosplex(@NotNull POSLParser.PosplexContext ctx) { 
		String s="";
		s = "posplex(";
		if(ctx.pos() != null)
			s+= visitPos(ctx.pos());
		s+=" " ;
		if(ctx.prest() !=null)
			s+= visitPrest(ctx.prest());
		s+=")";
		if(s.equalsIgnoreCase("( )")) //if posplex had at least pos or prest
				s=""; 
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * every atom in POSL in converted to uniterm in RIF
	 * in RIF:
	 * 		uniterm: const1 ('(' (term* | (NCName '->' term)*) ')')	;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitR(@NotNull POSLParser.RContext ctx) {
		
		return "Document(\r\nGroup(\r\n" + visitChildren(ctx) + "\r\n))";		
	}
	/**
	 * {@inheritDoc}
	 * slots : slot (SEMI slot)* ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSlots(@NotNull POSLParser.SlotsContext ctx) { 
		String s = "";
		for(int i=0; i<ctx.getChildCount(); i++){
			ParseTree child = ctx.getChild(i);
			if(child instanceof SlotContext)
				s+=" " + visitSlot((SlotContext)child);
		}
		return s;
		//return visitChildren(ctx); 		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCtor(@NotNull POSLParser.CtorContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * atom : rel LPAREN oid? (ps)? RPAREN ;
	 * oid is translated to irimeta for an atom. this irimeta will be irimeta of an atomic formula in RIF: 
  	 * irimeta  : '(*' IRICONST? (frame | 'And' '(' frame* ')')? '*)'	;
  	 * atomic   : irimeta? ( equal | member | subclass | uniterm | frame)	;
  	 * uniterm  : const1 ('(' (term* | (NCName '->' term)*) ')')	;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAtom(@NotNull POSLParser.AtomContext ctx) {	
		String s = "";
		if(ctx.oid()!=null)
			s = "(*" + visitOid(ctx.oid()) + "*)" ;
		s=  visitRel(ctx.rel()) + ctx.LPAREN() + visitPs(ctx.ps()) + ctx.RPAREN() ;
		//s = updateAtom(s);
		return s;
		//return visitChildren(ctx);
		
	}
	
	/** by default visit methods in BaseVisitor Superclass return null.
	 *  so to fix this issue we override two following methods.
     * these methods are in AbstractParseTreeVisitor<T> class which BaseVisitor<T> extends it.
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
	    //sb.append(" ");
	    sb.append(nextResult);

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
		return node.getText();		
	}
	/**
	 * 
	 * @param context
	 * A POSL rule
	 * @return
	 * returns a list of variables in the rule. variables are in the form of e.g. ?x  
	 */
	private Set<String> getVars(ParseTree ctx) {
		// TODO Auto-generated method stub
		//Utils u = new Utils();
		//List<Token> tokens = new ArrayList<Token>(u.getFlatTokenList(ctx));
		Set<String> vars = new HashSet<String>();
		String var ="";
		// Iterate over all child nodes of `parent`.
	    for (int i = 0; i < ctx.getChildCount(); i++) {

	        // Get the i-th child node of `parent`.
	        ParseTree child = ctx.getChild(i);

	        if (child instanceof VarContext) {
	        	//check if the variable has a type. for example ?t:teacher
	        	var = child.getText().split(":")[0];
	            vars.add(var); 
	        }
	        else {
	            vars.addAll(getVars(child));
	        }
	    }			
		return vars;
	}
	
	/**
	 * 
	 * @param atom : POSL atom translated to RIF-BLD atom.
	 * This method deals with predicate arguments that have a 
	 * type in an atom (e.g. variable ?t in teaches( ?t:teacher 'Math') ). Steps include:
	 *  A. the type will be removed from the variable
     *  B. a new atom will be added (type atom). for example teacher(?t).
     *  C. by adding the new atom, the number of atoms will become 2. 
     *  So they are conjuncted (using 'And').
	 * @return
	 */
	private String updateAtom(String atom) {
		return null;
	}
	
	/**
	 * update the initial translation of POSL to RIF-BLD. Update includes dealing with predicate arguments that have a type(e.g. variable ?t in teaches( ?t:teacher 'Math') ).
	 * There will be 3 situations: predicate arguments with a type in a rule body, rule head or in a fact.
     * <p>1. If a predicate argument in a rule body has a type:<br>
     * 	A. the type will be removed from the variable
     *  B. a new atom will be added to the atoms in the body
     *  C. by adding the new atom, the number of atoms in the body will be at least 2. so if the atoms are not conjuncted, they will be (using And).
     * </p>
     * 
     * <p>2. If a predicate argument in a rule head has a type:</p>
     * <p>3. If a predicate argument in a fact has a type:</p>
     * Also if a  rule has more than one statement then they should be 'And' ed.</p>  
       
	 * @param translation
	 * initial translation of N3 to RIF-BLD.
	 *  
	 * @return
	 * updated translation
	 */ 
	public String updateTranslation2(String translation) {
		
		return null;
	}
}
