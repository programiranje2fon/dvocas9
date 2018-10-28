package zadatak1;

import zadatak1.izuzeci.FormatBrojaException;

public class Knjiga {

	private String naziv = "";
	private String broj = "";

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null) {
			throw new RuntimeException("Naziv ne moze biti NULL");
		} else {
			this.naziv = naziv;
		}
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) throws FormatBrojaException {
		if (broj == null) {
			throw new RuntimeException("Broj ne moze biti NULL");
		} else if (broj.length() != 9 && broj.indexOf(4) != '-') {
			throw new FormatBrojaException("Broj nije u odgovarajucem formatu");
		} else {
			this.broj = broj;
		}
	}

}
