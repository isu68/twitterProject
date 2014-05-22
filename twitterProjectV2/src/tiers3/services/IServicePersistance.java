package tiers3.services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import common.Tweet;

public interface IServicePersistance extends Remote {

	public boolean creerUtilisateur() throws RemoteException;
	
	public boolean creerTweet() throws RemoteException;
	
	public List<Utilisateur> rechercherTousUtilisateurs() throws RemoteException;
	
	public List<Tweet> rechercherTousTweets() throws RemoteException ;
	
	public List<Tweet> rechercherTweetsParUtilisateur() throws RemoteException;
	
	public Utilisateur rechercherUtilisateur() throws RemoteException;
	
	public boolean modifierUtilisateur() throws RemoteException;

}
