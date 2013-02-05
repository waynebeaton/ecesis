package org.eclipse.lifegame.domain;

/**
 * @author Espirity Inc.
 */
public interface TwoDimensionalRule {
	public int getCellValue();
	public boolean doesApply(int[][] cells, int i, int j);
}
