package zadatak2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VodicKrozRestorane {

	private List<Restoran> restorani;
	
	public VodicKrozRestorane() {
		restorani = new ArrayList<>();
	}
	
	public void dodajNaPocetak(Restoran restoran) {
		restorani.add(0, restoran);
	}
	
	public void ispisiRestoraneSaOcenom(int ocena) {
		for (Restoran restoran : restorani) {
			if (restoran.getOcena() == ocena) {
				System.out.println(restoran.getNaziv());
			}
		}
	}
	
	public void obrisiLoseRestorane() {
		Iterator<Restoran> iterator = restorani.iterator();
		
		while (iterator.hasNext()) {
			Restoran restoran = (Restoran) iterator.next();
			
			if (restoran.getOcena() == 1) {
				iterator.remove();
			}
		}
	}
}
