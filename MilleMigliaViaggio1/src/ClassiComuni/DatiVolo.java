package ClassiComuni;

public class DatiVolo {
	
	private String codice;
	private String prezzo_v;
	private String compagnia_v;
	private String ora_andata;
	private String ora_ritorno;

	public DatiVolo(String codice, String prezzo_v, String compagnia_v, String ora_andata, String ora_ritorno) {
		this.codice = codice;
		this.prezzo_v = prezzo_v;
		this.compagnia_v = compagnia_v;
		this.ora_andata = ora_andata;
		this.ora_ritorno = ora_ritorno;
	}
	public DatiVolo() {
		
	}
		
		public String getCodice() {
			return codice;
		}

		public void setCodice(String c) {
			codice = c;
		}
		public String getPrezzo() {
			return prezzo_v;
		}

		public void setPrezzo(String p) {
			prezzo_v = p;
		}
	
		public String getCompagnia() {
			return compagnia_v;
		}

		public void setCompagnia(String c) {
			compagnia_v = c;
		}
		public String getOra_a() {
			return ora_andata;
		}

		public void setOra_a(String o) {
			ora_andata = o;
		}
		public String getOra_r() {
			return ora_ritorno;
		}

		public void setOra_r(String o) {
			ora_ritorno = o;
		}

		
}