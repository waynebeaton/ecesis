package org.eclipse.course.ui;

/**
 * @author Espirity Inc.
 */

public class TrafficLight { 
    int  currentState;

    // Constructor that makes a red traffic light
    public TrafficLight() { 
        currentState = 1; 
    }

    // Advance the traffic light to the next state
    public int advance() { 
        setState(getState() % 3 + 1);
        return currentState; 
    } 

    // Return the state of the traffic light (as a number from 1 to 3) 
    public int getState() { 
        return currentState; 
    } 

    // Set the state of the traffic light (as a number from 1 to 3) 
    // If the integer is out of range, do nothing 
    public void setState(int newState) { 
        if ((newState > 0) && (newState <4)) 
			currentState = newState; 
    } 
  
    // Return a string representation of the traffic light
    public String toString() { 
        switch(getState()) { 
        	case 1: return "Red Traffic Light"; 
        	case 2: return "Yellow Traffic Light"; 
        	case 3: return "Green Traffic Light"; 
        }; 
        return "Broken Traffic Light"; 
    } 
    
    public boolean isRed() {
    	return getState() == 1;
    }
    
	public boolean isYellow() {
		   return getState() == 2;
	  }
	   
	public boolean isGreen() {
		return getState() == 3;
	 }
} 