package com.apap.farmasi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//data yang didapat itu json terus langsung diparsing ke java -ka gitta

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffDetail {
	
	private int idStaff;
	
	private String namaStaff;

	
	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int id_staff) {
		this.idStaff = id_staff;
	}

	public String getNamaStaff() {
		return namaStaff;
	}

	public void setNamaStaff(String nama_staff) {
		this.namaStaff = nama_staff;
	}
}
