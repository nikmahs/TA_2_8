package com.apap.farmasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;

@Repository
public interface JenisMedicalSuppliesDb {
	JenisMedicalSuppliesModel findById(long id);
}
