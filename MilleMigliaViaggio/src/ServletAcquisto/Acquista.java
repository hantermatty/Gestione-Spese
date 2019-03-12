package ServletAcquisto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneAcquisto.Acquisto;
@WebServlet("/Acquista-Home.html")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Acquista() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		String id = request.getParameter("id");
		HttpSession sessione = request.getSession();
		String e = (String) sessione.getAttribute("email"); 
		Acquisto a = new Acquisto();
		a.Acquista(q,id,e);												// richiama la funzione acquista
		RequestDispatcher view = request.getRequestDispatcher("Acquisti.jsp?acquisto=si");	// passa i parametri a home.jsp
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
