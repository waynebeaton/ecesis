package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public abstract class Game {
	private Board board;
	private Rule[] rules;
	private int generation;
	public Game(){
		this.rules = new Rule[3];
		this.generation = 1;
	}

	/**
	 * @return
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @return
	 */
	public Rule[] getRules() {
		return rules;
	}

	/**
	 * @param rules
	 */
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	/*
	 * Runs the game
	 */
	 public void run(){
	 	getBoard().evolve(this, getGeneration());
	 }

	/**
	 * @return
	 */
	public int getGeneration() {
		return generation;
	}

	/**
	 * @param i
	 */
	public void setGeneration(int i) {
		generation = i;
	}

}
