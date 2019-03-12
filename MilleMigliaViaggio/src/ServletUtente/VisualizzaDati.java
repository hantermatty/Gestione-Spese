package ServletUtente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassiComuni.Utente;
import GestioneUtente.Accesso;

@WebServlet("/VisualizzaDati")
public class VisualizzaDati extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public VisualizzaDati() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession sessione = request.getSession();
			String e = (String) sessione.getAttribute("email");
			int i = 1;
			response.setContentType("text/html");
			response.getWriter().append("[");
			Accesso p = new Accesso();
			Utente dati = new Utente(); 
			dati = p.RecuperaDati(e);
					
			List<String> a = new ArrayList<String>();		
			a.add(dati.getCell());
			a.add(dati.getCognome());
			a.add(dati.getemail());
			a.add(dati.getIndirizzo());
			a.add(dati.getNazione());
			a.add(dati.getNome());
			a.add(dati.getPass());
			
			int n = a.size()/6;
			response.getWriter().append("{\"lunghezza\": \""+n+"\"},");
			Iterator<String> it = a.iterator();
			while(it.hasNext())
			{
				if(i!=n) {
					response.getWriter().append("{\"img\": \""+it.next()+"\",");
					response.getWriter().append("\"descrizione_pacchetto\": \""+it.next()+"\",");
					response.getWriter().append("\"prezzo\": \""+it.next()+"\",");
					response.getWriter().append("\"destinazione\": \""+it.next()+"\",");
					response.getWriter().append("\"codice_pacchetto\": \""+it.next()+"\",");
					response.getWriter().append("\"n_pacchetti_acquistati\": \""+it.next()+"\"},");
				}
				else {
					response.getWriter().append("{\"img\": \""+it.next()+"\",");
					response.getWriter().append("\"descrizione_pacchetto\": \""+it.next()+"\",");
					response.getWriter().append("\"prezzo\": \""+it.next()+"\",");
					response.getWriter().append("\"destinazione\": \""+it.next()+"\",");
					response.getWriter().append("\"codice_pacchetto\": \""+it.next()+"\",");
					response.getWriter().append("\"n_pacchetti_acquistati\": \""+it.next()+"\"}");
				}
				i++;
			}
			response.getWriter().append("]");
		} 
		catch (SQLException e1){
			e1.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
