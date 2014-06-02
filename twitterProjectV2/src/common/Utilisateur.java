package common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class Utilisateur du package common
 * @author delphinh
 *
 */
@XmlRootElement(name="Utilisateur")
public class Utilisateur extends UnicastRemoteObject{
	
	// D�claration des attributs priv�s de classe
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom, prenom, mail, login, mdp;
	private ArrayList<Tweet> listeTweets;
	
	/**
	 * Constucteur de la classe (vide)
	 */
	public Utilisateur() throws RemoteException{}
	
	/**
	 * Constructeur de la classe
	 * @param pNom Nom utilisateur
	 * @param pPrenom Prenom utilisateur
	 * @param pMail Mail utilisateur
	 * @param pLogin Login utilisateur
	 * @param pMdp Mot de pass utilisateur
	 */
	public Utilisateur(int pId, String pNom, String pPrenom, String pMail, String pLogin, String pMdp) throws RemoteException{
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
	
	/**
	 * Ajout d'un tweet à la liste de tweets postés par l'utilisateur
	 * @param tweet
	 */
	public void ajoutTweet(Tweet tweet) {
		this.listeTweets.add(tweet);
	}
	
	/**
	 * Suppression d'un tweet à la liste de tweets postés par l'utilisateur
	 * @param tweet
	 */
	public void suppTweet(Tweet tweet){
		this.listeTweets.add(tweet);
	}

}
