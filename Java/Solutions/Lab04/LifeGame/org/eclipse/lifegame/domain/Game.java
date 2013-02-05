package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class Game{
	private Board board;
	private int generation;
	
	public Game(){
		setBoard(new Board());
	}
	
	public Game(Board aBoard){
		this.board = aBoard;
		this.generation = 1;
	}
	
	/**
	 * @return
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return
	 */
	public int getGeneration() {
		return generation;
	}

	/**
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @param i
	 */
	public void setGeneration(int i) {
		generation = i;
	}

}
