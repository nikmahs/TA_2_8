package com.apap.farmasi.service;

import java.util.List;

import com.apap.farmasi.model.JadwalJagaModel;

public interface JadwalService {

	List<JadwalJagaModel> findAllJadwal();

	void addJadwal(JadwalJagaModel jadwal);

	JadwalJagaModel getJadwalDetailById(long parseLong);

	void updateJadwalJaga(long parseLong, JadwalJagaModel newJadwal);

	void updateJadwal(long parseLong, JadwalJagaModel newJadwal);
}
