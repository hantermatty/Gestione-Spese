package ServletUtente;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import ClassiComuni.Utente;
import GestioneUtente.Accesso;
import GestioneVendita.Vendita;

/**
 * Servlet implementation class ServletModificaProfilo
 */
@WebServlet("/ServletModificaProfilo")
public class ModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		String email = (String) sessione.getAttribute("email");
		String tipo = (String) sessione.getAttribute("tipo");
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String pass = request.getParameter("pass");
		String cell = request.getParameter("cell");
		String nazione = request.getParameter("nazione");
		String indirizzo = request.getParameter("indirizzo");
		String data = request.getParameter("data");
		
		Utente d = new Utente();
		if(tipo.equalsIgnoreCase("a")) {
			d.setNome(nome);
			d.setCognome(cognome);
			d.setemail(email);
			d.setPass(pass);
			d.setCell(cell);
			d.setNazionalita(nazione);
			d.setTipo(tipo);
			d.setIndirizzo(indirizzo);
			d.setData_nascita(data);
		
		/*
			int g,m,a,l;
			l = data.length();
			
			String anno = data.substring(0,4);
			if(anno.contains("/")) {a = Integer.parseInt(data.substring(0,3));data = data.substring(4,l);l = l - 4;}
			else{a = Integer.parseInt(anno);data = data.substring(5,l);l = l - 5;}
			
			String mese = data.substring(0,2);
			if(mese.contains("/")) {m = Integer.parseInt(data.substring(0,1));data = data.substring(2,l); l = l - 2;}
			else{m = Integer.parseInt(mese);data = data.substring(3,l); l = l - 3;}
			
			g = Integer.parseInt(data.substring(0,l));
			GregorianCalendar cc = new GregorianCalendar();
			cc.set(Calendar.DATE, g);
			cc.set(Calendar.MONTH, m - 1);
			cc.set(Calendar.YEAR, a);
			Date data_n = new Date(cc.getTimeInMillis());
			d.setData_nascita(data_n);
			*/
		}
		else if (tipo.equals("v")) {
			d.setNome(nome);
			d.setCognome(null);
			d.setemail(email);
			d.setPass(pass);
			d.setCell(cell);
			d.setNazionalita(nazione);
			d.setData_nascita(null);
			d.setTipo(tipo);
			d.setIndirizzo(indirizzo);
		}
		
		
	
		Accesso agg = new Accesso();
		try {agg.modifica(email,d);} catch (SQLException e) {e.printStackTrace();}
	
		RequestDispatcher view = request.getRequestDispatcher("modifica_profilo.jsp?modifica=si");
		view.forward(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
