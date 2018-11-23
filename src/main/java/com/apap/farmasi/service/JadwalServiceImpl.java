package com.apap.farmasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.farmasi.model.JadwalJagaModel;
import com.apap.farmasi.repository.JadwalJagaDb;

@Service
@Transactional
public class JadwalServiceImpl implements JadwalService{

	@Autowired
	JadwalJagaDb jadwalJagaDb;
	
	
	@Override
	public List<JadwalJagaModel> findAllJadwal() {
		return jadwalJagaDb.findAll();
	}

	@Override
	public void addJadwal(JadwalJagaModel jadwal) {
		jadwalJagaDb.save(jadwal);
		
	}

	@Override
	public JadwalJagaModel getJadwalDetailById(long parseLong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateJadwalJaga(long parseLong, JadwalJagaModel newJadwal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJadwal(long parseLong, JadwalJagaModel newJadwal) {
		// TODO Auto-generated method stub
		
	}

}
