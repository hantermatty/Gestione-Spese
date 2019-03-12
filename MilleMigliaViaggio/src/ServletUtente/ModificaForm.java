package ServletUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassiComuni.Utente;
import GestioneUtente.Accesso;

/**
 * Servlet implementation class ServletModificaForm
 */
@WebServlet("/ServletModificaForm.html")
public class ModificaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession();
	    String email = (String) session.getAttribute("email");
	    Utente u = new Utente();
	    Accesso a = new Accesso();
			u = a.RecuperaDati(email);
	
	    request.setAttribute("nome",u.getNome());
	      request.setAttribute("cognome",u.getCognome());
	      request.setAttribute("email",u.getemail());
	      request.setAttribute("nazione",u.getNazione());
	      request.setAttribute("nascita",u.getData_nascita());
	      request.setAttribute("cell",u.getCell());
	      request.setAttribute("indirizzo",u.getIndirizzo());
	      request.setAttribute("password",u.getPass());
	      RequestDispatcher view = request.getRequestDispatcher("modifica_profilo.jsp");
	      view.forward(request, response);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
