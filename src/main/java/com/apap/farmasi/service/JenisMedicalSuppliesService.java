package com.apap.farmasi.service;

import java.util.List;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;

public interface JenisMedicalSuppliesService {
	JenisMedicalSuppliesModel getJenisMedicalSuppliesById(long id);
	List<JenisMedicalSuppliesModel> getAllJenisMedicalSuppliesById();
}
