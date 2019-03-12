package ServletAcquisto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import GestioneAcquisto.Carrello;

@WebServlet("/AggCarPacOffline")
public class AggCarPacOffline extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggCarPacOffline() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("ciao");
		String page = request.getParameter("namePage"); // prende il parametro namepage
		System.out.print(page);
		Cookie c;
		int i=0,l=0;
		Cookie[] cookies = request.getCookies(); // prende i cookie e fa il controllo sulla lunghezza se i cookie è maggiore di 0 si memorizza la lunghezza 
		if(cookies.length > 0){l = cookies.length;}
		HttpSession sessione = request.getSession();
		String e = (String) sessione.getAttribute("email"); // si prende il parametro email dalla sessione e se lo memorizza
		Carrello carr = new Carrello();// inizializza il db per memomorizzare i pacchetti offline
		while(i < l){ // finchè i < 1 continua e si va a prendere ogni volta i valori fin quando la lunghezza è 6 
			c = cookies[i];
			String val = c.getValue();
			if(val.length() == 6)
			{
				try {carr.AggiungiC(val, e);} catch (SQLException e1) {}
			}
			i++;
		}
		sessione.setAttribute("primo", "no");

		RequestDispatcher view = request.getRequestDispatcher(page); // passa i parametri a page
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
