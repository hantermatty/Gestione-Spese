package ServletUtente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Logout-Home.html")
public class Logout extends HttpServlet {
	    
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//per fare in modo che un cookie venga cancellato dal browser
		//bisogna ricrearli con valore "", dargli MaxAge pari a 0 e rinviarglielo
		Cookie usr = new Cookie("email", "");
	    usr.setMaxAge(0);
	    response.addCookie(usr);
	    Cookie psw = new Cookie("password", "");
	    psw.setMaxAge(0);
	    response.addCookie(psw);
	    request.getSession().invalidate();
	    HttpSession sessione = request.getSession();
		sessione.setAttribute("email", "");  
		sessione.setAttribute("pass", "");
	    response.sendRedirect("home.html");					//reindirizza alla pagina home una volta effettuato il Logout
	}
}