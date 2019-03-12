package ServletVendita;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import GestioneVendita.GestionePacchetti;

/**
 * Servlet implementation class ModificaFormServlet
 */
@WebServlet("/ModificaFormServlet.html")
public class ModificaForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String id = request.getParameter("codm");
			DatiPacchetti d = new DatiPacchetti(null, null, null, null, null, null, null, null, null, null, null);
			DatiVolo v = new DatiVolo(null, null, null, null, null);	
			DatiAllogio a = new DatiAllogio(null, null, null, null, null);
			GestionePacchetti pacc = new GestionePacchetti();
			pacc.Pagina_pacc(id,d,v,a);

			request.setAttribute("data_fine",d.getData_f());
			request.setAttribute("data_inizio",d.getData_i());
			request.setAttribute("descrizione_luogo",d.getDescrluogo());
			request.setAttribute("descrizione_pacchetto",d.getDescrPacc());
			request.setAttribute("destinazione",d.getDestinazione());
			request.setAttribute("immagine",d.getImmagine());
			request.setAttribute("numero_acquisti",d.getN_acquisti());
			request.setAttribute("nazione",d.getNazione());
			request.setAttribute("prezzo",d.getPrezzo());

			request.setAttribute("compagnia_v",v.getCompagnia());
			request.setAttribute("ora_partenza",v.getOra_a());
			request.setAttribute("ora_ritorno",v.getOra_r());
			request.setAttribute("prezzo_v",v.getPrezzo());
			
			request.setAttribute("indirizzo",a.getIndirizzo());
			request.setAttribute("prezzo_a",a.getPrezzo());
			request.setAttribute("servizi",a.getServizio());
			request.setAttribute("tipo_a",a.getTipo());

			RequestDispatcher view = request.getRequestDispatcher("modifica_pacchetto.jsp");
			view.forward(request, response);
			}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
