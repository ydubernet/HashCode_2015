package fr.google.hashcode.main;



public class Emplacement {
	static public enum State {DISPO, INDISPO};
	
	public Point coord;
	public State state;
	
	public Emplacement(Point cord, State st) {
		this.coord = cord;
		this.state = st;
	}
}
