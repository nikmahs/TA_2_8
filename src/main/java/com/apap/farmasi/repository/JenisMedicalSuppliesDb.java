package com.apap.farmasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;

import antlr.collections.List;

@Repository
public interface JenisMedicalSuppliesDb extends JpaRepository<JenisMedicalSuppliesModel, Long>{
	JenisMedicalSuppliesModel findById(long id);
}
