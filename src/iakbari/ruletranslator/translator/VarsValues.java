package iakbari.ruletranslator.translator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class VarsValues {
	
	Queue<String> vars;
	Queue<Queue<String>> values;
	
	public VarsValues(){
		vars = new LinkedList<String>();
		values = new LinkedList<Queue<String>>();		
	}

	public VarsValues(Queue<String> vars, Queue<Queue<String>> values) {
		super();
		this.vars = vars;
		this.values = values;
	}

	public Queue<String> getVars() {
		return vars;
	}

	public void setVars(Queue<String> vars) {
		this.vars = vars; 
	}

	public Queue<Queue<String>> getValues() {
		return values;
	}

	public void setValues(Queue<Queue<String>> values) {
		this.values = values;
	}

	public void addVar(String var){
		this.vars.add(var);
	}
	
	public void addValue(Queue<String> value){
		this.values.add(value);
	}
	
	/**
	 * Returns the first value bound to a var from previous formulas (e.g. from conjunctive formulas)
	 * @param var
	 * variable to get its match value
	 * @return
	 * value bound (matched) to a value
	 */
	public Queue<String> getValue(String var){
		Queue<String> val;
		if(!this.vars.contains(var))
			return null;
	
		//get the index;
		int ind =0; 
		Iterator<String> it = vars.iterator();
		while(it.hasNext())
			if(!it.next().equals(var))
				ind++;
			else
				break;
		Iterator<Queue<String>> it2 = values.iterator();
		for(int i=0; i<ind; i++)
			it2.next();
		val = it2.next();
		return val;
	}
	
	/**
	 * Returns all values bound to a var from previous formulas (e.g. from conjunctive formulas)
	 * @param var
	 * variable to get its match values
	 * @return
	 * values bound (matched) to a value
	 */
	public Queue<Queue<String>> getValues(String var){
		 
		Queue<Queue<String>> vals = new LinkedList<Queue<String>>();
		if(!this.vars.contains(var))
			return null;
	
		//get the index;
		int ind =0; 
		Iterator<String> it = vars.iterator();
		while(it.hasNext()){
			if(it.next().equals(var))
				vals.add(getValue(ind));
			ind++;
		}
		
		return vals;
	}
	
	public Queue<String> getValue(int index) {
		// TODO Auto-generated method stub
		int ind =0; 
		Iterator<Queue<String>> it = values.iterator();
		while(ind!=index){
			it.next();
			ind++;
		}	
		return it.next();
	}
	public String getVar(int index) {
		// TODO Auto-generated method stub
		int ind =0; 
		Iterator<String> it = vars.iterator();
		while(ind!=index)
			it.next();
		return it.next();
	}

	public void clear(){
		this.vars.clear();
		this.values.clear();		
	}
	
	public boolean equal(VarsValues v){		
		boolean equal = true;
		if(!this.vars.containsAll(v.vars))
			equal = false;
		if(!this.values.containsAll(v.values))
			equal = false;
		return equal;
	}
	
	public VarsValues deepCopy(){
		VarsValues dc = new VarsValues();
		
		//copy vars
		Iterator<String> sit = this.vars.iterator();		
		while(sit.hasNext())
			dc.vars.add(sit.next());
		
		//copy values
		Queue<String> tmp; 
		Iterator<Queue<String>> it = this.values.iterator();
		while(it.hasNext()){ 
			tmp = it.next();
			sit = tmp.iterator();	
			Queue<String> val = new LinkedList<String>();
			while(sit.hasNext())
				val.add(sit.next());
			dc.values.add(val);
			//val.clear();
		}		
		return dc;		
	}
}




















