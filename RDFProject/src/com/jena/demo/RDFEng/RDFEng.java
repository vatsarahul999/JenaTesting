package com.jena.demo.RDFEng;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.jena.demo.RDFProject.RDFMaker;
import com.jena.demo.RDFProperties.RDFProperties;
import com.jena.demo.RDFProperties.RDFProperty;

public class RDFEng {

	List<String> plist;
	List<RDFProperties> prop;
	List<RDFMaker> rmaker;

	public RDFEng() {
		this.plist = new ArrayList<String>();
		this.prop = new ArrayList<RDFProperties>();
		this.rmaker = new ArrayList<RDFMaker>();
	}

	void MakeProperties() {
		Path path = FileSystems.getDefault()
				.getPath("C:\\Users\\Rahul\\Hinspector2\\New folder\\RDFProject\\resources\\property.txt");
		try {
			this.plist = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String h:plist){
			RDFProperties t = new RDFProperty(h);
			prop.add(t);	
		}
	}
	

	public static void main(String[] args) {
	RDFEng eng = new RDFEng();
	eng.MakeProperties();
	eng.execute();

	}

	private void execute() {
		// TODO Auto-generated method stub
		String inputURL = "";
		Path path = FileSystems.getDefault().getPath("C:\\Users\\Rahul\\Hinspector2\\New folder\\RDFProject\\resources\\input");
		List<String> lst = new ArrayList<String>();
		try {
			lst = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String g : lst) {
			RDFMaker t1 = new RDFMaker(inputURL, g,prop);
			rmaker.add(t1);
		}
		for(RDFMaker r123:rmaker){
			r123.makeRDF();
			r123.writeRDF();
		}
		
	}

}
