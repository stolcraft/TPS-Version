package fr.ensup.avenger.service;

import java.util.Collection;

import fr.ensup.avenger.exception.ServiceException;
import fr.ensup.avengers.domaine.Avenger;

public interface IAvengersService {

	void ajouterAvenger(Avenger avenger1, Avenger avenger2)throws ServiceException;

	void supprimerAvenger(Avenger avenger);

	void modifierAvenger(Avenger avenger);

	Collection<Avenger> recupererTousAvengers();

}