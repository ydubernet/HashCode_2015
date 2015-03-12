package fr.google.hashcode.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;


public class CalculCapacite {
	
	private List<Integer> rangees;
	private List<Integer> groupes;
	
	
	public static int calculCapaciteMin(Datacenter dc){
		
		
		
		return 0;
	}
	
	
	
	
	// Sommer pour chaque groupe tous les éléments de 
	// chaque rangée correspondant au groupe considéré
	public int calculCapaciteGroupes(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		
		
		
		List<Integer> capaciteGroupes = new ArrayList<Integer>();
		
		
		for(int i = 0 ; i < serveurs.length ; i++){
			capaciteGroupes.set(serveurs[i].getGroupe(), capaciteGroupes.get(serveurs[i].getGroupe()) + serveurs[i].getCapacite());
		}
		
	
		
		
		// On récupère les capacités selon les groupes et les rangées.
		for(int i = 0 ; i < serveurs.length ; i++){
			Serveur s = serveurs[i];
			
			int emplacement = s.getEmplacement();
			int rangee = s.getRange();
			int capaciteServeur = s.getCapacite();
			int groupe = s.getGroupe();
			
			groupes.add(groupe, capaciteServeur);
			rangees.add(rangee, capaciteServeur);
				
		}
		return 0;
	
	
	}
	
	
	
	

	
	public int calculCapacites(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		// On récupère les capacités selon les groupes et les rangées.
		for(int i = 0 ; i < serveurs.length ; i++){
			Serveur s = serveurs[i];
			
			int emplacement = s.getEmplacement();
			int rangee = s.getRange();
			int capaciteServeur = s.getCapacite();
			int groupe = s.getGroupe();
			
			groupes.add(groupe, capaciteServeur);
			rangees.add(rangee, capaciteServeur);
			
		}
		
		
		// Sommer pour le groupe 1 tous les éléments de chaque rangée correspondant au groupe 1
		// De même pour chaque groupe

		List<Integer> valeurs = new ArrayList<Integer>();
		
		for(Integer g : groupes){
			int val = 0;
				
			val += rangees.get(g);

			valeurs.add(g, val);
		}
		
		// Ensuite, calculer la capacité du 1er groupe sur toutes les rangées sans la rangée où le groupe a calculé le maximum de capacité
		// Store it
		// De même pour chaque groupe
		
		for(Integer r : rangees){
			
		}
		
		
		// A la fin, sortir une capacité garantie minimale de tous les  groupes.
		

		
		
	}
	
	
}
