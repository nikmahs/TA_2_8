package com.apap.farmasi.service;

import java.util.Optional;
import java.util.List;

import com.apap.farmasi.model.PermintaanModel;

public interface PermintaanService {
	Optional<PermintaanModel> getPermintaanDetailById(Long id);
	List<PermintaanModel> getPermintaanList();
	void addPermintaan(PermintaanModel permintaan);
}
