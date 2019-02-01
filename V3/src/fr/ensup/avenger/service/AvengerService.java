package fr.ensup.avenger.service;

import java.util.ArrayList;
import java.util.Collection;

import fr.ensup.avenger.dao.AfficherAvengersDao;
import fr.ensup.avenger.dao.AvengerDao;
import fr.ensup.avenger.exception.DaoException;
import fr.ensup.avenger.exception.ServiceException;
import fr.ensup.avengers.domaine.Avenger;


public class AvengerService implements IAvengersService {
	
	AvengerDao avengdao = new AvengerDao();
	
	/* (non-Javadoc)
	 * @see fr.ensup.avenger.service.IAvengersService#AjouterAvenger(fr.ensup.avengers.domaine.Avenger)
	 */
	@Override
	public void ajouterAvenger(Avenger avenger1, Avenger avenger2)throws ServiceException{
		
		if (avenger1.getName() != avenger2.getName()) {
			try {
				avengdao.createAvenger(avenger1);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			new ServiceException();

		}
	}


	
	/* (non-Javadoc)
	 * @see fr.ensup.avenger.service.IAvengersService#supprimerAvenger(fr.ensup.avengers.domaine.Avenger)
	 */
	@Override
	public void supprimerAvenger(Avenger avenger) {
		
		try {
			avengdao.deleteAvenger(avenger);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.ensup.avenger.service.IAvengersService#modifierAvenger(fr.ensup.avengers.domaine.Avenger)
	 */
	@Override
	public void modifierAvenger(Avenger avenger) {
		
		try {
			avengdao.updateAvenger(avenger);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.ensup.avenger.service.IAvengersService#recupererTousAvengers()
	 */
	@Override
	public Collection<Avenger> recupererTousAvengers() {
		
		Collection<Avenger> maListeAvengers = null;
		maListeAvengers = new ArrayList<Avenger>();
		try {
			maListeAvengers = avengdao.GetAvengers();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(maListeAvengers);
		return maListeAvengers;
	}
}
