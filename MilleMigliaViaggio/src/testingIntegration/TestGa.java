package testingIntegration;

import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.TestSuite;
import testingUnita.CarrelloTest;
import testingUnita.GestioneAcquistoTest;
import testingUnita.RicercaTest;

public class TestGa {
	public static void main(String[] args) {
		TestRunner.run(TestGa.suite());
		
	}
	
	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(GestioneAcquistoTest.suite());
		test.addTest(CarrelloTest.suite());
		test.addTest(RicercaTest.suite());
		return test;
		
	}
}
