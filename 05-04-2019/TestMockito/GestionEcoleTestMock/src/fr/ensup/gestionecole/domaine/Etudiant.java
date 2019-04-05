package fr.ensup.gestionecole.domaine;

import java.util.Date;

public class Etudiant {

	public String nom;
	public String prenom;
	public String mail;
	public String adresse;
	public int tel;
	public String dateNaissance;
	public String ecole;
	public Etudiant( String nom, String prenom, String mail, String adresse, int tel, String dateNaissance,
			String ecole) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.ecole = ecole;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", adresse=" + adresse
				+ ", tel=" + tel + ", dateNaissance=" + dateNaissance + ", ecole=" + ecole + "]";
	}
	
}
