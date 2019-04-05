/**
 * @author kevin guillard
 * @version 2.1.3
 * @category Gestion
 *
 */

package fr.ensup.gestionecole.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import fr.ensup.gestionecole.domaine.Etudiant;
import fr.ensup.gestionecole.service.GestionEcoleService;

public class LanceurGestionEcole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String droit = "visiteur";
		String login;
		String mdp;
		int index = 0;
		int choix = 1;
		int id;
		String nom;
		String prenom;
		String mail;
		String adresse;
		int tel;
		String dateNaissance;
		String ecole;
		Etudiant etudiant;
		Etudiant etudiantFinal;
		GestionEcoleService ges = new GestionEcoleService();
		Collection<Etudiant> maListeEtudiant = new ArrayList<Etudiant>();

		
		while (index < 3) {

			System.out.println("----------------------");
			System.out.println("1- Ajouter Etudiant");
			System.out.println("2- Voir un Etudiant");
			System.out.println("3- Modifier un Etudiant");
			System.out.println("4- Supprimer un Etudiant");
			System.out.println("5- Lister les Etudiant");
			System.out.println("6- Quitter");
			System.out.println("----------------------");

			System.out.println("Tapez votre choix");
			Scanner sChoix = new Scanner(System.in);
			choix = sChoix.nextInt();

			// TODO 1) Lance la methode voirArticle pour afficher l'ensemble des articles
			if (choix == 1) {

				System.out.println("Entrez le nom");
				Scanner scannerNom = new Scanner(System.in);
				nom = scannerNom.next();

				System.out.println("Entrez le prenom");
				Scanner scannerPrenom = new Scanner(System.in);
				prenom = scannerPrenom.next();

				System.out.println("Entrez le mail");
				Scanner scannerMail = new Scanner(System.in);
				mail = scannerMail.next();

				System.out.println("Entrez l'adresse");
				Scanner scannerAdresse = new Scanner(System.in);
				adresse = scannerAdresse.next();

				System.out.println("Entrez le tel");
				Scanner scannerTel = new Scanner(System.in);
				tel = scannerTel.nextInt();

				System.out.println("Entrez la date de naissance");
				Scanner scannerNaissance = new Scanner(System.in);
				dateNaissance = scannerNaissance.next();

				System.out.println("Entrez l'ecole");
				Scanner scannerEcole = new Scanner(System.in);
				ecole = scannerEcole.next();

				etudiant = new Etudiant(nom, prenom, mail, adresse, tel, dateNaissance, ecole);
				ges.ajouterEtudiant(etudiant);
			}

			// TODO 2) Lance la methode insereArticle pour insérer un article dans la BDD
			if (choix == 2) {

				System.out.println("Entrez le nom de l'étudiant");
				Scanner scannerNom = new Scanner(System.in);
				nom = scannerNom.next();
				etudiantFinal = ges.lire(nom);
				System.out.println(etudiantFinal);
			}

			// TODO 3) Lance la methode acheterArticle pour faire une facture au client
			if (choix == 3) {
				System.out.println("Entrez le nom de l'etudiant que vous voulez modifer");
				Scanner scannerNom = new Scanner(System.in);
				nom = scannerNom.next();

				System.out.println("Entrez le prenom");
				Scanner scannerPrenom = new Scanner(System.in);
				prenom = scannerPrenom.next();

				System.out.println("Entrez le mail");
				Scanner scannerMail = new Scanner(System.in);
				mail = scannerMail.next();

				System.out.println("Entrez l'adresse");
				Scanner scannerAdresse = new Scanner(System.in);
				adresse = scannerAdresse.next();

				System.out.println("Entrez le tel");
				Scanner scannerTel = new Scanner(System.in);
				tel = scannerTel.nextInt();

				System.out.println("Entrez la date de naissance");
				Scanner scannerNaissance = new Scanner(System.in);
				dateNaissance = scannerNaissance.next();

				System.out.println("Entrez l'ecole");
				Scanner scannerEcole = new Scanner(System.in);
				ecole = scannerEcole.next();

				etudiant = new Etudiant(nom, prenom, mail, adresse, tel, dateNaissance, ecole);
				ges.modifierEtudiant(etudiant);
			}
			if (choix == 4) {

				System.out.println("Entrez le nom de l'étudiant a supprimer");
				Scanner scannerNom = new Scanner(System.in);
				nom = scannerNom.next();
				ges.supprimerEtudiant(nom);
			
				
			}
			if (choix == 5) {
				System.out.println("Entrez le nom de l'ecole");
				Scanner scannerEcole = new Scanner(System.in);
				ecole = scannerEcole.next();
				
				maListeEtudiant = ges.lister(ecole);
				System.out.println(maListeEtudiant );
			}
			if (choix == 6) {
				System.out.println("Au revoir et revenez vite !");
				index = 4;
			}
		}
	}
}
