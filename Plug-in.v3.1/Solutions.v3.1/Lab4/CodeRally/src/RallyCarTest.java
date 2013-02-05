/*
 * Created on 2-Aug-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import junit.framework.TestCase;

/**
 * @author Nesa Matic
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RallyCarTest extends TestCase {
	private RallyCar car;

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.car = new RallyCar();
	}

	public void testGetName() {
		assertEquals(car.getName(),"My Coolest Car");
	}

}
