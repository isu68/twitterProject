package tiers3.services;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import common.Tweet;
import common.Utilisateur;
import tiers3.constants.Constantes;

public class ServicePersistanceImpl implements IServicePersistance {

	@Override
	public boolean creerUtilisateur(Utilisateur utilisateur) throws RemoteException {
		try {
			
			// Attribution d'un id � l'utilisateur
			int id = new Random().nextInt(99999);
			utilisateur.setId(id);
			JAXBContext contexteUtilisateur = JAXBContext.newInstance(Utilisateur.class);
			Marshaller marshaller = contexteUtilisateur.createMarshaller();
			marshaller.setProperty(Constantes.JAXB_PROPRIETE_ENCODING,Constantes.JAXB_PROPRIETE_ENCODING_VALEUR);
			marshaller.setProperty(Constantes.JAXB_PROPRIETE_FORMATTED, true);
			marshaller.marshal(utilisateur,new File(Constantes.UTILISATEUR_PREFIXE_SERIALISATION + utilisateur.getId() + Constantes.SUFFIXE_XML));
		} catch (JAXBException jaxbe) {
			jaxbe.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean creerTweet() throws RemoteException {
		return false;
	}

	@Override
	public boolean modifierUtilisateur() throws RemoteException {
		return false;
	}

	@Override
	public List<Utilisateur> rechercherTousUtilisateurs() throws RemoteException, JAXBException {
		// Instanciation d'une liste d'utilisateurs vide par défaut
		List<Utilisateur> maListeUtilisateur = new ArrayList<Utilisateur>();
		Utilisateur unUtilisateur;
		
		// Récupération et vérification du dossier de stockage des utilisateurs
		File repertoire = new File(Constantes.FOLDER);
		assert repertoire.isDirectory();
		
		// Instanciation du context et du Unmarshaller
		JAXBContext context = JAXBContext.newInstance(Utilisateur.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		// Récupération de l'ensemble des fichier contenus dans le répertoire
		File[] tousLesFichiers = repertoire.listFiles();
		if (tousLesFichiers != null) {
			for (File fichier : tousLesFichiers) {
				if (!fichier.isDirectory()) {
					unUtilisateur = (Utilisateur) unmarshaller.unmarshal(new File(fichier.getName()));
					maListeUtilisateur.add(unUtilisateur);
				}
			}
		}
		return maListeUtilisateur;
	}

	@Override
	public List<Tweet> rechercherTousTweets() throws RemoteException {
		List<Tweet> listeTweets = new ArrayList<Tweet>();
		// Pour chaque utilisateur 
		for (Utilisateur utilisateur) {
			listeTweets.addAll(utilisateur.getTweets());
		}
	}

	@Override
	public List<Tweet> rechercherTweetsParUtilisateur(Utilisateur utilisateur) throws RemoteException {
		return utilisateur.getListeTweets();
	}

	@Override
	public Utilisateur rechercherUtilisateur(int id,String nom, String prenom, String login, String motDePasse) throws RemoteException {
		
		return null;
	}
	
	@Override
	public Utilisateur rechercherUtilisateurParLoginMdp(String login, String motDePasse) throws RemoteException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>(); // appel� la m�thode getListUtilisateurs;
		for (Utilisateur utilisateur : listeUtilisateur) {
			if(login == utilisateur.getLogin() && motDePasse == utilisateur.getMdp()){
				return utilisateur;
			}
		}
		return null;
	}
	
	@Override
	public List<Utilisateur> rechercherUtilisateurParNom(String nom) throws RemoteException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>(); // appel� la m�thode getListUtilisateurs;
		List<Utilisateur> listeRetour = new ArrayList<Utilisateur>();
		for (Utilisateur utilisateur : listeUtilisateur) {
			if(nom == utilisateur.getNom()){
				 listeRetour.add(utilisateur);
			}
		}
		return listeRetour;
	}
	
	@Override
	public List<Utilisateur> rechercherUtilisateurParPrenom(String prenom) throws RemoteException {
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>(); // appel� la m�thode getListUtilisateurs;
		List<Utilisateur> listeRetour = new ArrayList<Utilisateur>();
		for (Utilisateur utilisateur : listeUtilisateur) {
			if(prenom == utilisateur.getPrenom()){
				 listeRetour.add(utilisateur);
			}
		}
		return listeRetour;
	}
}
