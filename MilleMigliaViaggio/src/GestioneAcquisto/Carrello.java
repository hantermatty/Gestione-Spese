package GestioneAcquisto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import ClassiComuni.DatiPacchetti;
import Storage.SingletonDataBase;

public class Carrello {
	private Connection con;
	private SingletonDataBase db;
	public Carrello() {
		db = new SingletonDataBase();
		con = db.getConnection();
	}
//////////////////////////////////////////////////////////////AGGIUNGERE A CARRELLO ONLINE///////////////////////////////////////////////
	public void AggiungiC(String cod,String email) throws SQLException {
		
		boolean ins = true;
		PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select * from carrello where stato = 'c'");
		ResultSet result = (ResultSet) prepared.executeQuery();
		while(result.next()) {
			if(email.equals((result.getString("email"))) && cod.equals(result.getString("pacchetto"))) {ins=false;}
		}
		
		if(ins == true) {
			prepared = (PreparedStatement) con.prepareStatement("insert into carrello(stato,email,pacchetto,quantita)values(?,?,?,?);");
			prepared.setString(1, "c");
			prepared.setString(2, email);
			prepared.setString(3, cod);
			prepared.setString(4, "0");
			prepared.executeUpdate();
		}
	}
	
//////////////////////////////////////////////////////////////////PACCHETTI AGGIUNTI NEL CARRELLO/////////////////////////////////////////////////////////	
	
	public DatiPacchetti[] PacCarrello(String email) {
		int i = 0;
		DatiPacchetti[] info_p = new DatiPacchetti[20];
		try 
		{
			ResultSet result = null;
			PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM pacchetti where codice_pacchetto = any (SELECT pacchetto FROM carrello where email = ? and stato = 'c');");
			prepared.setString(1, email);
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
///////////////////////////////////////////////////////////////////ELIMINA PACCHETTO DAL CARRELLO////////////////////////////////////////////////////
	public boolean Elimina(String id,String e) {
		boolean ok = true;
		try 
		{
			PreparedStatement prepared = (PreparedStatement) con.prepareStatement("DELETE FROM carrello WHERE pacchetto = ? and email = ?;");
			prepared.setString(1, id);
			prepared.setString(2, e);
			ok = prepared.execute();
			
		}
		catch (SQLException e1){System.out.print("errore");}
		return ok;
	}
	

}
