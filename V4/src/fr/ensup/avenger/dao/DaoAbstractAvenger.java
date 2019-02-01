package fr.ensup.avenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DaoAbstractAvenger implements IAvengerDao {

	protected Connection cn;
	protected Statement st;

	// TODO Connexion à la BD

	protected Connection seConnecter() {

		//

		// System.out.println("Connexion en cours...");

		String url = "jdbc:mysql://localhost/avenger";
		String login = "root";
		String passwd = "";

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			// System.out.println("Connecté.");
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("hello");
			e.printStackTrace();
		}

		return cn;
	}

	// TODO Déconnexion à la BD

	protected void seDeconnecter() {
		try {
			cn.close();
			st.close();
			// System.out.println("Déconnecté. \nBye ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
