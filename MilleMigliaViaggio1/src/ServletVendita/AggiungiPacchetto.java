package ServletVendita;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import ClassiComuni.DatiAllogio;
import ClassiComuni.DatiPacchetti;
import ClassiComuni.DatiVolo;
import GestioneVendita.Vendita;


@WebServlet("/AggiungiPacchetto-Home.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class AggiungiPacchetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AggiungiPacchetto() {
        super();
    }

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.lastIndexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		String email = (String) sessione.getAttribute("email");
		DatiPacchetti d = new DatiPacchetti(null, null, null, null, null, null, null, null, null, null, null);						// aggiunge il pacchetto nuovo creato dal venditore nel database
		
		String codice = request.getParameter("codice");
		d.setCodice(codice);
		String descr_p = request.getParameter("descr_p");
		d.setDescrPacc(descr_p);
		String descr_l = request.getParameter("descr_l");
		d.setDescrluogo(descr_l);
		String nazione = request.getParameter("naz");
		d.setNazione(nazione);
		String destinazione = request.getParameter("dest");
		d.setDestinazione(destinazione);
		String prezzo =  request.getParameter("prezzo");
		d.setPrezzo(prezzo);
		String data_p = request.getParameter("data_p");
		d.setData_i(data_p);
		String data_r = request.getParameter("data_r");
		d.setData_f(data_r);
		d.setEmail(email);
		Part part = request.getPart("file");
		String fileName = extractFileName(part);
		String savePath = "C:\\Program Files\\apache-tomcat-9.0.5\\webapps\\MilleMigliaViaggio6\\IMG" + File.separator + fileName;
		File fileSaveDir= new File(savePath);
		savePath = "C:\\Program Files\\apache-tomcat-9.0.5\\webapps\\MilleMigliaViaggio6\\IMG" + File.separator + fileName;
		File fileSave= new File(savePath);
		d.setImmagine("IMG/"+fileName);
		part.write(savePath + File.separator);
	
		DatiAllogio s = new DatiAllogio(null, null, null, null, null);
		
		String codice_s = request.getParameter("codice_s");
		s.setCodice(codice_s);
		String i = request.getParameter("indirizzo");
		s.setIndirizzo(i);
		String t = request.getParameter("tipo");
		s.setTipo(t);
		String p = request.getParameter("prezzo_s");
		s.setPrezzo(p);
		String se = request.getParameter("servizio");
		s.setServizio(se);
		
		DatiVolo v = new DatiVolo(null,null,null,null,null);
		
		String codice_v = request.getParameter("codice_v");
		v.setCodice(codice_v);
		String c = request.getParameter("compagnia");
		v.setCompagnia(c);
		String p_v = request.getParameter("prezzo_v");
		v.setPrezzo(p_v);
		String o_p = request.getParameter("ora_p");
		v.setOra_a(o_p);
		String o_r = request.getParameter("ora_r");
		v.setOra_r(o_r);
		
		Vendita pac = new Vendita();
		try {pac.Aggiungi(d,s,v);} catch (SQLException e) {e.printStackTrace();}
	
		RequestDispatcher view = request.getRequestDispatcher("aggiungi_pacchetto.jsp?inserito=si");
		view.forward(request, response);
	}

}

