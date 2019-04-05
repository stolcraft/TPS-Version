package fr.ensup.gestionecole.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.ensup.gestionecole.domaine.Etudiant;
import fr.ensup.gestionecole.service.GestionEcoleService;

public class TestMockDao {

	//On cr�e un mock de la classe DAO
	@Mock
	private GestionEcoleDao daoMock ;
	
	//On inject les mocks cr��s dans la classe Service
	@InjectMocks
	private GestionEcoleService service;
	
	//On initialise les mocks
	@Before
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	
	//On utilise la m�thodes ajouterEtudiant du Mock de la DAO en lui
	//On impose un comportement : (ici on l'oblige � retourner true )
	//On compare true et le r�sultat de la m�thode mocker
	@Test
	public void TestajouterEtudiant () {
		
		Etudiant etudiant = new Etudiant("jacky","chan", "jj", "d", 0, "j", "h" );
		when(daoMock.ajouterEtudiant(etudiant)).thenReturn(true);
		
		assertEquals(true, service.ajouterEtudiant(etudiant));
	}
	
	//On utilise la m�thodes lire du Mock de la DAO en lui
	//On impose un comportement : (ici on l'oblige � retourner un �tudiant )
	//On compare le nom et le nom de la m�thode mocker
	@Test
	public void TestlireEtudiant () {
		
		String nom = "jacky";
		Etudiant etu = new Etudiant("jacky", "j", "g", "g", 0, "h", "h");
		when(daoMock.lire(nom)).thenReturn(etu);
		
		assertEquals(nom, service.lire(nom).nom);
	}
}

