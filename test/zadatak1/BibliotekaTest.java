package zadatak1;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;
import zadatak1.biblioteka.Biblioteka;

public class BibliotekaTest {

	private Biblioteka instance;

	@Before
	public void setUp() throws Exception {
		instance = new Biblioteka();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_knjige() {
		assertTrue("U klasi nije definisan atribut knjige", TestUtil.doesFieldExist(Biblioteka.class, "knjige"));
	}
	
	@Test
	public void atribut_knjige_vidljivost() {
		assertTrue("Atribut knjige nije privatan", TestUtil.hasFieldModifier(Biblioteka.class, "knjige", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_knjige_tipLinkedList() {
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "knjige");
		
		assertTrue("Atribut knjige nije tipa LinkedList", LinkedList.class.isInstance(knjige));
	}
	
	@Test
	public void metoda_dodajKnjigu() {
		Knjiga k1 = new Knjiga();
		instance.dodajKnjigu(k1);
		
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "knjige");
		
		assertTrue("Metoda nije dodala knjigu u listu knjige", knjige.contains(k1));
	}
	
	@Test
	public void metoda_daLiPostoji() {
		Knjiga k1 = new Knjiga();
		instance.dodajKnjigu(k1);
		
		assertTrue("Metoda nije vratila TRUE za knjigu koja je dodata u listu knjige", instance.daLiPostoji(k1));
	}
	
	@Test
	public void metoda_obrisiKnjigu() {
		Knjiga k1 = new Knjiga();
		instance.dodajKnjigu(k1);
		instance.obrisiKnjigu(k1);
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "knjige");
		
		assertTrue("Metoda nije vratila TRUE za knjigu koja je dodata u listu knjige", !knjige.contains(k1));
	}
	
	@Test
	public void metoda_pretraziKnjige() {
		Knjiga k1 = new Knjiga();
		k1.setNaziv("Legenda o Taboru");
		instance.dodajKnjigu(k1);
		
		Knjiga k2 = new Knjiga();
		k2.setNaziv("Beleske jedne Ane");
		instance.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		k3.setNaziv("Konte");
		instance.dodajKnjigu(k3);
		
		Knjiga k4 = new Knjiga();
		k4.setNaziv("KO JE ALISA?");
		instance.dodajKnjigu(k4);
		
		List<Knjiga> pronadjeneKnjige = instance.pretraziKnjige("ko");
		
		assertTrue("Za biblioteku sa knjigama: \"Legenda o Taboru\", \"Beleske jedne Ane\", \"Konte\", \"KO JE ALISA?\", metoda nije vratila listu sa knjigama \"Konte\" i \"KO JE ALISA?\"", pronadjeneKnjige.size() == 2 && pronadjeneKnjige.contains(k3) && pronadjeneKnjige.contains(k4));
	}
	
	@Test
	public void metoda_arhivirajKnjige() throws Exception {
		Knjiga k1 = new Knjiga();
		k1.setGodina(2011);
		instance.dodajKnjigu(k1);
		
		Knjiga k2 = new Knjiga();
		k2.setGodina(2008);
		instance.dodajKnjigu(k2);
		
		Knjiga k3 = new Knjiga();
		k3.setGodina(2016);
		instance.dodajKnjigu(k3);
		
		Knjiga k4 = new Knjiga();
		k4.setGodina(2011);
		instance.dodajKnjigu(k4);
		
		instance.arhivirajKnjige(2011);
		
		List<?> knjige = (List<?>) TestUtil.getFieldValue(instance, "knjige");
		
		assertTrue("Za biblioteku sa knjigama sa godinama: \"2011\", \"2008\", \"2016\", \"2011\", metoda pozvana sa argumentom 2011 nije arhivirala knjige sa godinama \"2008\" i \"2011\"", knjige.size() == 1 && !knjige.contains(k1) && !knjige.contains(k2) && !knjige.contains(k4));
	}
}
