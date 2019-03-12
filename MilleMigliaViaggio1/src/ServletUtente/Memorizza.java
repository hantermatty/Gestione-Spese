package ServletUtente;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import ClassiComuni.Utente;
import GestioneUtente.Accesso;




@WebServlet("/Memorizza-Home.html")
public class Memorizza extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		// registra i dati inseriti dall'utente nel DB
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		String cell = request.getParameter("cell");
		String nazione = request.getParameter("nazione");
		String tipo = request.getParameter("tipo");
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
		
		Accesso reg = new Accesso();
		try {
			if(pass.equalsIgnoreCase(pass2)) {
				reg.registrazione(d);
			
				RequestDispatcher view = request.getRequestDispatcher("home.html");
				view.forward(request, response);
			}
			RequestDispatcher view = request.getRequestDispatcher("registrazione.html");
			view.forward(request, response);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}