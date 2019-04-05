package fr.ensup.gestionecole.dao;

import java.util.Collection;

import fr.ensup.gestionecole.domaine.Etudiant;

public interface IGestionEcole {
	public boolean ajouterEtudiant(Etudiant etudiant);
	public Etudiant lire(String etudiant);
	public void modifierEtudiant (Etudiant etudiant);
	public void supprimerEtudiant (String etudiant);
	public Collection<Etudiant> lister (String ecole);
}
