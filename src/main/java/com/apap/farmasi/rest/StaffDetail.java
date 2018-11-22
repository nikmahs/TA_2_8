package com.apap.farmasi.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//data yang didapat itu json terus langsung diparsing ke java -ka gitta

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffDetail {
	
	private int id;
	
	private String nama;
	
	// jenis = 0 -> staff farmasi
	private int jenis;

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

	public int getJenis() {
		return jenis;
	}

	public void setJenis(int jenis) {
		this.jenis = jenis;
	}
	
	
	
	/*
	 * TODO:
	 * 1. Buat StaffModel yg isinya status, message, result
	 * 2. Buat StaffDetail yg isinya id, nama, jenis
	 * 3. Buat method untuk mengambil data staff di SI Appointment
	 */
}
