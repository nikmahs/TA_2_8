package com.apap.farmasi.service;

import java.util.List;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;

public interface MedicalSuppliesService {

	MedicalSuppliesDb viewAllDaftarMedicalSupplies();
	MedicalSuppliesModel getMedicalSuppliesDetailById(long id);
}
