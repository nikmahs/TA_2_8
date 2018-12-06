package com.apap.farmasi.rest;

import java.util.List;
import com.apap.farmasi.rest.PasienModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//data yang didapat itu json terus langsung diparsing ke java -ka gitta

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingDetail {
	
	private long id;
	
	private int jumlahTagihan;
	
	private String tanggalTagihan;
	
	private PasienModel pasien;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getJumlahTagihan() {
		return jumlahTagihan;
	}

	public void setJumlahTagihan(int jumlahTagihan) {
		this.jumlahTagihan = jumlahTagihan;
	}

	public String getTanggalTagihan() {
		return tanggalTagihan;
	}

	public void setTanggalTagihan(String tanggalTagihan) {
		this.tanggalTagihan = tanggalTagihan;
	}

	public PasienModel getPasien() {
		return pasien;
	}

	public void setPasien(PasienModel pasien) {
		this.pasien = pasien;
	}
	
	
}
