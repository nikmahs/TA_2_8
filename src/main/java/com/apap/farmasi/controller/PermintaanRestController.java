package com.apap.farmasi.controller;

import com.apap.farmasi.repository.*;
import com.apap.farmasi.model.*;
import com.apap.farmasi.rest.*;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

import com.apap.farmasi.model.JadwalJagaModel;
import com.apap.farmasi.model.PermintaanModel;
import com.apap.farmasi.repository.JadwalJagaDb;
import com.apap.farmasi.repository.PermintaanDb;
import com.apap.farmasi.repository.StatusPermintaanDb;
import com.apap.farmasi.rest.BaseResponse;
import com.apap.farmasi.service.PermintaanService;

@RestController
public class PermintaanRestController {
	
	@Autowired
	private PermintaanService permintaanService;
	
	@Autowired
	private StatusPermintaanDb statusPermintaanDb;
	
	@Autowired
	private PermintaanMedicalSuppliesDb permintaanMedicalSuppliesDb;
	
	@Autowired
	private JadwalJagaDb jadwalJagaDb;
	
	@Autowired
	private MedicalSuppliesDb medicalSuppliesDb;
	
	@Autowired
	private PermintaanDb permintaanDb;

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	@PostMapping(value="/api/medical-supplies/permintaan")
	private BaseResponse<PermintaanModel> addPermintaanSubmit(
												@RequestBody PermintaanModel permintaan,
												BindingResult bindingresult) {
		BaseResponse<PermintaanModel> response = new BaseResponse<PermintaanModel>();
		
		if(permintaan.getJumlahMedicalSupplies() == 0 ||
		   permintaan.getIdPasien() == 0 ||
		   permintaan.getListPermintaanMedicalSupplies() == null) {
			response.setMessage("error data");
			response.setResult(null);
			response.setStatus(500);
		}
		else {	
			//date func
			DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
			Calendar today = Calendar.getInstance();
			df.setTimeZone(today.getTimeZone());
			Date tanggalMasuk = new Date(today.getTimeInMillis()); 
			String todayStr = df.format(today.getTime());
			String[] todaySplit = todayStr.split("-");
			String todayTahun = todaySplit[0];
			String todayBulan = todaySplit[1];
			String todayTanggal = todaySplit[2];
			
			//jadwal func
			int jamMasuk = today.get(Calendar.HOUR);
			
			List<JadwalJagaModel> allJadwal = jadwalJagaDb.findAll();
			JadwalJagaModel jadwalDipakai = null;
	
			//cari tanggal hari ini
			for (JadwalJagaModel jadwalTemp : allJadwal) {
				Date tempJadwalDate = jadwalTemp.getTanggal();
				Time waktuJadwalMulai = jadwalTemp.getWaktuMulai();
				
				String waktuJadwalMulaiStr = waktuJadwalMulai.toString();
				waktuJadwalMulaiStr = waktuJadwalMulaiStr.substring(0,2);
				int waktuJadwalMulaiInt = Integer.parseInt(waktuJadwalMulaiStr);
	
				String jadwalDateStr = df.format(tempJadwalDate);
				String[] splitJadwalDateStr = jadwalDateStr.split("-");
				String jadwalDateTahun = splitJadwalDateStr[0];
				String jadwalDateBulan = splitJadwalDateStr[1];
				String jadwalDateTanggal = splitJadwalDateStr[2];
				
				
				
				if (todayTanggal.equals(jadwalDateTanggal) &&
					todayBulan.equals(jadwalDateBulan) &&
					todayTahun.equals(jadwalDateTahun)){
						
					if(today.get(Calendar.HOUR_OF_DAY)>=0 && 
					   today.get(Calendar.HOUR_OF_DAY)<16 &&
					    waktuJadwalMulaiInt == 8) {
						jadwalDipakai = jadwalTemp;
					}
					else if(today.get(Calendar.HOUR_OF_DAY)>=16 && 
						today.get(Calendar.HOUR_OF_DAY)<=24 &&
						waktuJadwalMulaiInt == 16) {
						jadwalDipakai = jadwalTemp;
					}
				}			
			}
					
			List<PermintaanMedicalSuppliesModel> tempPMSMlst = permintaan.getListPermintaanMedicalSupplies();
			List<PermintaanMedicalSuppliesModel> PMSMAkhir = new ArrayList();
			
			//buat list permintaan
	
			for(PermintaanMedicalSuppliesModel masukKeDb : tempPMSMlst) {
				PermintaanMedicalSuppliesModel tempIterasi = masukKeDb;
				//cari obat dari nama
				MedicalSuppliesModel tempObat = medicalSuppliesDb.findByNama(masukKeDb.getMedicalSupplies().getNama());
	
				//save ke db PMSM
				masukKeDb.setMedicalSupplies(tempObat);
				
				//masukin PSMS yang udah bener ke list buat permintaan
				PMSMAkhir.add(masukKeDb);
			}
			
			
			
			permintaan.setJadwalJaga(jadwalDipakai);
			permintaan.setTanggal(tanggalMasuk);
			permintaan.setListPermintaanMedicalSupplies(PMSMAkhir);
			permintaan.setStatusPermintaan(statusPermintaanDb.findById(1).get());
			permintaanDb.save(permintaan);
			
			//save ke tabel antara
			for (int i = 0;i < permintaan.getListPermintaanMedicalSupplies().size();i++) {
				PermintaanMedicalSuppliesModel temp =permintaan.getListPermintaanMedicalSupplies().get(i);
				temp.setPermintaan(permintaan);
				permintaanMedicalSuppliesDb.save(temp);
			}
			
			response.setStatus(200);
			response.setMessage("success");	
			response.setResult(permintaan);
		}
		return response;
	}
	

}
