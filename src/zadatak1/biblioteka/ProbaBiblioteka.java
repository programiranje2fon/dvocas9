package zadatak1.biblioteka;

import zadatak1.Knjiga;

public class ProbaBiblioteka {

	public static void main(String[] args) {
		Knjiga k1 = new Knjiga();
		k1.setNaziv("Znakovi pored puta");
		try {
			k1.setGodina(1976);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Knjiga k2 = new Knjiga();
		k2.setNaziv("Mansarda");
		try {
			k2.setGodina(1960);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.arhivirajKnjige(2010);
	}
}
