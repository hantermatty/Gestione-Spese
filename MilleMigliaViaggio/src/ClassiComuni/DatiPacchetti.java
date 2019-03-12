package ClassiComuni;


public class DatiPacchetti {

	private String codice;
	private String descrizione_pacchetto;
	private String prezzo;
	private String data_inizio;
	private String data_fine;
	private String descrizione_luogo;
	private String destinazione;
	private String nazione;
	private String immagine;
	private String n_acquisti;
	private String Email;
	public DatiPacchetti() {
	
	}
	public DatiPacchetti(String codice, String descrizione_pacchetto, String prezzo, String data_inizio, String data_fine, String descrizione_luogo, String destinazione, String nazione, String immagine, String n_acquisti, String Email) {
		this.codice = codice;
		this.descrizione_pacchetto = descrizione_pacchetto;
		this.prezzo = prezzo;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
		this.descrizione_luogo = descrizione_luogo;
		this.destinazione = destinazione;
		this.nazione = nazione;
		this.immagine = immagine;
		this.n_acquisti = n_acquisti;
		this.Email = Email;
	}
		public String getCodice() {
			return codice;
		}

		public void setCodice(String d) {
			codice = d;
		}
	
		public String getDescrPacc() {
			return descrizione_pacchetto;
		}

		public void setDescrPacc(String d) {
			descrizione_pacchetto = d;
		}
		public String getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(String p) {
			prezzo = p;
		}
		public String getData_i() {
			return data_inizio;
		}

		public void setData_i(String d) {
			data_inizio = d;
		}

		public String getData_f() {
			return data_fine;
		}

		public void setData_f(String d) {
			data_fine = d;
		}

		public String getDescrluogo() {
			return descrizione_luogo;
		}

		public void setDescrluogo(String d) {
			descrizione_luogo = d;
		}

		public String getDestinazione() {
			return destinazione;
		}

		public void setDestinazione(String d) {
			destinazione = d;
		}
		
		public String getNazione() {
			return nazione;
		}

		public void setNazione(String nazione) {
			this.nazione = nazione;
		}
		
		public String getImmagine() {
			return immagine;
		}
		
		public void setImmagine(String i) {
			immagine = i;
		}
		
		public String getN_acquisti() {
			return n_acquisti;
		}
		
		public void setN_acquisti(String n) {
			n_acquisti = n;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
		public boolean Equals(DatiPacchetti p) {
			if(p.getCodice().equals(this.codice) && p.getData_i().equals(this.data_inizio) && p.getData_f().equals(this.data_fine)) {
				return true;
			}
			
			return false;
		}
}
