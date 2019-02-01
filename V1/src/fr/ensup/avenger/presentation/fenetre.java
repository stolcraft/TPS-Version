package fr.ensup.avenger.presentation;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import fr.ensup.avenger.service.AvengerService;
import fr.ensup.avengers.domaine.Avenger;

public class fenetre extends JComponent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<Avenger> maListeAvengers = new ArrayList<Avenger>();
		Collection<Avenger> maListeAvengers2 = new ArrayList<Avenger>();
		Avenger avenger = new Avenger(1,"black windows","windows","il marche");
		Avenger avenger2 = new Avenger(20,"black windows","mac","il crash");
		
		AvengerService avengerservice = new AvengerService();
		avengerservice.ajouteAvenger(avenger);
		avengerservice.modifierAvenger(avenger2);
		avengerservice.supprimerAvenger(avenger);
		maListeAvengers2 = avengerservice.recupererTousAvengers();
		
		Avenger av1 = new Avenger (10, "Hulk","vert","fort");
		Avenger av2 = new Avenger (20, "Spider-man","seré","vole");
		Avenger av3 = new Avenger (18, "Iron-man","fer","vole");
		
		maListeAvengers.add(av1);
		maListeAvengers.add(av2);
		maListeAvengers.add(av3);
		
		
	
	}

}
