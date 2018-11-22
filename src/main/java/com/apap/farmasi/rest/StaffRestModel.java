package com.apap.farmasi.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffRestModel {
	
	private int status;
	
	private String message;
	
	private List<StaffDetail> result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<StaffDetail> getResult() {
		return result;
	}

	public void setResult(List<StaffDetail> result) {
		this.result = result;
	}
	
	
}
