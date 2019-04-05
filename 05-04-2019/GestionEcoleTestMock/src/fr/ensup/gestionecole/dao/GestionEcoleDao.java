package fr.ensup.gestionecole.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.ensup.gestionecole.domaine.Etudiant;

public class GestionEcoleDao implements IGestionEcole {

	// Information d'accès à la base de données
	String url = "jdbc:mysql://localhost/ensup";
	String login = "root";
	String passwd = "";
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	String nom;
	String prenom;
	String mail;
	String adresse;
	int tel;
	String dateNaissance;
	String ecole;
	Etudiant LireEtudiant;
	Collection<Etudiant> maListeEtudiant = new ArrayList<Etudiant>();

	@Override
	public boolean ajouterEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "INSERT INTO `etudiant` (`nom`,`prenom`,`mail`,`adresse`,`tel`,`dateNaissance`,`ecole`) VALUES ('"
					+ etudiant.nom + "','" + etudiant.prenom + "','" + etudiant.mail + "','" + etudiant.adresse + "','"
					+ etudiant.tel + "','" + etudiant.dateNaissance + "','" + etudiant.ecole + "')";

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			// Si récup données alors étapes 5 (parcours Resultset)
			System.out.println("Etudiant bien inscrit");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;

	}

	@Override
	public Etudiant lire(String etudiant) {
		// TODO Auto-generated method stub
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM etudiant where Nom = '" + etudiant + "'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
			nom = rs.getString("Nom");
			prenom = rs.getString("Prenom");
			mail = rs.getString("Mail");
			adresse = rs.getString("Adresse");
			tel = rs.getInt("Tel");
			dateNaissance = rs.getString("DateNaissance");
			ecole = rs.getString("Ecole");
			
			}
			LireEtudiant = new Etudiant(nom, prenom, mail, adresse, tel, dateNaissance, ecole);
	

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return LireEtudiant;
	}

	@Override
	public void modifierEtudiant(Etudiant etudiant) {
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = " UPDATE `etudiant` SET prenom = '" + etudiant.prenom + "' , mail = '" + etudiant.mail + "' , adresse = '" + etudiant.adresse + "', tel = '" + etudiant.tel + "', dateNaissance = '" + etudiant.dateNaissance + "' , ecole = '" + etudiant.ecole + "'WHERE nom = '" + etudiant.nom + "' ";
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			// Si récup données alors étapes 5 (parcours Resultset)
			System.out.println("Etudiant bien modifier");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void supprimerEtudiant(String etudiant) {
		// TODO Auto-generated method stub
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "DELETE FROM `etudiant` WHERE nom = '" + etudiant + "'";
			System.out.println("Etudiant supprime");
			
			// Etape 4 : exécution requête
			st.executeUpdate(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Collection<Etudiant> lister(String ecole) {
		// TODO Auto-generated method stub
		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM etudiant where Ecole = '" + ecole + "'";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
			nom = rs.getString("Nom");
			prenom = rs.getString("Prenom");
			mail = rs.getString("Mail");
			adresse = rs.getString("Adresse");
			tel = rs.getInt("Tel");
			dateNaissance = rs.getString("DateNaissance");
			ecole = rs.getString("Ecole");
			
			LireEtudiant = new Etudiant(nom, prenom, mail, adresse, tel, dateNaissance, ecole);
			maListeEtudiant.add(LireEtudiant);
			
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : libérer ressources de la mémoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return maListeEtudiant;
	}

}
