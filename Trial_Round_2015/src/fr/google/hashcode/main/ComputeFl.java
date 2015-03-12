package fr.google.hashcode.main;

public final class ComputeFl {

	public static void Compute(Datacenter dc){
		/*int totalemplacement = dc.getNbRange()*dc.getNbEmplacementD()-dc.getNbEmplcementI();
		int currentUsed = 0;
		int capaciteTotal = 0;
		boolean next = true;
		do{
			Serveur srv = maxServeurAplace(dc.getServeurs());
			if (srv==null||currentUsed+srv.getTaille()>totalemplacement)
				break;
			srv.setPlace(true);
			currentUsed+=srv.getTaille();
			capaciteTotal+=srv.getCapacite();
		} while (next==true);*/
		
		
		int[] rangeFirstIndex = new int[dc.getNbRange()];

		int groupe = 0;
		boolean test = false;
		//int maxTaille = getMaxTaille(dc.getServeurs());
		boolean next ;
		do{
			next = false;
			test = !test;
			//for (int taille = maxTaille; taille>0;taille--){
				if (test){
			for (int j = 0 ; j<dc.getNbRange();j++){
				Serveur srv = maxServeurAplaceAfter(dc.getServeurs()/*,taille*/);
				for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacementD();col++){
					if (isPossible(j,col,dc,srv)){
						srv.range(j, col, groupe);
						groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
						rangeFirstIndex[j]+=1+srv.getTaille();
						next = true;
						
						break;
						
					}
				}
			}
					
				}
				else {
					for (int j = 15 ; j>=0;j--){
						Serveur srv = maxServeurAplace(dc.getServeurs()/*,taille*/);
						for (int col=rangeFirstIndex[j]; col<dc.getNbEmplacementD();col++){
							if (isPossible(j,col,dc,srv)){
								srv.range(j, col, groupe);
								groupe = groupe>=dc.getNbGroupe()-1?0:groupe+1;
								rangeFirstIndex[j]=rangeFirstIndex[j]+1+srv.getTaille();
								next = true;
								break;
								
							}
						}
					}
					
				}
			//}
			
		} while (next==true);
		
		
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
	
	private static Serveur maxServeurAplaceAfter(Serveur[] srv/*, int taille*/){
		Serveur result = srv[0];
		for (int i = 1 ; i<srv.length;i++){
			Serveur serveur= srv[i];
			if (serveur.isPlace()/*||serveur.getTaille()!=taille*/)
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
		Serveur result = null;
		int deb = 0;
		while (deb<srv.length){
			if (!srv[deb].isPlace()){
				result = srv[deb];
				break;
			}
			deb++;
		}
		if (result==null)
			return null;
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
