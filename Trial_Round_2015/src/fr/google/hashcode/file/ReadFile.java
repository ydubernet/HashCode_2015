package fr.google.hashcode.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class ReadFile {
	
	private final FileInputStream fis;
	
	public ReadFile(String name) throws FileNotFoundException {
		this.fis=new FileInputStream(name);
	}


}
