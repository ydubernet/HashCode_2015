package fr.google.hashcode.main;

public class datacenter {
	

	public datacenter(int nbRange, int nbEmplacementD, int nbEmplcementI,
			int nbGroupe, int nbServer) {
		this.nbRange = nbRange;
		this.nbEmplacementD = nbEmplacementD;
		this.nbEmplcementI = nbEmplcementI;
		this.nbGroupe = nbGroupe;
		this.nbServer = nbServer;
		this.emplacementIndispo=new Point[nbEmplcementI];
		this.serveurs = new Serveur[nbServer];
	}

	private final int nbRange;
	private final int nbEmplacementD;
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
	public int getNbEmplacementD() {
		return nbEmplacementD;
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

}
