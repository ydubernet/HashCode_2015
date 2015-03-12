package fr.google.hashcode.main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

import fr.google.hashcode.buffer.SerializedData;

public class Main {
	private static final String readFileName = "doodle.txt";
	private static final String writeFileName = "output.txt";
	private static final String endLine = "\n";
	private Integer S = 0;

	public static void main(String[] args) throws FileNotFoundException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
		//Ligne1
		String line1 = reader.readLine();
		//parcours des lines
		while ((line1=reader.readLine()) != null){
			
		}
		
		FileInputStream fis = new FileInputStream(readFileName);
		FileChannel c = fis.getChannel();
		byte[] array = new byte[fis.getChannel().];
		ByteBuffer buff = ByteBuffer.wrap(array);
		c.read(buff);
		fis.read(b);
		int i = 0;
		while ((i=fis.read())>-1)
			System.out.println(new String(i));
		//String c = new String (fis.read());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName)));
		CharBuffer buffer = new CharBuffer();
		reader.read(cbuf)
		try {
			String l1 = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileOutputStream fos = new FileOutputStream(writeFileName);
		endLine.getBytes();
		
		
		
		SerializedData sdI = new SerializedData(new File(readFileName));

		SerializedData sd = new SerializedData();
		
		fos.write(sd.toByteArray());
		fos.write(endLine.getBytes());
		
		//fos.write(S.);
		//writeFileName.
		
		

	}

}
