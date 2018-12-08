package com.apap.farmasi.service;

import java.util.List;
import java.util.Optional;

import com.apap.farmasi.model.JadwalJagaModel;

public interface JadwalService {

	List<JadwalJagaModel> findAllJadwal();

	void addJadwal(JadwalJagaModel jadwal);

	Optional<JadwalJagaModel> getJadwalDetailById(long parseLong);
	
	JadwalJagaModel updateJadwal(JadwalJagaModel jadwal);

}
