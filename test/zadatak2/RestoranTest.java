package zadatak2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import test.TestUtil;

public class RestoranTest {

	private Restoran instance;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		instance = new Restoran();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void atribut_naziv() {
		assertTrue("U klasi nije definisan atribut naziv", TestUtil.doesFieldExist(Restoran.class, "naziv"));
	}

	@Test
	public void atribut_naziv_vidljivost() {
		assertTrue("Atribut naziv nije privatan", TestUtil.hasFieldModifier(Restoran.class, "naziv", Modifier.PRIVATE));
	}

	@Test
	public void atribut_ocena() {
		assertTrue("U klasi nije definisan atribut ocena", TestUtil.doesFieldExist(Restoran.class, "ocena"));
	}

	@Test
	public void atribut_ocena_vidljivost() {
		assertTrue("Atribut ocena nije privatan", TestUtil.hasFieldModifier(Restoran.class, "ocena", Modifier.PRIVATE));
	}

	@Test
	public void metoda_setNaziv() {
		instance.setNaziv("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "naziv");
		assertEquals(
				"Nakon poziva metode setNaziv(String) sa prosledjenim argumentom \"Madera\", vrednost atributa naziv nema tu vrednost",
				"Madera", nazivValue);
	}

	@Test
	public void metoda_setNaziv_null() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("GRESKA");

		instance.setNaziv(null);
	}

	@Test
	public void metoda_getNaziv() {
		instance.setNaziv("Madera");
		String nazivValue = (String) TestUtil.getFieldValue(instance, "naziv");

		assertEquals("Metoda getNaziv() ne vraca vrednost atributa naziv", nazivValue, instance.getNaziv());
	}

	@Test
	public void metoda_setOcena_1() {
		instance.setOcena(1);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "ocena");
		assertEquals(
				"Nakon poziva metode setOcena(int) sa prosledjenim argumentom \"1\", vrednost atributa ocena nema tu vrednost",
				1, ocenaValue);
	}

	@Test
	public void metoda_setOcena_3() {
		instance.setOcena(3);
		int brojValue = (int) TestUtil.getFieldValue(instance, "ocena");
		assertEquals(
				"Nakon poziva metode setOcena(int) sa prosledjenim argumentom \"3\", vrednost atributa ocena nema tu vrednost",
				3, brojValue);
	}

	@Test
	public void metoda_setOcena_5() {
		instance.setOcena(5);
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "ocena");
		assertEquals(
				"Nakon poziva metode setOcena(int) sa prosledjenim argumentom \"5\", vrednost atributa ocena nema tu vrednost",
				5, ocenaValue);
	}

	@Test
	public void metoda_setOcena_vanGranice() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("GRESKA");

		instance.setOcena(100);
	}

	@Test
	public void metoda_getOcena() {
		int ocenaValue = (int) TestUtil.getFieldValue(instance, "ocena");

		assertEquals("Metoda getOcena() ne vraca vrednost atributa ocena", ocenaValue, instance.getOcena());
	}
}
