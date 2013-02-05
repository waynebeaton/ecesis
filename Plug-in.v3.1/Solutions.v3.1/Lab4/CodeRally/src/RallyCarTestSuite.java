/*
 * Created on 2-Aug-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Nesa Matic
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RallyCarTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.plugins.labs.coderally.testing");
		//$JUnit-BEGIN$
		suite.addTestSuite(RallyCarTest.class);
		suite.addTestSuite(RallyCarTest1.class);
		//$JUnit-END$
		return suite;
	}
}
