package fr.ensup.gestionecole.service;

import java.util.ArrayList;
import java.util.Collection;

import fr.ensup.gestionecole.dao.GestionEcoleDao;
import fr.ensup.gestionecole.dao.IGestionEcole;
import fr.ensup.gestionecole.domaine.Etudiant;

public class GestionEcoleService implements IGestionEcole {

	Collection<Etudiant> maListeEtudiant = new ArrayList<Etudiant>();
	GestionEcoleDao gestionecoledao = new GestionEcoleDao();
	Etudiant etudiantFinal;
	
	
	
	public boolean ajouterEtudiant(Etudiant etudiant)
	{
		gestionecoledao.ajouterEtudiant(etudiant);
		return true;
		
	}
	
	public Etudiant lire(String etudiant)
	{
		etudiantFinal = gestionecoledao.lire(etudiant);
		return etudiantFinal;
	}
	
	public void modifierEtudiant (Etudiant etudiant)
	{
		gestionecoledao.modifierEtudiant(etudiant);
	}
	public void supprimerEtudiant (String etudiant)
	{
		gestionecoledao.supprimerEtudiant(etudiant);
	}
	
	public Collection<Etudiant> lister (String ecole)
	{
		maListeEtudiant = gestionecoledao.lister(ecole);
		return maListeEtudiant;
	}
}
