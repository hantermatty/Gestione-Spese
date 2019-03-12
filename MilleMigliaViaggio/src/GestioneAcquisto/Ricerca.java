package GestioneAcquisto;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import ClassiComuni.DatiPacchetti;
import Storage.SingletonDataBase;

public class Ricerca {
	public DatiPacchetti[] Ricerca(String arr,int m, int a) {
		String periodo;
		String anno = String.valueOf(a);
		String mese = String.valueOf(m);
		DatiPacchetti[] info_p = new DatiPacchetti[10];
		SingletonDataBase db = new SingletonDataBase();
		Connection con = db.getConnection();
		try 
		{
			ResultSet result = null;
			if(arr != "" && m!=0 && a != 0) {
				periodo=anno + "-" +"0"+mese + "-%";
				Statement query = (Statement) con.createStatement();
				result = (ResultSet) query.executeQuery("SELECT * FROM pacchetti where nazione = '"+arr+"' AND data_inizio like '"+periodo+"';");
			}
			else if (arr != "" && m == 0 && a == 0) {
				periodo = "";
				
				PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM pacchetti where nazione = ? ");
				prepared.setString(1,arr);
				result = (ResultSet) prepared.executeQuery();
			}
			else if (arr == "" && m!= 0 && a != 0) {
				periodo=anno + "-" +"0"+mese + "-%";
				
				Statement query = (Statement) con.createStatement();
				result = (ResultSet) query.executeQuery("SELECT * FROM pacchetti where data_inizio like '"+periodo+"';");
			}
				
			int x = 0;
			while (result.next())
			{
				DatiPacchetti p = new  DatiPacchetti();
				p.setImmagine(result.getString("immagine"));
				p.setDestinazione(result.getString("destinazione"));
				p.setDescrPacc(result.getString("descrizione_pacchetto"));
				p.setPrezzo(result.getString("prezzo"));
				p.setCodice(result.getString("codice_pacchetto"));
				info_p[x]=p;
				x++;
			}
			
		}
		catch (Exception e){}
		return info_p;
	}
}
