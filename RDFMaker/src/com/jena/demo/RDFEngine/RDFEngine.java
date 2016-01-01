package com.jena.demo.RDFEngine;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jena.demo.RDFMaker.RDFMaker;

public class RDFEngine {
	List<RDFMaker> rdf;

	public RDFEngine() {
		super();
		this.rdf = new ArrayList<RDFMaker>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RDFEngine eng = new RDFEngine();
		eng.readInput();
		eng.execute();
	}

	private void execute() {
		// TODO Auto-generated method stub
		Iterator<RDFMaker> itr = rdf.iterator();
		while (itr.hasNext()) {
			RDFMaker t = itr.next();
			t.makeRDF();
			t.writeRDF();
		}

	}

	public void readInput() {
		Path path = FileSystems.getDefault().getPath("C:\\Users\\Rahul\\Hinspector2\\New folder\\RDFMaker\\resources\\input");
		List<String> lst = new ArrayList<String>();
		try {
			lst = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String g : lst) {
			String[] temp = g.split("#");
			RDFMaker t1 = new RDFMaker(temp[0], temp[1]);
			rdf.add(t1);
		}

	}

}
