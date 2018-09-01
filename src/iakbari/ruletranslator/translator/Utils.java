package iakbari.ruletranslator.translator;

import iakbari.ruletranslator.parsers.RIFBLDLexer;
import iakbari.ruletranslator.parsers.RIFBLDParser;
import iakbari.ruletranslator.parsers.RIFBLDParser.AndFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.AtomicContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.AtomicFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ClauseContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ExistsFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FactContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.FormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.GroupContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.ImpliesContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.OrFormulaContext;
import iakbari.ruletranslator.parsers.RIFBLDParser.Rule1Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Utils {
	
	/**
	 * Retrieves all Tokens from the {@code tree} in an in-order sequence.
	 *
	 * @param tree
	 *         the parse tree to get all tokens from. context can be used as input parameter too. 
	 *
	 * @return all Tokens from the {@code tree} in an in-order (depth-first) sequence.
	 */
	public List<Token> getFlatTokenList(ParseTree tree) {
	    List<Token> tokens = new ArrayList<Token>();
	    inOrderTraversal(tokens, tree);
	    return tokens;
	}

	/**
	 * Makes an in-order traversal over {@code parent} (recursively) collecting
	 * all Tokens of the terminal nodes it encounters.
	 *
	 * @param tokens
	 *         the list of tokens.
	 * @param parent
	 *         the current parent node to inspect for terminal nodes.
	 */
	private void inOrderTraversal(List<Token> tokens, ParseTree parent) {

	    // Iterate over all child nodes of `parent`.
	    for (int i = 0; i < parent.getChildCount(); i++) {

	        // Get the i-th child node of `parent`.
	        ParseTree child = parent.getChild(i);

	        if (child instanceof TerminalNode) {
	            // We found a leaf/terminal, add its Token to our list.
	            TerminalNode node = (TerminalNode) child;
	            tokens.add(node.getSymbol()); 
	        }
	        else {
	            // No leaf/terminal node, recursively call this method.
	            inOrderTraversal(tokens, child);
	        }
	    }
	}
	
	/**
	 * Retrieves all Tokens from the {@code tree} in an in-order sequence.
	 *
	 * @param tree
	 *         the parse tree to get all tokens from. context can be used as input parameter too. 
	 *
	 * @return all Tokens from the {@code tree} in an in-order sequence.
	 */
	public Queue<String> getTokens(ParseTree tree) {
	    Queue<String> tokens = new LinkedList<String>();
	    inOrderTraversal2(tokens, tree);
	    return tokens;
	}

	/**
	 * Makes an in-order traversal over {@code parent} (recursively) collecting
	 * all Tokens of the terminal nodes it encounters.
	 *
	 * @param tokens
	 *         the list of tokens.
	 * @param parent
	 *         the current parent node to inspect for terminal nodes.
	 */
	private void inOrderTraversal2(Queue<String> tokens, ParseTree parent) {

	    // Iterate over all child nodes of `parent`.
	    for (int i = 0; i < parent.getChildCount(); i++) {

	        // Get the i-th child node of `parent`.
	        ParseTree child = parent.getChild(i);

	        if (child instanceof TerminalNode) {
	            // We found a leaf/terminal, add its Token to our list.
	            TerminalNode node = (TerminalNode) child;
	            tokens.add(node.getText()); 
	        }
	        else {
	            // No leaf/terminal node, recursively call this method.
	            inOrderTraversal2(tokens, child);
	        }
	    }
	}
	
	/**	 
	 * Retrieves  terminal nodes of the root of {@code tree} tree.
	 *
	 * @param tree
	 *         the parse tree to get its terminal nodes from. context can be used as input parameter too.
	 *
	 * @return terminal nodes of the root of the {@code tree} tree.
	 */
	public List<TerminalNode> getRootTerminalNodes (ParseTree tree){
		//System.out.println("fc children="+tree.getChildCount());
		List<TerminalNode> terminalNodes = new ArrayList<TerminalNode>();
		for (int i = 0; i < tree.getChildCount(); i++) {
			//System.out.println("fc child="+ tree.getChild(i).getClass().getName());
		    if (tree.getChild(i) instanceof TerminalNode) {
		        terminalNodes.add((TerminalNode)tree.getChild(i));
		    }
		}
		return terminalNodes;
	}
	/**
	 * matches the body of a rule (as a single atomic formula) with all facts in KB. Returns empty queue if both body and fact are FACTS (have no variables)
	 * @param body_tokens
	 * 	body as list of tokens
	 * @param fact_tokens
	 *  fact as list of tokens
	 * @return
	 * 	return the binding of variables between the body a fact
	 *  each variable is mapped to a value. each value is a queue of tokens. 
	 */
	private Queue<VarsValues> bindTokens(Queue<String> body_tokens, Queue<String> fact_tokens){
		
		
		Queue<VarsValues> bindings = new LinkedList<VarsValues>();
		VarsValues vv = new VarsValues();
		
		//copy body tokens
		Queue<String> b = copyQueue(body_tokens);		
		//Queue<String> f = copyQueue(fact_tokens);
		
		body_tokens.removeAll(fact_tokens);
		fact_tokens.removeAll(b);
		//if there are any non-variable tokens left in body, it means that the body and fact are not matched
		Iterator<String> it = body_tokens.iterator();
		while(it.hasNext())
			if(!isVar(it.next()))
				return null;
		//now assign each variable remained in body to a token remained in fact
		while(!body_tokens.isEmpty()){
			vv.addVar(body_tokens.remove());
			Queue<String> value = new LinkedList<String>();
			value.add(fact_tokens.remove());
			vv.addValue(value);			
		}
		//if there are any tokens left, they will be added to the last value 
		while(!fact_tokens.isEmpty()){
			Queue<String> value = new LinkedList<String>();
			value.add(fact_tokens.remove());
			vv.addValue(value);	
		}		
		bindings.add(vv); 
		
		return bindings;
		/*
		//bind each var to its corresponding fact parts		 
		//Queue<String> tmp = new LinkedList<String>();
		String topb, topf, nextb, nextf;
		//int index =0 ; //var index in array
		while(!body_tokens.isEmpty()){
			topb = body_tokens.remove();
			//check if the token is a variable
			if(isVar(topb)){
				var.add(topb);
				//if the queue has only 1 element and its a variable then it matches rest of the fact queue
				if(body_tokens.isEmpty()){
					//match ?var with fact queue
					while(!fact_tokens.isEmpty())
						value.add(fact_tokens.remove());
					//bindings.put(topb,  queue2SetQueue(tmp)); 	// queue2SetQueue converts tmp to a set to be compatible with the BindFacts method.
					
				}else{
					nextb = body_tokens.remove();
					while(!fact_tokens.isEmpty()){
						nextf = fact_tokens.remove();
						if(nextb.equals(nextf))
							break;
						else
							value.add(nextf);
					}
					vv.setVars(vars);
					vv.setValues(values);
					values.add(value);
					bindings.add(vv);					
				}			
				//tmp.clear();	
			}
			else{
				topf = fact_tokens.remove();
				//if there are 2 unmatched tokens
				if(!topb.equals(topf))
					return null;
			}			
		}
		//if there is anything left in one of the token lists, then the 2 lists are not matched 
		if(!body_tokens.isEmpty() || !fact_tokens.isEmpty())
			return null;
		
		 
		
		return bindings;
		*/
	}
	
	private Queue<String> copyQueue(Queue<String> body_tokens) {
		// TODO Auto-generated method stub
		
		Queue<String> copy = new LinkedList<String>();
		Iterator<String> it = body_tokens.iterator();
		while(it.hasNext())
			copy.add(it.next());				
		return copy;
	}

	/**
	 * convert queue of tokens to a set of queue of tokens (with only one queue) to be compatible with the BindFacts method.
	 * @param tmp
	 * queue of tokens
	 * @return
	 *  set of queue of tokens (with one element) 
	 */
	private Set<Queue<String>> queue2SetQueue(Queue<String> tmp) {
		// TODO Auto-generated method stub
		
		Set<Queue<String>> s = new HashSet<Queue<String>>();
		s.add(tmp);		
		return s;
	}

	/**
	 * binds body of an atomic rule with all facts in KB. I am ASSUMING that atomic formula does not need previous binding.
	 * I may be wrong. Time will prove it. 
	 * @param body
	 *  body of an atomic rule
	 * @return
	 *  bindings between variables in the body (atomic rule) and facts
	 */
	private Queue<VarsValues> bindFacts(ParseTree body, Queue<VarsValues> preBinds) {
		// TODO Auto-generated method stub
		
		Queue<VarsValues> bindings = new LinkedList<VarsValues>();
		Queue<VarsValues> tmp      = new LinkedList<VarsValues>();
		VarsValues top  = new VarsValues();
		//first we need to get access to the Group element
		ParseTree group = body.getParent();		
		while(!(group instanceof GroupContext))
		group = group.getParent();
		
		//body tokens
		Queue<String> body_tokens = new LinkedList<String>();
		//fact tokens
		Queue<String> fact_tokens = new LinkedList<String>();
		ParseTree child, fact;

		
		//add previous bindings to the body
		if(preBinds!=null && !preBinds.isEmpty()){
			while(!preBinds.isEmpty()){
				//top.clear();
				top = preBinds.remove();
				
				//find facts
				for(int j=0; j< group.getChildCount(); j++){
					child = group.getChild(j) ;
					if(child instanceof RIFBLDParser.FactContext){
						//body tokens
						body_tokens.clear();
						body_tokens.addAll(getTokens(body));
						body_tokens = updateBodyTokens(body_tokens, top);
						///System.out.println("body="+body_tokens);
						
						//read fact								
						fact = ((RIFBLDParser.FactContext) child).clause();
						//fact tokens
						fact_tokens.clear();
						fact_tokens.addAll(getTokens(fact));
						///System.out.println("fact="+fact_tokens);
						
						//now bind body tokens with fact tokens
						tmp = bindTokens(body_tokens, fact_tokens);
						if(tmp!=null){
							//add top 
							tmp.add(top);
							bindings.addAll(tmp);
							//tmp.clear();
							///System.out.println("bindings="+ bindingstoString(bindings));
						}
					}
				}//for	
			}
			
		}else			
			for(int j=0; j< group.getChildCount(); j++){
				child = group.getChild(j) ;
				if(child instanceof RIFBLDParser.FactContext){					
					//body tokens
					body_tokens.clear();
					body_tokens.addAll(getTokens(body));
					//body_tokens = updateBodyTokens(body_tokens, top);
					///System.out.println("body="+body_tokens);
					
					//read fact								
					fact = ((RIFBLDParser.FactContext) child).clause();
					//fact tokens
					fact_tokens.clear();
					fact_tokens.addAll(getTokens(fact));
					///System.out.println("fact="+fact_tokens);
					
					//now bind body tokens with fact tokens
					tmp = bindTokens(body_tokens, fact_tokens);
					if(tmp!=null){
						bindings.addAll(tmp);
						//tmp.clear();
						///System.out.println("bindings="+ bindingstoString(bindings));
					}
				}
			}//for
		return bindings;
	}

	public String bindingstoString(Queue<VarsValues> bindings) {
		// TODO Auto-generated method stub
		Iterator<VarsValues> it = bindings.iterator();
		VarsValues v ;
		String s="";
		while(it.hasNext()){
			v = it.next();
			s+=v.vars +"=";
			s+=v.values +"\n";
		}
		return s;
	}

	/**
	 * updates body with variable bindings from previous formulae 
	 * @param body_tokens
	 * @param top
	 * is the top element of previous bindings queue
	 * top is  {vars, values}. e.g.:
	 * 	vars={?customer, ?birthday} and values = {"Jane Doe", "May 21, 1990"} 
	 * @return
	 */
	private Queue<String> updateBodyTokens(Queue<String> body_tokens, VarsValues top) {
		// TODO Auto-generated method stub
		
		Queue<Queue<String>> newBTs = new LinkedList<Queue<String>>(); // all new bodies
		
		//calculate how many new body_tokens will be created. total = ( num of variables * num of values for each variable)
		int total;
		String token;
		/*Iterator<String> it = body_tokens.iterator();
		while(it.hasNext()){
			if(isVar(token)){
				newBTs = updateBodyTokens(token, body_tokens, newBTs);
			}
		}
		*/
		Queue<String> tmp =  new LinkedList<String>();
		while(!body_tokens.isEmpty()){
			token = body_tokens.remove();
			if(isVar(token)){
				Queue<String> value = top.getValue(token);
				if(value!=null)
					tmp.addAll(value);
				else // var does not have a match in previous bindings. So the var will be added
					tmp.add(token);
			}
			else
				tmp.add(token);
		}
		return tmp;
	}
	
	private Queue<Queue<String>> updateBodyTokens2(Queue<Queue<String>> body_tokens, VarsValues bindings) {
		// TODO Auto-generated method stub
		
		//check if all the body_tokens are fact
		Queue<String> top;
		Iterator<Queue<String>> iter = body_tokens.iterator();
		Iterator<String> it , it2;
		boolean fact = true;
		while(iter.hasNext()){
			top = iter.next();
			it = top.iterator();
			//check if top has any variables (is a fact)
			while(it.hasNext())
				if(isVar(it.next())){
					fact = false;
					break;
				}
		}
		if(fact)
			return body_tokens;
		
		top = body_tokens.remove(); // all new bodies
		/*it = top.iterator();
		//check if top has any variables (is a fact)
		while(it.hasNext())
			if(isVar(it.next())){
				fact = false;
				break;
			}
		if(!fact){
			*///replace the first variable with its all occurrences. then recurse the method
			String token, token2;
			it = top.iterator();
			while(it.hasNext()){
				token = it.next();
				if(isVar(token)){
					Queue<Queue<String>> values = bindings.getValues(token);
					while(!values.isEmpty()){
						Queue<String> value =values.remove();
						Queue<String> tmp =  new LinkedList<String>();			
						//copy token from beginning to this var. then replace var with its values
						it2 = top.iterator();
						boolean firstVar = true; // to replace only the first occurrence of the variable
						while(it2.hasNext()){
							token2 = it2.next();
							if(token2.equals(token) && firstVar){
								tmp.addAll(value);
								firstVar = false;
							}	
							else
								tmp.add(token2);
						}
						body_tokens.add(tmp);
					}
					break; //will not check the rest of tokens
				}
			}
		//}
		//else
		//	result.add(top);		
		body_tokens = updateBodyTokens2 (body_tokens, bindings);
		return body_tokens;
	}

	private Queue<Queue<String>> preUpdateBodyTokens(Queue<VarsValues> bindings) {
		// TODO Auto-generated method stub
		
		VarsValues top = bindings.remove();
		VarsValues binds = new VarsValues();
		///using set to prevent var repetition		
		Set<String> varss =  new HashSet<String>();
		for(String var : top.vars)
			varss.add(var);
		//convert the set back to queue
		Queue<String> vars =  new LinkedList<String>();
		for(String var : varss)
			vars.add(var);
		
		Set<Queue<String>> values = new HashSet<Queue<String>>();
		
		/*
		Queue<Queue<String>> values = bindings.getValues(variable);
		Queue<String> value;
		if(newBTs.isEmpty()){
			String token;			
			Iterator<String> it = body_tokens.iterator();
			while(it.hasNext()){				
				token = body_tokens.remove();
				if(isVar(token)){
					value = top.getValue(token);
					if(value!=null)
						tmp.addAll(value);
					else // var does not have a match in previous bindings. So the var will be added
						tmp.add(token);
				}
				else
					tmp.add(token);
			}
			return tmp;
			
		}
		else{
			
		}
		*/
		return null;
	}

	//---------------------------------------------------------------------------------
	/**
	 * 
	 * @param body
	 * 	body of a rule. it's of formula type
	 * @param preBinds
	 * 	previous bindings passed to next formula. used in conjunction, disjunction, existential and external formulas.
	 *  previous bindings is a list of maps between variables and their values. list is updated in next 
	 *  subformulas of And, Or, Exists External. following is an example (from W3C RIF-BLD web page):
	 *  
	 *  Forall ?item ?deliverydate ?scheduledate ?diffduration ?diffdays (
        cpt:reject(<John> ?item) :-
            And(cpt:perishable(?item)
                cpt:delivered(?item ?deliverydate <John>)
                cpt:scheduled(?item ?scheduledate)
                ?diffduration = External(func:subtract-dateTimes(?deliverydate ?scheduledate))
                ?diffdays = External(func:days-from-duration(?diffduration))
                External(pred:numeric-greater-than(?diffdays 10)))
                
        or rule:
        
        Forall ?item (
        cpt:reject(<John> ?item ) :-
            Exists ?deliverydate ?scheduledate ?diffduration ?diffdays (
                 And(cpt:perishable(?item)
                     cpt:delivered(?item ?deliverydate <John>)
                     cpt:scheduled(?item ?scheduledate)
                     ?diffduration = External(func:subtract-dateTimes(?deliverydate ?scheduledate))
                     ?diffdays = External(func:days-from-duration(?diffduration))
                     External(pred:numeric-greater-than(?diffdays 10)))
            )
   		)
        
                 
	 *  <?items>        | {milk, fruit}		
	 *  deliverableDate | {NOV 12, NOV 15}	
	 *  		...		|		...			
	 *  									
	 *   
	 * @return
	 * 	return the binding of variables between the body of a rule and all facts in knowledge base (as a map).
	 */
	public Queue<VarsValues> bindFormula(ParseTree body, Queue<VarsValues> preBinds){

		//bind each var to its corresponding fact parts
		
		Queue<VarsValues> tmp_bindings = new LinkedList<VarsValues>();
		
		ParseTree child;
		
		//check body (formula) type: atomic, conjunctive, disjunctive, existential or external
		
		//Atomic		
		if(body instanceof AtomicFormulaContext)
			preBinds = bindFacts(body, preBinds);
		
		//conjunction
		if(body instanceof AndFormulaContext){			
			for(int i=0; i< body.getChildCount(); i++){
				child = body.getChild(i) ;
				if(child instanceof FormulaContext){
					tmp_bindings = bindFacts(child, preBinds);
					if(tmp_bindings!=null && !tmp_bindings.isEmpty())
						preBinds.addAll(tmp_bindings);
					else
						return null;
				}
			}	
		}
		
		//Disjunction
		if(body instanceof OrFormulaContext){	
			//Queue<VarsValues> or_bindings = new LinkedList<VarsValues>();
			for(int i=0; i< body.getChildCount(); i++){
				child = body.getChild(i) ;
				if(child instanceof FormulaContext){
					tmp_bindings.addAll(bindFacts(child, preBinds));
					//if(tmp_bindings!=null && !tmp_bindings.isEmpty())
					//else
						//return null;
				}
			}
			preBinds.addAll(tmp_bindings);			
		}
		
		//Existential
		if(body instanceof ExistsFormulaContext){	
			//Queue<VarsValues> or_bindings = new LinkedList<VarsValues>();
			for(int i=0; i< body.getChildCount(); i++){
				child = body.getChild(i) ;
				if(child instanceof FormulaContext){
					tmp_bindings.addAll(bindFormula(child, preBinds));
					//if(tmp_bindings!=null && !tmp_bindings.isEmpty())
					//else
						//return null;
				}
			}
			preBinds.addAll(tmp_bindings);			
		}

		
		return preBinds;	
		
		/*
		List<TerminalNode> roottnodes = getRootTerminalNodes(body);
		//atomic formula
		if(roottnodes.isEmpty()){			
			 tmp_bindings.clear();
			 tmp_bindings = bindAtomic(body, preBinds) ;
			 bindings.clear();		
			 if(tmp_bindings!=null)
				 bindings.putAll(tmp_bindings);
		}				
		else
			switch(roottnodes.get(0).getText()){
				//conjunction
				case "And" :
					
					for(int i=0; i<body.getChildCount(); i++){
						if(body.getChild(i) instanceof FormulaContext){							
							tmp_bindings.clear();
							tmp_bindings = bindFormula(body.getChild(i), fact);
							//if there is no match for one of the formulas in conjunction the whole conjunction matches to false
							if(tmp_bindings==null || tmp_bindings.isEmpty())
								return null;
							bindings.putAll(tmp_bindings);
						}
							
					}
					
					
					break;
					//disjunction
				case "Or" :
					
					for(int i=0; i<body.getChildCount(); i++){
						if(body.getChild(i) instanceof FormulaContext){							
							tmp_bindings.clear();
							tmp_bindings = bindFormula(body.getChild(i), fact);
							//if there is no match for one of the formulas in conjunction the whole conjunction matches to false
							if(tmp_bindings!=null)
								bindings.putAll(tmp_bindings);
						}
							
					}
					
					break;
					//Existential
				case "Exists" :
					
					for(int i=0; i<body.getChildCount(); i++){
						if(body.getChild(i) instanceof FormulaContext){							
							tmp_bindings.clear();
							tmp_bindings = bindFormula(body.getChild(i), fact);
							//if there is no match for one of the formulas in conjunction the whole conjunction matches to false
							if(tmp_bindings!=null)
								bindings.putAll(tmp_bindings);
						}
							
					}
					//check if all variable have bindings
					boolean bound = true;
					Queue<String> vars = getVariables(body);
					for(String var : vars)
						if(bindings.get(var)==null || bindings.get(var).isEmpty())
							bound = false;
					if(bound)
						return bindings;
					else
						return null;					
					//break;
					
					//External formula
				case "External" :
					
					break;						
			}
		*/
		/*
		//int varCount = varCount(body_tokens);
		Queue<String> tmp = new LinkedList<String>();
		String headb, headf, nextb, nextf;
		//int index =0 ; //var index in array
		while(!body_tokens.isEmpty()){
			headb = body_tokens.remove();
			//check if the token is a variable
			if(isVar(headb)){				
				//if the queue has only 1 element and its a variable then it matches rest of the fact queue
				if(body_tokens.isEmpty()){
					//match ?var with fact queue
					while(!fact_tokens.isEmpty())
						tmp.add(fact_tokens.remove());
					bindings.put(headb, tmp);					
				}else{
					nextb = body_tokens.remove();
					while(!fact_tokens.isEmpty()){
						nextf = fact_tokens.remove();
						if(nextb.equals(nextf))
							break;
						else
							tmp.add(nextf);
					}
					bindings.put(headb, tmp);					
				}			
				//tmp.clear();	
			}
			else{
				headf = fact_tokens.remove();
				//if there are 2 unmatched tokens
				if(!headb.equals(headf))
					return null;
			}			
		}
		//if there is anything left in one of the token lists, then the 2 lists are not matched 
		if(!body_tokens.isEmpty() || !fact_tokens.isEmpty())
			return null;
		return bindings;
		*/
		//return bindings;
	}
	
	/**
	 * returns the variables of a rule
	 * @param root_node
	 * @return
	 * 	returns variables of the rule
	 */
	private Queue<String> getVariables(ParseTree root_node) {
		// TODO Auto-generated method stub
		List<TerminalNode> rtn = getRootTerminalNodes(root_node);
		Queue<String> vars = new LinkedList<String>();
		for(TerminalNode tn : rtn)
			if(isVar(tn.getText()))
				vars.add(tn.getText());
		return vars;
	}

	//---------------------------------------------------------------------------------
	/**
	 * 
	 * @param token
	 * @return 
	 * 	checks if a token string is a variable comparing its first char with '?' 
	 */
	private boolean isVar(String token){
		return (token.charAt(0)=='?');
	}
	
	/**
	 * searches a queue of tokens for variables 
	 * @param tokens
	 * @return
	 * 	numbers of variables in a queue of tokens
	 */
	private int varCount(Queue<String> tokens){
		int vc =0;
		Iterator<String> iter = tokens.iterator();
		while(iter.hasNext()){
			if(iter.next().charAt(0)=='?')
				vc++;
		}
		return vc;
	}

	/**
	 * 
	 * @param ac
	 * 	atomic clause in head 
	 * @param bindings
	 * 	variable bindings. each variable has a value bound to it. 
	 * @return
	 * 	returns a new fact by bindings variables in the atomic clause (of head of a rule) with values from the bindings list
	 */
	public List<AtomicContext> bindHead(AtomicContext head, Queue<VarsValues> bindings) {
		// TODO Auto-generated method stub		 
		
		List<AtomicContext> res = new ArrayList<AtomicContext>();		
		Queue<Queue<String>> results = new LinkedList<Queue<String>>();
		results.add(getTokens(head));
		
		//at first put all bindings in one object
		//remove the repeated bindings from the list 
		bindings = trimBindings(bindings); //now bindings has only one element (object of tyep VarsValues)
		///System.out.println(bindingstoString(bindings));
		VarsValues binds = bindings.remove();
		//second get all combination of bindings. combination of variables' values
		results = updateBodyTokens2(results, binds);
		 
		
		/**convert the new facts (queue tokens of each new fact) to a list of AtomicContext with the help
		 * of RIF-BLD lexer and parser
		 *Because queue.toString() does not return the desired result as an input to ANTLR input stream, method queue2TokenString is used. 
		 */
		while(!results.isEmpty()){
			ANTLRInputStream input = new ANTLRInputStream(tokens2String(results.remove()));
			//System.out.println("input stream="+ input.toString());
			RIFBLDLexer lexer = new RIFBLDLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			tokens.fill();
			///System.out.println("bind head tokens="+tokens.getText());
			//System.out.println("in util>>toekns="+ tokens.toString());
			RIFBLDParser parser = new RIFBLDParser(tokens);
			//th = parser.atomic();
			//AtomicContext atom = (AtomicContext) th;				
			//System.out.println("in util>>head2fact="+ tree.toStringTree(parser));		
			//return atom;
			res.add(parser.atomic());
			
		}
		return res;	    
	}
	
	/**
	 * Because queue.toString() does not return the desired result as an input to ANTLR input stream,this method is used.
	 * converts a queue of token strings to a string. it puts an space between each token.  
	 * @param tokens
	 * 	a queue contains token strings
	 * @return
	 *  returns a string representation of the queue argument
	 */
	public String tokens2String(Queue<String> tokens){
		String s = "";
		for(String st : tokens)
			s += st+" ";
		return s;
	}
	
	/**
	 * Adds new (inferred) facts to the KB
	 * @param bindingsCopy
	 * queue of new facts
	 * @param group
	 * parent of facts and rules in KB parse tree
	 */
	public void addNewFacts(Queue<VarsValues> bindings, ParseTree implies){
		
		//now time to bind body with head
		
		AtomicContext headi, tmp;
		List<AtomicContext> headFacts; //each atomic context in head of a rule is bound against all the bindings		
		
		/**
		 * At first, last child (close parenthesis) of Group element is removed
		 *  then the new fact and last child are added to the Group. 
		 * last child of Group is ')'
		 * 
		 */
		//first we need to get access to the Group element
		ParseTree group;
		group = implies.getParent();		
		while(!(group instanceof GroupContext))
			group = group.getParent();
		int childCount = group.getChildCount();
		TerminalNode lastChild = (TerminalNode) group.getChild(childCount-1);
		((ParserRuleContext) group).removeLastChild();
		
		//if there is any bindings they will be added to the end of group
		//first need to make a copy of bindings. it seems collections are not immutable
		Queue<VarsValues> bindingsCopy = new LinkedList<VarsValues>();		
		Iterator<VarsValues> it = bindings.iterator();  
		while(it.hasNext())
			bindingsCopy.add(it.next().deepCopy());	
		if(bindingsCopy!=null && !bindingsCopy.isEmpty()){
			for(int k=0; k<implies.getChildCount(); k++){								 
				if( implies.getChild(k) instanceof AtomicContext){
					headi = (AtomicContext) implies.getChild(k) ; 
					headFacts = bindHead(headi, bindingsCopy); //headf is the new (inferred) fact
					//remove equals such as {ex:b = ex:b} or {ex:b = ex:c , ex:c = ex:b}. SHOULD BE UPDATED LATER
					
					/**
					 *  letf empty to remind of implementing update_equals method
					 */
					
					
					/**
					 * add new inferred atomic fact to the KB (as Group element's child). Also ctx child count gets updated.
					 * new fact is added before last child (closing parenthesis) of Group element. 
					 * Group (rule1_1, ruel1_2, ...,rule1_n, rule1_NEW_FACT)
					 */
					//new facts are added one by one to the end of group
					while(!headFacts.isEmpty()){
						tmp = headFacts.remove(0);
						Rule1Context rule1 = new Rule1Context(); 
						ClauseContext clause = new ClauseContext(rule1, -1); //rule1 is parent. not sure about -1.
						clause.addChild(tmp);
						rule1.addChild(clause);
						((ParserRuleContext) group).addChild(rule1);
						//childCount = group.getChildCount();
					}
					//copy bindings again. Because AtomicContext consumes the bindingsCopy
					it = bindings.iterator();  
					bindingsCopy.clear();
					while(it.hasNext())
						bindingsCopy.add(it.next().deepCopy());					
				}				
			}
		}
		// finally ')' is added back to the Group element.
		((ParserRuleContext) group).addChild(lastChild);					
	}

	public Queue<VarsValues> trimBindings(Queue<VarsValues> bindings) {
		// TODO Auto-generated method stub		
		 
		Queue<VarsValues> result = new LinkedList<VarsValues>();		
		result = sortBinds(bindings);
		result = removeRepeatedBinds(result);
		///System.out.println("bindings size="+ result.size());
		return result;
	}

	/**
	 * bindings has only ONE elmenet (of type VarValues) 
	 * @param bindings
	 * @return
	 */
	private Queue<VarsValues> removeRepeatedBinds(Queue<VarsValues> bindings) {
		// TODO Auto-generated method stub
		
		Queue<VarsValues> result = new LinkedList<VarsValues>();
		VarsValues bin = bindings.remove(), tmp = new VarsValues();
		//VarsValues v1, v2;
		Iterator<String> it1, it2;
		it1 = bin.vars.iterator();
		it2 = bin.vars.iterator();
		Iterator<Queue<String>> vlit1, vlit2;
		vlit1 = bin.values.iterator();
		vlit2 = bin.values.iterator();
		String var1, var2;
		Queue<String> value1, value2;
		
		int i=0; //it2 should refer to elements after it1
		while(it1.hasNext()){
			boolean rep = false;
			var1 = it1.next();
			value1 = vlit1.next(); 
			i++;
			for(int j=0;j<i; j++){
				it2.next(); //check elements after it1
				value2 = vlit2.next();
			}	
			while(it2.hasNext()){
				var2 = it2.next();
				value2 = vlit2.next();
				if(var1.equals(var2) && equals(value1, value2)){
					rep = true;
					break; //there's no need to check the remaining
				}	
			}
			if(!rep){
				tmp.vars.add(var1);
				tmp.values.add(value1);
			}	
			it2 = bin.vars.iterator();// reset it2 because above while will consume it. 
			vlit2 = bin.values.iterator();
		}	
		result.add(tmp);
		return result;
		
	}
	

	/**
	 * takes all the bindings and put them in ONE VarsValues object (queue with one element) 
	 * @param result
	 * @return
	 */
	private Queue<VarsValues> sortBinds(Queue<VarsValues> result) {
		// TODO Auto-generated method stub
		
		Queue<VarsValues> res = new LinkedList<VarsValues>();
		VarsValues tmp = new VarsValues();			
		Iterator<VarsValues> it = result.iterator();
		while(it.hasNext()){
			VarsValues v = it.next();
			tmp.vars.addAll(v.vars);
			tmp.values.addAll(v.values);
		}
		res.add(tmp);
		return res;
	}
	
	public boolean equals(Queue<String> q1, Queue<String> q2) {
		// TODO Auto-generated method stub
		
		if(q1.size()!=q2.size())
			return false;
		
		Iterator<String> it1 = q1.iterator();
		Iterator<String> it2 = q2.iterator();
		while(it1.hasNext()){
			if(!it1.next().equals(it2.next()))
					return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
}//class
