package com.jena.demo.RDFProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

import com.jena.demo.RDFProperties.RDFProperties;

public class RDFMaker {
	String resourceURL;
	List<RDFProperties> plist;
	List<String> prop;
	Model m;
	Resource r;

	public RDFMaker(String resourceURL, String input, List<RDFProperties> temp) {
		super();
		this.resourceURL = resourceURL;
		this.plist = temp;
		this.prop = new ArrayList<String>();
		String[] temp1 = input.split("#");
		for (String t : temp1) {
			prop.add(t);
		}

	}

	public void makeRDF() {
		// TODO Auto-generated method stub
		this.m = ModelFactory.createDefaultModel();
		this.r = m.createResource(this.resourceURL);
		Iterator<String> itr = prop.iterator();
		for (@SuppressWarnings("unused")
		RDFProperties r1 : plist) {
			r.addProperty(VCARD.FN, itr.next());
		}
	}

	public void writeRDF() {
		this.m.write(System.out, "N3");
		this.m.write(System.out, "N-TRIPLES");
	}

}
