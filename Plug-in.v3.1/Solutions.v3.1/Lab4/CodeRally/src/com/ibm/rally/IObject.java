package com.ibm.rally;
/**
 * This interface is implemented by all objects in the game. It allows
 * you to get the location of any object, and to determine the distance
 * and heading to or from the object.
 */
public interface IObject {
	/**
	 * Return the X position.
	 * 
	 * @return double
	 */
	public double getX();
	
	/**
	 * Return the Y position.
	 * 
	 * @return double
	 */
	public double getY();


	/* ---------- Helper methods ---------- */
	
	/**
	 * Returns the distance to the given object.
	 * 
	 * @param IObject
	 * @return double
	 */
	public double getDistanceTo(IObject obj);

	/**
	 * Returns the distance to the given location.
	 * 
	 * @param double x
	 * @param double y
	 * @return double
	 */
	public double getDistanceTo(double x, double y);

	/**
	 * Returns the heading (angle) to the given object.
	 * 
	 * @param IObject
	 * @return int
	 */
	public int getHeadingTo(IObject obj);
	
	/**
	 * Returns the heading (angle) to the given location.
	 * 
	 * @param double x
	 * @param double y
	 * @return int
	 */
	public int getHeadingTo(double x, double y);
}