package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public abstract class Board{
	public abstract void evolve(Game aGame);
	public abstract void evolve(Game aGame, int index);
}
