package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class TwoDimensionalDeathRule extends DeathRule  implements TwoDimensionalRule{
	/**
	 * Returns the value for rule
	 */
	public int getCellValue(){
		return 0;
	}
	
	/**
	 * Returns whether or not rule appies for passed cells, and current cell
	 */
	public boolean doesApply(int[][] cells, int i, int j){
		TwoDimensionalGame game = TwoDimensionalGame.getInstance();
		TwoDimensionalRule rule;
		for (int k = 0; k < game.getRules().length - 1; k++){
			rule = (TwoDimensionalRule)game.getRules()[k];
			if(rule.doesApply(cells, i, j)){
				return false;
			}
		}
		return true;
	}
}
