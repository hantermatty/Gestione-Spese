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

@WebServlet("/Elimina-Pacchetti.html")
public class Elimina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Elimina() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int l=0,i=0;
		HttpSession sessione = request.getSession();							// elimina il pacchetto dal carrello
		String e = (String) sessione.getAttribute("email");
		String cod = request.getParameter("id");
		if(e == null || e == "") {
			Cookie[] cookies = request.getCookies();
			if(cookies.length > 0){l = cookies.length;}
			while(i < l){
				Cookie c;
				c = cookies[i];
				String val = c.getValue();
				if(val.equals(cod)) {
					Cookie usr = new Cookie(c.getName(), "");
				    usr.setMaxAge(0);
				    response.addCookie(usr);
				}
				i++;
			}
		}
		else {
			Carrello carr = new Carrello();
			boolean ok = true;
			 ok = carr.Elimina(cod,e);
			System.out.println(ok);
		}
		RequestDispatcher view = request.getRequestDispatcher("carrello.jsp?elimina=si");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
