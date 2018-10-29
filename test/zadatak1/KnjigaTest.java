package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import test.TestUtil;

public class KnjigaTest {

	private Knjiga instance;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		instance = new Knjiga();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(Knjiga.class, "naziv"));
	}
	
	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(Knjiga.class, "naziv", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_naziv_pocetnaVrednost() {
		String nazivValue = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals("Pocetna vrednost atributa naziv nije prazan string", "", nazivValue);
	}
	
	@Test
	public void atribut_broj() {
		assertTrue("U klasi nije definisan atribut broj", TestUtil.doesFieldExist(Knjiga.class, "broj"));
	}
	
	@Test
	public void atribut_broj_vidljivost() {
		assertTrue("Atribut broj nije privatan", TestUtil.hasFieldModifier(Knjiga.class, "broj", Modifier.PRIVATE));
	}
	
	@Test
	public void atribut_broj_pocetnaVrednost() {
		String brojValue = (String) TestUtil.getFieldValue(instance, "broj");
		assertEquals("Pocetna vrednost atributa broj nije prazan string", "", brojValue);
	}
	
	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Na Drini cuprija");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals("Nakon poziva metode setNaziv(String) sa prosledjenim argumentom \"Na Drini cuprija\", vrednost atributa naziv nema tu vrednost", "Na Drini cuprija", nazivValue);
	}
	
	@Test
	public void metoda_setNaziv_null() {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Naziv ne moze biti NULL");
	    
	    instance.setNaziv(null);
	}
	
	@Test
	public void metoda_getNaziv() {
		String nazivValue = (String) TestUtil.getFieldValue(instance, "naziv");

		assertEquals("Metoda getNaziv() ne vraca vrednost atributa naziv", nazivValue, instance.getNaziv());
	}
	
	@Test
	public void metoda_setBroj() throws Exception {
		instance.setBroj("4432-4324");
		String brojValue = (String) TestUtil.getFieldValue(instance, "broj");
		assertEquals("Nakon poziva metode setBroj(String) sa prosledjenim argumentom \"4432-4324\", vrednost atributa broj nema tu vrednost", "4432-4324", brojValue);
	}
	
	@Test
	public void metoda_setBroj_null() throws Exception {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Broj ne moze biti NULL");
	    
		instance.setBroj(null);
	}
	
	@Test
	public void metoda_setBroj_losFormatBroja() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("Broj nije u odgovarajucem formatu");
		
		instance.setBroj("aaa");
	}
	
	@Test
	public void metoda_getBroj() {
		String brojValue = (String) TestUtil.getFieldValue(instance, "broj");

		assertEquals("Metoda getBroj() ne vraca vrednost atributa broj", brojValue, instance.getBroj());
	}
	
}
