package fr.ensup.avenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AfficherAvengersDao {
	
	public static void lireEnBase() {

		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/bijouterie";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int age;
		String name;
		String costume;
		String pouvoir;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM Article";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {
				
				age = rs.getInt("age");
				name = rs.getString("name");
				costume = rs.getString("costume");
				pouvoir = rs.getString("pouvoir");
				
				System.out.println("Nous avons lavengers: " + name + " qui est age de: "+ age);

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
	}
}
