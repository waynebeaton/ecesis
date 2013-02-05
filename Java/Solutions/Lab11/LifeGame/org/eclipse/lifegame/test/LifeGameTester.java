package org.eclipse.lifegame.test;

import org.eclipse.lifegame.domain.TwoDimensionalBoard;
import org.eclipse.lifegame.domain.TwoDimensionalGame;

/**
 * @author Espirity Inc.
 */
public class LifeGameTester {

	public static void main(String[] args) {
		int[][] boardCells = {
			{0, 0, 0, 1, 0, 0, 1 , 0, 1, 0}, 
			{0, 0, 1, 0, 1, 0, 1 , 0, 0, 0}, 
			{1, 0, 0, 1, 0, 0, 1 , 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 1 , 0, 0, 0},
			{0, 0, 1, 0, 1, 0, 1 , 1 ,0, 0}, 
			{0, 0, 0, 1, 0, 0, 1 , 1, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 1 , 1, 0, 1},
			{1, 0, 1, 0, 1, 0, 1 , 0, 1, 0},
			{0, 0, 1, 0, 1, 0, 1 , 0, 1, 1}, 
			{0, 0, 0, 1, 0, 0, 1 , 0, 0, 1}};
		TwoDimensionalBoard board = new TwoDimensionalBoard(boardCells);
		TwoDimensionalGame.clearInstance();
		TwoDimensionalGame game = TwoDimensionalGame.getInstance();
		game.setBoard(board);
		game.setGeneration(10);
		game.run();
		game.printHistory();
	}
}
