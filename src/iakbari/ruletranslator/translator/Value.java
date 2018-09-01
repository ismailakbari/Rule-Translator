package iakbari.ruletranslator.translator;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Value {
	/**
	 *  Returns leaves of a tree (node). In other words returns a flat representation of a tree.  
	 */
	private ParseTree tree;
	
	/**
	 * 
	 * @param tree
	 * 	The parse tree or node context to return its leaves
	 */
	public Value(ParseTree tree){
		this.tree = tree;
	}
	
	/**
	 * 
	 * @return 
	 * 	return the {@code tree} as a string. 
	 */
	public String asText(){
		return tree.getText();
	}
	
	/**
	 * 
	 * @return
	 * return the {@code tree} as a List<TerminalNode>.
	 * uses Utils class to return tree as list of terminals. all leaves are returned.
	 */
	//  
	public List<TerminalNode> asTerminals(){
		Utils util = new Utils();
		return util.getRootTerminalNodes(tree);
	}

	/**
	 * 
	 * @return
	 * return the {@code tree} as a List<Token>.
	 *uses Utils class to return tree as list of tokens. all leaves are returned.   
	 */
	//
	public List<Token> asTokens(){
		Utils util = new Utils();
		return util.getFlatTokenList(tree);
	}

}
