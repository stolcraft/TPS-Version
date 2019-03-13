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
		//Vérifie si le résultat est bien l'addition des deux valeurs
		int resultat = Calc.addition(2, 3);
		assertEquals(resultat, 5);
	}

	@Test
	public void testSoustraction() {
		//Vérifie si le résultat est bien la soustraction des deux valeurs
		int resultat = Calc.soustraction(3, 2);
		assertEquals(resultat, 1);
	}

	@Test
	public void testAssertArrayEquals() {
		//Vérifie si les deux tableaux de bytes sont les mêmes
		byte[] expected = "cyril".getBytes();
		byte[] actual = "cyril".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		//Vérifie si les deux chaine de caractère sont égaux
		assertEquals("failure - strings are not equal", "calculatrice", "calculatrice");
	}

	@Test
	public void testAssertFalse() {
		//Vérifie si le retour est bien faux
		assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		//Vérifie si la valeur n'est pas null
		int a = 3;
		assertNotNull("should not be null", a);
	}

	@Test
	public void testAssertNotSame() {
		//Vérifie si ce n'est pas les mêmes objets
		int a = 0;
		int b = 2;
		assertNotSame("should not be same Object", a, b);
	}

	@Test
	public void testAssertNull() {
		//Vérifie si la valeur a est null
		String a = null;
		assertNull("should be null", a);
	}

	@Test
	public void testAssertSame() {
		//vérifie si la valeur est la même
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	@Ignore("Test is ignored as a demonstration")
	//On ignore le test
	@Test
	public void testAssertTrue() {
		//Vérifie si c'est vrai
		assertTrue("failure - should be true", true);
	}

}
