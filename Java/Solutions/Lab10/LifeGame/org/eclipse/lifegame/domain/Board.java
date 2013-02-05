package org.eclipse.lifegame.domain;

import java.io.Serializable;
import org.eclipse.lifegame.support.LifeGameException;

/**
 * @author Espirity Inc.
 */
public abstract class Board  implements Serializable{
	public abstract void evolve(Game aGame)throws LifeGameException;
	public abstract void evolve(Game aGame, int index)throws LifeGameException;
}
