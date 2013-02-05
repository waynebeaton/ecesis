package org.eclipse.lifegame.domain;

import org.eclipse.lifegame.support.LifeGameException;

/**
 * @author Espirity Inc.
 */
public abstract class Board{
	public abstract void evolve(Game aGame)throws LifeGameException;
	public abstract void evolve(Game aGame, int index)throws LifeGameException;
}
