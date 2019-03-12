package testingIntegration;

import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.TestSuite;
import testingUnita.GestioneVenditaTest;
import testingUnita.GestionePacchettiTest;

public class TestGv {
	public static void main(String[] args) {
		TestRunner.run(TestGv.suite());
		
	}
	
	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(GestioneVenditaTest.suite());
		test.addTest(GestionePacchettiTest.suite());
		return test;
		
	}
}
