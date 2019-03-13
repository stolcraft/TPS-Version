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


}
