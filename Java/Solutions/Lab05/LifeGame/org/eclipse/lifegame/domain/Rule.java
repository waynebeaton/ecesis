package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class Rule {
	private String name;
	
	public Rule(){
	}
	
	public Rule(String name){
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

}
