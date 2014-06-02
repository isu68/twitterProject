package tiers2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import javax.xml.bind.JAXBException;

import common.Tweet;
import common.Utilisateur;
import tiers3.services.IServicePersistance;

public class Main {
	
	
	public static void main(String[] args) throws RemoteException {	
		
		Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2000);
		IServicePersistance service;
		try {
			service = (IServicePersistance) registry.lookup("ServicePersistance");
			// création d'un utilisateur 
			Utilisateur utilisateur = new Utilisateur(1, "DURAND", "Jacques", "monmail@mail.com", "userlogin", "mdp1");
			Tweet tweet = new Tweet(utilisateur.getId(), "Ceci est un tweet de test!");
			service.creerUtilisateur(utilisateur);
			service.creerTweet(utilisateur, tweet);
			List<Utilisateur> maListeUser = service.rechercherTousUtilisateurs();
			List<Tweet> maListeTweets = service.rechercherTousTweets();
			System.out.println("Mes utilisateurs:");
			for(Utilisateur u : maListeUser){
				System.out.println(u.getNom() + ", " + u.getPrenom());
			}
			System.out.println("Mes utilisateurs:");
			for(Tweet t : maListeTweets){
				System.out.println("Posté par: "+t.getIdUtilisateur()+"\n"
						+ t.getContenu());
			}
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
}
