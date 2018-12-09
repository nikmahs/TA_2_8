package com.apap.farmasi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.farmasi.model.PerencanaanModel;
import com.apap.farmasi.repository.PerencanaanDb;

@Service
public class PerencanaanServiceImpl implements PerencanaanService {

	@Autowired
	private PerencanaanDb perencanaanDb;
	
	@Override
	public Optional<PerencanaanModel> getPerencanaanDetailById(long id) {
		return perencanaanDb.findById(id);
	}
	
	@Override
	public List<PerencanaanModel> getAllPerencanaan() {
		return perencanaanDb.findAll();
	}
	
	@Override
	public void addPerencanaan(PerencanaanModel perencanaan) {
		perencanaanDb.save(perencanaan);
	}
}
