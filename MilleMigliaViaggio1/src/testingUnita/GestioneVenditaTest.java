package testingUnita;

import java.sql.SQLException;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import GestioneVendita.GestionePacchetti;
import GestioneVendita.Vendita;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class GestioneVenditaTest extends TestCase{
	private DatiPacchetti p,nuovo;
	private DatiVolo v,v2;
	private DatiAllogio a ,a2;
	private Vendita vendita;
	private GestionePacchetti gest;
	
	
	public void test1AggiungiPacchetto() {
		p = new DatiPacchetti("10","Vacanza a New York: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","New York","Stati Uniti D'America","IMG/dubai.jpg","4","v@v.v");	
		v = new DatiVolo("121","30","qed","23","23");
		a = new DatiAllogio("12","Napoli","Hotel","20","Bar");
		
		vendita = new Vendita();
		
		try {
			vendita.Aggiungi(p, a, v);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		gest = new GestionePacchetti();
		String id = p.getCodice();
		
		DatiPacchetti [] pacchetti = gest.Pac();
		assertEquals(pacchetti[0].getCodice(),p.getCodice());
		
	}
	
	
	public void test2ModificaPacchetto() {
		p = new DatiPacchetti("10","Vacanza a New York: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","New York","Stati Uniti D'America","IMG/dubai.jpg","4","v@v.v");	
		nuovo = new DatiPacchetti("10","Vacanza in Africa: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","eeeee","New York","Stati Uniti America","IMG/dubai.jpg","4","v@v.v");	
		v = new DatiVolo("679031","200","Air Dolominti","22","6");
		a = new DatiAllogio("000289","Hessa","hotel","61","discoteca");
		String id = p.getCodice();
		vendita = new Vendita();
		gest = new GestionePacchetti();
		try {
			vendita.Modifica(id, nuovo,a, v);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DatiPacchetti [] pacchetti = gest.Pac();
		assertEquals(pacchetti[0].getDescrPacc(),nuovo.getDescrPacc());
		
	}
	
	public void test3EliminaPacchetto() {
		p = new DatiPacchetti("10","Vacanza in Africa: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","eeeee","New York","Stati Uniti America","IMG/dubai.jpg","4","v@v.v");	
		String id = p.getCodice();
		boolean ok = false;
		vendita = new Vendita();
		ok = vendita.Elimina_pac(id);
		assertEquals(true,ok);
		
	}
	
	
	public static Test suite() {
    return new TestSuite(GestioneVenditaTest.class);
  }
	
}
