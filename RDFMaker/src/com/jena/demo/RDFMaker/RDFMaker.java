package com.jena.demo.RDFMaker;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class RDFMaker {
	String resourceURL;
	String FullName;
	Model m;
	Resource r;

	public RDFMaker(String resourceURL, String fullName) {
		super();
		this.resourceURL = resourceURL;
		FullName = fullName;

	}

	public void makeRDF() {
		// TODO Auto-generated method stub
		this.m = ModelFactory.createDefaultModel();
		this.r = m.createResource(this.resourceURL);
		r.addProperty(VCARD.FN, this.FullName);
	}

	public void writeRDF() {
		this.m.write(System.out);
		this.m.write(System.out, "N3");
		this.m.write(System.out, "RDF/XML-ABBREV");
		this.m.write(System.out, "N-TRIPLES");
	}

}
