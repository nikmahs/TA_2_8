package com.apap.farmasi.service;

import java.util.List;
import java.util.Optional;

import com.apap.farmasi.model.PermintaanModel;
import com.apap.farmasi.repository.PermintaanDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermintaanServiceImpl implements PermintaanService{

	@Autowired
	private PermintaanDb permintaanDb;
	
	@Override
	public Optional<PermintaanModel> getDealerDetailById(Long id) {		
		return permintaanDb.findById(id);
	}

	@Override
	public List<PermintaanModel> getPermintaanList() {
		return permintaanDb.findAll();
	}

	@Override
	public void addPermintaan(PermintaanModel permintaan) {
		permintaanDb.save(permintaan);
		
	}

}
