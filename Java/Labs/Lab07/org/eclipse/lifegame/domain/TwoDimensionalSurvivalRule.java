package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class TwoDimensionalSurvivalRule extends SurvivalRule implements TwoDimensionalRule{
	/**
	 * Returns the value for rule
	 */
	public int getCellValue(){
		return 1;
	}
	/**
	 * Returns whether or not rule appies for passed cells, and current cell
	 */
	public boolean doesApply(int[][] cells, int i, int j){
		int cellValue = cells[i][j];
		//return false if cell is not alive
		if (cellValue == 0)
			return false;
		//check if it's the first row
		if (i == 0){
			//check if it's fist cell in the first row
			if (j == 0){
				if (shouldFirstSurviveThreeAround(cells, i, j)) 
					return true;
				else 
					return false;
			}
			//check if it's last cell in the first row
			if (j == cells[0].length - 1){
				if (shouldLastFirstSurviveThreeAround(cells, i, j)) 
					return true;
				else
					return false;
			}
			//there are 5 surounding cells, check each of them
			return shouldFirstSurviveFiveAround(cells, j, i);
		}
		//check if it's the last row
		if (i == cells.length - 1){
			//check if it's fist cell in the last row
			if (j == 0){
				if (shouldLastFirstSurviveThreeAround(cells, j, i)) 
					return true;
				else
					return false;
			}
			//check if it's last cell in the first row
			if (j == cells[0].length - 1){
				if (shouldLastSurviveThreeAround(cells, i, j)) 
					return true;
				else
					return false;
			}
			//there are 5 surounding cells, check each of them
			return shouldLastSurviveFiveAround(cells, j, i);
		}
		//check if it's the first column
		if (j == 0){
			//no need to check for first or last row as we already did
			//there are 5 surounding cells, check each of them
			return shouldFirstSurviveFiveAround(cells, i, j);
		}
		//check if it's the last column
		if (j == cells[0].length - 1){
			//no need to check for first or last row as we already did
			//there are 5 surounding cells, check each of them
			return shouldLastSurviveFiveAround(cells, i, j);
		}
		//there are 8 surounding cells, check each of them
		return shouldSurviveEightAround(cells, i, j);
	}

	/**
	 * Returns wheather or not current cell should survive based on its 3 neighbours 
	 */
	private boolean shouldFirstSurviveThreeAround(int[][] cells, int k, int l){
		int counter = 0;
		if (cells[k][l+1] == 1) counter++;
		if (cells[k+1][l] == 1) counter++;
		if (cells[k+1][l+1] == 1)counter++;
		if ((counter == 2) || (counter == 3)) return true;
		return false;
	}
	
	/**
	 * Returns wheather or not current cell should survive based on its 3 neighbours 
	 */
	private boolean shouldLastSurviveThreeAround(int[][] cells, int k, int l){
		int counter = 0;
		if (cells[k][l-1] == 1) counter++;
		if (cells[k-1][l] == 1) counter++;
		if (cells[k-1][l-1] == 1)counter++;
		if ((counter == 2) || (counter == 3)) return true;
		return false;
	}
	
	/**
	 * Returns wheather or not current cell should survive based on its 3 neighbours 
	 */
	private boolean shouldLastFirstSurviveThreeAround(int[][] cells, int k, int l){
		int counter = 0;
		if (cells[k][l-1] == 1) counter++;
		if (cells[k+1][l] == 1) counter++;
		if (cells[k+1][l-1] == 1)counter++;
		if ((counter == 2) || (counter == 3)) return true;
		return false;
	}
	
	/**
		 * Returns wheather or not current cell should survive based on its 8 neighbours 
		 */
		private boolean shouldSurviveEightAround(int[][] cells, int k, int l){
			int counter = 0;
			if (cells[k][l+1] == 1) counter++;
			if (cells[k][l-1] == 1) counter++;
			if (cells[k+1][l] == 1) counter++;
			if (cells[k+1][l-1] == 1) counter++;
			if (cells[k+1][l+1] == 1) counter++;
			if (cells[k-1][l] == 1) counter++;
			if (cells[k-1][l-1] == 1) counter++;
			if (cells[k-1][l+1] == 1) counter++;
			if ((counter == 2) || (counter == 3)) return true;
			return false;
		}
	
		/**
		 * Returns wheather or not current cell (in the last row or column) should survive based on its 5 neighbours
		 */
		private boolean shouldLastSurviveFiveAround(int[][] cells, int k, int l){
			int counter = 0;
			if (cells[k-1][l] == 1) counter++;
			if (cells[k-1][l-1] == 1) counter++;
			if (cells[k+1][l] == 1) counter++;
			if (cells[k+1][l-1] == 1) counter++;
			if (cells[k][l-1] == 1) counter++;
			if ((counter == 2) || (counter == 3)) return true;
			return false;
		}
	
		/**
		 * Returns wheather or not current cell (in the first row or column) should survive based on its 5 neighbours
		 */
		private boolean shouldFirstSurviveFiveAround(int[][] cells, int k, int l){
			int counter = 0;
			if (cells[k-1][l] == 1) counter++;
			if (cells[k-1][l+1] == 1) counter++;
			if (cells[k+1][l] == 1) counter++;
			if (cells[k+1][l+1] == 1) counter++;
			if (cells[k][l+1] == 1) counter++;
			if ((counter == 2) || (counter == 3)) return true;
			return false;
		}
}
