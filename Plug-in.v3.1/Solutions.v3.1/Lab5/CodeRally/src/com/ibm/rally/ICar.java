package com.ibm.rally;
/**
 * This interface is used by all cars on the track. It allows you to
 * find information about the other cars in your match.
 */
public interface ICar extends IObject {
	/**
	 * Returns the name of the car.
	 * 
	 * @return java.lang.String
	 */
	public String getName();

	/**
	 * Returns the name of the school.
	 * 
	 * @return java.lang.String
	 */
	public String getSchoolName();

	/**
	 * Return the car's heading, in degrees.
	 * 
	 * @return int
	 */
	public int getHeading();

	/**
	 * Returns the current change of heading of the car, in degrees
	 * per turn. This method returns a positive number if the car is
	 * turning right, and a negative number if the car is turning
	 * left.
	 *
	 * @return int
	 */
	public int getChangeInHeading();

	/**
	 * Return the car's current speed, in units per turn. This method
	 * returns the speed in the direction in which the car is heading,
	 * so the car may move (e.g. as the result of being hit sideways
	 * by another car) without the speed changing. Also, the method
	 * will return positive values when the car is stuck (e.g. pushing
	 * against a wall or another car). This method will return a
	 * negative value if the car is going backwards.
	 * 
	 * @return double
	 */
	public double getSpeed();

	/**
	 * Returns the amount of fuel remaining in the car.
	 *
	 * @return int
	 */
	public int getFuel();

	/**
	 * Returns the number of spare tires currently available to be
	 * thrown from this car.
	 *
	 * @return int
	 */
	public int getNumberOfSpareTires();

	/**
	 * Returns the number of points that this car has accumulated
	 * during this match.
	 *
	 * @return int
	 */
	public int getPoints();

	/**
	 * Returns true if the car is in protect mode.
	 * 
	 * @return boolean
	 */
	public boolean isInProtectMode();
}