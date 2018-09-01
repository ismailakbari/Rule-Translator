package iakbari.ruletranslator.translator;

import iakbari.ruletranslator.parsers.POSLParser.VarContext;
import iakbari.ruletranslator.parsers.RIFBLDBaseVisitor;
import iakbari.ruletranslator.parsers.RIFBLDLexer;
import iakbari.ruletranslator.parsers.RIFBLDParser;
import iakbari.ruletranslator.parsers.RIFBLDParser.AtomicContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FrameContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ImpliesContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.IrimetaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.PrefixContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.TermContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * <p>
 * This class translated RIF-BLD rules in presentation syntax to their
 * equivalent XML-based syntax. 
 * </p>
 * This class provides extends {@link RIFBLDBaseVisitor},
 * which creates a visitor which only needs to handle a subset
 * of the available methods. 
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class RIFBLD_PRES2XML extends RIFBLDBaseVisitor<String> {

	public RIFBLD_PRES2XML() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * {@inheritDoc}
	 * constshort      : ANGLEBRACKIRI              // shortcut for "..."^^rif:iri
                  | CURIE                      // shortcut for "..."^^rif:iri
                  | UNICODESTRING
                  | UNICODE   
                  | NCName                     // shortcut for "..."^^rif:local 
                  | NumericLiteral        ;    // shortcut for "..."^^xs:integer,xs:decimal,xs:double
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitConstshort(@NotNull RIFBLDParser.ConstshortContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * rule1          : (irimeta? 'Forall' Var+ '(' clause ')') 		#forall	 
  	 *				| clause	#fact
  	 * # sign creates separate enter/exit methods for that alternative e.g. enterForall/exitForall				
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFact(@NotNull RIFBLDParser.FactContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrefix(@NotNull RIFBLDParser.PrefixContext ctx) { 
		String uri = visitTerminal(ctx.ANGLEBRACKIRI());
		//String uri = ctx.ANGLEBRACKIRI().getText();
		//uri = uri.substring(1, uri.length()-1); //remove < and > from start and end of the angle bracket iri 
		String s = ctx.NCName().getText() +"\t" + "\"" + uri + "\""; 
		//return visitChildren(ctx);
		return s;
		
	}
	/**
	 * {@inheritDoc}
	 * document   : irimeta? 'Document' '(' base? prefix* import1* group? ')'	;
	 * 'base' is translated to <Document xml:base="...">
	 * 'prefix' is translated to DOCTYPE ENTITY and is placed before &lt;Document&gt; tag.
	 * 'irimeta' is translated to  
	 * &lt;Document&gt;
	 *  &lt;id&gt;χbld(iriconst)&lt;/id&gt;?
  	 *	&lt;meta&gt;χbld(frameconj)&lt;/meta&gt;?
  	 * &lt;/Document&gt;
  	 * import is translated to directive tag
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * @see iakbari.RIFBLDBaseVisitor#visitDocument(iakbari.RIFBLDParser.DocumentContext)
	 * 'irimeta' is translated to id and meta tags and they will be added as <Document> first and second children  
	 * <Document>
	   	<id>χbld(iriconst)</id>?
  	 	<meta>χbld(frameconj)</meta>?
  	 	.
  	 	.
  	 	.
  	  </Document>
  	 * Import(loc1 prfl1?) is translated to 
  	 * <Document>
  	 *  <directive>
	     <Import>
	       <location>χbld(loc1)</location>
	       <profile>χbld(prfl1)</profile>?
	     </Import>
  	    </directive>
  	   </Document>
	 */
	@Override public String visitDocument(@NotNull RIFBLDParser.DocumentContext ctx) { 
		String s ="";
		//prefix
		String doctype = "<!DOCTYPE Document [" ;
		doctype += "\r\n" + "<!ENTITY rif  \"http://www.w3.org/2007/rif#\">" ; //add rif as an entity
		if(!ctx.prefix().isEmpty()){ //if document has prefix they will be defined as doctype entity
			for(int i=0; i<ctx.prefix().size(); i++)
				//doctype += "\r\n" + "<!ENTITY " + prefix.NCName() +"\t" + prefix.ANGLEBRACKIRI() + ">" ;
				doctype += "\r\n" + "<!ENTITY " + visitPrefix(ctx.prefix(i)) + ">" ;
		}
		doctype += "\r\n]>";
		s += doctype + "\r\n";
		
		//base
		s+= "<Document\r\n" ;
		String docAtts ="";
		if(ctx.base()!=null)
			docAtts+= "xml:base=\"" + visitBase(ctx.base()) +"\"" + "\r\n"  ;		
		docAtts+= "xmlns=\"http://www.w3.org/2007/rif#\""  +
		   "\r\n" +  "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
		   "\r\n" +  "xmlns:xs=\"http://www.w3.org/2001/XMLSchema#\"" ;
		s+= docAtts + ">";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		
		//import
		List<RIFBLDParser.Import1Context> importList = ctx.import1();
		if(!importList.isEmpty())
			for(int i=0; i<importList.size(); i++)
				s+= "\r\n" +visitImport1(ctx.import1(i)) ;
		//group
		if(ctx.group()!=null)
			s+="\r\n<payload>" + visitGroup(ctx.group()) + "\r\n</payload>"; 
		s+="\r\n</Document>";
		//return visitChildren(ctx);
		return s;
		
	}
	/**
	 * {@inheritDoc}
	 * /Condition Language:
  	 * formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
  	 *		 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  	 *		 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  	 *		 	   | atomic 								#atomicFormula
  	 *		 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  	 *		 	 ;
  	 *
  	 * And (
     *  conjunct1
     *  . . .
     *  conjunctn
     * )
     * is transformed to
     * &lt;And&gt;
  	 *	&lt;formula&gt;χbld(conjunct1)&lt;/formula&gt;
     *	. . .
  	 *	&lt;formula&gt;χbld(conjunctn)&lt;/formula&gt;
	 * &lt;/And&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * And (
  	  *  conjunct1
      *  . . .
      *  conjunctn
      * )
      * is converted to:
      * <And>
  	  *	<formula>χbld(conjunct1)</formula>
      *	. . .
  	  *	<formula>χbld(conjunctn)</formula>
	  * </And>
	  * (non-Javadoc)
	  * @see iakbari.RIFBLDBaseVisitor#visitAndFormula(iakbari.RIFBLDParser.AndFormulaContext)
	  */
	//formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
	@Override public String visitAndFormula(@NotNull RIFBLDParser.AndFormulaContext ctx) { 
		String s="\r\n<And>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		int i, cc = ctx.getChildCount();
		//ParseTree child;
		for(i=0; i<cc; i++)
			if(ctx.getChild(i) instanceof RIFBLDParser.FormulaContext)
				s+="\r\n<formula>" + visit(ctx.getChild(i)) + "\r\n</formula>" ;
		s+="\r\n</And>";
		return s;
		//return visitChildren(ctx); 		
	}
	/**
	 * {@inheritDoc}
	 * /Condition Language:
  	 * formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
  	 *		 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  	 *		 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  	 *		 	   | atomic 								#atomicFormula
  	 *		 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  	 *		 	 ;
  	 *
  	 * Or (
     *  conjunct1
     *  . . .
     *  conjunctn
     * )
     * is transformed to
     * &lt;Or&gt;
  	 *	&lt;formula&gt;χbld(conjunct1)&lt;/formula&gt;
     *	. . .
  	 *	&lt;formula&gt;χbld(conjunctn)&lt;/formula&gt;
	 * &lt;/Or&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * Or (
  	  *  conjunct1
      *  . . .
      *  conjunctn
      * )
      * is converted to:
      * <Or>
  	  *	<formula>χbld(conjunct1)</formula>
      *	. . .
  	  *	<formula>χbld(conjunctn)</formula>
	  * </Or>
	  * (non-Javadoc)
	  * @see iakbari.RIFBLDBaseVisitor#visitAndFormula(iakbari.RIFBLDParser.AndFormulaContext)
	  */
	//formula     : irimeta? 'Or' '(' formula* ')' 		#orFormula 
	@Override public String visitOrFormula(@NotNull RIFBLDParser.OrFormulaContext ctx) { 
String s="\r\n<Or>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		int i, cc = ctx.getChildCount();
		//ParseTree child;
		for(i=0; i<cc; i++)
			if(ctx.getChild(i) instanceof RIFBLDParser.FormulaContext)
				s+="\r\n<formula>" + visit(ctx.getChild(i)) + "\r\n</formula>" ;
		s+="\r\n</Or>";
		return s;
		//return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 * const1       : IRICONST | UNICODESTRING '^^' symspace | constshort	;
	 * "unicodestring"^^symspace
	 * is translated to 
	 * &lt;Const type="symspace"&gt;unicodestring&lt;/Const&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * "unicodestring"^^symspace
	 * is translated to
	 * <Const type="symspace">unicodestring</Const>
	 * @see iakbari.RIFBLDBaseVisitor#visitConst1(iakbari.RIFBLDParser.Const1Context)
	 */
	@Override public String visitConst1(@NotNull RIFBLDParser.Const1Context ctx) { 
		String s="";
		if(ctx.UNICODESTRING()!=null){
			s+= "<Const type=\"" + visitSymspace(ctx.symspace()) +"\">" + visitTerminal(ctx.UNICODESTRING()) + "</Const>";
			return s;
		}			
		return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * Annotations:
     * irimeta    : '(*' IRICONST? (frame | 'And' '(' frame* ')')? '*)'	;
     * (* iriconst? frameconj? *)
     * is transformed to
     * &lt;id&gt;χbld(iriconst)&lt;/id&gt;?
     * &lt;meta&gt;χbld(frameconj)&lt;/meta&gt;?
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * Annotations:
     * irimeta    : '(*' IRICONST? (frame | 'And' '(' frame* ')')? '*)'	;
     * (* iriconst? frameconj? *)
     * is transformed to
     * <id>χbld(iriconst)</id>?
     * <meta>χbld(frameconj)</meta>?
	 */
	@Override public String visitIrimeta(@NotNull RIFBLDParser.IrimetaContext ctx) { 
		String s="";
		
		//iriconst
		if(ctx.IRICONST()!=null)
			s+="\r\n<id>" + visitTerminal(ctx.IRICONST()) + "</id>" ;
		
		//frame
		s+="\r\n<meta>";
		//if irimeta is a conjunction of frames
		//if(ctx.getTokens(RIFBLDLexer.T__15).size()==1) // T__15 = 'And' token
		List<FrameContext> frames = ctx.frame();
		if(frames.size()>1){ //conjunction
			s+="\r\n<And>";			 
			for(int i=0; i<frames.size(); i++)
				s+="\r\n<formula>" + visitFrame(frames.get(i)) + "\r\n</formula>" ;
			s+="\r\n</And>";
		}
		else
			s+="\r\n" + visitFrame(frames.get(0));//has one frame context
		
		s+="\r\n</meta>";
		return s;		
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * member   : term '#' term	;
	 * inst # class
	 * is transformed to
	 * &lt;Member&gt;
     *  &lt;instance&gt;χbld(inst)&lt;/instance&gt;
     *  &lt;class&gt;χbld(class)&lt;/class&gt;
     * &lt;/Member&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
	 * member   : term '#' term	;
	 * inst # class
	 * is transformed to
	 * <Member>
     *  <instance>χbld(inst)</instance>
     *  <class>χbld(class)</class>
     * </Member>
	 * @see iakbari.RIFBLDBaseVisitor#visitEqual(iakbari.RIFBLDParser.EqualContext)
	 */
	@Override public String visitMember(@NotNull RIFBLDParser.MemberContext ctx) { 
		String s="\r\n<Member>";
		
		//irimeta
		//irimeta should be grabbed from ctx parent which is 'atomic' context
		String meta ="";
		IrimetaContext irimeta= ((RIFBLDParser.AtomicContext)ctx.parent).irimeta() ; 
		if(irimeta!=null){
			meta = visitIrimeta(irimeta);	
			s+="\r\n" + meta ;
		}
		s+="\r\n<instance>" + visitTerm(ctx.term(0)) + "\r\n</instance>" ;
		s+="\r\n<class>" + visitTerm(ctx.term(1)) + "\r\n</class>" ;
		s+="\r\n</Member>";
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * angle	: ANGLEBRACKIRI ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAngle(@NotNull RIFBLDParser.AngleContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
	 * uniterm is a predicate and 'External' '(' uniterm ')' is a function.
	 * External is processed here. the rest of alternatives will be processed in their own methods.
	 * External (
     *  atomexpr
     * )
     * is translated to
     * &lt;External&gt;
     *   &lt;content&gt;χbld(atomexpr)&lt;/content&gt;
     * &lt;/External&gt;
	 * if it has irimeta it will be passed to (processed in) the child 
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * External (
     *  atomexpr
     * )
     * is translated to
     * <External>
     *   <content>χbld(atomexpr)</content>
     * </External>
	 * @see iakbari.RIFBLDBaseVisitor#visitTerm(iakbari.RIFBLDParser.TermContext)
	 */
	 // term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
	@Override public String visitTerm(@NotNull RIFBLDParser.TermContext ctx) { 
		if(!ctx.getTokens(RIFBLDLexer.T__0).isEmpty()){ // token T__0 = 'External'
			String s="\r\n<External>";
			s+="\r\n<content>" + visitUniterm(ctx.uniterm()) + "\r\n</content>" ;
			s+="\r\n</External>";
			return s;
		}
		return visitChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitSymspace(@NotNull RIFBLDParser.SymspaceContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * group          : irimeta? 'Group' '(' (rule1 | group)* ')'	;
	 * Group    =  (nested collection of sentences)
     * sentence =  (sentence role, containing RULE or Group)
     * Group(
  	 *	clause1
   	 *	. . .
  	 *	clausen
     * )
     * is translated to
     * &lt;Group&gt;
  	 *	&lt;sentence&gt;χbld(clause1)&lt;/sentence&gt;
   	 *	. . .
  	 *	&lt;sentence&gt;χbld(clausen)&lt;/sentence&gt;
	 * &lt;/Group&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * Group(
  	 *	 clause1
   	 *	 . . .
  	 *	 clausen
     *  )
     * is translated to
     * <Group>
     *  <sentence>χbld(clause1)</sentence>
     *  . . .
     *  <sentence>χbld(clausen)</sentence>
     * </Group>
	  * (non-Javadoc)
	  * @see iakbari.RIFBLDBaseVisitor#visitGroup(iakbari.RIFBLDParser.GroupContext)
	  * 
	  */
	@Override public String visitGroup(@NotNull RIFBLDParser.GroupContext ctx) { 
		String s = "\r\n<Group>" ;
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		
		//rule or group
		for(int i=0; i<ctx.getChildCount(); i++)
			if(ctx.getChild(i) instanceof RIFBLDParser.Rule1Context || ctx.getChild(i) instanceof RIFBLDParser.GroupContext)
				s+="\r\n<sentence>\r\n" + visit(ctx.getChild(i)) + "\r\n</sentence>" ;
		
		s+= "\r\n</Group>";
		return s;
		//return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 * clause  : implies | atomic		;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitClause(@NotNull RIFBLDParser.ClauseContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * import1         : irimeta? 'Import' '(' LOCATOR PROFILE? ')'	;
	 * in developed g4 grammar is changed to
	 * import1        : irimeta? 'Import' '(' angle angle? ')'	;
  	 * angle	 	  : ANGLEBRACKIRI ; 
  	 * Import(loc1 prfl1?) is converted to 
  	 * &lt;directive&gt;
     *  &lt;Import&gt;
     *   &lt;location&gt;χbld(loc1)&lt;/location&gt;
     *   &lt;profile&gt;χbld(prfl1)&lt;/profile&gt;?
     *  &lt;/Import&gt;
     * &lt;/directive&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * @see iakbari.RIFBLDBaseVisitor#visitImport1(iakbari.RIFBLDParser.Import1Context)
	 * Import(loc1 prfl1?) is converted to 
	 * <directive>
     *  <Import>
     *   <location>χbld(loc1)</location>
     *   <profile>χbld(prfl1)</profile>?
     *  </Import>
     * </directive>
	 */
	@Override public String visitImport1(@NotNull RIFBLDParser.Import1Context ctx) { 
		String s= "<directive>\r\n<Import>\r\n<location>" ;
		String locator = visitAngle(ctx.angle(0));
		s+= locator + "</location>" ;
		if(ctx.angle().size()==2){ //if it has profile
			String profile = visitAngle(ctx.angle(1));
			s+= "\r\n<profile>" + profile + "</profile>";
		}
		s += "\r\n</Import>\r\n</directive>" ;
		return s;		
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * rule1          : (irimeta? 'Forall' Var+ '(' clause ')') 	#forall		 
  	 *				  | clause	#fact
  	 * # sign creates separate enter/exit methods for that alternative e.g. enterForall/exitForall
  	 * Forall
  	 *	variable1
   	 *	. . .
  	 *	variablen (
     *    rule
     * )
     * is transformed to
     * &lt;Forall&gt;
     *   &lt;declare&gt;χbld(variable1)&lt;/declare&gt;
     *   . . .
     *   &lt;declare&gt;χbld(variablen)&lt;/declare&gt;
     *   &lt;formula&gt;χbld(rule)&lt;/formula&gt;
     * &lt;/Forall&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * Forall
  	 *	variable1
   	 *	. . .
  	 *	variablen (
     *    rule
     * )
     * is transformed to
     * <Forall>
  	 *	 <declare>χbld(variable1)</declare>
     *   . . .
     *   <declare>χbld(variablen)</declare>
  	 *   <formula>χbld(rule)</formula>
     * </Forall>
	 * (non-Javadoc)
	 * @see iakbari.RIFBLDBaseVisitor#visitForall(iakbari.RIFBLDParser.ForallContext)
	 */
	@Override public String visitForall(@NotNull RIFBLDParser.ForallContext ctx) { 
		String s="<Forall>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}	
		
		//var
		String var="";
		for(int i=0; i<ctx.getChildCount(); i++)
			if(ctx.getChild(i) instanceof TerminalNode){ //for parser rules use 'ctx.getChild(i) instanceof parser_rule_name'
				TerminalNode tnode = (TerminalNode) ctx.getChild(i);
				if(tnode.getSymbol().getType() == RIFBLDLexer.Var){
					//var = ctx.getChild(i).getText() ; 
					//var = var.substring(1, var.length()); // remove ? sign from the beginning of the variable name
					var = visitTerminal(tnode);
					s+="\r\n<declare>" + var + "</declare>" ;
				}
			}			
		s+="\r\n<formula>" + visitClause(ctx.clause()) + "\r\n</formula>";
		s+="\r\n</Forall>" ;
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * Condition Language:
  	 * formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
  	 *		 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  	 *		 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  	 *		 	   | atomic 								#atomicFormula
  	 *		 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  	 *		 	 ;
  	 *
  	 * Exists
  	  *  variable1
  	  *  . . .
  	  *  variablen (
      *    premise
      *  )
     * is transformed to
     * &lt;Exists&gt;
     *   &lt;declare&gt;χbld(variable1)&lt;/declare&gt;
     *   . . .
     *   &lt;declare&gt;χbld(variablen)&lt;/declare&gt;
     *   &lt;formula&gt;χbld(premise)&lt;/formula&gt;
     * &lt;/Exists&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * Exists
  	  *  variable1
  	  *  . . .
  	  *  variablen (
      *    premise
      *  )
      * is converted to:
      * <Exists>
  	  *  <declare>χbld(variable1)</declare>
      *  . . .
      *  <declare>χbld(variablen)</declare>
      *  <formula>χbld(premise)</formula>
      * </Exists>
	  * (non-Javadoc)
	  * @see iakbari.RIFBLDBaseVisitor#visitAndFormula(iakbari.RIFBLDParser.AndFormulaContext)
	  */
	//formula     : irimeta? 'Exists' Var+ '(' formula ')' #existsFormula 
	@Override public String visitExistsFormula(@NotNull RIFBLDParser.ExistsFormulaContext ctx) { 
		String s="\r\n<Exists>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		
		//var
		String var="";
		for(int i=0; i<ctx.getChildCount(); i++)
			if(ctx.getChild(i) instanceof TerminalNode){ //for parser rules use 'ctx.getChild(i) instanceof parser_rule_name'
				TerminalNode tnode = (TerminalNode) ctx.getChild(i);
				if(tnode.getSymbol().getType() == RIFBLDLexer.Var){
					//var = ctx.getChild(i).getText() ;
					//var = var.substring(1, var.length()); // remove ? sign from the beginning of the variable name
					var = visitTerminal(tnode);
					s+="\r\n<declare>" + var + "</declare>" ;
				}
			}			
		s+="\r\n<formula>" + visit(ctx.formula()) + "\r\n</formula>";
		s+="\r\n</Exists>" ;
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * Condition Language:
  	 * formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
  	 *		 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  	 *		 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  	 *		 	   | atomic 								#atomicFormula
  	 *		 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  	 *		 	 ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAtomicFormula(@NotNull RIFBLDParser.AtomicFormulaContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * list           : 'List' '(' term* ')' | 'List' '(' term+ '|' term ')'	;
	 * 
	 * list in the form of 
	 * (* iriconst? frameconj? *)
     * List (
     *  element1
     *  . . .
     *  elementn
     *  | remainder
     * )
     * is transformed to the
     * &lt;List&gt;
     *  &lt;id&gt;χbld(iriconst)&lt;/id&gt;?
     *  &lt;meta&gt;χbld(frameconj)&lt;/meta&gt;?
     *  &lt;items ordered="yes"&gt;
     *  χbld(element1)
     *  . . .
     *  χbld(elementn)
     *  &lt;/items&gt;
     *  &lt;rest&gt;χbld(remainder)&lt;/rest&gt;
     * &lt;/List&gt;
     * list parent is a term which may have an irimeta.
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * list in the form of 
	 * (* iriconst? frameconj? *)
     * List (
     *  element1
     *  . . .
     *  elementn
     *  | remainder
     * )
     * is transformed to the
     * <List>
     *  <id>χbld(iriconst)</id>?
     *  <meta>χbld(frameconj)</meta>?
     *  <items ordered="yes">
     *  χbld(element1)
     *  . . .
     *  χbld(elementn)
     *  </items>
     *  <rest>χbld(remainder)</rest>
     * </List>
	 * @see iakbari.RIFBLDBaseVisitor#visitList(iakbari.RIFBLDParser.ListContext)
	 * term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
	 * list           : 'List' '(' term* ')' | 'List' '(' term+ '|' term ')'	;
	 */	
	@Override public String visitList(@NotNull RIFBLDParser.ListContext ctx) { 
		String s="\r\n<List>";
		
		//irimeta
		//irimeta should be grabbed from ctx parent which is 'term' context
		String meta ="";
		IrimetaContext irimeta= ((RIFBLDParser.TermContext)ctx.parent).irimeta() ; 
		if(irimeta!=null){
			meta = visitIrimeta(irimeta);	
			s+="\r\n" + meta ;
		}
		s+="\r\n<items ordered=\"yes\">" ;
		List<TermContext> terms = ctx.term();
		//System.out.println("gettoken size="+ ctx.getTokens(RIFBLDLexer.T__13).size()); //T__13 = '|'
		//if the list has rest
		if(ctx.getTokens(RIFBLDLexer.T__13).size()==1){ // token T__13 = 11 =  '|' . see RIFBLD.tokens file
			for(int i=0; i<terms.size()-1; i++)
				s+="\r\n" + visitTerm(terms.get(i));
			s+="\r\n</items>";
			s+="\r\n<rest>" + visitTerm(terms.get(terms.size()-1)) + "\r\n</rest>" ;
		}
		else{
			for(int i=0; i<terms.size(); i++)
				s+="\r\n" + visitTerm(terms.get(i));
			s+="\r\n</items>";
		}
		s+="\r\n</List>" ;
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * equal    : term '=' term	;
	 * left = right
	 * is transfomed to
	 * &lt;Equal&gt;
     *  &lt;left&gt;χbld(left)&lt;/left&gt;
     *  &lt;right&gt;χbld(right)&lt;/right&gt;
     * &lt;/Equal&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
	 * equal    : term '=' term	;
	 * left = right
	 * is transfomed to
	 * <Equal>
     *  <left>χbld(left)</left>
     *  <right>χbld(right)</right>
     * </Equal>
	 * @see iakbari.RIFBLDBaseVisitor#visitEqual(iakbari.RIFBLDParser.EqualContext)
	 */
	@Override public String visitEqual(@NotNull RIFBLDParser.EqualContext ctx) { 
		String s="\r\n<Equal>";
		
		//irimeta
		//irimeta should be grabbed from ctx parent which is 'atomic' context
		String meta ="";
		IrimetaContext irimeta= ((RIFBLDParser.AtomicContext)ctx.parent).irimeta() ; 
		if(irimeta!=null){
			meta = visitIrimeta(irimeta);	
			s+="\r\n" + meta ;
		}
		s+="\r\n<left>" + visitTerm(ctx.term(0)) + "\r\n</left>" ;
		s+="\r\n<right>" + visitTerm(ctx.term(1)) + "\r\n</right>" ;
		s+="\r\n</Equal>";
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * uniterm        : const1 ('(' (term* | (NCName '->' term)*) ')')	;
	 * uniterm can be positional or slotted (named arguments):
	 * pred (
     * )
     * 
     * pred (
     *  argument1
     *  . . .
     *  argumentm
     * )
     * 
     * pred (
     *  name1 -> filler1
     *  . . .
     *  namen -> fillern
     * )
     * 
     * pred (
     *  argument1
     *  . . .
     *  argumentm
     * )
     * is translated to 
     * &lt;Atom&gt;
     *  &lt;op&gt;χbld(pred)&lt;/op&gt;
     *  &lt;args ordered="yes"&gt;
     *   χbld(argument1)
     *   . . .
     *   χbld(argumentm)
     *  &lt;/args&gt;
     * &lt;/Atom&gt;
     * 
     * pred (
     *  name1 -> filler1
     *  . . .
     *  namen -> fillern
     * )
     * is translated to
     * &lt;Atom&gt;
     *  &lt;op&gt;χbld(pred)&lt;/op&gt;
     *  &lt;slot ordered="yes"&gt;
     *   &lt;Name&gt;χbld(name1)&lt;/Name&gt;
     *   χbld(filler1)
     *  &lt;/slot&gt;
     *  . . .
     *  &lt;slot ordered="yes"&gt;
     *   &lt;Name&gt;χbld(namen)&lt;/Name&gt;
     *   χbld(fillern)
     *  &lt;/slot&gt;
     * &lt;/Atom&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * pred (
     *  argument1
     *  . . .
     *  argumentm
     * )
     * is translated to
     * <Atom>
     *  <op>χbld(pred)</op>
     *  <args ordered="yes">
     *   χbld(argument1)
     *   . . .
     *   χbld(argumentm)
     *  </args>
     * </Atom>
     * 
     * pred (
     *  name1 -> filler1
     *  . . .
     *  namen -> fillern
     * )
     * is translated to
     * <Atom>
     *  <op>χbld(pred)</op>
     *  <slot ordered="yes">
     *   <Name>χbld(name1)</Name>
     *   χbld(filler1)
     *  </slot>
     *  . . .
     *  <slot ordered="yes">
     *   <Name>χbld(namen)</Name>
     *   χbld(fillern)
     *  </slot>
     * </Atom>
     * 
	 * @see iakbari.RIFBLDBaseVisitor#visitUniterm(iakbari.RIFBLDParser.UnitermContext)
	 */
	//uniterm        : const1 ('(' (term* | (NCName '->' term)*) ')')	;
	@Override public String visitUniterm(@NotNull RIFBLDParser.UnitermContext ctx) { 
		//check if uniterm is predicate or function in the case that uniterm parent is term
		//term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
		boolean external = false;
		if(ctx.parent instanceof RIFBLDParser.TermContext)
			if(!((RIFBLDParser.TermContext)ctx.parent).getTokens(RIFBLDLexer.T__0).isEmpty()) // token T__0 = 'External'. see RIFBLD.tokens file
				external = true;
		String tag ="";
		if(external)
			tag = "Expr" ;
		else
			tag = "Atom" ;
		String s="\r\n<" + tag +">";
		
		
		//irimeta
		//irimeta if its parent is term
		// if so, it should be grabbed from its parent which is 'term' context
		if(ctx.parent instanceof TermContext){
			String meta ="";
			IrimetaContext irimeta= ((RIFBLDParser.TermContext)ctx.parent).irimeta() ; 
			if(irimeta!=null){
				meta = visitIrimeta(irimeta);	
				s+="\r\n" + meta ;
			}
		}
		s+="\r\n<op>" + visitConst1(ctx.const1()) + "</op>" ;
		//check if uniterm is positional or  slotted (with named arguments)
		if(ctx.getTokens(RIFBLDLexer.T__22).isEmpty()){ //positional. T__22=2= '->' token.
			s+="\r\n<args ordered=\"yes\">";
			List<TermContext> terms = ctx.term();
			for(int i=0; i<terms.size(); i++)
				s+="\r\n" + visitTerm(terms.get(i)) ;
			s+="\r\n</args>";			
		}
		else{			
			List<TerminalNode> names = ctx.NCName();
			List<TermContext> terms = ctx.term();
			for(int i=0; i< names.size(); i++){
				s+="\r\n<slot ordered=\"yes\">";
				s+="\r\n<Name>" + visitTerminal(names.get(i)) + "\r\n</Name>" ;
				s+="\r\n" + visitTerm(terms.get(i)) ;
				s+="\r\n</slot>" ;
			}
		}
		s+="\r\n</" + tag + ">";
		return s;
		//return visitChildren(ctx); 		
	}
	/**
	 * {@inheritDoc}
	 * r production rule is the start of RIF-BLD grammar
	 * r: document EOF;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitR(@NotNull RIFBLDParser.RContext ctx) {
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" ;
		s+= "\r\n";
		return s + visitDocument(ctx.document()); 
		
	}
	/**
	 * {@inheritDoc}
	 * atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
	 * 
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * pred () is translated to 
	 * <Atom>
     *  <op>χbld(pred)</op>
     * </Atom>
	 * (non-Javadoc)
	 * @see iakbari.RIFBLDBaseVisitor#visitAtomic(iakbari.RIFBLDParser.AtomicContext)
	 */
	//atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
	@Override public String visitAtomic(@NotNull RIFBLDParser.AtomicContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc} 
	 * subclass       : term '##' term	;
	 * sub ## super
	 * is transformed to
	 * &lt;Subclass&gt;
     *  &lt;sub&gt;χbld(sub)&lt;/sub&gt;
     *  &lt;super&gt;χbld(super)&lt;/super&gt;
     * &lt;/Subclass&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * atomic         : irimeta? ( equal | member | subclass | uniterm | frame)	;
	 * subclass       : term '##' term	;
	 * sub ## super
	 * is transformed to
	 * <Subclass>
     *  <sub>χbld(sub)</sub>
     *  <super>χbld(super)</super>
     * </Subclass>
	 * @see iakbari.RIFBLDBaseVisitor#visitEqual(iakbari.RIFBLDParser.EqualContext)
	 */
	@Override public String visitSubclass(@NotNull RIFBLDParser.SubclassContext ctx) { 
		String s="\r\n<Subclass>";
		
		//irimeta
		//irimeta should be grabbed from ctx parent which is 'atomic' context
		String meta ="";
		IrimetaContext irimeta= ((RIFBLDParser.AtomicContext)ctx.parent).irimeta() ; 
		if(irimeta!=null){
			meta = visitIrimeta(irimeta);	
			s+="\r\n" + meta ;
		}
		s+="\r\n<sub>" + visitTerm(ctx.term(0)) + "\r\n</sub>" ;
		s+="\r\n<super>" + visitTerm(ctx.term(1)) + "\r\n</super>" ;
		s+="\r\n</Subclass>";
		return s;
		//return visitChildren(ctx);	
	}
	/**
	 * {@inheritDoc}
	 * implies    : irimeta? (atomic | 'And' '(' atomic* ')') ':-' formula	;
	 * conclusion :- condition
	 * is transformed to
	 * &lt;Implies&gt;
     * &lt;if&gt;χbld(condition)&lt;/if&gt;
     * &lt;then&gt;χbld(conclusion)&lt;/then&gt;
     * &lt;/Implies&gt;
     * <br>
     * And (
  	 *  conjunct1
     *  . . .
     *  conjunctn
     * )
     * is converted to
     * &lt;And&gt;
  	 *	&lt;formula&gt;χbld(conjunct1)&lt;/formula&gt;
     *	. . .
  	 *	&lt;formula&gt;χbld(conjunctn)&lt;/formula&gt;
	 * &lt;/And&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * (non-Javadoc)
	  * <Implies>
  	  *  <if>χbld(condition)</if>
      *  <then>χbld(conclusion)</then>
      * </Implies>
	  * 
	  * And (
  	  *  conjunct1
      *  . . .
      *  conjunctn
      * )
      * is converted to:
      * <And>
  	  *	<formula>χbld(conjunct1)</formula>
      *	. . .
  	  *	<formula>χbld(conjunctn)</formula>
	  * </And>
	  * 
	  * @see iakbari.RIFBLDBaseVisitor#visitImplies(iakbari.RIFBLDParser.ImpliesContext)
	  * 
	  */
	//implies    : irimeta? (atomic | 'And' '(' atomic* ')') ':-' formula	;
	@Override public String visitImplies(@NotNull RIFBLDParser.ImpliesContext ctx) { 
		String s="\r\n<Implies>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}	
		
		//body
		s+="\r\n<if>" + visit(ctx.getChild(ctx.getChildCount()-1)) + "\r\n</if>" ; // visit last child (formula) 
		
		//head
		s+="\r\n<then>";
		//if head is a conjuncion of atoms (implies has 'And' in the head)
		boolean conj=false;
		if(ctx.getTokens(RIFBLDLexer.T__15).size()==1) //T__15 = 'And'
			conj= true;
		/*int cc = ctx.getChildCount();
		ParseTree child;		 
		for(int i=0; i<cc; i++){
			child = ctx.getChild(i);
			if(child instanceof TerminalNode && child.getText().matches("And"))
				conj = true;	
		}*/		
		if(conj){
			s+="\r\n<And>";
			List<AtomicContext> atomics = ctx.atomic();
			for(int i=0; i<atomics.size(); i++)
				s+="\r\n<formula>" + visitAtomic(atomics.get(i)) + "\r\n</formula>" ;
			s+="\r\n</And>";
		}
		else
			s+="\r\n" + visitAtomic(ctx.atomic(0));//has one atmic context
		s+="\r\n</then>";
		s+="\r\n</Implies>";
		return s;
		//return visitChildren(ctx); 
		
	}
	
	/**
	 * {@inheritDoc}
	 * * Condition Language:
  	 * formula     : irimeta? 'And' '(' formula* ')' 		#andFormula 
  	 *		 	   | irimeta? 'Or' '(' formula* ')' 		#orFormula
  	 *		 	   | irimeta? 'Exists' Var+ '(' formula ')' #existsFormula
  	 *		 	   | atomic 								#atomicFormula
  	 *		 	   | irimeta? 'External' '(' uniterm ')'	#externalFormula
  	 *		 	 ;
  	 *
  	 * External (
     *  atomexpr
     * )
     * is transformed to
     * &lt;External&gt;
     *  &lt;content&gt;χbld(atomexpr)&lt;/content&gt;
     * &lt;/External&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	 /*
	  * External (
      *  atomexpr
      * )
      * is converted to:
      * <External>
      *  <content>χbld(atomexpr)</content>
      * </External>
	  * (non-Javadoc)
	  * @see iakbari.RIFBLDBaseVisitor#visitAndFormula(iakbari.RIFBLDParser.AndFormulaContext)
	  */
	//formula     :  irimeta? 'External' '(' uniterm ')'	#externalFormula 
	@Override public String visitExternalFormula(@NotNull RIFBLDParser.ExternalFormulaContext ctx) { 
		String s="\r\n<External>";
		
		//irimeta		
		String meta ="";
		if(ctx.irimeta()!=null){
			meta = visitIrimeta(ctx.irimeta());	
			s+="\r\n" + meta ;
		}
		
		s+="\r\n<content>" + visitUniterm(ctx.uniterm()) + "\r\n</content>" ;
		s="\r\n</External>";
		return s;
		//return visitChildren(ctx);		
	}
	/**
	 * {@inheritDoc}
	 * base           : 'Base'  '(' ANGLEBRACKIRI ')'	;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBase(@NotNull RIFBLDParser.BaseContext ctx) { 
		//String s = visitTerminal(ctx.ANGLEBRACKIRI());
		//s = s.substring(1, s.length()-1) ; //removing <> from the begining and end of the uri
		//return s; 
		//return visitChildren(ctx); 
		return visitTerminal(ctx.ANGLEBRACKIRI());
		
	}
	/**
	 * {@inheritDoc}
	 * 
	 * frame          : term '[' (term '->' term)* ']'	;
	 * 
	 * inst [
     *   key1 -> filler1
     *   . . .
     *   keyn -> fillern
     * ]
     * is transformed to
     * &lt;Frame&gt;
     *  &lt;object&gt;χbld(inst)&lt;/object&gt;
     *  &lt;slot ordered="yes"&gt;
     *   χbld(key1)
     *   χbld(filler1)
     *  &lt;/slot&gt;
     *  . . .
     *  &lt;slot ordered="yes"&gt;
     *   χbld(keyn)
     *   χbld(fillern)
     *  &lt;/slot&gt;
     * &lt;/Frame&gt;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	/*
	 * (non-Javadoc)
	 * frame is transformed to
     * <Frame>
     *  <object>χbld(inst)</object>
     *  <slot ordered="yes">
     *   χbld(key1)
     *   χbld(filler1)
     *  </slot>
     *  . . .
     *  <slot ordered="yes">
     *   χbld(keyn)
     *   χbld(fillern)
     *  </slot>
     * </Frame>
	 * @see iakbari.RIFBLDBaseVisitor#visitFrame(iakbari.RIFBLDParser.FrameContext)
	 */
	//frame          : term '[' (term '->' term)* ']'	;
	@Override public String visitFrame(@NotNull RIFBLDParser.FrameContext ctx) { 
		String s="\r\n<Frame>" ;
		List<TermContext> terms = ctx.term();
		s+="\r\n<object>" + visitTerm(terms.get(0)) + "</object>" ;
		for(int i=1; i<terms.size(); i+=2){
			s+="\r\n<slot ordered=\"yes\">";
			s+="\r\n" + visitTerm(terms.get(i)) ;
			s+="\r\n" + visitTerm(terms.get(i+1)) ;
			s+="\r\n</slot>" ;
		}
		s+="\r\n</Frame>";
		return s;
		//return visitChildren(ctx);		
	}
	//-----------------------------------------------------------------------------------------------------------------------
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
		int nodeType = node.getSymbol().getType();
		String s=node.getText(); //default case 
		switch (nodeType){
		case RIFBLDLexer.ANGLEBRACKIRI:
			s = node.getText();
			s = s.substring(1, s.length()-1); //remove < and > from start and end of the angle bracket iri 
			break;
		case RIFBLDLexer.Var:
			s = visitVar(node);			
			break;
		case RIFBLDLexer.IRICONST:
			/*
			 * IRICONST		 : '"'  ('http' | 'https'|'ftp'|'file') ':' [-a-zA-Z0-9+&@#/%?=~_|!:,.;]* [-a-zA-Z0-9+&@#/%=~_|] '"^^' 'rif:iri' ;
			 * "unicodestring"^^symspace 
			 * is converted to
			 * <Const type="symspace">unicodestring</Const> 
			 */
			String[] sp = node.getText().split("\"\\^\\^"); //slpit on "^^. caret ^ is special character
			//remove the first " from uri
			sp[0] = sp[0].substring(1, sp[0].length());
			s ="<Const type=\"" + sp[1] +"\">" + sp[0] + "</Const>" ;	
			break;
		case RIFBLDLexer.UNICODESTRING : 
			//UNICODESTRING   :  '"' (~["\r\n\\] | ECHAR | UCHAR)* '"' ; //#x22#x5C#xA#xD   
			s = node.getText();
			s = s.substring(1, s.length()-1); //remove " from start and end of the unicode string
			break;
		default:
			return node.getText();			
		}
		return s;
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
		// Iterate over all child nodes of `parent`.
	    for (int i = 0; i < ctx.getChildCount(); i++) {

	        // Get the i-th child node of `parent`.
	        ParseTree child = ctx.getChild(i);

	        if (child instanceof VarContext) {
	            vars.add(child.getText()); 
	        }
	        else {
	            vars.addAll(getVars(child));
	        }
	    }			
		return vars;
	}
	
	/**
	 * 
	 * @param ctx
	 * Context
	 * @param className
	 * Class name of the child. name can be a parser rule name or a lexer rule name (terminal node)
	 * @return
	 */
	private boolean hasChild(@NotNull ParserRuleContext ctx, String className) {
		// TODO Auto-generated method stub
		String childName ="";
		for(int i=0; i< ctx.getChildCount(); i++){
			childName = ctx.getChild(i).getClass().getSimpleName(); 
			if(childName.matches(className))				
				return true;
		}		
		return false;
	}
	/**
	 * Var            : '?' (NCName | (PN_CHARS_BASE)*) ; 
	 * 
	 * (* iriconst? frameconj? *)
     * ?name1
     * is translated to
     * &lt;Var&gt;
     *  &lt;id&gt;χbld(iriconst)&lt;/id&gt;?
     *  &lt;meta&gt;χbld(frameconj)&lt;/meta&gt;?
     *  χbld(name1)
     * &lt;/Var&gt;
     * if var parent is term and had irimeta
     * term			: irimeta? ( const1 | Var | uniterm | list | 'External' '(' uniterm ')')	;
	 * @param node
	 * @return
	 */
	/*
	 * ?name1
     * is translated to
     * <Var>
     *  <id>χbld(iriconst)</id>?
     *  <meta>χbld(frameconj)</meta>?
     *  χbld(name1)
     * </Var>
	 */
    private String visitVar(TerminalNode node){
    	String s="\r\n<Var>";
    	
    	//irimeta if its parent is term
		// if so, it should be grabbed from its parent which is 'term' context
    	if(node.getParent() instanceof TermContext){
			String meta ="";
			IrimetaContext irimeta= ((RIFBLDParser.TermContext)node.getParent()).irimeta() ; 
			if(irimeta!=null){
				meta = visitIrimeta(irimeta);	
				s+="\r\n" + meta ;
			}		
    	}
    	String s1 = node.getText();
		s1 = s1.substring(1, s1.length()); // remove ? sign from the beginning of the variable name
    	s+= s1;
    	s+="</Var>";
    	return s;
    }

}
