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
				Serveur srv = maxServeurAplaceAfter(dc.getServeurs(),dc.getNbEmplacement());
				if (srv==null)
					break;
				for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacement();col++){
					if (isPossible(j,col,dc,srv)){
						srv.range(j, col, groupe);
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
		
		groupe=0;
		while (!dc.isFull()){
			for (int i = 0 ; i<dc.getNbRange();i++){
				for (int j=0;j<dc.getNbEmplacement();j++){
					if (!dc.isUsed(i, j)){
						int nb = dc.getNBEmplacementAfter(i, j)+1;
						Serveur srv = maxServeurAplaceAfter(dc.getServeurs(), nb);
						srv.range(i, j, groupe);
						groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
						break;
					}
				}
			}
		}
		
		
	}
	
	private static boolean isPossible(int x, int y, Datacenter dc,Serveur srv){
		if (dc.getNbEmplacement()-y<srv.getTaille())
			return false;
		
		for (int i = y ;i<y+srv.getTaille();i++){
			for (int z = 0 ; z<dc.getNbEmplcementI();z++){
			if (dc.getEmplacementIndispo()[z].getX()==x&&dc.getEmplacementIndispo()[z].getY()==i)
				return false;
			}
		}
		return true;
	}
	
	private static Serveur maxServeurAplaceAfter(Serveur[] srv, int taille){
		Serveur result = null;
		int deb = 0;
		while (deb<srv.length){
			if (!srv[deb].isPlace()&&srv[deb].getTaille()<=taille){
				result = srv[deb];
				break;
			}
			deb++;
		}
		
		for (int i = deb ; i<srv.length;i++){
			Serveur serveur= srv[i];
			if (serveur.isPlace()||serveur.getTaille()>taille)
				continue;
			if (serveur.getCapacite()>result.getCapacite()||(serveur.getCapacite()==result.getCapacite()&&serveur.getTaille()<result.getTaille()))
				result=serveur;
		}
			
		return result;
	}
	
	
	private static Serveur maxServeurAplace(Serveur[] srv, int diff){
		Serveur result = null;
		int deb = 0;
		while (deb<srv.length){
			if (!srv[deb].isPlace()&&srv[deb].getTaille()<=diff){
				result = srv[deb];
				break;
			}
			deb++;
		}
		if (result==null)
			return null;
		deb++;
		for (int i = deb ; i<srv.length;i++){
			Serveur serveur= srv[i];
			if (serveur.isPlace()||srv[deb].getTaille()>diff)
				continue;
			if (serveur.getCapacite()>result.getCapacite()||(serveur.getCapacite()==result.getCapacite()&&serveur.getTaille()<result.getTaille()))
				result=serveur;
		}
			
		return result;
	}
	

}
