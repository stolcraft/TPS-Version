package fr.ensup.avenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.ensup.avengers.domaine.Avenger;

public class DaoGetAvengers {

	public Collection<Avenger> GetAvengers() {
		// Information d'accès à la base de données
		String url = "jdbc:mysql://localhost/avenger";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int age;
		String name;
		String costume;
		String pouvoir;
		Collection<Avenger> maListeAvengers = null;
		maListeAvengers = new ArrayList<Avenger>();

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Création d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM membre";

			// Etape 4 : exécution requête
			rs = st.executeQuery(sql);

			// Si récup données alors étapes 5 (parcours Resultset)

			while (rs.next()) {

				age = rs.getInt("age");
				name = rs.getString("nom");
				costume = rs.getString("costume");
				pouvoir = rs.getString("pouvoir");

				Avenger avenger2 = new Avenger(age, name, costume, pouvoir);
				maListeAvengers.add(avenger2);
				System.out.println("Nous avons lavengers: " + name + " qui est age de: " + age + " avec un costume de "
						+ costume + " un pouvoir de : " + pouvoir);

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

		return maListeAvengers;
	}

}
