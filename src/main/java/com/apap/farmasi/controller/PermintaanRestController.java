package com.apap.farmasi.controller;

import com.apap.farmasi.model.*;
import com.apap.farmasi.service.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RestController
public class PermintaanRestController {
	
	@Autowired
	private PermintaanService permintaanService;
	
	@PostMapping(value="/api/medical-supplies/permintaan")
	private PermintaanModel addPermintaanSubmit(@RequestBody PermintaanModel permintaan) {
		System.out.println("masuk" + permintaan.getIdPasien());
		permintaanService.addPermintaan(permintaan);
		
		return permintaan;
	}

}
