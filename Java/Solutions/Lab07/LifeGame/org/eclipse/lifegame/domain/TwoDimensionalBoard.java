package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class TwoDimensionalBoard extends Board{
	private int[][] cells;

	public TwoDimensionalBoard(){
		this.cells = new int[10][10];
	}
	
	public TwoDimensionalBoard(int[][] cells){
			this.cells = cells;
		}

	/**
	 * @return
	 */
	public int[][] getCells() {
		return cells;
	}

	/**
	 * @param is
	 */
	public void setCells(int[][] is) {
		cells = is;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < getCells().length; i++){
			buffer.append("\n");
			for (int j = 0; j < getCells()[0].length; j++){
				if (getCells()[i][j] == 0)
					buffer.append(" ");
				else 
					buffer.append("X");
			}
		}
		return buffer.toString();
	}
	
	/**
	 * Evolves board
	 */
	public void evolve(Game aGame){
		boolean doesAnyApply = false;
		TwoDimensionalRule rule = null;
		for (int i = 0; i < cells.length; i++){
			for (int j = 0; j < cells[0].length; j++){
				doesAnyApply = false;
				for (int k = 0; k < aGame.getRules().length; k++){
					rule = (TwoDimensionalRule)aGame.getRules()[k];
					if(rule.doesApply(getCells(), i, j)){
						getCells()[i][j] = rule.getCellValue();
						doesAnyApply = true;
						break;
					}
				}
				if (!(doesAnyApply))
					System.out.println("No rules apply for cell[" + i + "][" + j + "]");
			}
		}
	}
	/**
	 * Evolves board as many times as passed index
	 */
	public void evolve(Game aGame, int index){
		if (index == 0) return;
		for (int i = 1; i <= index; i++){
			evolve(aGame);
			System.out.println(this);
		}
	}
}
