package iakbari.ruletranslator.translator;

import iakbari.ruletranslator.parsers.N3BaseVisitor;
import iakbari.ruletranslator.parsers.N3Lexer;
import iakbari.ruletranslator.parsers.N3Parser;
import iakbari.ruletranslator.parsers.N3Parser.N3_qnameContext;
import iakbari.ruletranslator.parsers.N3Parser.N3_statementlistContext;
import iakbari.ruletranslator.parsers.N3Parser.N3_statements_optionalContext;
import iakbari.ruletranslator.parsers.N3Parser.N3_subjectContext;
import iakbari.ruletranslator.parsers.N3Parser.RContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.PrefixContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.views.AbstractView;

public class MyN3BaseVisitor extends N3BaseVisitor<String>{
	
	String toRIF ;
	private static long idCounter;
	
	public MyN3BaseVisitor() {
		// TODO Auto-generated constructor stub
		toRIF = "";
		idCounter =1;
	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_pathtail(@NotNull N3Parser.N3_pathtailContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG11(@NotNull N3Parser.G11Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//@Override public String visitG10(@NotNull N3Parser.G10Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * n3_statements_optional:  (n3_statement '.')* ;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_statements_optional(@NotNull N3Parser.N3_statements_optionalContext ctx) { 
		/* "\r\n#\r\n" is used to define end of each statement. it is placed after each statement*/
		if(ctx.n3_statement()!=null)	
			return visitN3_statement(ctx.n3_statement()) + "\r\n#\r\n" + visitN3_statements_optional(ctx.n3_statements_optional()); 
		return "";	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_object(@NotNull N3Parser.N3_objectContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_literal(@NotNull N3Parser.N3_literalContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_dtlang(@NotNull N3Parser.N3_dtlangContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_formulacontent(@NotNull N3Parser.N3_formulacontentContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_pathlist(@NotNull N3Parser.N3_pathlistContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_subject(@NotNull N3Parser.N3_subjectContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//@Override public String visitN3_propertylisttail(@NotNull N3Parser.N3_propertylisttailContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * 
	 * subject, predicate, object in N3 are nodes. A node can be one of the followings
	 * n3_node : n3_symbol | '{' n3_formulacontent '}' | N3_VARIABLE | N3_NUMERICLITERAL 
	 * 		   | n3_literal | '[' n3_propertylist ']' | '(' n3_pathlist ')' | '@this' ;
	 *  
	 *  n3_symbol, N3_VARIABLE, N3_NUMERICLITERAL, and n3_literal can return their text value. 
	 *  '{' n3_formulacontent '}'  | '[' n3_propertylist ']' | '(' n3_pathlist ')' will be more processed.
	 * 
	 *  
	 *  node '[' n3_propertylist ']' will add a variable before '[' n3_propertylist ']'
		   for example the following statement:
		   		:who1 :father [ :brother :who2 ].
		   will be changed to 
		   		:who1 :father ?x.
		   		?x :brother :who2 .
		   and variable ?x will be added to forSome/forAll if applicable	
	 *	
	 * '(' n3_pathlist ')' : I am not sure if parenthesis around pathlist are meant to group statements.
	 * 	   		   		   
	 *  '@this' won't be covered for now.
	 *  
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_node(@NotNull N3Parser.N3_nodeContext ctx) { 
		//check node type 
		//formula node
		if(ctx.n3_formulacontent()!=null)
			return visitN3_formulacontent(ctx.n3_formulacontent()); //removing {} from formula
		
		/* node '[' n3_propertylist ']'. this node will add a variable before '[' n3_propertylist ']'
		   for example the following statement:
		   :who1 :father [ :brother :who2 ].
		   means 
		   :who1 :father ?x.
		   ?x :brother :who2 .	
		*/
		if(ctx.n3_propertylist()!=null){
			Utils u = new Utils();
			String uid = createID("?x"); // e.g. ?x1, ?x2, ?x3, ...
			String s = uid+ " "+ u.tokens2String(u.getTokens(ctx.n3_propertylist())) +" .\r\n";
			/*
			System.out.println("s=" + s );			
			if(s.indexOf("<EOF>")>0){
	         	s = s.replace("<EOF>", "");
	         	System.out.println("yes");
			} 
			*/	
			ANTLRInputStream input = new ANTLRInputStream(s);
	        // create a lexer that feeds off of input CharStream	        
			N3Lexer lexer = new N3Lexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			N3Parser parser = new N3Parser(tokens);
			ParseTree tree = parser.n3_statements_optional(); 
			//((RuleContext) tree).inspect(parser); // show in gui 
	        //System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
	         
	        //MyN3BaseVisitor visitor = new MyN3BaseVisitor();
	        //System.out.println(visitor.visit(tree));
	        //System.out.println(visitor.toRIF);
			s = visitN3_statements_optional( (N3_statements_optionalContext) tree);
			return uid+ "|" + s + "$"; // | and $ are used to separate newly created statement(s) 
		}
		
		//check node : '(' pathlist ')'
		if(ctx.n3_pathlist()!=null)
			return visitN3_pathlist(ctx.n3_pathlist()); //removing '(' and ')'
			//return "Group (" + visitN3_pathlist(ctx.n3_pathlist()) + ")"; //I am not sure if parenthesis around pathlist are meant to group statements.
		return visitChildren(ctx); 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_symbol(@NotNull N3Parser.N3_symbolContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_existential(@NotNull N3Parser.N3_existentialContext ctx) { 
		
		return "Exists " + visitG6(ctx.g6()) +"(\r\n";
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_qname(@NotNull N3Parser.N3_qnameContext ctx) { return visitChildren(ctx); }
	
	/**
	 * {@inheritDoc}
	 * g0 declares base, prefix and keywords.
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG0(@NotNull N3Parser.G0Context ctx) { 
		//super.visitG0(ctx);
		
		return visitChildren(ctx);		
	}
	
	/**
	 * {@inheritDoc}
	 * statements in N3 in the form of 'subject predicate object' will become 
	 * uniterms in RIFBLD in the form of predicate( subject object).
	 * However if verb is '=', '=>' or '<=' then the statement will become and equality or formula in RIF-BLD
	 * n3_statement:	 n3_subject n3_propertylist ;
	 * n3_propertylist:	 //empty
	 	|		 n3_verb n3_object n3_objecttail (';' n3_propertylist)?
		;
	 * for example in N3
	 * A brother B,C,D .
	 * will become	
	 * brother(A B C D) in RIFBLD.
	 * Also in situations like this in N3:
	 * A bother B; father C . 
	 * will become two following uniterms in RIFBLD:
	 * brother(A B)
	 * father(A C)
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_statement(@NotNull N3Parser.N3_statementContext ctx) { 
		//n3_statement:	 n3_subject n3_propertylist ;
		//first we need to get predicate(verb) and object from n3_propertylist
		String s="", s1="", s2="";
		
		String subj = visitN3_subject(ctx.n3_subject());
		String prop = visitN3_propertylist(ctx.n3_propertylist()); 
		
		/*first check if any new variable (and therefore new statement) is added to the original statement because 
		 * of the '[' propertylist ']' . if so, then the bar '|' char is already added to the prop to use to determine. 
		 *  the following code removes the newly added statements from propertylist and checks the rest.
		 *  e.g.
		 *     
		 */
		String[] prop1, prop2;
		//List<String> props = new ArrayList<String>();
		if (prop.indexOf('|')>=0){
			/*
			s1 = prop.split("\\|")[0] ; // double backslash is used because | is a special char in java regex
			prop1 = s1.split(";");
			s2 = prop.split("\\|")[1];
			prop2 = s2.split(";");
			s2 = prop2[0];
			*/
			s2 = prop.substring(prop.indexOf("|")+1, prop.indexOf("$"));
			prop = prop.replace("|"+s2+"$", "");
			//prop1 = prop.split("\\|.*$"); 
			//s1 = prop
		}
		//else
			prop1 = prop.split(";"); //semicolon is used for verb repetition. comma is used for object repetition
			
		//System.out.println(prop);
		//first item of propertylist is the verb or predicate
		//String[] prop2 = prop.split("\\|\\|");	//split by |. \\ is used because | is special character for java regex
		//p includes a verb and object(s) e.g. brother A,B,C
		String verb;
		for(String p : prop1){
			String[] pelements= p.split(","); // first element will be a verb and the rest are objects			 
			 verb = pelements[0];
			 //now that we have subject, verb, object it's time to build the statement.
			 for(int i=1; i<pelements.length; i++){
				 //check type of statement based on verb
				 switch (verb) {
				 	case	"=":
				 		s += subj +" = " + pelements[i] + "\r\n"; //equality. newline is for putting each statement in a new line
				 		break;
				 	case	"<=":
				 		s += subj + " :- " + pelements[i] + "\r\n"; //formula
				 		break;
				 	case	"=>":
				 		s += pelements[i] + " :- " + subj + "\r\n"; //formula
				 		break;
				 	default:
				 		/**
				 		 * ignore true as argument. in N3 usually log:Truth is used as true value
				 		 */
				 		if(pelements[i].equalsIgnoreCase("log:Truth"))
				 			s += verb +"( "+ subj+ " ) \r\n"; //peroid sign is used to show end of an atom (rule fact) 
				 		else {
				 			/**
				 			 * check if verb is 'rdf:Type'. for example statement rdf:Type("John" n3:teacher). will change to n3:teacher("John")
				 			 */
				 			if(verb.equalsIgnoreCase("rdf:Type"))
				 				s += pelements[i]  +"( "+ subj + " ) \r\n";  //peroid sign is used to show end of an atom (rule fact)
				 			else
				 				s += verb +"( "+ subj+ " " + pelements[i] + " ) \r\n";  //peroid sign is used to show end of an atom (rule fact) 
				 			
				 		}
				 		 
				 		
				 }
			 }
		}
		//System.out.println("stat=>" + s+s2);
		return s + s2; 
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_statementlist(@NotNull N3Parser.N3_statementlistContext ctx) { return visitChildren(ctx); }
	
	/**
	 * {@inheritDoc}
	 *example of N3 base and prefix declarations:
	 *"@base <http://www.example.org/> ."
	 *"@prefix g: <http://www.another.example.org/geographical#> ."
	 *"@prefix : <http://www.example.org/meeting_organization#> ."
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_declaration(@NotNull N3Parser.N3_declarationContext ctx) {
		//super.visitN3_declaration(ctx);
		//System.out.println("decl>");
		String s ="";
		//first child of n3_declaration is always a terminal node (i.e. it is @base, @prefix or @keywords)
		if(ctx.getChild(0).getText().equalsIgnoreCase("@base"))
				s += "Base(" + ctx.getChild(1).getText() + ") " ;
		//N3 can contain empty prefix e.g.  @prefix : <http://www.example.com>
		if(ctx.getChild(0).getText().equalsIgnoreCase("@prefix")){
			s += "Prefix(";
			String p = ctx.getChild(1).getText() ;
			//check empty prefix
			if(p.equals(":"))
				// add local as prefix for now
				s+= "local ";
			else
				s+= p.substring(0, p.length()-1); //remove colon from prefix name e.g. people:
			s+= " " + ctx.getChild(2).getText() + ") ";
		}	
		if(ctx.getChild(0).getText().equalsIgnoreCase("@keywords")){
			s+= "@keywords not implemented yet" ;
		}
		//System.out.println("s=" +s);
		toRIF+= s;
		/* 
		Utils u = new Utils();
		List<TerminalNode> tn = u.getRootTerminalNodes(ctx);
		System.out.println("n3 decl tn=" + tn.toString());
		*/
		//return s+visitChildren(ctx);
		 
		//return visitChildren(ctx);
		 
		return s + "\r\n";
	}

	/**
	 * {@inheritDoc}
	 * g1 declares universal implication
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG1(@NotNull N3Parser.G1Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG2(@NotNull N3Parser.G2Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG3(@NotNull N3Parser.G3Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * n3_universal:	 '@forAll' g6
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_universal(@NotNull N3Parser.N3_universalContext ctx) { 
		
		return "Forall " + visitG6(ctx.g6()) +"("; 
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG4(@NotNull N3Parser.G4Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG5(@NotNull N3Parser.G5Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * g6 contains the universal variables (e.g. "@forall x,y ." )
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG6(@NotNull N3Parser.G6Context ctx) { 
		
		//get list of terminals
		Utils u =  new Utils();
		List<String> t = new ArrayList<String>(u.getTokens(ctx));
		//clean the list (keeping variables and removing commas and last dot)
		t.removeAll(Arrays.asList(","));
		//t.removeAll(Collections.singletonList(","));
		t.remove(".");
		String s = "";
		for(String var : t)
			s+=var + " ";
		return s;		
		//return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	//@Override public String visitG7(@NotNull N3Parser.G7Context ctx) { return visitChildren(ctx); }
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG8(@NotNull N3Parser.G8Context ctx) { return visitChildren(ctx); }
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitR(@NotNull N3Parser.RContext ctx) {		
		//toRIF = "Document("+ visitChildren(ctx) + ")";
		//String g0;
		String s = "Document(\r\n" ;
		if(ctx.g0()!=null){
			String g0 = visitG0(ctx.g0());
			s+=g0;
		}	
		//check if there are any rules/facts in the N3 document
		//if(ctx.g1().children!=null || ctx.g2().children!=null || ctx.n3_statements_optional().children!=null){
			s+="Group(\r\n" ;
			//visit rest of r children (g1, g2 and n3_statements_optional)
			s+= visitG1(ctx.g1()) + visitG2(ctx.g2()) + visitN3_statements_optional(ctx.n3_statements_optional()) ;
			//close forall and forsome if there are any universal or existential rules
			if(ctx.g1().children!=null || ctx.g2().children!=null)
				s+=")";
			
			
			//s+="#"; //for indicating end of statements. 
			//close group 
			s+=")";
		//}	
		
		//return toRIF;
		//close document tag 
		s+=")";
		return s;
		}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitG9(@NotNull N3Parser.G9Context ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * n3_propertylist:	 //empty
		|		 n3_verb n3_object n3_objecttail (';' n3_propertylist)?
		;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_propertylist(@NotNull N3Parser.N3_propertylistContext ctx) { 
		String s="";		
		String verb = visitN3_verb(ctx.n3_verb());		
		String obj = visitN3_object(ctx.n3_object()); 
		String objtail = visitN3_objecttail(ctx.n3_objecttail());
		if(objtail!="")
			s = verb +"," + obj + "," + objtail;
		else
			s = verb +"," + obj ;
		if(ctx.n3_propertylist()!=null)
			return s + ";"+ visitN3_propertylist(ctx.n3_propertylist());
		else
			return s;
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_statementtail(@NotNull N3Parser.N3_statementtailContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_path(@NotNull N3Parser.N3_pathContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 * n3_objecttail:	 //empty
		|		 ',' n3_object n3_objecttail
		;
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_objecttail(@NotNull N3Parser.N3_objecttailContext ctx) { 
		if(ctx.n3_object()!=null)
			return visitN3_object(ctx.n3_object());
		//return "";
		return visitChildren(ctx);
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitN3_verb(@NotNull N3Parser.N3_verbContext ctx) { return visitChildren(ctx); }
	
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
		String s = node.getText();
		//if(node instanceof N3_qnameContext)
			//return "prefix " + node.getText();
		if(s.charAt(0) == ':')
			s = "local" + s;
		//return node.getText();
		return s;
	}
	
	// create unique id 
	/**
	 * 
	 * @param id 
	 * add a unique number to end of id. numbers start from 0. e.g. id1, id2, id3, .... 
	 * @return
	 */
	public static synchronized String createID(String id)
	{
	    return id + String.valueOf(idCounter++);	    
	}  
	// create unique id 	
	/**
	 * 
	 * @return
	 * returns a Java-generated unique id e.g. 067e6162-3b6f-4ae2-a171-2470b63dff00 
	 */
	public static synchronized String createID()
	{		    
	    String uniqueID = UUID.randomUUID().toString();
	    return uniqueID;
	}

		
	/**
	 * update the initial translation of N3 to RIF-BLD:
     * <p>if any variable has been added to the statements and if those statements enclosed in a  
     * universal or existential rule then the new variables definition should be added to the  
     * universal or existential declaration.
     * Also if a  universal or existential rule has more than one statement then they should be 'And' ed.</p>  
       
	 * @param translation
	 * initial translation of N3 to RIF-BLD.
	 *  
	 * @return
	 * updated translation
	 */ 
	public String updateTranslation(String translation) {
		// TODO Auto-generated method stub
		/* steps:
		 * 1. get the universal/existential declaration 
		 * 2. get the universal/existential body
		 * 3. get the new variables in the body
		 * 4. add the new variables to the universal/existential declaration
		 * 5. replace the old declaration line with the new one
		 * 6. Add 'And(...)' to the body if it has more than one statement
		 */
		String s ;
		if(translation.indexOf("Exists")<0 && translation.indexOf("Forall")<0)
			return translation;
		String ueDecl ; // universal/existential declaration line
		String ueBody = "" ; // universal/existential body
		String ue;
		if(translation.indexOf("Exists")>=0)
			ue = "Exists" ;
		else
			ue = "Forall";
		int begin = translation.indexOf(ue) ;
		int end = begin;
		while(translation.charAt(end)!='(')
			end ++;
		ueDecl = translation.substring(begin, end);
		Stack<Character> st = new Stack<Character>();
		int i ;
		//int firstp = translation.indexOf('(') ;
		char c;
		st.push('(');
		i = end + 1; //body starts after first (
		while(!st.isEmpty()){
			c = translation.charAt(i); 
			switch (c){
			case '(' :
				st.push('(');
				break;
			case ')' :
				st.pop();
				break;
			}
			ueBody += c ;
			i++;
		}
		ueBody = ueBody.substring(0, ueBody.length()-1); //remove last )
		
		//check for new variables
		Set<String> vars = new HashSet<String>();
		Matcher m = Pattern.compile("\\?\\w+").matcher(ueBody); // \w is a word character, short for [a-zA-Z_0-9]
		while(m.find()){
			vars.add(m.group(0).trim());
		}
		String ueDecl2 = ueDecl;
		for(String v : vars)
			if(ueDecl2.indexOf(v)<0)
				ueDecl2 += " "+ v + " " ;
		translation = translation.replace(ueDecl, ueDecl2);
		
		//String ueBody2 = ueBody;		
		String rbody = ueBody.split(":-")[0] ; //rule body
		//count the statements in rule body and head
		String rhead = ueBody.split(":-")[1];// rule head
		String[] bodyatoms = rbody.split("\r\n") ;
		int  ba= 0;
		for(i=0; i<bodyatoms.length; i++){		
			if(bodyatoms[i].length()>0)
				ba++;
		}	
		if(ba>1) //first element is empty thats why I used 2			
			translation = translation.replace(rbody, "\r\nAnd(" + rbody + ")");
		String[] headatoms = rhead.split("\r\n") ;
		int  ha= 0;
		for(i=0; i<headatoms.length; i++)
			if(headatoms[i].length()>0)
				ha++;
		if(ha>1) //first element is empty thats why I used 2			
			translation = translation.replace(rhead, "\r\nAnd(" + rhead + ")");
		
		return translation;
	}  		
	
	/**
	 * update the initial translation of N3 to RIF-BLD:
     * <p>if any variable has been added to the statements, then the new variables definition should be added to the  
     * statement beginning (with a universal or existential declaration).
     * Also if a  rule has more than one statement then they should be 'And' ed.</p>  
       
	 * @param translation
	 * initial translation of N3 to RIF-BLD.
	 *  
	 * @return
	 * updated translation
	 */ 
	public String updateTranslation2(String translation) {
		//System.out.println("trans >"+ translation);
		// TODO Auto-generated method stub
		/* steps:
		 * 1. check if the statement is a fact or a rule
		 * 2. find the  variables in the rule
		 * 3. add the new variables to the universal declaration of the rule
		 * 4. replace the old rule with the new one
		 * 5. Add 'And(...)' to the body if it has more than one statement
		 */
	
		//translation has this format: 	Document( <header> Group( <statements> ))
		//first add  for all to the rule if it has variables
		//first get the statements (rules and facts) by splitting the translation
		String trans = translation.substring(translation.indexOf("Group(")+6, translation.length()-2);
		String[] statements = trans.split("#");
		String newtranslation =translation.substring(0, translation.indexOf("Group(")+7);
		//first and last parts of the slpit will be the document part : Document( <header> Group(# <statements> #))
		for(int stat_count=0; stat_count<statements.length; stat_count++){
			String stat = statements[stat_count];
			//get the atoms
			//now check if the rule body/head has more than one statement(atom)
			//it will be done by searching for period . sign 
			//if fact
			if(stat.indexOf(":-")<0) {
				/*String[] facts = stat.split("\\.");
				for(int i=0; i<facts.length; i++)		
					if(facts[i].trim().length()>0) 
						newtranslation += "\r\n" + facts[i];*/
				newtranslation += stat;
				
			}
			else {
				String head = stat.split(":-")[0] ; //rule body
				String body = stat.split(":-")[1] ; // rule head
				
				String[] atoms = body.split("\\.") ; //end of each statement 
				
				//first remove the period . sign from body				
				String newbody="";
				for(int i=0; i<atoms.length; i++)		
					if(atoms[i].trim().length()>0) 
						newbody+= "\r\n " + atoms[i] ;
				//second conjunct (And) the atoms if there are more than one
				int atmos_count=0;
				for(int i=0; i<atoms.length; i++)		
					if(atoms[i].trim().length()>0) 
						atmos_count++;
				if(atmos_count>1) { //if there are more than 1 atoms 		
					// conjunct (And) the atoms and remove the period . sign from body
					newbody = "\r\nAnd(\r\n" + newbody + ")";
				}	
				
				atoms = head.split("\\.") ; //end of each statement
				//first remove the period . sign from body				
				String newhead="";
				for(int i=0; i<atoms.length; i++)		
					if(atoms[i].trim().length()>0) 
						newhead+= "\r\n " + atoms[i] ;
				//second conjunct (And) the atoms if there are more than one
				atmos_count=0;
				for(int i=0; i<atoms.length; i++)		
					if(atoms[i].trim().length()>0) 
						atmos_count++;
				if(atmos_count>1) { //if there are more than 1 atoms 		
					// conjunct (And) the atoms and remove the period . sign from body
					newhead = "\r\nAnd(\r\n" + newhead + ")";
				}	
				
				//update the new rule with new head and body
				String newrule = newhead + ":-" + newbody;
			

				//rule's variables set
				Set<String> vars = new HashSet<String>();
				Matcher m;
				//check for new variables				
				m = Pattern.compile("\\?\\w+").matcher(newrule); // \w is a word character, short for [a-zA-Z_0-9]
				while(m.find()){
					vars.add(m.group(0).trim());
				}
				//if there are variables in the rule
				if(vars.size()>0) {
					String ruleDecl = "\r\nForall "; 
					for(String v : vars)				
						ruleDecl += " "+ v + " " ;					
					newrule = ruleDecl + "(" + newrule + ")" ;					
				}
				newtranslation += newrule;
			}//end of else
		}//end of rules
		newtranslation +="))"; //close group and document 
		return newtranslation;
	} // end of func updateTranslation2 
}
