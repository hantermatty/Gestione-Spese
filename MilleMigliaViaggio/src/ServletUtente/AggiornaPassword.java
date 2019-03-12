package ServletUtente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import GestioneUtente.Accesso;

/**
 * Servlet implementation class AggiornaPasswordServlet
 */
@WebServlet("/AggiornaPasswordServlet")
public class AggiornaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("em");
    		String nuovaPass = (String) request.getParameter("pass");    
    		String confermaPass = (String) request.getParameter("pass2");
    		Accesso agg = new Accesso(); 
    		
    		if(nuovaPass.equals(confermaPass)) {
    			agg.aggiorna(nuovaPass, email);
    			RequestDispatcher view = request.getRequestDispatcher("home.jsp");
    			view.forward(request, response);
    		} else {
    			RequestDispatcher view = request.getRequestDispatcher("RecuperaPassword.jsp");
    			view.forward(request, response);
    		}
    		
    		
    		}catch(Exception e) {
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
