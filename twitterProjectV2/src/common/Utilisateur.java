package common;

import java.util.ArrayList;
import java.util.Random;

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
	private ArrayList<Tweet> listeTweets;
	
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
	public Utilisateur(int pId, String pNom, String pPrenom, String pMail, String pLogin, String pMdp) {
		setId(pId);
		setNom(pNom);
		setPrenom(pPrenom);
		setMail(pMail);
		setLogin(pLogin);
		setMdp(pMdp);
		setListeTweets(new ArrayList<Tweet>());
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Tweet> getListeTweets() {
		return listeTweets;
	}
	public void setListeTweets(ArrayList<Tweet> listeTweets) {
		this.listeTweets = listeTweets;
	}

}
