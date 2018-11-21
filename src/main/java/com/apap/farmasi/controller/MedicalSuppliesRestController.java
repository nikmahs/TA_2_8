package com.apap.farmasi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.apap.farmasi.service.MedicalSuppliesService;

@RestController
public class MedicalSuppliesRestController {
	@Autowired
	private MedicalSuppliesService medicalSuppliesService;
}
