package GestioneVendita;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import Storage.SingletonDataBase;

public class Vendita {
	private SingletonDataBase db;
	private Connection con;
	public Vendita() {
		db = new SingletonDataBase();
		con = db.getConnection();
	}
//////////////////////////////////////////////////////////////////INSERISCI PACCHETTO////////////////////////////////////////////////////////////////	
	
	public void Aggiungi(DatiPacchetti d,DatiAllogio s,DatiVolo v) throws  SQLException {
	PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into pacchetti(codice_pacchetto,descrizione_pacchetto,prezzo,data_inizio,data_fine,descrizione_luogo,destinazione,nazione,immagine,n_pacchetti_acquistati,codice_volo,codice_struttura,email)values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
	prepared.setString(1, d.getCodice());
	prepared.setString(2, d.getDescrPacc());
	int n = Integer.parseInt(d.getPrezzo());
	prepared.setInt(3, n);
	prepared.setString(4, d.getData_i());
	prepared.setString(5, d.getData_f());
	prepared.setString(6, d.getDescrluogo());
	prepared.setString(7, d.getDestinazione());
	prepared.setString(8, d.getNazione());
	prepared.setString(9, d.getImmagine());
	n = 0;
	prepared.setInt(10, n);
	prepared.setString(11, v.getCodice());
	prepared.setString(12, s.getCodice());
	prepared.setString(13, d.getEmail());
	prepared.executeUpdate();
	
	prepared = (PreparedStatement) con.prepareStatement("insert into struttura(codice_struttura,prezzo,indirizzo,tipo,servizio)values(?,?,?,?,?);");
	prepared.setString(1, s.getCodice());
	prepared.setString(3,s.getIndirizzo() );
	n = Integer.parseInt(s.getPrezzo());
	prepared.setInt(2, n);
	prepared.setString(4, s.getTipo());
	prepared.setString(5, s.getServizio());
	prepared.executeUpdate();
	
	prepared = (PreparedStatement) con.prepareStatement("insert into volo(codice_volo,prezzo,compagnia,ora_andata,ora_ritorno)values(?,?,?,?,?);");
	prepared.setString(1, v.getCodice());
	prepared.setString(3,v.getCompagnia() );
	n = Integer.parseInt(v.getPrezzo());
	prepared.setInt(2, n);
	prepared.setString(4, v.getOra_a());
	prepared.setString(5, v.getOra_r());
	prepared.executeUpdate();
	}
	
	/////////////////////////////////////////////////////ELIMINA PACCHETTO/////////////////////////////////////////////////////////////////////////////////////	
	
	public boolean Elimina_pac(String id) {
	String s = null,v = null;
	boolean ok = false;
	try 
	{
	PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from pacchetti where codice_pacchetto = ?;");
	prepared.setString(1, id);
	ResultSet r = (ResultSet) prepared.executeQuery();
	while(r.next()) {
	s = (String) (r.getString("codice_struttura"));
	v = (String)(r.getString("codice_volo"));
	}
	
	prepared = (PreparedStatement) con.prepareStatement("delete from pacchetti where codice_pacchetto = ?;");
	prepared.setString(1, id);
	prepared.execute();
	
	prepared = (PreparedStatement) con.prepareStatement("delete from volo where codice_volo = ?;");
	prepared.setString(1, v);
	prepared.execute();
	
	prepared = (PreparedStatement) con.prepareStatement("delete from struttura where codice_struttura = ?;");
	prepared.setString(1, s);
	prepared.execute();
	ok = true;
	}
	catch (Exception e1){System.out.print("errore");}
	return ok;
	}
	
	///////////////////////////////////////////////////////MODIFICA PACCHETTO/////////////////////////////////////////////////////////////////////////////////////
	public void Modifica(String id,DatiPacchetti d,DatiAllogio s,DatiVolo v) throws SQLException{
		try {
			String cv = "";
			String cs = "";
			PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from prog_web.pacchetti where codice_pacchetto = ?;");
			prepared.setString(1, id);
			ResultSet r = (ResultSet) prepared.executeQuery();
			while(r.next()) {
			 cs = (String) (r.getString("codice_struttura"));
			 cv = (String)(r.getString("codice_volo"));
			}
			Statement query = (Statement) con.createStatement();
			int n =0;
			query.executeUpdate("UPDATE prog_web.pacchetti SET descrizione_pacchetto = '"+d.getDescrPacc()+"' ,prezzo = '"+d.getPrezzo()+"' , data_inizio = '"+d.getData_i()+"' , data_fine = '"+d.getData_f()+"' , descrizione_luogo = '"+d.getDescrluogo()+"' , destinazione = '"+d.getDestinazione()+"' , nazione = '"+d.getNazione()+"' , immagine = '"+d.getImmagine()+"' ,n_pacchetti_acquistati = '"+n+"' WHERE (codice_pacchetto = '"+id+"')");
			
			Statement qu = (Statement) con.createStatement();
			qu.executeUpdate("UPDATE prog_web.struttura SET  indirizzo = '"+s.getIndirizzo()+"', tipo = '"+s.getTipo()+"', prezzo = '"+s.getPrezzo()+"', servizio = '"+s.getServizio()+"' WHERE (codice_struttura = '"+cs+"');");
			
			
			Statement q = (Statement) con.createStatement();
			q.executeUpdate("UPDATE prog_web.volo SET prezzo = '"+v.getPrezzo()+"', compagnia = '"+v.getCompagnia()+"', ora_andata = '"+v.getOra_a()+"', ora_ritorno = '"+v.getOra_r()+"' WHERE( codice_volo = '"+cv+"');");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}