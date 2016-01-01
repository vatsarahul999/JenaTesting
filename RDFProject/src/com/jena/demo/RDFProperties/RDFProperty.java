package com.jena.demo.RDFProperties;

public class RDFProperty implements RDFProperties

{

	String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public RDFProperty(String property) {
		super();
		this.property = property;
	}

}
