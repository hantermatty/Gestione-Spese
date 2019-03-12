package ClassiComuni;

public class DatiAllogio {
	
	private String codice;
	private String indirizzo;
	private String tipo_a;
	private String prezzo;
	private String servizio;
	 
	public DatiAllogio(String codice,String indirizzo,String tipo_a, String prezzo, String servizio) {
		this.codice = codice;
		this.indirizzo = indirizzo;
		this.tipo_a = tipo_a;
		this.prezzo = prezzo;
		this.servizio = servizio;
	}
	public DatiAllogio() {
		
	}

		public String getCodice() {
			return codice;
		}

		public void setCodice(String c) {
			codice = c;
		}

		public String getIndirizzo() {
			return indirizzo;
		}

		public void setIndirizzo(String i) {
			indirizzo = i;
		}
		public String getTipo() {
			return tipo_a;
		}

		public void setTipo(String t) {
			tipo_a = t;
		}
		public String getPrezzo() {
			return prezzo;
		}

		public void setPrezzo(String p) {
			prezzo = p;
		}
	

		public String getServizio() {
			return servizio;
		}

		public void setServizio(String s) {
			servizio = s;
		}
}