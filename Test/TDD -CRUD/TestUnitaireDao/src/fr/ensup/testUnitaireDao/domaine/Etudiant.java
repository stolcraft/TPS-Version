package fr.ensup.testUnitaireDao.domaine;

public class Etudiant {
	public int ID;
	public String nom;
	public String prenom;
	public String email;
	
	
	public Etudiant(int i, String string, String string2, String string3) {
		super();
		ID = ID;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Etudiant [ID=" + ID + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
	
}

