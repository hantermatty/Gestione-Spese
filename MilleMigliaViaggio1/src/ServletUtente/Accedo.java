package ServletUtente;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ClassiComuni.Utente;
import GestioneUtente.Accesso;

@WebServlet("/PageAccess.html")
public class Accedo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String page = (String) request.getParameter("page");
    	String pa;
    	int l;
    	if(page != null ) {
    		l = page.length();
    	   	pa = page.substring(42,l-5);
    		if (pa.equals("carrell")) {pa = "carrello";}
    		if (pa.equals("PageAccess.")) {pa = "home";}
    		if (pa.equals("PageAccess")) {pa = "home";}
    	}
    	else {
    		pa = "home";
    	}
    	Utente d = new Utente();
    	boolean test = false;
    	String e = null;
    	String p = null;
    	
    	Cookie[] c = request.getCookies();   
		if (c!=null) { 
			for(int i=0;i<c.length;i++) {
				if (c[i].getName().equals("usr")) 
					e = c[i].getValue();
				if (c[i].getName().equals("pass")) 
					p = c[i].getValue();	
			}
		} 	
		if (e == null || p == null){
			if(e == null) {e = request.getParameter("email");}
			if(p == null) {p = request.getParameter("pass");}   		
		}
		
		if(e != null && p != null) {
			d.setemail(e);
			d.setPass(p);
			Accesso acc = new Accesso();
			test = acc.accesso(d);						// richiama la funzione accesso per verificare se la pass e l'email corrispondono
		}
		
		if(test == true) {								// se sono giusti memorizza all'interno dei parametri della sessione, il primo accesso, l'email e il tipo ( se è venditore o Acquirente)
			Cookie usr = new Cookie("email", e);		
		    response.addCookie(usr);
		    Cookie psw = new Cookie("password", p);
		    response.addCookie(psw);
			
			HttpSession sessione = request.getSession();
			sessione.setAttribute("email", e);  
			sessione.setAttribute("tipo", d.getTipo());
			
			if(d.getTipo().equals("a")) {sessione.setAttribute("primo", "si");}
			request.setAttribute("test", "true");
		}
		else 
		{
			request.setAttribute("test", "false");
		}
		RequestDispatcher view;													// questi parametri ci serviranno nella pagina client per accedere nella
		if(d.getTipo()=="v") {view = request.getRequestDispatcher("home.jsp");} // pagina in cui si ci trova in quel momento
		else {view = request.getRequestDispatcher(pa+".jsp");}					// quindi verranno inviati i parametri a page+.jsp ( es. home.jsp o carrello.jsp ecc..)
		view.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
