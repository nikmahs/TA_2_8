package com.apap.farmasi.service;

import java.util.Optional;

import com.apap.farmasi.model.PerencanaanModel;

public interface PerencanaanService {
	Optional<PerencanaanModel> getPerencanaanDetailById(long id);
}
