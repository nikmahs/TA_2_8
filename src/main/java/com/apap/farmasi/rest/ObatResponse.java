package com.apap.farmasi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//data yang didapat itu json terus langsung diparsing ke java -ka gitta

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObatResponse {
	
	private int id;
	
	private String nama;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	
	
	
}
