package com.apap.farmasi.rest;

public class BillingResponse {
	private int status;
	private String message;
	private BillingDetail result;
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
	public BillingDetail getResult() {
		return result;
	}
	public void setResult(BillingDetail result) {
		this.result = result;
	}
	
	

}
