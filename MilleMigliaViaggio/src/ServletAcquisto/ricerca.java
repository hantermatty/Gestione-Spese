package ServletAcquisto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassiComuni.DatiPacchetti;
import GestioneAcquisto.Ricerca;

@WebServlet("/RisultatoRicerca.html")
public class ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public ricerca() {
        super();
    }

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data =(String)request.getParameter("data");
		String arr =(String)request.getParameter("arrivi");
		// converte la data in interi
		int m = 0,a = 0,l,i=0;
		if(data != "") 
		{
				l = data.length();
		
				if(l == 7) 
				{
					m = Integer.parseInt(data.substring(0,2));
					a = Integer.parseInt(data.substring(3,7));
				}
				else
				{
					m = Integer.parseInt(data.substring(0,1));
					a = Integer.parseInt(data.substring(2,6));
				}
		}
		Ricerca r = new Ricerca();
		DatiPacchetti [] pacchetti = new DatiPacchetti[10];
		pacchetti = r.Ricerca(arr, m, a);				// richiama la funzione ricerca 
		
		List<String> info_p = new ArrayList<String>();
		while(pacchetti[i]!=null) {
			info_p.add(pacchetti[i].getImmagine());
			info_p.add(pacchetti[i].getDestinazione());
			info_p.add(pacchetti[i].getDescrPacc());
			info_p.add(pacchetti[i].getPrezzo());
			info_p.add(pacchetti[i].getCodice());
			i++;
		}
		request.setAttribute("info_p", info_p);
		if(info_p.isEmpty()== false) {
		RequestDispatcher view = request.getRequestDispatcher("risultato_ricerca.jsp?risultato=si");		//invia i parametri alla pagina risultato ricerca per la visual.
		view.forward(request, response);													// del messaggio.
		} else {
			RequestDispatcher view = request.getRequestDispatcher("risultato_ricerca.jsp");
			view.forward(request, response);
		}
		
	}


}
