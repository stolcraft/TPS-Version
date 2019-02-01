package fr.ensup.avenger.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import fr.ensup.avenger.exception.DaoException;
import fr.ensup.avengers.domaine.Avenger;

public class DaoGetAvengers {

	public Collection<Avenger> GetAvengers() throws DaoException{
		// Information d'acc�s � la base de donn�es
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

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM membre";

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

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
			new DaoException();
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

		return maListeAvengers;
	}

}
