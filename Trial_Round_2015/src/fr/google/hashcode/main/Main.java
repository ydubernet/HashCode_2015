package fr.google.hashcode.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final String readFileName = "dc.in";
	private static final String writeFileName = "dc.out";
	private static final String endLine = "\n";

	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
		FileOutputStream fos = new FileOutputStream(writeFileName);
		
		try {
			//Ligne1
			String line = reader.readLine();
			String[] test = line.split(" ");
			Datacenter dc = new Datacenter(Integer.parseInt(test[0]),Integer.parseInt(test[1]),Integer.parseInt(test[2]),
					Integer.parseInt(test[3]),Integer.parseInt(test[4]));
			
			//Parcours des emplacement indispo
			for (int i = 0 ; i <dc.getNbEmplcementI();i++){
				line=reader.readLine();
				String[] point = line.split(" ");
				dc.getEmplacementIndispo()[i]=new Point(Integer.parseInt(point[0]),Integer.parseInt(point[1]));
			}
			
			//parcours des serveurs
			for (int i = 0 ; i<dc.getNbServer();i++){
				line=reader.readLine();
				String[] serveur = line.split(" ");
				dc.getServeurs()[i]=new Serveur(Integer.parseInt(serveur[0]),Integer.parseInt(serveur[1]));
			}			
			
			ComputeFl.Compute(dc);
			
			//Boucle ecrire serveur
			for (int i = 0 ; i<dc.getNbServer();i++){
				Serveur server = dc.getServeurs()[i];
				String lin;
				if (!server.isPlace())
					lin="x"+(i<dc.getNbServer()-1?endLine:"");
				else
					lin = server.getRange()+" "+server.getEmplacement()+" "+server.getGroupe()+(i<dc.getNbServer()-1?endLine:"");
				fos.write(lin.getBytes());
			}
			
			System.out.println("end");
			
			/*while ((line=reader.readLine()) != null){
				
			}
			char car;
			StringBuilder ligne = new StringBuilder();
			int c;
			while((c=reader.read())!=-1){
	             car= (char)reader.read();
	             c=c+1;
	             ligne.append(car);
	             if (car=='\n') {
	                   System.out.println("ligne: "+ligne);
	                   ligne.delete(0,ligne.length());
	                 }
			}
		
			
			FileOutputStream fos = new FileOutputStream(writeFileName);
			endLine.getBytes();
		
		
			SerializedData sdI = new SerializedData(new File(readFileName));
			SerializedData sd = new SerializedData();
			
			fos.write(sd.toByteArray());
			fos.write(endLine.getBytes());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				fos.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		

	}

}
