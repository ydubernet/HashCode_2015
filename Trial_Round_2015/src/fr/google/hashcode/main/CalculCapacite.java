package fr.google.hashcode.main;

import java.util.ArrayList;
import java.util.List;


public class CalculCapacite {	
	
	public static int calculCapaciteMin(Datacenter dc){
		Serveur[] serveurs = dc.getServeurs();
		
		int groupes[] = new int[dc.getNbGroupe()];
		int rangees[] = new int[dc.getNbRange()];
		int bestGroupeRange[] = new int[dc.getNbRange()];

		for(int i = 0 ; i < bestGroupeRange.length; i ++){
			bestGroupeRange[i] = 0;
		}
		
		for(int k = 0;k<dc.getNbRange();k++)
		{
			int tmpGroupes[] = new int[dc.getNbGroupe()];
			
			for(int i = 0 ; i < tmpGroupes.length; i ++){
				tmpGroupes[i] = 0;
			}
			
			for(int i = 0 ; i < serveurs.length ; i++){	
				if(serveurs[i].isPlace() && serveurs[i].getRange() == k){
					tmpGroupes[serveurs[i].getGroupe()] += serveurs[i].getCapacite(); //sommes de chaque groupe
				}
			}
			
			int max=0;
			for(int h = 0;h<tmpGroupes.length;h++)
			{
				if(tmpGroupes[h] > max)
					max = tmpGroupes[h];
			}
			
			bestGroupeRange[k] = max;
		}
		
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
		
		
		int result[] = new int[dc.getNbRange()];
		for(int k = 0;k<dc.getNbRange();k++)
		{
			result[k] = groupe[k] - bestGroupeRange[k];
		}
		for (int i =  0 groupe[i] //- bestGroupeRange[h];
		
		return 0;
		
	}
	
	
	
	
	// Sommer pour chaque groupe tous les �l�ments de 
	// chaque rang�e correspondant au groupe consid�r�
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
//		// On r�cup�re les capacit�s selon les groupes et les rang�es.
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
//		// On r�cup�re les capacit�s selon les groupes et les rang�es.
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
//		// A la fin, sortir une capacit� garantie minimale de tous les  groupes.
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
