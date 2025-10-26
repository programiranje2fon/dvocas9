package zadatak1;

import java.util.GregorianCalendar;

public class Knjiga {

	private String naziv = "";
	private int godina;

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

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) throws Exception {
		GregorianCalendar sada = new GregorianCalendar();

		if (godina >= 1950 && godina <= sada.get(GregorianCalendar.YEAR)) {
			this.godina = godina;
		} else {
			throw new Exception("Godina nije u odgovarajucem opsegu");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Knjiga)) {
			return false;
		}

		Knjiga k1 = (Knjiga) obj;

		return this.naziv.equals(k1.naziv) && this.godina == k1.godina;
	}
}
