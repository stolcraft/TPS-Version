package fr.ensup.avenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.ensup.avengers.domaine.Avenger;

public class DaoSupprimerAvenger {

	public void deleteAvenger(Avenger avenger) {
		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/avenger";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "DELETE FROM `membre` WHERE nom = '" + avenger.name + "'";
			System.out.println("Ligne supprime");

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

}
