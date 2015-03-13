package fr.google.hashcode.main;

public class Datacenter {
	

	public Datacenter(int nbRange, int nbEmplacement, int nbEmplcementI,
			int nbGroupe, int nbServer) {
		this.nbRange = nbRange;
		this.nbEmplacement = nbEmplacement;
		this.nbEmplcementI = nbEmplcementI;
		this.nbGroupe = nbGroupe;
		this.nbServer = nbServer;
		this.emplacementIndispo=new Point[nbEmplcementI];
		this.serveurs = new Serveur[nbServer];
	}

	private final int nbRange;
	private final int nbEmplacement;
	private final int nbEmplcementI;
	private final int nbGroupe;
	private final int nbServer;
	
	private final Point[] emplacementIndispo;
	private final Serveur[] serveurs;
	
	
	/**
	 * @return the nbEmplcementI
	 */
	public int getNbEmplcementI() {
		return nbEmplcementI;
	}

	/**
	 * @return the nbGroupe
	 */
	public int getNbGroupe() {
		return nbGroupe;
	}

	/**
	 * @return the nbServer
	 */
	public int getNbServer() {
		return nbServer;
	}

	/**
	 * @return the nbRange
	 */
	public int getNbRange() {
		return nbRange;
	}

	/**
	 * @return the nbEmplacementD
	 */
	public int getNbEmplacement() {
		return nbEmplacement;
	}

	/**
	 * @return the emplacementIndispo
	 */
	public Point[] getEmplacementIndispo() {
		return emplacementIndispo;
	}

	/**
	 * @return the serveurs
	 */
	public Serveur[] getServeurs() {
		return serveurs;
	}
	
	public boolean isIndispo(int x, int y){
		for (int z = 0 ; z<nbEmplcementI;z++){
			if (emplacementIndispo[z].getX()==x&&emplacementIndispo[z].getY()==y)
				return true;
		}
		return false;
	}
	
	public boolean isUsed(int x, int y){
		for (int z = 0 ; z<nbServer;z++){
			if (!serveurs[z].isPlace())
				continue;
			int fin = serveurs[z].getEmplacement()+serveurs[z].getTaille()-1;
			if (serveurs[z].getRange()==x&&(serveurs[z].getEmplacement()<=y&&fin>=y))
				return true;
		}
		return false;
	}
	
	public boolean isFull(){
		for (int i = 0 ; i<nbRange;i++){
			for (int j = 0; j<nbEmplacement;j++){
				if (isIndispo(i, j))
					continue;
				if(!isUsed(i,j))
						return false;
			}
		}
		return true;
	}
	
	public int getNBEmplacementDispo(int x, int y){
		int result = 0;
		while (y<nbEmplacement&&!isUsed(x,y)&&!isIndispo(x,y)){
			result++;
			y++;
		}
			return result;
	}
	
	public Serveur nextServeurNonPlace(int taille){
		Serveur result = null;
		int deb = 0;
		while (deb<nbServer){
			if (!serveurs[deb].isPlace()&&serveurs[deb].getTaille()<=taille){
				result = serveurs[deb];
				break;
			}
			deb++;
		}
		
		for (int i = deb ; i<nbServer;i++){
			Serveur serveur = serveurs[i];
			if (serveur.isPlace()||serveur.getTaille()>taille)
				continue;
			if (serveur.getCapacite()>result.getCapacite()||(serveur.getCapacite()==result.getCapacite()&&serveur.getTaille()<result.getTaille()))
			//if ((serveur.getCapacite()/serveur.getTaille())>(result.getCapacite()/result.getTaille()))
				result=serveur;
		}
			
		return result;
	}
	
	public int getGroupe(int range){
		int[] groupes = new int[nbGroupe];
		for (int i = 0 ; i<nbServer;i++){
			Serveur serveur = serveurs[i];
			if (!serveur.isPlace()||serveur.getRange()!=range)
				continue;
			
			groupes[serveur.getGroupe()]+=serveur.getCapacite();
			
		}
		
		int groupeMin = 0;
		int min = 0;
		int pas = range*nbGroupe;
		int debut = nbGroupe-1+pas;
		int fin = pas;
		for (int i = debut ; i>=fin;i--){
			int indice = i%(nbGroupe);
			if (min>=groupes[indice]){
				groupeMin=indice;
				min = groupes[indice];
			}
		}
		
		return groupeMin;
	}
	
	public void affecterGroupe(){
		
	}
	

}
