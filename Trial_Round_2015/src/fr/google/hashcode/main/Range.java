package fr.google.hashcode.main;

import java.util.ArrayList;

public class Range {
	
	private int taille;
	private int index;
	public Point[] emplacements;
	
	public Range(int size, int ind) {
		this.taille = size;
		this.index=ind;
	}
	
	public void prepare()
	{
		for(int i =0;i<this.taille;i++)
		{
			emplacements[i] = new Point(index, i);
		}
	}
}
