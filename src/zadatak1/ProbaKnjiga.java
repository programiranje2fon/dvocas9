package zadatak1;

import zadatak1.izuzeci.FormatBrojaException;

public class ProbaKnjiga {

	public static void main(String[] args) {
		Knjiga k1 = new Knjiga();
		System.out.println(k1.getNaziv().length());

		try {
			k1.setBroj("1234");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} catch (FormatBrojaException e) {
			System.out.println(e.getMessage());
		}
	}
}
