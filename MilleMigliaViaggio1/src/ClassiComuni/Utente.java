package ClassiComuni;

import java.util.Date;

public class Utente {
	private String email;
	private String pass;
	private String cell;
	private String nazionalita;
	private String indirizzo;
	private String tipo;
	private String Data_nascita;
	private String Nome;
	private String Cognome;
	public Utente(String Nome,String Cognome,String email,String pass,String cell,String nazionalita,String indirizzo,String Data_nascita,String tipo) {
		this.email = email;
		this.pass = pass; 
		this.cell = cell;
		this.nazionalita = nazionalita;
		this.indirizzo = indirizzo;
		this.Data_nascita = Data_nascita;
		this.Nome=Nome;
		this.setCognome(Cognome);
		this.tipo = tipo;
	}
	public Utente() {
		
	}
	public String getemail() {
		return email;
	}
	public void setemail(String e) {
		this.email = e;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell2) {
		this.cell = cell2;
	}
	public String getNazione() {
		return nazionalita;
	}
	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public String getData_nascita() {
		return Data_nascita;
	}
	public void setData_nascita(String date) {
		this.Data_nascita = date;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}

}
