package fr.ensup.avenger.service;

import java.util.ArrayList;
import java.util.Collection;
import fr.ensup.avenger.dao.DaoAjouteAvenger;
import fr.ensup.avenger.dao.DaoGetAvengers;
import fr.ensup.avenger.dao.DaoModifierAvenger;
import fr.ensup.avenger.dao.DaoSupprimerAvenger;
import fr.ensup.avenger.exception.DaoException;
import fr.ensup.avenger.exception.ServiceException;
import fr.ensup.avengers.domaine.Avenger;

public class AvengerService {
	DaoAjouteAvenger ajouterAvenger = new DaoAjouteAvenger();
	DaoSupprimerAvenger supprimerAvenger = new DaoSupprimerAvenger();
	DaoModifierAvenger modifierAvenger = new DaoModifierAvenger();
	DaoGetAvengers afficherAvenger = new DaoGetAvengers();

	public void ajouteAvenger(Avenger avenger1, Avenger avenger2) throws ServiceException {

		if (avenger1.getName() != avenger2.getName()) {
			try {
				ajouterAvenger.createAvenger(avenger1);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			new ServiceException();

		}

	}

	public void supprimerAvenger(Avenger avenger) {
		try {
			supprimerAvenger.deleteAvenger(avenger);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modifierAvenger(Avenger avenger) {
		try {
			modifierAvenger.updateAvenger(avenger);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Collection<Avenger> recupererTousAvengers() {
		Collection<Avenger> maListeAvengers = null;
		maListeAvengers = new ArrayList<Avenger>();
		try {
			maListeAvengers = afficherAvenger.GetAvengers();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(maListeAvengers);
		return maListeAvengers;
	}
}
