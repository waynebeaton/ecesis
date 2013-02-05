import com.ibm.rally.Car;
import com.ibm.rally.ICar;
/**
 * This is the class that you must implement to enable your car within
 * the CodeRally track. Adding code to these methods will give your car
 * it's personality and allow it to compete.
 */
public class RallyCar extends Car {
	/**
	 * @see com.ibm.rally.Car#getName()
	 */
	public String getName() {
		return "My Cool Car";
	}

	/**
	 * @see com.ibm.rally.Car#getSchoolName()
	 */
	public String getSchoolName() {
		return "Espirity University";
	}

	/**
	 * @see com.ibm.rally.Car#getColor()
	 */
	public byte getColor() {
		return CAR_BLUE;
	}

	/**
	 * @see com.ibm.rally.Car#initialize()
	 */
	public void initialize() {
		// put implementation here
	}

	/**
	 * @see com.ibm.rally.Car#move(int, boolean, ICar, ICar)
	 * Put the car in reverse for a few moves if you collide with another car.
	 * Go toward the first gas depot.
	 */
	public void move(int lastMoveTime, boolean hitWall, ICar collidedWithCar, ICar hitBySpareTire) {
		// put implementation here
	}
}