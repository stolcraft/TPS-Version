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

public class AvengerDao extends DaoAbstractAvenger {

	@Override
	public void createAvenger(Avenger avenger) throws DaoException {

		seConnecter();
		try {

			String sql = "INSERT INTO `membre` (`age`,`nom`,`costume`,`pouvoir`) VALUES ('" + avenger.age + "','"
					+ avenger.name + "','" + avenger.costume + "','" + avenger.pouvoir + "')";

			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			new DaoException();
		}

		seDeconnecter();

	}

	@Override
	public void updateAvenger(Avenger avenger) throws DaoException {

		seConnecter();
		try {

			String sql = " UPDATE `membre` SET age = '" + avenger.age + "' , costume = '" + avenger.costume
					+ "' , pouvoir = '" + avenger.pouvoir + "' WHERE nom = '" + avenger.name + "' ";
			System.out.println("Ligne update");

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			new DaoException();
		}

		seDeconnecter();

	}

	@Override
	public void deleteAvenger(Avenger avenger) throws DaoException {

		seConnecter();
		try {

			String sql = "DELETE FROM `membre` WHERE nom = '" + avenger.name + "'";
			System.out.println("Ligne supprime");

			// Etape 4 : exécution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO: handle exception
			new DaoException();
		}

		seDeconnecter();

	}

	@Override
	public Collection<Avenger> GetAvengers() throws DaoException {
		ResultSet rs = null;
		int age;
		String name;
		String costume;
		String pouvoir;
		Collection<Avenger> maListeAvengers = null;
		maListeAvengers = new ArrayList<Avenger>();

		seConnecter();
		try {

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
			// TODO: handle exception
			new DaoException();
		}

		seDeconnecter();
		return maListeAvengers;

	}
}
