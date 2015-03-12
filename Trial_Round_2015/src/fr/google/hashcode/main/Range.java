package fr.google.hashcode.main;

import java.util.ArrayList;

public class Range {
	
	private int taille;
	private int index;
	public Emplacement[] emplacements;
	
	public Range(int size, int ind) {
		this.taille = size;
		this.index=ind;
	}
	
	public void prepare()
	{
		for(int i =0;i<this.taille;i++)
		{
			emplacements[i] = new Emplacement(new Point(index, i), Emplacement.State.DISPO);
		}
	}
	
	public int getMaxSize()
	{
		int cpt = 0;
		
		for(int i = 0;i<taille;i++)
		{
			if(emplacements[i])
		}
	}
}
