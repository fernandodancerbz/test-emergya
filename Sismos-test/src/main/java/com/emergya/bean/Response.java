package com.emergya.bean;

import java.util.ArrayList;


public class Response {
	private String type;
	private Metadata metadata = new Metadata();
	private ArrayList<Features> features = new ArrayList<Features>();
	

	public Response() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public ArrayList<Features> getFeatures() {
		return features;
	}
	public void setFeatures(ArrayList<Features> features) {
		this.features = features;
	}
	
	
	
	

}
