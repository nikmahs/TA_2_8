package com.apap.farmasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.farmasi.repository.MedicalSuppliesDb;

@Service
@Transactional
public class MedicalSuppliesServiceImpl implements MedicalSuppliesService {
	@Autowired 
	private MedicalSuppliesDb medicalSuppliesDb;

	@Override
	public MedicalSuppliesDb viewAllDaftarMedicalSupplies() {
		return medicalSuppliesDb;
	}
	
}
