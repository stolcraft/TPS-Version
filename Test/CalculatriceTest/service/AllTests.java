package fr.ensup.projetTDD.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ test1.class, TestMatchers.class, FibonacciTest.class })
public class AllTests {

}
