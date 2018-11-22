package com.apap.farmasi.controller;

import com.apap.farmasi.model.*;
import com.apap.farmasi.service.*;
import com.apap.farmasi.repository.*;
import com.apap.farmasi.rest.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

@RestController
public class PermintaanRestController {
	
	
	@Autowired
	private PermintaanService permintaanService;
	
	@Autowired
	private StatusPermintaanDb statusPermintaanDb;
	
	@Autowired
	private JadwalJagaDb jadwalJagaDb;
	
	
	@Autowired
	private PermintaanDb permintaanDb;
	@PostMapping(value="/api/medical-supplies/permintaan")
	private BaseResponse<PermintaanModel> addPermintaanSubmit(
												@RequestBody PermintaanModel permintaan,
												BindingResult bindingresult) {
		BaseResponse<PermintaanModel> response = new BaseResponse<PermintaanModel>();

		//date func
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0); // same for minutes and seconds
		Date tanggalMasuk = new Date(today.getTimeInMillis()); 
		
		//jadwal func
		int jamMasuk = today.get(Calendar.HOUR);
		List<JadwalJagaModel> allJadwal = jadwalJagaDb.findAll();
		System.out.println(allJadwal);
		JadwalJagaModel jadwalDipakai = null;

		//cari tanggal hari ini
		for (JadwalJagaModel jadwalTemp : allJadwal) {
			Date tempJadwalDate = jadwalTemp.getTanggal();
			Time waktuJadwalMulai = jadwalTemp.getWaktuMulai();
			Calendar tempJadwalCal = Calendar.getInstance();
			tempJadwalCal.setTime(tempJadwalDate);
			Calendar tempJadwalMulai = Calendar.getInstance();
			tempJadwalCal.setTime(waktuJadwalMulai);
			System.out.println(today.get(Calendar.DATE));
			System.out.println(today.get(Calendar.MONTH));
			System.out.println(today.get(Calendar.YEAR));
			
			
			if (today.get(Calendar.DATE) == tempJadwalCal.get(Calendar.DATE) &&
				today.get(Calendar.MONTH) == tempJadwalCal.get(Calendar.MONTH) &&
				today.get(Calendar.YEAR) == tempJadwalCal.get(Calendar.YEAR)) {
				
				if(today.get(Calendar.HOUR_OF_DAY)>=0 && 
				   today.get(Calendar.HOUR_OF_DAY)<16 &&
				   tempJadwalMulai.get(Calendar.HOUR_OF_DAY) == 8) {
					jadwalDipakai = jadwalTemp;
					}
				else if(today.get(Calendar.HOUR_OF_DAY)>=16 && 
						today.get(Calendar.HOUR_OF_DAY)<=11 &&
						tempJadwalMulai.get(Calendar.HOUR_OF_DAY) == 16) {
					jadwalDipakai = jadwalTemp;
					
				}
			}
		}
		
		System.out.println("masuk" + permintaan.getIdPasien());
		permintaan.setIdJadwal(jadwalDipakai.getId());
		permintaan.setTanggal(tanggalMasuk);
		permintaan.setStatusPermintaan(statusPermintaanDb.findById(1).get());
		permintaanDb.save(permintaan);
		
		response.setStatus(200);
		response.setMessage("success");	
		response.setResult(permintaan);
		return response;
	}
	

}
