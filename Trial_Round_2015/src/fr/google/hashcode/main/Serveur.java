package fr.google.hashcode.main;

public class Serveur {
	private final int taille;
	private final int capacite;
	
	private boolean place;
	
	private int range;
	private int emplacement;
	private int groupe;

	public Serveur(int taille, int capacite) {
		this.taille = taille;
		this.capacite=capacite;
	}

	/**
	 * @return the capacite
	 */
	public int getCapacite() {
		return capacite;
	}


	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @return the place
	 */
	public boolean isPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(boolean place) {
		this.place = place;
	}

	/**
	 * @return the groupe
	 */
	public int getGroupe() {
		return groupe;
	}

	/**
	 * @param groupe the groupe to set
	 */
	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	/**
	 * @return the emplacement
	 */
	public int getEmplacement() {
		return emplacement;
	}

	/**
	 * @param emplacement the emplacement to set
	 */
	public void setEmplacement(int emplacement) {
		this.emplacement = emplacement;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}


}
