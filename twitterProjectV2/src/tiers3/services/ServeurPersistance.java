package tiers3.services;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import tiers3.constants.Constantes;

public class ServeurPersistance {
	public static void main(String[] args) throws Exception {
		ServicePersistanceImpl servicePersistance = new ServicePersistanceImpl();
		IServicePersistance stub;
		// Création du stub
		stub = (IServicePersistance) UnicastRemoteObject.exportObject(servicePersistance,0);
		// Création du Registry sur le port 2000
		Registry registry = LocateRegistry.createRegistry(Constantes.PORT_SERVEUR);
		// Enregistrement du service sur le namespace "ServicePersistance"
		registry.bind(Constantes.NAMESPACE_SERVEUR, stub);
		
	}
}
