package org.eclipse.lifegame.domain;

/** <p>This class represents Life Game.
 * To run the game run the throw <tt>LifeGameTester</tt> class.
 * @see org.eclipse.lifegame.test 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.lifegame.support.LifeGameException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Espirity Inc.
 */
public abstract class Game {
	private Board board;
	private Rule[] rules;
	private int generation;
	private ArrayList boardHistory;
	
	/**
	 * Default constructor for Game.
	 */
	public Game(){
		this.rules = new Rule[3];
		this.generation = 1;
		this.boardHistory = new ArrayList();
	}

	/**
	 * Return receiver's board.
	 * @return receiver's board, an instance of Board class
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the receiver's board.
	 * @param an instance of Board class
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Return game rules.
	 * @return array of Rule objects
	 */
	public Rule[] getRules() {
		return rules;
	}

	/**
	 * Set the game rules.
	 * @param an array of Rule objects
	 */
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	/**
	 * Runs the game.
	 */
	 public void run(){
	 	clearHistory();
		try {
			getBoard().evolve(this, getGeneration());
		}catch (LifeGameException exception) {
			Display display = new Display ();
			Shell shell = new Shell (display);
			MessageDialog.openError(shell, "Error with Game", exception.getMessage());
		}
	 }

	/**
	 * Return generations for teh game.
	 * @return integer
	 */
	public int getGeneration() {
		return generation;
	}

	/**
	 * Set game's generations.
	 * @param i, integer
	 */
	public void setGeneration(int i) {
		generation = i;
	}

	/**
	 * Return collection of boards, a history.
	 * @return a collection
	 */
	public ArrayList getBoardHistory() {
		return boardHistory;
	}

	/**
	 * Set game's board history.
	 * @param list collection of boards
	 */
	public void setBoardHistory(ArrayList list) {
		boardHistory = list;
	}
	
	/**
	 * Add aBoard to the game's board history.
	 * @param an instance of Board class
	 */
	public void addToHistory(Board aBoard){
		getBoardHistory().add(aBoard);
	}
	
	/**
	 * Removes receiver's history, clears the collection of boards.
	 */
	public void clearHistory(){
		getBoardHistory().removeAll(getBoardHistory());
	}
	
	/**
	 * Prints receiver's board history to standard output.
	 */
	public void printHistory(){
		Iterator iterator = getBoardHistory().iterator();
		Board board = null;
		while (iterator.hasNext()){
			board = (Board)iterator.next();
			System.out.println(board);
		}
	}
	
	/**
	 * Saves receiver's board to a given file.
	 */
	public void saveCurrentBoardToFile(String filename){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(getBoard());
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads receiver's board from a given file and assigns it to the receiver.
	 */
	public void loadBoardFromFile(String filename){
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
			setBoard((Board)in.readObject());
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}