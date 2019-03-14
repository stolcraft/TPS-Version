package fr.ensup.projetTDD.service;

import java.io.Closeable;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//permet de lancer des méthodes avant ou après selon un ordre
/*
@BeforeClass setUpClass  ==> ce fait une seule fois au début de la classe
@Before setUp  ==> ce fait avant chaque test
@Test test2()
@After tearDownd
@Before setUp ==> ce fait après chaque test
@Test test1()
@After tearDown
@AfterClass tearDownClass ==> ce fait une seule fois à la fin de la classe
*/

public class Fixture {

	static class ExpensiveManagedResource implements Closeable {
	    public void close() throws IOException {}
	  }

	  static class ManagedResource implements Closeable {
	    public void close() throws IOException {}
	  }

	  @BeforeClass
	  public static void setUpClass() {
	    System.out.println("@BeforeClass setUpClass");
	    myExpensiveManagedResource = new ExpensiveManagedResource();
	  }

	  @AfterClass
	  public static void tearDownClass() throws IOException {
	    System.out.println("@AfterClass tearDownClass");
	    myExpensiveManagedResource.close();
	    myExpensiveManagedResource = null;
	  }

	  private ManagedResource myManagedResource;
	  private static ExpensiveManagedResource myExpensiveManagedResource;

	  private void println(String string) {
	    System.out.println(string);
	  }

	  @Before
	  public void setUp() {
	    this.println("@Before setUp");
	    this.myManagedResource = new ManagedResource();
	  }

	  @After
	  public void tearDown() throws IOException {
	    this.println("@After tearDown");
	    this.myManagedResource.close();
	    this.myManagedResource = null;
	  }

	  @Test
	  public void test1() {
	    this.println("@Test test1()");
	  }

	  @Test
	  public void test2() {
	    this.println("@Test test2()");
	  }

}
