package zadatak1.biblioteka;

import zadatak1.Knjiga;

public class ProbaBiblioteka {

	public static void main(String[] args) {
		Knjiga k1 = new Knjiga();
		k1.setNaziv("Pored puta");
		try {
			k1.setBroj("0324-2010");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Knjiga k2 = new Knjiga();
		k2.setNaziv("Mansarda");
		try {
			k2.setBroj("5253-2012");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.arhivirajKnjige(2010);
	}
}
