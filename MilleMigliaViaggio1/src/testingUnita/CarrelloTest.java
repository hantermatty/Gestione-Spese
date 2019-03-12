package testingUnita;

import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import ClassiComuni.DatiPacchetti;
import ClassiComuni.Utente;
import GestioneAcquisto.Carrello;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarrelloTest extends TestCase {
	
	private DatiPacchetti p;
	private Carrello carrello;
	private Utente u;
	
	public void testAggiungiCarrello() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");	
		u = new Utente("a","a","a@a.a","a","112","italiana","a","1997-10-08","a");
		String email = u.getemail();
		carrello = new Carrello();
		try {
			carrello.AggiungiC(p.getCodice(), email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatiPacchetti [] pacchetti = carrello.PacCarrello(email);
		assertEquals(pacchetti[0].getDestinazione(),p.getDestinazione());
		
	}
	
	public void testElimina() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");	
		u = new Utente("a","a","a@a.a","a","112","italiana","a","1997-10-08","a");
		String email = u.getemail();
		String cod = p.getCodice();
		carrello = new Carrello();
		boolean ok = true;
		ok = carrello.Elimina(cod,email);
		assertEquals(false,ok);
		
	}
	
	public static Test suite() {
	    return new TestSuite(CarrelloTest.class);
	 }
}
