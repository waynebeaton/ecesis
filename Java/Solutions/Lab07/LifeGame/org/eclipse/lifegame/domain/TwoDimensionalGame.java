package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public class TwoDimensionalGame extends Game {
	private static TwoDimensionalGame theInstance;
	
	public static TwoDimensionalGame getInstance(){
			if (theInstance == null){
				theInstance = new TwoDimensionalGame();
			}
			return theInstance;
	}
	
	public static void clearInstance(){
		theInstance = null;
	}
	
	private TwoDimensionalGame(){
		setBoard(new TwoDimensionalBoard());
		getRules()[0] = new TwoDimensionalBirthRule();
		getRules()[1] = new TwoDimensionalSurvivalRule();
		getRules()[2] = new TwoDimensionalDeathRule();
	}
}
