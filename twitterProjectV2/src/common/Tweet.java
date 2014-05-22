package common;

import java.text.DateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Class Utilisateur du package common
 * @author poitevia
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Tweet {
	
	//Permet de faire le lien entre un utilisateur et ses Tweets
	private int idUtilisateur;

	//Date de cr�ation du Tweet
	private String date;
	//Permet de modifier le format de la date pour obtenir : jj/mm/aa hh:mm
	DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

	//Contenu associ� � un Tweet
	private String contenu;
	
	/**
	 * Constructeur vide obligatoire pour la s�rialisation XML
	 */
	Tweet(){}
	
	/**
	 * Constructeur de la classe
	 * @param contenuTweet Contenu associ� au Tweet
	 */
	Tweet(int idUtilisateur, String contenuTweet) {
		this.idUtilisateur = idUtilisateur;
		this.date = shortDateFormat.format(new Date());
		this.contenu = contenuTweet;
	}

	//Accesseurs et modificateurs
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
