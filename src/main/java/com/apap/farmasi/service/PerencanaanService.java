package com.apap.farmasi.service;

import java.util.List;
import java.util.Optional;

import com.apap.farmasi.model.PerencanaanModel;

public interface PerencanaanService {
	Optional<PerencanaanModel> getPerencanaanDetailById(long id);
	
	List<PerencanaanModel> getAllPerencanaan();
	
	void addPerencanaan(PerencanaanModel perencanaan);
}
