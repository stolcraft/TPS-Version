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
		int resultat = Calc.addition(2, 3);
		assertEquals(resultat, 5);
	}

	@Test
	public void testSoustraction() {
		int resultat = Calc.soustraction(3, 2);
		assertEquals(resultat, 1);
	}

	@Test
	public void testAssertArrayEquals() {
		byte[] expected = "cyril".getBytes();
		byte[] actual = "cyril".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	public void testAssertEquals() {
		assertEquals("failure - strings are not equal", "calculatrice", "calculatrice");
	}

	@Test
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}

	@Test
	public void testAssertNotNull() {
		int a = 3;
		assertNotNull("should not be null", a);
	}

	@Test
	public void testAssertNotSame() {
		int a = 0;
		int b = 2;
		assertNotSame("should not be same Object", a, b);
	}

	@Test
	public void testAssertNull() {
		String a = null;
		assertNull("should be null", a);
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	@Ignore("Test is ignored as a demonstration")
	@Test
	public void testAssertTrue() {
		assertTrue("failure - should be true", true);
	}

}
