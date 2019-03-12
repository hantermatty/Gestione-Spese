package testingUnita;




import java.util.ArrayList;
import java.util.List;

import ClassiComuni.DatiPacchetti;
import GestioneAcquisto.Ricerca;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class RicercaTest extends TestCase {
	private DatiPacchetti p;
	private Ricerca ricerca;
	private String[] arr;
	private DatiPacchetti[] pacchetti;
	
	public void testRicerca() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431€!","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");	
		ricerca = new Ricerca();
		String data = p.getData_i();
		int m = 5;
		int a = 2019;
		int i =0;
		String arr = "Emirati Arabi Uniti";
		pacchetti = ricerca.Ricerca(arr, m, a);
		assertEquals(pacchetti[0].getDestinazione(),p.getDestinazione());
	}
	public static Test suite() {
	    return new TestSuite(RicercaTest.class);
	  }
}
