package fr.google.hashcode.main;

import java.util.List;


public class CalculCapacite {
	
	private List<Integer> rangees;
	private List<Integer> groupes;
	
	
	public static int calculCapaciteMin(Datacenter dc){
		
		
		
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
		
		
		
		
	}
	
	
}
