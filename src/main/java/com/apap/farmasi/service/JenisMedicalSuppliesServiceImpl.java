package com.apap.farmasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;
import com.apap.farmasi.repository.JenisMedicalSuppliesDb;

@Service
@Transactional
public class JenisMedicalSuppliesServiceImpl {
	@Autowired
	JenisMedicalSuppliesDb jenisMedicalSuppliesDb;
	
	public JenisMedicalSuppliesModel getJenisMedicalSuppliesDetailById(long id) {
		return jenisMedicalSuppliesDb.findById(id);
	}
}
