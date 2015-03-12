package fr.google.hashcode.main;

public final class ComputeFl {

	public static void Compute(Datacenter dc){
		int totalemplacement = dc.getNbGroupe()*dc.getNbEmplacementD()-dc.getNbEmplcementI();
		int currentUsed = 0;
		boolean next = true;
		do{
			Serveur srv = maxServeurAplace(dc.getServeurs());
			srv.setPlace(p);
		} while (next==true)
		for (int i=0;i<dc.getNbServer();i++){
			
		}
		
		int[] rangeFirstIndex = new int[dc.getNbRange()];
		boolean next;
		int groupe = 0;
		//boolean test = false;
		int maxTaille = getMaxTaille(dc.getServeurs());
		
		do{
			next = false;
			//test = !test;
			for (int taille = maxTaille; taille>0;taille--){
				//if (test){
					for (int j = 0 ; j<dc.getNbRange();j++){
						Serveur srv = maxServeurAplace(dc.getServeurs(),taille);
						for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacementD();col++){
							if (isPossible(j,col,dc,srv)){
								srv.range(j, col, groupe);
								groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
								rangeFirstIndex[j]=col+1+srv.getTaille();
								next = true;
								
								break;
								
							}
						}
					}
					
				/*}
				else {
					for (int j = 15 ; j>=0;j--){
						Serveur srv = maxServeurAplace(dc.getServeurs(),taille);
						for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacementD();col++){
							if (isPossible(j,col,dc,srv)){
								srv.range(j, col, groupe);
								groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
								rangeFirstIndex[j]=col+1+srv.getTaille();
								next = true;
								break;
								
							}
						}
					}
					
				}*/
			}
			
		} while (next==true);
		
		/*for (int rang = 0 ; rang<dc.getNbRange();rang++){
			
			for (int emp=0;emp<dc.getNbEmplacementD();emp++){
				if (isIndispo(rang,emp,dc.getEmplacementIndispo()))
					continue;
				for (int i = 0;i<dc.getNbServer();i++){
					Serveur serv = dc.getServeurs()[i];
					if (serv.isPlace())
						continue;
					int diff = dc.getNbEmplacementD()-emp+1;
					if (serv.getTaille()>)
				}
				
			}
			
			
		}*/
		
	}
	
	private static boolean isPossible(int x, int y, Datacenter dc,Serveur srv){
		if (dc.getNbEmplacementD()-y<srv.getTaille())
			return false;
		
		for (int i = y ;i<y+srv.getTaille();i++){
			for (int z = 0 ; z<dc.getNbEmplcementI();z++){
			if (dc.getEmplacementIndispo()[z].getX()==x&&dc.getEmplacementIndispo()[z].getY()==i)
				return false;
			}
		}
		return true;
	}
	
	private static Serveur maxServeurAplace(Serveur[] srv, int taille){
		Serveur result = srv[0];
		for (int i = 1 ; i<srv.length;i++){
			Serveur serveur= srv[i];
			if (serveur.isPlace()||serveur.getTaille()!=taille)
				continue;
			if (serveur.getCapacite()>result.getCapacite()||(serveur.getCapacite()==result.getCapacite()&&serveur.getTaille()<result.getTaille()))
				result=serveur;
		}
			
		return result;
	}
	
	private static int getMaxTaille(Serveur[] srv){
		int result = 0;
		for (int i = 0 ; i<srv.length;i++){
			if (srv[i].getTaille()>result)
				result = srv[i].getTaille();
		}
			
			return result;
		
	}
	
	
	private static Serveur maxServeurAplace(Serveur[] srv){
		Serveur result = srv[0];
		for (int i = 1 ; i<srv.length;i++){
			Serveur serveur= srv[i];
			if (serveur.isPlace())
				continue;
			if (serveur.getCapacite()>result.getCapacite()||(serveur.getCapacite()==result.getCapacite()&&serveur.getTaille()<result.getTaille()))
				result=serveur;
		}
			
		return result;
	}
	

}
