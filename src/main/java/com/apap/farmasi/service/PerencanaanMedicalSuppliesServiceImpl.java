package com.apap.farmasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.farmasi.model.PerencanaanMedicalSuppliesModel;
import com.apap.farmasi.repository.PerencanaanMedicalSuppliesDb;


@Service
public class PerencanaanMedicalSuppliesServiceImpl implements PerencanaanMedicalSuppliesService {

	@Autowired
	private PerencanaanMedicalSuppliesDb perencanaanMedsupDb;
	
	@Override
	public void addPerencanaanMedsup(PerencanaanMedicalSuppliesModel perencanaanMedsup) {
		perencanaanMedsupDb.save(perencanaanMedsup);
	}
}
