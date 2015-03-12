package fr.google.hashcode.main;

import java.util.ArrayList;
import java.util.List;


public class CalculCapacite {	
	
	public static int calculCapaciteMin(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		int groupes[] = new int[serveurs.length];
		int rangees[] = new int[dc.getNbRange()];
		for(int i = 0 ; i < groupes.length; i ++){
			groupes[i] = 0;
			
		}
		for(int i = 0 ; i < rangees.length; i ++){
			rangees[i] = 0;
			
		}
		
		for(int i = 0 ; i < serveurs.length ; i++){	
			if(serveurs[i].isPlace()){
				groupes[serveurs[i].getGroupe()] += serveurs[i].getCapacite(); //sommes de chaque groupe
			}
		}
		
		for(int i = 0 ; i < dc.getNbRange() ; i++){	
			for(int j = 0 ; j < serveurs.length ; j++){
			
				if(serveurs[j].getRange() == i && serveurs[j].isPlace()){
					rangees[i] += serveurs[j].getCapacite();
				}
			}	
		}
		
		return 0;
		
	}
	
	
	
	
	// Sommer pour chaque groupe tous les éléments de 
	// chaque rangée correspondant au groupe considéré
//	public int calculCapaciteGroupes(Datacenter dc){
//		Serveur[] serveurs = dc.getServeurs();
//		
//		List<Integer> capaciteGroupes = new ArrayList<Integer>();
//		
//		
//		for(int i = 0 ; i < serveurs.length ; i++){
//
//			capaciteGroupes.set(serveurs[i].getGroupe(), capaciteGroupes.get(serveurs[i].getGroupe()) + serveurs[i].getCapacite());
//		}
//		
//		
//		// On récupère les capacités selon les groupes et les rangées.
//		for(int i = 0 ; i < serveurs.length ; i++){
//			Serveur s = serveurs[i];
//			
//			int emplacement = s.getEmplacement();
//			int rangee = s.getRange();
//			int capaciteServeur = s.getCapacite();
//			int groupe = s.getGroupe();
//			
//			groupes.add(groupe, capaciteServeur);
//			rangees.add(rangee, capaciteServeur);
//				
//		}
//		return 0;
//	
//	
//	}
//
//	public int calculCapacites(Datacenter dc){
//		Serveur[] serveurs = dc.getServeurs();
//		
//		// On récupère les capacités selon les groupes et les rangées.
//		for(int i = 0 ; i < serveurs.length ; i++){
//			Serveur s = serveurs[i];
//			
//			int emplacement = s.getEmplacement();
//			int rangee = s.getRange();
//			int capaciteServeur = s.getCapacite();
//			int groupe = s.getGroupe();
//			
//			groupes.add(groupe, capaciteServeur);
//			rangees.add(rangee, capaciteServeur);
//		
//		}
//		return 0;
//		
//		
//		// A la fin, sortir une capacité garantie minimale de tous les  groupes.
//		
//	}
//	
	public static int calculCapaciteTotale(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		int capaciteTotale = 0;
		for(int i = 0 ; i<serveurs.length;i++){
			capaciteTotale += serveurs[i].getCapacite();
		}
		return capaciteTotale;
	}
	
	public static double calculCapaciteMoyenne(Datacenter dc){
		int nombreServeursActifs = 0;
		Serveur[] serveurs = dc.getServeurs();
		
		for(int i = 0 ; i<serveurs.length ; i++){
			if(serveurs[i].isPlace()){
				nombreServeursActifs++;
			}
		}
		
		return calculCapaciteTotale(dc) / nombreServeursActifs;
	}	
	
	
}
