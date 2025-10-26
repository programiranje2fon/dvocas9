package zadatak2;

public class ProbaRestorani {

	public static void main(String[] args) {
		Restoran r1 = new Restoran();
		r1.setNaziv("Blue Hill");
		r1.setOcena(4);
		
		Restoran r2 = new Restoran();
		r2.setNaziv("Per Se");
		r2.setOcena(1);
		
		Restoran r3 = new Restoran();
		r3.setNaziv("Daniel");
		r3.setOcena(4);
		
		VodicKrozRestorane vodic = new VodicKrozRestorane();
		vodic.dodajNaPocetak(r1);
		vodic.dodajNaPocetak(r2);
		vodic.dodajNaPocetak(r3);
		
		vodic.ispisiRestoraneSaOcenom(4);
		
		vodic.obrisiLoseRestorane();
	}

}
