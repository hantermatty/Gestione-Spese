package ServletUtente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneUtente.Accesso;

/**
 * Servlet implementation class RecuperaPasswordServlet
 */
@WebServlet("/RecuperaPasswordServlet")
public class RecuperaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String Email = (String) request.getParameter("email");
    		HttpSession session = request.getSession();
			session.setAttribute("em", Email);
			Accesso acc= new Accesso();
			if(acc.verificaEmail(Email)==true) {
				RequestDispatcher view = request.getRequestDispatcher("RecuperaPassword.jsp?em='"+Email+"'");
				view.forward(request, response);
			}
			else{
				RequestDispatcher view = request.getRequestDispatcher("recupera.jsp?errore=si");
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
