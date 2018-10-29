package zadatak2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class VodicKrozRestoraneTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private VodicKrozRestorane instance;

	@Before
	public void setUp() throws Exception {
		instance = new VodicKrozRestorane();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void atribut_restorani() {
		assertTrue("U klasi nije definisan atribut restorani", TestUtil.doesFieldExist(VodicKrozRestorane.class, "restorani"));
	}
	
	@Test
	public void atribut_restorani_vidljivost() {
		assertTrue("Atribut restorani nije privatan", TestUtil.hasFieldModifier(VodicKrozRestorane.class, "restorani", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_restorani_tipArrayList() {
		List<?> restorani = (List<?>) TestUtil.getFieldValue(instance, "restorani");
		
		assertTrue("Atribut restorani nije tipa ArrayList", ArrayList.class.isInstance(restorani));
	}
	
	@Test
	public void metoda_dodajNaPocetak() {
		Restoran r1 = new Restoran();
		instance.dodajNaPocetak(r1);
		
		Restoran r2 = new Restoran();
		instance.dodajNaPocetak(r2);
		
		ArrayList<?> restorani = (ArrayList<?>) TestUtil.getFieldValue(instance, "restorani");
		
		assertTrue("Nakon dodavanja dva restorana u vodic, prvi restoran nije na drugom mestu u nizu restorani", restorani.get(0).equals(r2));
		assertTrue("Nakon dodavanja dva restorana u vodic, drugi restoran nije na prvom mestu u nizu restorani", restorani.get(1).equals(r1));
	}
	
	@Test
	public void metoda_ispisiRestoraneSaOcenom() {
		Restoran r1 = new Restoran();
		r1.setNaziv("Salon 5");
		r1.setOcena(5);
		instance.dodajNaPocetak(r1);
		
		Restoran r2 = new Restoran();
		r2.setNaziv("Casa Nova");
		r2.setOcena(1);
		instance.dodajNaPocetak(r2);
		
		Restoran r3 = new Restoran();
		r3.setNaziv("Ciribu Ciriba");
		r3.setOcena(3);
		instance.dodajNaPocetak(r3);
		
		Restoran r4 = new Restoran();
		r4.setNaziv("Radost");
		r4.setOcena(5);
		instance.dodajNaPocetak(r4);
		
		instance.ispisiRestoraneSaOcenom(5);
		
		String ispis = outContent.toString();
		String ocekivaniIspis = "Radost" + System.lineSeparator() + "Salon 5" + System.lineSeparator();
		
		assertEquals("Za restorane u vodicu: \"Salon 5\" (ocena 5), \"Casa Nova\" (ocena 1), \"Ciribu Ciriba\" (ocena 3), \"Radost\" (ocena 5), ispisiRestoraneSaOcenom() sa prosledjenim parametrom \"5\" nije ispisao:\n" + ocekivaniIspis, ispis, ocekivaniIspis);
	}
	
	@Test
	public void metoda_obrisiLoseRestorane() {
		Restoran r1 = new Restoran();
		r1.setNaziv("Salon 5");
		r1.setOcena(5);
		instance.dodajNaPocetak(r1);
		
		Restoran r2 = new Restoran();
		r2.setNaziv("Casa Nova");
		r2.setOcena(1);
		instance.dodajNaPocetak(r2);
		
		Restoran r3 = new Restoran();
		r3.setNaziv("Ciribu Ciriba");
		r3.setOcena(3);
		instance.dodajNaPocetak(r3);
		
		Restoran r4 = new Restoran();
		r4.setNaziv("Radost");
		r4.setOcena(5);
		instance.dodajNaPocetak(r4);
		
		instance.obrisiLoseRestorane();
		
		ArrayList<?> restorani = (ArrayList<?>) TestUtil.getFieldValue(instance, "restorani");
		
		assertFalse("Za restorane u vodicu: \"Salon 5\" (ocena 5), \"Casa Nova\" (ocena 1), \"Ciribu Ciriba\" (ocena 3), \"Radost\" (ocena 5), obrisiLoseRestorane() nije uklonila restoran \"Casa Nova\" (ocena 1) iz liste restorani", restorani.contains(r2));
	}
	
	
}
