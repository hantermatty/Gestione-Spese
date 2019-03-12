package testingUnita;

import java.sql.SQLException;

import ClassiComuni.DatiPacchetti;
import ClassiComuni.Utente;
import GestioneAcquisto.Acquisto;
import GestioneAcquisto.Carrello;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GestioneAcquistoTest extends TestCase{
	private Utente u;
	private DatiPacchetti p;
	private Carrello carrello;
	private Acquisto acq;
	public void testAcquistoPacchetti() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");	
		u = new Utente("a","a","a@a.a","a","112","italiana","a","1997-10-08","a");
		String email = u.getemail();
		String id = p.getCodice();
		String q = "1";
		carrello = new Carrello();
		acq = new Acquisto();
		try {
			carrello.AggiungiC(id, email);
			acq.Acquista(q, id, email);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatiPacchetti [] pacchetti = acq.PacAcquisti(email);
		assertEquals(pacchetti[0].getCodice(),p.getCodice());
	}
	
		
	public static Test suite() {
	    return new TestSuite(GestioneAcquistoTest.class);
	  }
}
