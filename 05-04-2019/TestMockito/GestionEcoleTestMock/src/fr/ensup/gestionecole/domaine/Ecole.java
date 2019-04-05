package fr.ensup.gestionecole.domaine;

public class Ecole {
	private String nom;
	private String mail;
	private String adresse;
	private int tel;
	private String directeur;
	public Ecole(String nom, String mail, String adresse, int tel, String directeur) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.adresse = adresse;
		this.tel = tel;
		this.directeur = directeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getDirecteur() {
		return directeur;
	}
	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}
	@Override
	public String toString() {
		return "Ecole [nom=" + nom + ", mail=" + mail + ", adresse=" + adresse + ", tel=" + tel + ", directeur="
				+ directeur + "]";
	}
	
	
}
