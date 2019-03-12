package GestioneVendita;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import Storage.SingletonDataBase;

public class GestionePacchetti {
	private SingletonDataBase db;
	Connection con;
	public GestionePacchetti () {
		db = new SingletonDataBase();
		con = db.getConnection();
	}
	
	// recuperare tutti i pacchetti
	public DatiPacchetti[] Pac() { 
		int i = 0;
		DatiPacchetti[] info_p = new DatiPacchetti[20];
		try 
		{
			ResultSet result = null;
			PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM pacchetti;");
			result = (ResultSet) prepared.executeQuery();
				
			int x = 0;
			while (result.next())
			{
				DatiPacchetti p = new  DatiPacchetti(null, null, null, null, null, null, null, null, null, null, null);
				p.setImmagine(result.getString("immagine"));
				p.setDestinazione(result.getString("destinazione"));
				p.setDescrPacc(result.getString("descrizione_pacchetto"));
				p.setPrezzo(result.getString("prezzo"));
				p.setCodice(result.getString("codice_pacchetto"));
				p.setN_acquisti(result.getString("n_pacchetti_acquistati"));
				info_p[x] = p;
				x++;					
			}
			
		}
		catch (Exception e){}
		
		return info_p;
	}
	// Pacchetto specifico
	public DatiPacchetti[] Pagina_pacc(String id,DatiPacchetti p,DatiVolo v, DatiAllogio a) {   
		DatiPacchetti[] info_p = new DatiPacchetti[20];
		try 
		{

			String cod_a = null,cod_v = null;
			ResultSet result = null;
			PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM pacchetti where codice_pacchetto = ?;");
			prepared.setString(1, id);
			result = (ResultSet) prepared.executeQuery();
			int x = 0;			
			while (result.next())
			{
					
					p.setImmagine(result.getString("immagine"));
					p.setDescrPacc(result.getString("descrizione_pacchetto"));
					p.setData_f(result.getString("data_fine"));
					p.setData_i(result.getString("data_inizio"));
					p.setNazione(result.getString("nazione"));
					p.setDescrluogo(result.getString("descrizione_luogo"));
					p.setPrezzo(result.getString("prezzo"));
					p.setDestinazione(result.getString("destinazione"));
					p.setN_acquisti(result.getString("n_pacchetti_acquistati"));
					cod_a = result.getString("codice_struttura");
					cod_v = result.getString("codice_volo");
					info_p[x] = p;
					x++;
			}
			
			prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM struttura where codice_struttura = ?;");
			prepared.setString(1, cod_a);
			result = (ResultSet) prepared.executeQuery();
										
			while (result.next())
			{
					
					a.setIndirizzo(result.getString("indirizzo"));
					a.setTipo(result.getString("tipo"));
					a.setPrezzo(result.getString("prezzo"));
					a.setServizio(result.getString("servizio"));
									
			}
			prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM volo where codice_volo = ?;");
			prepared.setString(1, cod_v);
			result = (ResultSet) prepared.executeQuery();
										
			while (result.next())
			{
					v.setPrezzo(result.getString("prezzo"));	
					v.setCompagnia(result.getString("compagnia"));
					v.setOra_a(result.getString("ora_andata"));
					v.setOra_r(result.getString("ora_ritorno"));
								
			}
			return info_p;
		}
		
		catch (Exception e){}
		return info_p;
		}
	
	
	////// reupera pacchetto data un'email
	public DatiPacchetti[] Recupera_Pacch(String email) throws SQLException {
		DatiPacchetti[] info_p = new DatiPacchetti[10];
		ResultSet result = null;
		PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT codice_pacchetto FROM prog_web.pacchetti where email = ?;");
		prepared.setString(1, email);
		result = (ResultSet) prepared.executeQuery();
		
		int x = 0;
		
		while(result.next()) {
		DatiPacchetti p = new  DatiPacchetti(null, null, null, null, null, null, null, null, null, null, null);	
		p.setCodice(result.getString("codice_pacchetto"));
		info_p[x]=p;
		x++;
		}
		return info_p;
	}
}
