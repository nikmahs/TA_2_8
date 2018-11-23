package com.apap.farmasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;
import com.apap.farmasi.rest.BaseResponse;
import com.apap.farmasi.service.MedicalSuppliesService;

@RestController
public class MedicalSuppliesRestController {
	
	@Autowired
	private MedicalSuppliesService medicalSuppliesService;
	
	@GetMapping(value="/api/daftar-medical-service")
	private List<MedicalSuppliesModel> getAllMedicalSupplies(){
		MedicalSuppliesDb medsupRepo = medicalSuppliesService.viewAllDaftarMedicalSupplies();
		List<MedicalSuppliesModel> allMedSup = medsupRepo.findAll();
		return allMedSup;
	}
}
