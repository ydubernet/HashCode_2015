package fr.google.hashcode.main;

public class Serveur {
	private final int taille;
	private final int capacite;

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


}
