package fr.ensup.projetTDD.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class test1 {

	CalculatriceService Calc = new CalculatriceService();

	@Test
	public void testAdditionner() {
		//V�rifie si le r�sultat est bien l'addition des deux valeurs
		int resultat = Calc.addition(2, 3);
		assertEquals(resultat, 5);
	}

	@Test
	public void testSoustraction() {
		//V�rifie si le r�sultat est bien la soustraction des deux valeurs
		int resultat = Calc.soustraction(3, 2);
		assertEquals(resultat, 1);
	}

	@Test
	public void testAssertArrayEquals() {
		//V�rifie si les deux tableaux de bytes sont les m�mes
		byte[] expected = "cyril".getBytes();
		byte[] actual = "cyril".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		//V�rifie si les deux chaine de caract�re sont �gaux
		assertEquals("failure - strings are not equal", "calculatrice", "calculatrice");
	}

	@Test
	public void testAssertFalse() {
		//V�rifie si le retour est bien faux
		assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		//V�rifie si la valeur n'est pas null
		int a = 3;
		assertNotNull("should not be null", a);
	}

	@Test
	public void testAssertNotSame() {
		//V�rifie si ce n'est pas les m�mes objets
		int a = 0;
		int b = 2;
		assertNotSame("should not be same Object", a, b);
	}

	@Test
	public void testAssertNull() {
		//V�rifie si la valeur a est null
		String a = null;
		assertNull("should be null", a);
	}

	@Test
	public void testAssertSame() {
		//v�rifie si la valeur est la m�me
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	@Ignore("Test is ignored as a demonstration")
	//On ignore le test
	@Test
	public void testAssertTrue() {
		//V�rifie si c'est vrai
		assertTrue("failure - should be true", true);
	}

}
