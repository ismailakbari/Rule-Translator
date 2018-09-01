/**
 * 
 */
package iakbari.ruletranslator.translator;

import iakbari.ruletranslator.parsers.N3Lexer;
import iakbari.ruletranslator.parsers.N3Parser;
import iakbari.ruletranslator.parsers.POSLLexer;
import iakbari.ruletranslator.parsers.POSLParser;
import iakbari.ruletranslator.parsers.RIFBLDLexer;
import iakbari.ruletranslator.parsers.RIFBLDParser;
import iakbari.ruletranslator.gui.MainFrame;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

/**
 * This class handles rule translation (or rule inference in case of RIF) based on user selection on main gui.
 * @author Ismail Akbari
 *
 */
public class inputHandler {

	/**
	 * 
	 */
	public inputHandler() {
		// TODO Auto-generated constructor stub
	}
	
   
  
    
    /**
	 * This method runs the appropriate translator (rule engine in case of RIF) based on user selection on main frame.
	 * @param sourceLanguage
	 * source language to be translated to RIF.
	 * @param input
	 * The rules in source language
	 * @param
	 * CST
	 * Whether to show the CST tree
     * @throws IOException 
	 */
	public String translate(String sourceLanguage, String input, String query, boolean CST) throws IOException{
		String result ="";
		if(!input.trim().isEmpty())			
			switch(sourceLanguage){    
	    	case "n3":    		
	    		result=n3Handler(input, CST);
	    		break;
			case "posl":
				result=poslHandler(input, CST);  		
			    break;
			case "ruleml":    		
				result=rulemlHandler(input, CST);
	    		break;
			case "swrl":
				result=swrlHandler(input, CST);  		
			    break;		    
			case "rif2xml":
				result=rif2XML(input, CST);
				break;	
			case "xml2rif":
				result=xml2RIF(input, CST);
				break;	
			case "rifParser":
				rifParser(input, CST);
				break;
			case "rifq":
				rifQuery(input, query, CST);
				break;	
			case "rif":
				result=rifHandler(input, CST);
				break;	
				
	    	}  
		return result;
	}
    
    //
    public static void showCST(RIFBLDParser parser, ParseTree tree, RIFBLDParser inferred_parser, ParseTree inferred_tree){
    	//show CST (Concrete Syntax Tree)in GUI
    	//Using ANTLR built-in viewer
    	//((RuleContext)tree).inspect(parser); //display graphically
    	
    	//Or show it in a JFrame
    	JScrollPane pane1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);    	
    	JScrollPane pane2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	JTabbedPane tpane = new JTabbedPane(JTabbedPane.SCROLL_TAB_LAYOUT, JTabbedPane.SCROLL_TAB_LAYOUT);
    	JFrame frame = new JFrame("Antlr CST");

    	TreeViewer viewer1 = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);        
    	viewer1.setScale(1.5);//scale a little
    	pane1.setViewportView(viewer1);    		
    	TreeViewer viewer2 = new TreeViewer(Arrays.asList( inferred_parser.getRuleNames()),inferred_tree);        
    	viewer2.setScale(1.5);//scale a little
    	pane2.setViewportView(viewer2);	
    	
    	//frame.add(panel);
    	
    	tpane.addTab("original", pane1);    	
    	tpane.addTab("inferred", pane2);
    	
    	frame.setContentPane(tpane);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(800,800);        
    	frame.setVisible(true);
    	
    }
    
   
    //---------------------------------------------------
    //handle n3 processing
    /**
     * This method translates N3 rules to RIF-BLD rules.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main gui.
     * @param CST
     * Whether to show Concrete Syntax Tree or not.
     * @throws Exception
     * throws IOException 
     */
    public static String n3Handler(String data, boolean CST) throws IOException{
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(data);// data contains the input rules
    	
        
        // create a lexer that feeds off of input CharStream	        
		N3Lexer lexer = new N3Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		N3Parser parser = new N3Parser(tokens);
		ParseTree tree = parser.r(); // begin parsing at init rule 
		
		if(CST)
			((RuleContext) tree).inspect(parser); // show in gui 
        //System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
         
        MyN3BaseVisitor visitor = new MyN3BaseVisitor();
        String translation = visitor.visit(tree); 
        //System.out.println(translation);
        //translation = visitor.updateTranslation(translation);
        translation = visitor.updateTranslation2(translation);
        
        //System.out.println(translation);
        return translation;
        /*update the rule base:
         * if any variable has been added to the statements and if those statements enclosed in a  
         *  universal or existential rule then the new varaibles definition should be added to the  
         *  universal or existential declaration
         *  Also if a  universal or existential rule has more than one statement then they should be 'And' ed.  
        */
        //System.out.println(visitor.toRIF);

    }
    
    //handle POSL processing--------------------------------------------
    /**
     * This method translates POSL rules to RIF-BLD rules.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main gui.
     * @param CST
     * Whether to show Concrete Syntax Tree or not.
     * @throws Exception
     * throws IOException 
     */
    public static String poslHandler(String data, boolean CST) throws IOException{
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(data);// data contains the input rules
    	
    	 
    	/*//File f = new File("NBBizKBRules.posl");
    	File f = new File("discount.posl");
    	//File f = new File("minivan.posl");
    	//File f = new File("example1.posl");
    	FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        */
    	
        // create a lexer that feeds off of input CharStream
        POSLLexer lexer = new POSLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        POSLParser parser = new POSLParser(tokens);  
        ParseTree tree = parser.r(); // begin parsing at init rule 
        
        if(CST)
        	((RuleContext) tree).inspect(parser); // show in gui 
        //System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
        
        MyPOSLBaseVisitor visitor = new MyPOSLBaseVisitor();
        //System.out.println(visitor.visit(tree));
        return visitor.visit(tree);
    }
    
    //handle rif processing--------------------------------------------
    /**
     * This method parses the input RIF rules. It generates parse tree of the input rules. 
     * The method then calls the RIF engine to infer new knowledge. Finally it generates a parse tree of the new knowledge 
     * base as well.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main gui.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules.
     * @throws Exception
     * throws file IO exception 
     */
    public static String rifHandler(String data, boolean CST) throws IOException{
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(data);// data contains the input rules
    	
    	/*    	    	
    	File f = new File("rif-ex2.rif"); 
    	//File f = new File("ex1.rif");
    	FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        */
        RIFBLDLexer lexer = new RIFBLDLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RIFBLDParser parser = new RIFBLDParser(tokens);
    	ParseTree tree = parser.r(); // begin parsing at init rule 
         // because original tree will change after inferring new knowledge, I made a copy of it
         //RuleContext root = new RuleContext();
         //root = (RuleContext) tree.getPayload();
         //RIFBLDParser parser2 = new RIFBLDParser(tokens);
         ///System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
         //System.out.println("    copy tree=" + root.toStringTree(parser2)); // print LISP-style tree
         /* this method also works to build the parse tree 
         parser.setBuildParseTree(true);
         ParserRuleContext tree = parser.r();
         tree.inspect(parser); // show in gui
         */
         
         // Walk the parse tree and attach Baselistener to it.
         //can attach our own listener by inheriting from BaseLinstener
         /*ParseTreeWalker walker = new ParseTreeWalker();
         RIFBLDBaseListener listener = new RIFBLDBaseListener();
         walker.walk(listener, tree); 
         */
         
        
         //visit the tree and print # of rules and facts
         MyRIFBLDBaseVisitor rifVisitor = new MyRIFBLDBaseVisitor();        
         rifVisitor.visit(tree); //here the tree gets updated by new facts (the reasoning is done here) 
         
         //build the updated tree and parser again---------------------------------------------
         Utils util = new Utils();        
         //remove EOF from end of tree
         String stree = util.tokens2String(util.getTokens(tree));
         if(stree.indexOf("<EOF>")>0)
         	stree = stree.replace("<EOF>", "");
         //Format (clean up, indentation) the inference result
         lexer.setInputStream(new ANTLRInputStream(stree));
         lexer.reset(); 
         tokens = new  CommonTokenStream(lexer);
         tokens.reset();  
         //List<tokens>tokens.getTokens();
         parser.setTokenStream(tokens);
         parser.reset();
         tree = parser.r();
      
         
         //Build the original tree--------------------------------------------------
      // create a CharStream that reads from a file or a string
     	ANTLRInputStream input2 = new ANTLRInputStream(data);// data contains the input rules
     	
        /* f = new File("rif-ex2.rif");
         //f = new File("ex1.rif");
     	fis = new FileInputStream(f);
         ANTLRInputStream input2 = new ANTLRInputStream(fis);
		*/
         // create a lexer that feeds off of input CharStream
         //POSLLexer lexer = new POSLLexer(input);
         //N3Lexer lexer = new N3Lexer(input);
         RIFBLDLexer lexer2 = new RIFBLDLexer(input2);
         // create a buffer of tokens pulled from the lexer
         CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
         
         // create a parser that feeds off the tokens buffer
         //POSLParser parser = new POSLParser(tokens);
         //N3Parser parser = new N3Parser(tokens);
         RIFBLDParser parser2 = new RIFBLDParser(tokens2);
         ParseTree tree2 = parser2.r(); // begin parsing at init rule        
         // because original tree will change after inferring new knowledge, I made a copy of it
         //RuleContext root = new RuleContext();
         //root = (RuleContext) tree.getPayload();
         //RIFBLDParser parser2 = new RIFBLDParser(tokens);
         //System.out.println("orignial tree2=" + tree2.toStringTree(parser2)); // print LISP-style tree
         //----------------------------------------------------------------------
         
         //tree = parser.r();
         //walker.walk(listener, tree);
         ///System.out.println("#rules = " + rifVisitor.rule_count + "| #facts = " + rifVisitor.fact_count);
         ///System.out.println("updated  tree=" + tree.toStringTree(parser)); // print LISP-style tree
         ///System.out.println("original tree=" + tree2.toStringTree(parser2)); // print LISP-style tree
         
         /**if I want to show the tree in Graphviz I can use the following code
          * it converts the tree to a dot file which is input to Graphviz
          * However, I need to install StringTemplate first
             DOTTreeGenerator gen = new DOTTreeGenerator();
          	StringTemplate st = gen.toDOT(tree);
          	System.out.println(st);
          */                   
         //show the tree in GUI
         if(CST)
        	 showCST(parser2, tree2, parser, tree);
         //((RuleContext) tree2).inspect(parser2); // show in gui 
         ///System.out.println("stree=" + stree); // stree contains the updated rule base (in pure RIF syntax)
         
         stree = Format(tree);
         return stree;
    }

	//---Translate RIF presentation syntax to its XML-based syntax--------------------------------------------
    /**
     * This method parses the input RIF rules. It generates parse tree of the input rules. 
     * The method then translates the input RIF rules (in presentation syntax) to RIF XML syntax.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main gui.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules.
     * @throws Exception
     * throws file IO exception 
     */
    public static String rif2XML(String data, boolean CST) throws IOException{
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(data);// data contains the input rules
    	
    	/*// create a CharStream that reads from a file    	 
    	File f = new File("rif2xml-1.rif"); 
    	//File f = new File("rif-ex2.rif"); 
    	//File f = new File("ex8.rif");
    	//File f = new File("ex1.rif");
    	FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        */
        RIFBLDLexer lexer = new RIFBLDLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RIFBLDParser parser = new RIFBLDParser(tokens);
    	ParseTree tree = parser.r(); // begin parsing at init rule 
         
	    ///System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
	    //System.out.println("    copy tree=" + root.toStringTree(parser2)); // print LISP-style tree
	      
    	// show in gui 
    	if(CST)
        	((RuleContext) tree).inspect(parser); 
	    //visit the tree 
	    RIFBLD_PRES2XML Visitor = new RIFBLD_PRES2XML();        
	    String xml = Visitor.visit(tree); //here tree is translated to XML
	    ///System.out.println("xml=" + xml);
	    return xml;
    	
    }
  //---Translate RuleML to RIF-BLD--------------------------------------------
    /**
     * This method translates RuleML XML to RIF-BLD XML with the help of developed XSL stylesheet.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main GUI.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules. CST must
     * be false since Datalog RuleML is in XML syntax. 
     * @throws Exception
     * throws file IO exception 
     */
    public static String rulemlHandler(String data, boolean CST) throws IOException {
    	//String xsltpath = System.getProperty("user.dir") + File.separator + "xslt" + File.separator + "UBDatalogRuleML2RIF_BLD.xsl" ; 
    	//String xsltName = "xslt" + File.separator + "UBDatalogRuleML2RIF_BLD.xsl" ;
    	String xsltName = "UBDatalogRuleML2RIF_BLD.xsl" ;
    	//set output path
    	//check output directory
    	//File output_dir = new File(System.getProperty("user.dir") + File.separator + "output");
    	File output_dir = new File("output");
    	if(!output_dir.exists())
    		output_dir.mkdirs();
    	//String outpath  = System.getProperty("user.dir") + File.separator + "output" + File.separator + "UBDatalogRuleML2RIF_BLD-output.rif";    	
    	String outpath  = "output" + File.separator + "UBDatalogRuleML2RIF_BLD-output.rif";
    	//call the xslt transformer 
    	XsltProccess xslp = new XsltProccess();
    	//xslp.Transform(data, xsltpath, outpath);
    	String result = xslp.Transform(data, xsltName);
    	return result;
    }
  //---Translate SWRL to RIF-BLD--------------------------------------------
    /**
     * This method translates SWRL XML to RIF-BLD XML with the help of developed XSL stylesheet.
     *  result is saved in the 'output' directory
     * @param data
     * it contains the rules of the source language written in the source text area of the main GUI.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules. CST must
     * be false since SWRL is in XML syntax. 
     * @throws Exception
     * throws file IO exception 
     */
    public static String swrlHandler(String data, boolean CST) throws IOException {
    	/* you can write into a file using
    	 * 1. FileOutputStream
    	 * 2. BufferedWriter
    	 * 3. BufferedOutputStream
    	 * 4. FileUtils.writeFile
    	 * 5. etc
    	 */   
    	
    	//String xsltpath = System.getProperty("user.dir") + File.separator + "xslt" + File.separator + "SWRL2RIF.xsl" ; 
    	//String xsltName = "xslt" + File.separator + "SWRL2RIF.xsl" ;
    	String xsltName = "SWRL2RIF.xsl" ;
    	//set output path
    	//check output directory
    	//File output_dir = new File(System.getProperty("user.dir") + File.separator + "output");
    	File output_dir = new File("output");
    	if(!output_dir.exists())
    		output_dir.mkdirs();
    	//String outpath  = System.getProperty("user.dir") + File.separator + "output" + File.separator + "SWRL2RIF-output.rif";    	
    	String outpath  = "output" + File.separator + "SWRL2RIF-output.rif";
    	//call the xslt transformer 
    	XsltProccess xslp = new XsltProccess();
    	//xslp.Transform(data, xsltpath, outpath);
    	String result = xslp.Transform(data, xsltName);
    	/**
    	 * add default namespace to <Document> tags.
    	 */
    	//result = updateString(result);
    	
    	return result;
    }
    
  /*----------------Translate RIF XML to RIF in presentation syntax --------------------------------------------*/
    /**
     *  
     * The method translates RIF XML to RIF in presentation syntax.
     *  
     * @param data
     *  contains the knowledge base in RIF XML.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules.
     * @throws Exception
     * throws file IO exception 
     */
    public static String xml2RIF(String data, boolean CST) throws IOException {
    	/* you can write into a file using
    	 * 1. FileOutputStream
    	 * 2. BufferedWriter
    	 * 3. BufferedOutputStream
    	 * 4. FileUtils.writeFile
    	 * 5. etc
    	 */   
    	
    	//String xsltpath = System.getProperty("user.dir") + File.separator + "xslt" + File.separator + "SWRL2RIF.xsl" ; 
    	//String xsltName = "xslt" + File.separator + "SWRL2RIF.xsl" ;
    	String xsltName = "RIFBLD_XML2PRES2.xsl" ;
    	//set output path
    	//check output directory
    	//File output_dir = new File(System.getProperty("user.dir") + File.separator + "output");
    	File output_dir = new File("output");
    	if(!output_dir.exists())
    		output_dir.mkdirs();
    	//String outpath  = System.getProperty("user.dir") + File.separator + "output" + File.separator + "SWRL2RIF-output.rif";    	
    	String outpath  = "output" + File.separator + "XML2RIF-output.rif";
    	//call the xslt transformer 
    	XsltProccess xslp = new XsltProccess();
    	//xslp.Transform(data, xsltpath, outpath);
    	String result = xslp.Transform(data, xsltName);
    	return result;
    }
    
  //---Translate RIF presentation syntax to its XML-based syntax--------------------------------------------
    /**
     * This method parses the input RIF rules. It generates parse tree of the input rules.
     *  
     * @param data
     * it contains the rules of the source language written in the source text area of the main gui.
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules.
     * @throws Exception
     * throws file IO exception 
     */
    public static void rifParser(String data, boolean CST) throws IOException{
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(data);// data contains the input rules
    	
    	/*// create a CharStream that reads from a file    	 
    	File f = new File("rif2xml-1.rif"); 
    	//File f = new File("rif-ex2.rif"); 
    	//File f = new File("ex8.rif");
    	//File f = new File("ex1.rif");
    	FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        */
        RIFBLDLexer lexer = new RIFBLDLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RIFBLDParser parser = new RIFBLDParser(tokens);
    	ParseTree tree = parser.r(); // begin parsing at init rule 
         
	    ///System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
	    //System.out.println("    copy tree=" + root.toStringTree(parser2)); // print LISP-style tree
	      
    	// show in gui 
    	if(CST)
        	((RuleContext) tree).inspect(parser); 
    }
    
  //------------------Query and answer RIF rules --------------------------------------------
    /**
     * This method runs a query on provided rif KB and returns the answers. 
     * First it parses the rif KB to make sure it's syntactically correct (calls RIF parser function).
     *  
     * @param data
     * it contains the RIF KB (including rules and facts)
     * @param CST
     * Whether to show Concrete Syntax Tree of the input rules as well as the inferred rules. set to Not show.
     * @throws Exception
     * throws file IO exception 
     */
    public static void rifQuery(String data, String query, boolean CST) throws IOException{
    	
    	/* First parse the rif KB to make sure it's syntactically correct. Here, CST is used for the query not the RIF KB. */
    	rifParser(data, false);
    	
    	//parse the query
    	
    	// create a CharStream that reads from a file or a string
    	ANTLRInputStream input = new ANTLRInputStream(query);// data contains the input rules
    	
    	/*// create a CharStream that reads from a file    	 
    	File f = new File("rif2xml-1.rif"); 
    	//File f = new File("rif-ex2.rif"); 
    	//File f = new File("ex8.rif");
    	//File f = new File("ex1.rif");
    	FileInputStream fis = new FileInputStream(f);
        ANTLRInputStream input = new ANTLRInputStream(fis);
        */
        RIFBLDLexer lexer = new RIFBLDLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RIFBLDParser parser = new RIFBLDParser(tokens);
    	ParseTree tree = parser.clause(); // begin parsing at init rule 
         
	    ///System.out.println("orignial tree=" + tree.toStringTree(parser)); // print LISP-style tree
	    //System.out.println("    copy tree=" + root.toStringTree(parser2)); // print LISP-style tree
	      
    	// show in gui 
    	if(CST)
        	((RuleContext) tree).inspect(parser); 
    	
    }
    
    /*----------------Format (indent) the RIF inference result--------------------------------------------*/
    /**
     * This method pretty-prints (word-wraps) the tree by adding line feed ('\n') to some 
     * of the nodes
     * @param tree
     * tree that is going to be pretty format 
     * @return
     * returns the pretty print string value of the tree 
     */
      
    private static String Format(ParseTree tree) {		
        FormatReasoningResult frVisitor = new FormatReasoningResult();
        //System.out.println(util.tokens2String(util.getTokens(tree)));
        String stree = frVisitor.visit(tree);
        if(stree.indexOf("<EOF>")>0)
         	stree = stree.replace("<EOF>", "");
        //-----------------------------------
		return stree;
	}

    /*----------------------------add defualt namespace to <Document> tag------------------------*/
    /**
     * this method receives a string in RIF XML and adds a default namespace to its <Document> tag.
     * the default namespace is xmlns="http://www.w3.org/2007/rif#" .
     * This method uses Java Regex. it finds a pattern and updates the found matches.
     * @param htmlString
     * @return
     */
    public static String updateString(CharSequence htmlString) {
    	Pattern p = Pattern.compile("<Document.*>");    //pattern: starts with '<Document' can include anything and ends with '>'. 	
    	  Matcher m = p.matcher(htmlString);
      	
    	  StringBuffer sb = new StringBuffer(htmlString.length());
    	  while (m.find()) {
    	    String text = m.group(0);
    	    text = text.substring(0, text.length()-1) + " xmlns=\"http://www.w3.org/2007/rif#\">";
    	    
    	    m.appendReplacement(sb, Matcher.quoteReplacement(text));
    	  }
    	  m.appendTail(sb);
    	  return sb.toString();
    	}
    
}
