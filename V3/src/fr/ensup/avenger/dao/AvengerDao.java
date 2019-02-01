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

public class AvengerDao implements IAvengerDao {

	@Override
	public void createAvenger(Avenger avenger)throws DaoException{
		
		// Information d'acc�s � la base de donn�es
				String url = "jdbc:mysql://localhost/avenger";
				String login = "root";
				String passwd = "";
				Connection cn = null;
				Statement st = null;

				try {

					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");

					// Etape 2 : r�cup�ration de la connexion
					cn = DriverManager.getConnection(url, login, passwd);

					// Etape 3 : Cr�ation d'un statement
					st = cn.createStatement();

					String sql = "INSERT INTO `membre` (`age`,`nom`,`costume`,`pouvoir`) VALUES ('" + avenger.age + "','" + avenger.name + "','" + avenger.costume + "','" + avenger.pouvoir + "')";

					// Etape 4 : ex�cution requ�te
					st.executeUpdate(sql);

					// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					
					
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
					new DaoException();
				} finally {
					try {
						// Etape 6 : lib�rer ressources de la m�moire.
						cn.close();
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	
	}

	@Override
	public void updateAvenger(Avenger avenger) throws DaoException{

		// Information d'acc�s � la base de donn�es
		String url = "jdbc:mysql://localhost/avenger";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {

			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");

			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = " UPDATE `membre` SET age = '" + avenger.age + "' , costume = '" + avenger.costume + "' , pouvoir = '" + avenger.pouvoir + "' WHERE nom = '" + avenger.name + "' ";
			System.out.println("Ligne update");
			
			// Etape 4 : ex�cution requ�te
			st.executeUpdate(sql);

			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

		} catch (SQLException e) {
			new DaoException();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
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

		
	}

	@Override
	public void deleteAvenger(Avenger avenger)throws DaoException {
		// Information d'acc�s � la base de donn�es
				String url = "jdbc:mysql://localhost/avenger";
				String login = "root";
				String passwd = "";
				Connection cn = null;
				Statement st = null;

				try {

					// Etape 1 : Chargement du driver
					Class.forName("com.mysql.jdbc.Driver");

					// Etape 2 : r�cup�ration de la connexion
					cn = DriverManager.getConnection(url, login, passwd);

					// Etape 3 : Cr�ation d'un statement
					st = cn.createStatement();

					String sql = "DELETE FROM `membre` WHERE nom = '" + avenger.name + "'";
					System.out.println("Ligne supprime");
					
					// Etape 4 : ex�cution requ�te
					st.executeUpdate(sql);

					// Si r�cup donn�es alors �tapes 5 (parcours Resultset)

				} catch (SQLException e) {
					new DaoException();
				} catch (ClassNotFoundException e) {
					// TODO: handle exception
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


	}

	

	@Override
	public Collection<Avenger> GetAvengers()throws DaoException {
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
				
				Avenger avenger2 = new Avenger(age,name,costume,pouvoir);
				maListeAvengers.add(avenger2);
				System.out.println("Nous avons lavengers: " + name + " qui est age de: "+ age+ " avec un costume de "+ costume + " un pouvoir de : " + pouvoir);

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
