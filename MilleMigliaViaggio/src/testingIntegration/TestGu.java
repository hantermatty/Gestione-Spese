package testingIntegration;

import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.TestSuite;
import testingUnita.GestioneUtenteTest;

public class TestGu {
	public static void main(String[] args) {
		TestRunner.run(TestGu.suite());
		
	}
	
	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(GestioneUtenteTest.suite());
		
		return test;
		
	}
}





/*

public class TestGugp {

  public static void main(String[] args) {
    TestRunner.run(TestGugp.suite());
  }
  
  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(ImpGestioneUtenteTest.suite());
    test.addTest(TestGp.suite());
    return test;
  }


*/