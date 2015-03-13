package fr.google.hashcode.main;

public final class ComputeFl {

	public static void Compute(Datacenter dc){
		boolean next = true;
		/*int totalemplacement = dc.getNbRange()*dc.getNbEmplacementD()-dc.getNbEmplcementI();
		int currentUsed = 0;
		int capaciteTotal = 0;
		int diff = totalemplacement;
		do{
			diff = totalemplacement-currentUsed;
			Serveur srv = maxServeurAplace(dc.getServeurs(),diff);
			if (srv==null||currentUsed+srv.getTaille()>totalemplacement)
				break;
			srv.setChoisi(true);
			currentUsed+=srv.getTaille();
			capaciteTotal+=srv.getCapacite();
		} while (diff>0);*/
		
		
		int[] rangeFirstIndex = new int[dc.getNbRange()];

		int groupe = 0;
		//boolean test = false;
		//int maxTaille = getMaxTaille(dc.getServeurs());
		//boolean next ;
		do{
			next = false;
			//test = !test;
			//for (int taille = maxTaille; taille>0;taille--){
				//if (test){
			for (int j = 0 ; j<dc.getNbRange();j++){
				Serveur srv = dc.nextServeurNonPlace(dc.getNbEmplacement());
				for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacement();col++){
					if (isPossible(j,col,dc,srv)){
						srv.range(j, col, /*dc.getGroupe(j)*/groupe);
						groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
						rangeFirstIndex[j]=col+srv.getTaille();
						next = true;
						break;
					}
				}
			}
							
			
		/*}
				else {
					for (int j = 15 ; j>=0;j--){
						Serveur srv = maxServeurAplace(dc.getServeurs());
						if (srv==null)
							break;
						for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacementD();col++){
							if (isPossible(j,col,dc,srv)){
								srv.range(j, col, groupe);
								groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
								rangeFirstIndex[j]+=col+srv.getTaille();
								next = true;
								break;
								
							}
						}
					}
					
				}
			}*/
			
		} while (next==true);
		
		next=true;
		groupe=0;
		while (next==true){
			next=false;
			for (int i = 0 ; i<dc.getNbRange();i++){
				for (int j=0;j<dc.getNbEmplacement();j++){
					if (!dc.isUsed(i,j)&!dc.isIndispo(i, j)){
						int nb = dc.getNBEmplacementDispo(i,j);
						Serveur srv = dc.nextServeurNonPlace(nb);
						if (srv==null)
							continue;
						srv.range(i, j, /*dc.getGroupe(i)*/groupe);
						groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
						next=true;
						break;
					}
				}
			}
		}
		
		
	}
	
	private static boolean isPossible(int x, int y, Datacenter dc,Serveur srv){
		int nbDispo = dc.getNBEmplacementDispo(x, y);
		if (nbDispo<srv.getTaille())
			return false;
		return true;
	}
	

}
