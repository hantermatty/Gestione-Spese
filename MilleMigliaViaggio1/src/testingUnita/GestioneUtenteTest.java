package testingUnita;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import ClassiComuni.Utente;
import GestioneUtente.Accesso;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestioneUtenteTest extends TestCase{
	private Utente u,n,l;
	private Accesso acc;


	public void test1Registrazione() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		n = new Utente();
		acc = new Accesso();
		try {
			acc.registrazione(u);
			
			n = acc.RecuperaDati(u.getemail());

			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(n.getemail(),u.getemail());
		
	}
	
	public void test2Accesso() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		acc = new Accesso();
		boolean ok = false;
		ok = acc.accesso(u);
		assertEquals(true,ok);
	}
	
	public void test3RecuperaDati() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		n = new Utente();
		String email = u.getemail();
		acc = new Accesso();
		try {
			n = acc.RecuperaDati(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(n.getemail(),u.getemail());
	}
	
	public void test4VerificaEmail() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		String email = u.getemail();
		boolean ok = false;
		acc = new Accesso();
		
		ok = acc.verificaEmail(email);
		assertEquals(true,ok);
	}
	
	public void test5RecuperaPassword() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		n = new Utente();
		String email = u.getemail();
		String pass = "pippo";
		acc = new Accesso();
		try {
			acc.aggiorna(pass, email);
			n = acc.RecuperaDati(u.getemail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		assertEquals(n.getPass(),pass);
	}
	
	public void test6ModificaProfilo() {
		u = new Utente("pippo",null,"p@p.p","p","123","italiana","milano",null,"v");
		n = new Utente("Marco",null,"p@p.p","p","149","Americana","New York",null,"v");
		l = new Utente();
		String email = u.getemail();
		acc = new Accesso();
		
		try {
			acc.modifica(email,n);
			l = acc.RecuperaDati(n.getemail());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertEquals(l.getNome(),n.getNome());
	}
	
	public static Test suite() {
	    return new TestSuite(GestioneUtenteTest.class);
	 }

}
