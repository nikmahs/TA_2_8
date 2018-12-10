package com.apap.farmasi.service;

import java.sql.Date;
import java.util.List;

import com.apap.farmasi.model.MedicalSuppliesModel;

public interface MedicalSuppliesService {

	List<MedicalSuppliesModel> viewAllDaftarMedicalSupplies();
	List<MedicalSuppliesModel> getAllMedsupByDate(Date date, List<MedicalSuppliesModel> listMedsup);
	
	MedicalSuppliesModel getMedicalSuppliesDetailById(long id);
	public void addMedsup(MedicalSuppliesModel medsup);
	String kirimKeRawatJalan(MedicalSuppliesModel target,int jumlahDitambah);
}
