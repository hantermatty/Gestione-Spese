package testingUnita;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import ClassiComuni.Utente;
import GestioneVendita.GestionePacchetti;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GestionePacchettiTest extends TestCase{
	private DatiPacchetti p;
	private DatiVolo v1;
	private DatiAllogio s1;
	private DatiVolo v2;
	private DatiAllogio s2;
	private GestionePacchetti gest;
	private Utente u;
	private int j,i;
	private boolean ok ;
	public void testTuttiPacchetti() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");
		
		String id = p.getCodice();
			j=0;
			i =0;
			ok = false;
			gest = new GestionePacchetti();
			DatiPacchetti [] pacchetti = gest.Pac();
			List<DatiPacchetti> a = new ArrayList<DatiPacchetti>();
			while(pacchetti[j]!=null) {
				a.add(pacchetti[j]);
				j++;
			}
			while (i<a.size()) {
				if(a.get(i).getCodice().equals(id)) {
					ok = true;
				}
				i++;
			}
			
		assertEquals(true,ok);
	}
	
	public void testPacchettoSpecifico() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");
		v1 = new DatiVolo("679031","200","Air Dolominti","22","6");
		s1 = new DatiAllogio("000289","Hessa","hotel","61","discoteca");
		v2 = new DatiVolo();
		s2 = new DatiAllogio();
		gest = new GestionePacchetti();
		String id = p.getCodice();
		DatiPacchetti [] pacchetti = gest.Pagina_pacc(id, p, v2, s2);
		assertEquals(pacchetti[0].getCodice(),p.getCodice());
	}
	
	public void testPacchettoEmail() {
		p = new DatiPacchetti("333333","Vacanza di lusso a Dubai: 5 notti in fantastico Melia Hotel 5* + volo a/r da soli 431","457","2019-05-22","2019-05-27","L'aspetto che sicuramente contraddistingue la meta più intrigante del momento è il continuo mix fra antichità, con la sua centenaria cultura islamica, e modernità, con i suoi grattacieli, mall e giardini artificiali. Dubai però vuol dire anche e soprattuto natura, con lo splendido deserto che circonda la città e le meravigliose spiagge bianche che caratterizzano la costa. Ecco un breve elenco di ciò che non dovete perdere in questa metropoli:","Dubai","Emirati Arabi Uniti","IMG/dubai.jpg","4","v@v.v");
		u = new Utente("v",null,"v@v.v","v","112","italiana","v",null,"v");
		String email = u.getemail();
		DatiPacchetti [] pacchetti = null;
		gest = new GestionePacchetti();
		try {
		 pacchetti = gest.Recupera_Pacch(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(pacchetti[0].getCodice(),p.getCodice());
	}
		
	public static Test suite() {
	    return new TestSuite(GestionePacchettiTest.class);
	  }
}
