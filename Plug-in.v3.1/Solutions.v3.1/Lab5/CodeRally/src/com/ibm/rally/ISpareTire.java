package com.ibm.rally;
/**
 * This interface is used by the spare tires that have been thrown
 * across the track. Use this interface to determine the speed and
 * heading for a spare tire.
 */
public interface ISpareTire extends IObject {
	/**
	 * Return the heading, in degrees.
	 * 
	 * @return int
	 */
	public int getHeading();

	/**
	 * Return the speed, in units per turn.
	 * 
	 * @return double
	 */
	public double getSpeed();
}