package fr.google.hashcode.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
	private static final String readFileName = "dc.in";
	private static final String writeFileName = "output.txt";
	private static final String endLine = "\n";
	private Integer S = 0;

	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
		
		try {
			//Ligne1
			String line1 = reader.readLine();
			String[] test = line1.split(" ");
			datacenter dc = new datacenter(Integer.parseInt(test[0]),Integer.parseInt(test[1]),Integer.parseInt(test[2]),
					Integer.parseInt(test[3]),Integer.parseInt(test[4]));
			
			Parcours des emplacement indispo
			for (int i = 0 ; i <dc.getNbEmplcementI();i++){
				
				
			}
			//parcours des lines
			while ((line1=reader.readLine()) != null){
				
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
	
		

	}

}
