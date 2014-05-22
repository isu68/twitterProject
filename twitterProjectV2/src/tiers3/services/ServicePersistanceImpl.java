package tiers3.services;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import common.Tweet;

import tiers3.constants.Constantes;

public class ServicePersistanceImpl implements IServicePersistance {

	@Override
	public boolean creerUtilisateur(Utilisateur utilisateur)
			throws RemoteException {
		try {
			
			// Attribution d'un id à l'utilisateur
			int id = new Random().nextInt(99999);
			utilisateur.setIdUtilisateur(id);
			
			JAXBContext contexteUtilisateur = JAXBContext
					.newInstance(Utilisateur.class);
			Marshaller marshaller = contexteUtilisateur.createMarshaller();
			marshaller.setProperty(Constantes.JAXB_PROPRIETE_ENCODING,
					Constantes.JAXB_PROPRIETE_ENCODING_VALEUR);
			marshaller.setProperty(Constantes.JAXB_PROPRIETE_FORMATTED, true);
			

			marshaller.marshal(utilisateur,
					new File(Constantes.UTILISATEUR_PREFIXE_SERIALISATION
							+ utilisateur.getIdUtilisateur()
							+ Constantes.SUFFIXE_XML));
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
	public List<Utilisateur> rechercherTousUtilisateurs()
			throws RemoteException {
		
		return null;
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
	public List<Tweet> rechercherTweetsParUtilisateur(int id,String nom, String prenom, String login, String motDePasse ) throws RemoteException {
		
		return utilisateur.getTweets();
	}

	@Override
	public Utilisateur rechercherUtilisateur() throws RemoteException {
		return null;
	}

}
