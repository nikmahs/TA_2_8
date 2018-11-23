package com.apap.farmasi.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.farmasi.model.StatusPermintaanModel;
import com.apap.farmasi.repository.StatusPermintaanDb;

@Service
public class StatusPermintaanServiceImpl implements StatusPermintaanService {

	@Autowired
	StatusPermintaanDb statusPermintaanDb;
	
	@Override
	public List<StatusPermintaanModel> getAllPermintaan() {
		return statusPermintaanDb.findAll();		

	}

}
