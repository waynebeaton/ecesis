package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class Board{
	private int[][] cells;

	public Board(){
		this.cells = new int[10][10];
	}
	
	public Board(int[][] cells){
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
		return "Board for game of life";
	}
	
	/**
	 * Evolves board
	 */
	public void evolve(Game aGame){
	}
	/**
	 * Evolves board as many times as passed index
	 */
	public void evolve(Game aGame, int index){

	}
}
