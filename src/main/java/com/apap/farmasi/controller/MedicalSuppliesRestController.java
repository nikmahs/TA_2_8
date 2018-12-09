package com.apap.farmasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.model.PermintaanModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;
import com.apap.farmasi.rest.BaseResponse;
import com.apap.farmasi.service.MedicalSuppliesService;

@RestController
public class MedicalSuppliesRestController {
	
	@Autowired
	private MedicalSuppliesService medicalSuppliesService;
	
	@GetMapping(value="/api/daftar-medical-service")
	private BaseResponse<List<MedicalSuppliesModel>> getAllMedicalSupplies() {
		BaseResponse<List<MedicalSuppliesModel>> response = new BaseResponse<List<MedicalSuppliesModel>>();

		List<MedicalSuppliesModel> allMedSup = medicalSuppliesService.viewAllDaftarMedicalSupplies();
		if(!allMedSup.isEmpty()) {
			response.setStatus(200);
			response.setMessage("success");
			response.setResult(allMedSup);
		}
		else {
			response.setStatus(404);
			response.setMessage("not found");
		}
		return response;
		}

}
