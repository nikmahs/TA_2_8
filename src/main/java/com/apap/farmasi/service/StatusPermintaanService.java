package com.apap.farmasi.service;

import java.util.List;
import java.util.Optional;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.model.StatusPermintaanModel;

public interface StatusPermintaanService {
	List<StatusPermintaanModel> getAllPermintaan();
	StatusPermintaanModel getStatusPermintaanDetailById(int id);


}
