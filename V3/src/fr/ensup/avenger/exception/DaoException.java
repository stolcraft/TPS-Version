package fr.ensup.avenger.exception;

import java.sql.SQLException;

public class DaoException extends Exception {
	
	//public SQLException except = new SQLException();
	
	public DaoException() {
		System.out.println("Problème venant du DAO : \nVerifier l'écriture des champs");
	}
	

}
