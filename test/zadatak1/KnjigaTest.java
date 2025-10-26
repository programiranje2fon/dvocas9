package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;
import java.util.GregorianCalendar;

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
	public void atribut_godina() {
		assertTrue("U klasi nije definisan atribut godina", TestUtil.doesFieldExist(Knjiga.class, "godina"));
	}
	
	@Test
	public void atribut_godina_vidljivost() {
		assertTrue("Atribut godina nije privatan", TestUtil.hasFieldModifier(Knjiga.class, "godina", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Na Drini cuprija");
		String naziv = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals("Nakon poziva metode setNaziv(String) sa prosledjenim argumentom \"Na Drini cuprija\", vrednost atributa naziv nema tu vrednost", "Na Drini cuprija", naziv);
	}
	
	@Test
	public void metoda_setNaziv_null() {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Naziv ne moze biti NULL");
	    
	    instance.setNaziv(null);
	}
	
	@Test
	public void metoda_getNaziv() {
		String naziv = (String) TestUtil.getFieldValue(instance, "naziv");

		assertEquals("Metoda getNaziv() ne vraca vrednost atributa naziv", naziv, instance.getNaziv());
	}
	
	@Test
	public void metoda_setGodina() throws Exception {
		instance.setGodina(2010);
		int godina = (int) TestUtil.getFieldValue(instance, "godina");
		assertEquals("Nakon poziva metode setGodina(int) sa prosledjenim argumentom \"2010\", vrednost atributa godina nema tu vrednost", 2010, godina);
	}
	
	@Test
	public void metoda_setGodina_ispodOpsega() throws Exception {
		expectedEx.expect(Exception.class);
	    expectedEx.expectMessage("Godina nije u odgovarajucem opsegu");
	    
		instance.setGodina(1900);
	}
	
	@Test
	public void metoda_setGodina_iznadOpsega() throws Exception {
		expectedEx.expect(Exception.class);
		expectedEx.expectMessage("Godina nije u odgovarajucem opsegu");
		
		GregorianCalendar sada = new GregorianCalendar();
		
		instance.setGodina(sada.get(GregorianCalendar.YEAR + 1));
	}
	
	@Test
	public void metoda_getGodina() {
		int godina = (int) TestUtil.getFieldValue(instance, "godina");

		assertEquals("Metoda metoda_getGodina() ne vraca vrednost atributa godina", godina, instance.getGodina());
	}
	
	@Test
	public void metoda_equals() throws Exception {
		instance.setNaziv("Zapisi o Goji");
		instance.setGodina(1961);
		
		Knjiga k1 = new Knjiga();
		k1.setNaziv("Zapisi o Goji");
		k1.setGodina(1961);
		
		assertEquals("Metoda equals() ne vraca vrednost true za prosledjenu knjigu sa istim nazivom i godinom", k1, instance);
	}
}
