package fr.ensup.testUnitaireDao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ensup.testUnitaireDao.domaine.Etudiant;

public class DaoEtudiant {

	public Etudiant readgetById(int i) {

		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/daotest";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		Etudiant etu = new Etudiant();

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM etudiant WHERE ID = '" + i + "' ";

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

			while (rs.next()) {

				etu.ID = rs.getInt("ID");
				etu.nom = rs.getString("nom");
				etu.prenom = rs.getString("prenom");
				etu.email = rs.getString("email");

			}
			return etu;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return etu;
	}

	public Boolean update(int i, String nom) {
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/daotest";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		Boolean resultat = false;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = " UPDATE `etudiant` SET nom = '" + nom + "' WHERE ID = '" + i + "' ";

			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

			resultat = true;

		} catch (SQLException e) {
			e.printStackTrace();
			resultat = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			resultat = false;
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultat;
	}

	public Boolean creation(int i, String nom, String prenom, String email) {
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/daotest";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		Boolean resultat = false;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "INSERT INTO `etudiant` (`ID`,`nom`,`prenom`,`email`) VALUES ('" + i + "','" + nom + "','"
					+ prenom + "','" + email + "')";

			st.executeUpdate(sql);

			resultat = true;

		} catch (SQLException e) {
			e.printStackTrace();
			resultat = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			resultat = false;
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultat;
	}

	public int getAll() {
		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/daotest";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;

		int total = 0;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT id FROM etudiant ";

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);

			// Si r�cup donn�es alors �tapes 
			while (rs.next()) {
				total += 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return total;
	}

}
