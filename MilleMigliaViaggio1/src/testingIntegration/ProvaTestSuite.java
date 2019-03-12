package testingIntegration;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingUnita.ResetDataBase;

public class ProvaTestSuite {

	public static void main(String[] args) {
		ResetDataBase reset = new ResetDataBase();
	    reset.resetDataBase();
		
	   TestRunner.run(ProvaTestSuite.suite());

	}
	
	
	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(TestGa.suite());
		test.addTest(TestGu.suite());
		test.addTest(TestGv.suite());
		return test;
		
	}
}
