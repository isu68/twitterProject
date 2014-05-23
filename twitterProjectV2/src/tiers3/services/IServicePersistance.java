package tiers3.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.bind.JAXBException;

import common.Tweet;
import common.Utilisateur;

public interface IServicePersistance extends Remote {

	public boolean creerUtilisateur(Utilisateur utilisateur) throws RemoteException;
	
	public boolean creerTweet() throws RemoteException;
	
	public List<Utilisateur> rechercherTousUtilisateurs() throws RemoteException, JAXBException;
	
	public List<Tweet> rechercherTousTweets() throws RemoteException ;
	
	public List<Tweet> rechercherTweetsParUtilisateur(Utilisateur utilisateur) throws RemoteException;
	
	public Utilisateur rechercherUtilisateur(int id,String nom, String prenom, String login, String motDePasse) throws RemoteException;
	
	public boolean modifierUtilisateur() throws RemoteException;
	
	public Utilisateur rechercherUtilisateurParLoginMdp(String login, String motDePasse) throws RemoteException;
	
	public List<Utilisateur> rechercherUtilisateurParNom(String nom) throws RemoteException;
	
	public List<Utilisateur> rechercherUtilisateurParPrenom(String prenom) throws RemoteException;

}
