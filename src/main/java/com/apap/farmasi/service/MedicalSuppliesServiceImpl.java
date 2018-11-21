package com.apap.farmasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;

@Service
@Transactional
public class MedicalSuppliesServiceImpl implements MedicalSuppliesService {
	@Autowired 
	private MedicalSuppliesDb medicalSuppliesDb;

//	@Override
//	public MedicalSuppliesDb viewAllDaftarMedicalSupplies() {
//		return medicalSuppliesDb;
//	}
	
	@Override
	public List<MedicalSuppliesModel>  viewAllDaftarMedicalSupplies() {
		return medicalSuppliesDb.findAll();
	}

	@Override
	public MedicalSuppliesModel getMedicalSuppliesDetailById(long id) {
		return medicalSuppliesDb.findById(id);
	}
	
}
