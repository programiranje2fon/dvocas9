package zadatak1.biblioteka;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import zadatak1.Knjiga;

public class Biblioteka {

	private List<Knjiga> knjige = new LinkedList<>();

	public void dodajKnjigu(Knjiga knjiga) {
		knjige.add(knjiga);
	}

	public boolean daLiPostoji(Knjiga knjiga) {
		return knjige.contains(knjiga);
	}

	public void obrisiKnjigu(Knjiga knjiga) {
		knjige.remove(knjiga);
	}

	public List<Knjiga> pretraziKnjige(String pocetakNaziva) {
		List<Knjiga> knjigeSaNazivom = new LinkedList<>();

		for (Knjiga knjiga : knjige) {
			if (knjiga.getNaziv().toLowerCase().startsWith(pocetakNaziva.toLowerCase())) {
				knjigeSaNazivom.add(knjiga);
			}
		}

		return knjigeSaNazivom;
	}

	public void arhivirajKnjige(int godina) {
		Iterator<Knjiga> iterator = knjige.iterator();

		while (iterator.hasNext()) {
			Knjiga knjiga = iterator.next();

			if (knjiga.getGodina() <= godina) {
				iterator.remove();
			}
		}
	}
}
