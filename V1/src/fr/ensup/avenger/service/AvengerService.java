package fr.ensup.avenger.service;

import java.util.ArrayList;
import java.util.Collection;
import fr.ensup.avenger.dao.DaoAjouteAvenger;
import fr.ensup.avenger.dao.DaoGetAvengers;
import fr.ensup.avenger.dao.DaoModifierAvenger;
import fr.ensup.avenger.dao.DaoSupprimerAvenger;
import fr.ensup.avengers.domaine.Avenger;

public class AvengerService {
	DaoAjouteAvenger ajouterAvenger = new DaoAjouteAvenger();
	DaoSupprimerAvenger supprimerAvenger = new DaoSupprimerAvenger();
	DaoModifierAvenger modifierAvenger = new DaoModifierAvenger();
	DaoGetAvengers afficherAvenger = new DaoGetAvengers();
	
	public void ajouteAvenger(Avenger avenger) {
		ajouterAvenger.createAvenger(avenger);
	}


	
	public void supprimerAvenger(Avenger avenger) {
		supprimerAvenger.deleteAvenger(avenger);
	}
	
	
	public void modifierAvenger(Avenger avenger) {
		modifierAvenger.updateAvenger(avenger);
	}
	
	public Collection<Avenger> recupererTousAvengers() {
		Collection<Avenger> maListeAvengers = null;
		maListeAvengers = new ArrayList<Avenger>();
		maListeAvengers = afficherAvenger.GetAvengers();
		System.out.println(maListeAvengers);
		return maListeAvengers;
	}
}
