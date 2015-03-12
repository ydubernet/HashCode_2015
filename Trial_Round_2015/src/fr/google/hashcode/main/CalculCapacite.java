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
	
	
	
	
	// Sommer pour chaque groupe tous les �l�ments de 
	// chaque rang�e correspondant au groupe consid�r�
	public int calculCapaciteGroupes(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		
		
		
		List<Integer> capaciteGroupes = new ArrayList<Integer>();
		
		
		for(int i = 0 ; i < serveurs.length ; i++){
			capaciteGroupes.set(serveurs[i].getGroupe(), capaciteGroupes.get(serveurs[i].getGroupe()) + serveurs[i].getCapacite());
		}
		
	
		
		
		// On r�cup�re les capacit�s selon les groupes et les rang�es.
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
		
		// On r�cup�re les capacit�s selon les groupes et les rang�es.
		for(int i = 0 ; i < serveurs.length ; i++){
			Serveur s = serveurs[i];
			
			int emplacement = s.getEmplacement();
			int rangee = s.getRange();
			int capaciteServeur = s.getCapacite();
			int groupe = s.getGroupe();
			
			groupes.add(groupe, capaciteServeur);
			rangees.add(rangee, capaciteServeur);
			
		}
		
		
		// Sommer pour le groupe 1 tous les �l�ments de chaque rang�e correspondant au groupe 1
		// De m�me pour chaque groupe

		List<Integer> valeurs = new ArrayList<Integer>();
		
		for(Integer g : groupes){
			int val = 0;
				
			val += rangees.get(g);

			valeurs.add(g, val);
		}
		
		// Ensuite, calculer la capacit� du 1er groupe sur toutes les rang�es sans la rang�e o� le groupe a calcul� le maximum de capacit�
		// Store it
		// De m�me pour chaque groupe
		
		for(Integer r : rangees){
			
		}
		
		
		// A la fin, sortir une capacit� garantie minimale de tous les  groupes.
		

		
		
	}
	
	
}
