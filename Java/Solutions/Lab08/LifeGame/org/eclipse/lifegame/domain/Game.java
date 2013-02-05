package org.eclipse.lifegame.domain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Espirity Inc.
 */
public abstract class Game {
	private Board board;
	private Rule[] rules;
	private int generation;
	private ArrayList boardHistory;
	
	public Game(){
		this.rules = new Rule[3];
		this.generation = 1;
		this.boardHistory = new ArrayList();
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
	 	clearHistory();
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

	/**
	 * @return
	 */
	public ArrayList getBoardHistory() {
		return boardHistory;
	}

	/**
	 * @param list
	 */
	public void setBoardHistory(ArrayList list) {
		boardHistory = list;
	}
	
	public void addToHistory(Board aBoard){
		getBoardHistory().add(aBoard);
	}
	
	public void clearHistory(){
		getBoardHistory().removeAll(getBoardHistory());
	}
	
	public void printHistory(){
		Iterator iterator = getBoardHistory().iterator();
		Board board = null;
		while (iterator.hasNext()){
			board = (Board)iterator.next();
//			System.out.println(board);
		}
	}

}
