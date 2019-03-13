package fr.ensup.projetTDD.service;

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
import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMatchers {

	// JUnit Matchers assertThat
		  @Test (timeout=1000)
		  //On met un timeout de 1000
		  public void testAssertThatBothContainsString() {
			  //V�rifie si l'albumen contient la valeur a et e
		    assertThat("albumen", both(containsString("a")).and(containsString("e")));
		  }
		  
		  @Test
		  public void testAssertThatHasItems() {
			  //V�rifie si l'array contient bien les valeurs "one" et "two"
		    assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "two"));
		  }

		  @Test
		  public void testAssertThatEveryItemContainsString() {
			  //V�rifie si e est bien contenu dans tous les mots
		    assertThat(Arrays.asList(new String[] { "fune", "bane", "net" }), everyItem(containsString("e")));
		  }
		
		  // Core Hamcrest Matchers with assertThat
		  @Test
		  public void testAssertThatHamcrestCoreMatchers() {
			  //V�rifie si good correspond au deux autre mot
		    assertThat("good", allOf(equalTo("good"), startsWith("good")));
		    //V�rifie si c'est pas �gal � bad et �gal � good
		    assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		    //V�rifie si au moins l'un des deux est �gal � good
		    assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		    //V�rifie si aucun des deux n'est �gal � 7
		    assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
		    //V�rifie si ce n'est pas les m�mes objets
		    assertThat(new Object(), not(sameInstance(new Object())));
		  }

}
