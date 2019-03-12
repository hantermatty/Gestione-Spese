package GestioneUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import ClassiComuni.Utente;
import Storage.SingletonDataBase;

public class Accesso {
	private SingletonDataBase db;
	private Connection con;
	public boolean accesso(Utente d) 
	{
		String email =  d.getemail();
		String pass =  d.getPass();
		db = new SingletonDataBase();
		con = db.getConnection();
		try 
		{
			
			Statement query = (Statement) con.createStatement();
			ResultSet result = (ResultSet) query.executeQuery("select * from utente;");
			while (result.next())
			{
				String e = result.getString("email");
				String p = result.getString("pass");
				d.setTipo(result.getString("tipo"));
				if(e.equals(email) && p.equals(pass)) {return true;} // verifica se l'email e la password sono uguali ed effetua l'accesso
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	///////////////////////////////////////////////////VERIFICA EMAIL/////////////////////////////////////////////////////////////////////
	public boolean verificaEmail(String email) {
		try {
		if(email=="") {
	    	return false;
	    }
		db = new SingletonDataBase();
		con = db.getConnection();
			Statement query = (Statement) con.createStatement();
			ResultSet result = (ResultSet) query.executeQuery("SELECT email FROM utente WHERE email ='"+email+"'");
			    while (result.next()) {
			    	return true;
			    } 
			    
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

////////////////////////////////////////////////////RECUPERA DATI//////////////////////////////////////////////////////////////////////////////////////	
public Utente RecuperaDati(String email) throws SQLException {
	db = new SingletonDataBase();
	con = db.getConnection();
	Utente p = new Utente();
	
	Statement query = (Statement) con.createStatement();
	ResultSet result = (ResultSet) query.executeQuery("SELECT * FROM prog_web.utente WHERE email = '"+email+"';");

	while(result.next()) {
		p.setemail(result.getString("email"));
		p.setPass(result.getString("pass"));
		p.setCell(result.getString("cell"));
		p.setNazionalita(result.getString("nazione"));
		p.setIndirizzo(result.getString("indirizzo"));
		p.setTipo(result.getString("tipo"));
		p.setData_nascita(result.getString("data_nascita"));
		p.setNome(result.getString("nome"));
		p.setCognome(result.getString("cognome"));
}
return p;
}


///////////////////////////////////////////////////////REGISTRAZIONE/////////////////////////////////////////////////////////////////////////////////////////////


	public void registrazione(Utente d) throws SQLException, IOException 
	{
		db = new SingletonDataBase();
		con = db.getConnection();
	String email = d.getemail();
	String pass = d.getPass();
	String nome = d.getNome();
	String cognome = d.getCognome();
	String cell = d.getCell();
	String nazione = d.getNazione();
	String data_nascita = d.getData_nascita();
	String tipo = d.getTipo();
	String indirizzo = d.getIndirizzo();
	
	PreparedStatement prepared = (PreparedStatement) con.prepareStatement("insert into utente (email,pass,nome,cognome,cell,nazione,data_nascita,tipo,indirizzo) values(?,?,?,?,?,?,?,?,?)");
	prepared.setString(1, email);
	prepared.setString(2, pass);
	prepared.setString(3, nome);
	prepared.setString(4, cognome);
	prepared.setString(5, cell);
	prepared.setString(6, nazione);
	prepared.setString(7, data_nascita);
	prepared.setString(8, tipo);
	prepared.setString(9,indirizzo);
	
	prepared.executeUpdate();
	 
}


/////////////////////////////////////////////////////////////////////////RECUPERA PASSWORD////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	

	public void aggiorna(String password,String email) throws SQLException{

		db = new SingletonDataBase();
		con = db.getConnection();
		
		Statement query = (Statement) con.createStatement();
		query.executeUpdate("UPDATE utente SET pass = '"+password+"' WHERE email = '"+email+"'");
		
	}
///////////////////////////////////////////////////////////////////////////MODIFICA PROFILO////////////////////////////////////////////////////////////////////////////////////////////////////
	public void modifica(String email, Utente u) throws SQLException {
		db = new SingletonDataBase();
		con = db.getConnection();
		Statement query = (Statement) con.createStatement();
		
		query.executeUpdate("UPDATE utente SET pass = '"+u.getPass()+"', nome = '"+u.getNome()+"', cognome = '"+u.getCognome()+"', cell = '"+u.getCell()+"', nazione = '"+u.getNazione()+"', data_nascita = '"+u.getData_nascita()+"', indirizzo = '"+u.getIndirizzo()+"' WHERE email = '"+email+"'");
	}
	
	
}
