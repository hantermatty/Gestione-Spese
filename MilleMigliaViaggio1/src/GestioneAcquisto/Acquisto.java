package GestioneAcquisto;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import ClassiComuni.DatiPacchetti;
import Storage.SingletonDataBase;

public class Acquisto {
	private Connection con;
	private SingletonDataBase db;
	public Acquisto() {
		db = new SingletonDataBase();
		con = db.getConnection();
	}
/////////////////////////////////////////////////////////////////////////////ACQUISTA PACCHETTO///////////////////////////////////////////	
	
	public void Acquista(String q,String id,String e) {
		String n = null,n2 = null;
		int i = 0;
	List<String> info_p = new ArrayList<String>();
	try 
	{
	PreparedStatement prepared = (PreparedStatement) con.prepareStatement("select quantita from carrello where pacchetto = ? AND email = ? AND stato='v';");
	prepared.setString(1, id);
	prepared.setString(2, e);
	ResultSet r = (ResultSet) prepared.executeQuery();
	while(r.next()) {
	n2 = r.getString("quantita"); 
	}
	int qua;
	if(n2!=null) {qua = Integer.parseInt(n2) + Integer.parseInt(q);} else {qua = Integer.parseInt(q);}
	prepared = (PreparedStatement) con.prepareStatement("delete from carrello where pacchetto = ? AND email = ?;");
	prepared.setString(1, id);
	prepared.setString(2, e);
	prepared.execute();
	prepared = (PreparedStatement) con.prepareStatement("insert into carrello(stato,email,pacchetto,quantita)values(?,?,?,?);");
	prepared.setString(1, "v");
	prepared.setString(2, e);
	prepared.setString(3, id);
	prepared.setString(4, String.valueOf(qua));
	prepared.executeUpdate();
	prepared = (PreparedStatement) con.prepareStatement("select * from pacchetti where codice_pacchetto = ?");
	prepared.setString(1, id);
	r = (ResultSet) prepared.executeQuery();
	while(r.next()) {
	n = r.getString("n_pacchetti_acquistati");
	}
	int j = Integer.parseInt(q);
	int x = Integer.parseInt(n) + j;
	prepared = (PreparedStatement) con.prepareStatement("update pacchetti set n_pacchetti_acquistati = ? where codice_pacchetto = ?");
	prepared.setInt(1,x);
	prepared.setString(2, id);
	prepared.executeUpdate();

	}
	catch (Exception e1){System.out.print("errore");}
	
	}
	
	/////////////////////////////////////////////////////////////////////////PACCHETTI ACQUISTATI//////////////////////////////////////////////////////////	
	
	public DatiPacchetti[] PacAcquisti(String email) {
	int i = 0;
	DatiPacchetti[] info_p = new DatiPacchetti[20];
	try 
	{
	ResultSet result = null;
	PreparedStatement prepared = (PreparedStatement) con.prepareStatement("SELECT * FROM pacchetti,carrello where  codice_pacchetto = pacchetto and codice_pacchetto = any (SELECT pacchetto FROM carrello where email = ? and stato = 'v');");
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
	p.setN_acquisti(result.getString("quantita"));
	info_p[x] = p;
	x++;					
	}
	}
	catch (Exception e){}
	
	return info_p;
	}	
	}
