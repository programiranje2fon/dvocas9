package zadatak1;

public class ProbaKnjiga {

	public static void main(String[] args) {
		Knjiga k1 = new Knjiga();
		System.out.println(k1.getNaziv().length());

		try {
			k1.setGodina(2015);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
