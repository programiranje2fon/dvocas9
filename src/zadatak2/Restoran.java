package zadatak2;

public class Restoran {

	private String naziv;
	private int ocena;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv != null && !naziv.isEmpty()) {
			this.naziv = naziv;
		} else {
			throw new RuntimeException("GRESKA");
		}
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		if (ocena >= 1 && ocena <= 5) {
			this.ocena = ocena;
		} else {
			throw new RuntimeException("GRESKA");
		}
	}

}
