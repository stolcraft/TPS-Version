package fr.ensup.avenger.dao;

import java.util.Collection;

import fr.ensup.avenger.exception.DaoException;
import fr.ensup.avengers.domaine.Avenger;

public interface IAvengerDao {
	public void createAvenger (Avenger avenger) throws DaoException;
	public void updateAvenger(Avenger avenger) throws DaoException;
	public void deleteAvenger(Avenger avenger)throws DaoException;
	public Collection<Avenger> GetAvengers() throws DaoException;
}
