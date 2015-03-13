package fr.google.hashcode.main;

public class Compute {
	
	private Datacenter dc;
	
	public Compute(Datacenter mydc) {
		this.dc = mydc;
		populateRanges();
	}
	
	public void populateRanges() {
		Point[] indispo = dc.getEmplacementIndispo();
		Range[] ranges = new Range[dc.getNbEmplacement()];
		
		Emplacement[] emplacements = new Emplacement[dc.getNbEmplacement()];
		
		for(int j = 0 ; j<dc.getNbRange();j++)
		{
			ranges[j] = new Range(dc.getNbEmplacement(),j);
			ranges[j].prepare();
			
			//Pour chaque range
			for(int i = 0; i<dc.getNbEmplcementI();i++)
			{
				if(indispo[i].x == j)
				{
					ranges[j].emplacements[i] = new Emplacement(indispo[i],Emplacement.State.INDISPO);
				}
			}
		}
	}
}
