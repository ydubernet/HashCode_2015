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
			if (serveurs[z].getRange()==x&&(serveurs[z].getEmplacement()<=y&&serveurs[z].getEmplacement()+serveurs[z].getTaille()>=y))
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
	
	public int getNBEmplacementAfter(int x, int y){
		int result = 0;
		y++;
		while (y<nbEmplacement&&!isUsed(x, y)&&!isIndispo(x, y)){
			result++;
			y++;
		}
			return result;
	}

}
