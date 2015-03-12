package fr.google.hashcode.main;

public final class ComputeFl {

	public static void Compute(Datacenter dc){
		
		for (int rang = 0 ; rang<dc.getNbRange();rang++){
			
			for (int emp=0;emp<dc.getNbEmplacementD();emp++){
				if (isIndispo(rang,emp,dc.getEmplacementIndispo()))
					continue;
			}
			
			
		}
		
	}
	
	private static boolean isIndispo(int x, int y, Point[] pointIndispo){
		for (int i = 0 ;i<pointIndispo.length;i++){
			if (pointIndispo[i].getX()==x&&pointIndispo[i].getY()==y)
				return true;
		}
		return false;
	}

}
