package fr.ensup.testUnitaireDao.daoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import fr.ensup.testUnitaireDao.dao.DaoEtudiant;
import fr.ensup.testUnitaireDao.domaine.Etudiant;

public class DaoTest {

	DaoEtudiant daoetudiant = new DaoEtudiant();
	
	@Test
	public void scenarioLecture() {
		Etudiant resultatEtu = daoetudiant.readgetById(1);
		assertEquals("failure - strings are not equal", resultatEtu.nom , "gerard");
	}
	
	@Test
	public void scenarioMofication() {
		Boolean resultat = daoetudiant.update(1 , "gerard");
		assertTrue("failure - should be true", resultat);
	}
	
	@Ignore
	@Test
	public void scenarioCreation() {
		Boolean resultat = daoetudiant.creation(4, "jacky","jean", "pierre.kungfun@hotmail.fr");
		assertTrue("failure - should be true", resultat);
	}
	
	
	@Test
	public void lectureToutEtudiant() {
		int TotalLigne = 0;
		TotalLigne = daoetudiant.getAll();
		assertEquals(TotalLigne, 3);
		
	}


}
