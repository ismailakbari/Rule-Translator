/**
 * 
 */
package iakbari.ruletranslator.gui;

import iakbari.ruletranslator.syntaxhighlight.xml.XmlTextPane;

import javax.swing.JTextPane;

/**
 * @author Ismail Akbari
 * This class chooses the right editor (syntax highlighter) for the input language 
 * (N3, POSL, SWRL, Datalog RuleML, and RIF). The SWRL and Datalog RuleML are XML based.
 */
public class EditorHandler<T>{

	private T cls;
	
	public T get(){
		return this.cls;
	}	
	public void set(T cls){
		this.cls=cls;
	}
	
	//String language ="";
	/**
	 * @param language
	 * The language to select the editor for.
	 */
	public EditorHandler(String language) {
		String lang = language.toUpperCase();		
		switch (lang){
		case "N3":
		case "NOTATION3":
			break;
		case "POSL":
			break;
		case "SWRL":			
		case "DATALOGRULEML":			
		case "RIFXML":
			//this.cls = XmlTextPane;			
		case "RIF":
			break;	
		}
		//default
		//this.cls = JTextPane.class;
	}
	

}
