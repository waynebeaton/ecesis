package org.eclipse.lifegame.test;

import org.eclipse.lifegame.domain.Rule;

/**
 * @author Espirity Inc.
 */
public class LifeGameTester {

	public static void main(String[] args) {
		Rule rule = new Rule("Survival");
		System.out.println(rule.getName());
	}
}
