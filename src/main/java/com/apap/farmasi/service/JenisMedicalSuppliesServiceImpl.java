package com.apap.farmasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;
import com.apap.farmasi.repository.JenisMedicalSuppliesDb;

@Service
@Transactional
public class JenisMedicalSuppliesServiceImpl implements JenisMedicalSuppliesService {
	@Autowired
	private JenisMedicalSuppliesDb jenisMedicalSuppliesDb;
	
	@Override
	public JenisMedicalSuppliesModel getJenisMedicalSuppliesById(long id) {
		return jenisMedicalSuppliesDb.findById(id);
	}

	@Override
	public List<JenisMedicalSuppliesModel> getAllJenisMedicalSuppliesById() {
		return jenisMedicalSuppliesDb.findAll();
	}
}
