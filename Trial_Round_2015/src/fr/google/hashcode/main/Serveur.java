package fr.google.hashcode.main;

public class Serveur {
	private final int taille;
	private final int capacite;
	
	private boolean place;
	private boolean choisi;
	
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
	 * @return the groupe
	 */
	public int getGroupe() {
		return groupe;
	}


	/**
	 * @return the emplacement
	 */
	public int getEmplacement() {
		return emplacement;
	}


	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}
	
	public void range(int range, int emplacement, int groupe){
		this.range=range;
		this.emplacement=emplacement;
		this.groupe=groupe;
		place=true;
	}

	/**
	 * @return the choisi
	 */
	public boolean isChoisi() {
		return choisi;
	}

	/**
	 * @param choisi the choisi to set
	 */
	public void setChoisi(boolean choisi) {
		this.choisi = choisi;
	}



}
