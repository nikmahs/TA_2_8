package com.apap.farmasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.farmasi.model.MedicalSuppliesModel;

@Repository
public interface MedicalSuppliesDb extends JpaRepository<MedicalSuppliesModel, Long> {

}
