package fr.google.hashcode.main;

public class Compute {
	
	private Datacenter dc;
	
	public Compute(Datacenter mydc) {
		this.dc = mydc;
		populateRanges();
	}
	
	public void populateRanges() {
		Point[] indispo = dc.getEmplacementIndispo();
		Range[] ranges = null;
		
		for(int j = 0 ; j<dc.getNbRange();j++)
		{
			ranges[j] = new Range(dc.getNbEmplacementD(),j);
			ranges[j].prepare();
			
			//Pour chaque range
			for(int i = 0; i<dc.getNbEmplcementI();i++)
			{
				if(indispo[i].x == j)
				{
					ranges[j].emplacements[i] = indispo[i];
				}
			}
		}
	}
}
