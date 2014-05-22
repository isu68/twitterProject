package common;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class Utilisateur du package common
 * @author delphinh
 *
 */
@XmlRootElement(name="Utilisateur")
public class Utilisateur{
	
	// Déclaration des attributs privés de classe
	private int id;
	private String nom, prenom, mail, login, mdp;
	
	/**
	 * Constucteur de la classe (vide)
	 */
	public Utilisateur(){}
	
	/**
	 * Constructeur de la classe
	 * @param pNom Nom utilisateur
	 * @param pPrenom Prenom utilisateur
	 * @param pMail Mail utilisateur
	 * @param pLogin Login utilisateur
	 * @param pMdp Mot de pass utilisateur
	 */
	public Utilisateur(String pNom, String pPrenom, String pMail, String pLogin, String pMdp) {
		setNom(pNom);
		setPrenom(pPrenom);
		setMail(pMail);
		setLogin(pLogin);
		setMdp(pMdp);
	}

	// Accesseurs et modificateurs
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
