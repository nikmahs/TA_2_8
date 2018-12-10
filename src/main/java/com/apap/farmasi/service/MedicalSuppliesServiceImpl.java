package com.apap.farmasi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;
import com.apap.farmasi.rest.ObatModel;
import com.apap.farmasi.rest.Setting;

@Service
@Transactional
public class MedicalSuppliesServiceImpl implements MedicalSuppliesService { 
	@Autowired 
	private MedicalSuppliesDb medicalSuppliesDb;

	@Override
	public List<MedicalSuppliesModel> viewAllDaftarMedicalSupplies() {
		return medicalSuppliesDb.findAll();
	}
	
	@Override
	public List<MedicalSuppliesModel> getAllMedsupByDate(Date date, List<MedicalSuppliesModel> listMedsup) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		// if week 1 or 3
		if (day < 7 || (day > 13 && day < 21)) {
			return medicalSuppliesDb.findAll();
		}
		else {
			List<MedicalSuppliesModel> newList = new ArrayList<MedicalSuppliesModel>();
			
			for (MedicalSuppliesModel medsup : listMedsup) {
				// if medsup is urgent
				if (medsup.getJenisMedicalSupplies().getIdUrgent().getFlag() == 1) {
					newList.add(medsup);
				}
			}
			return newList;
		}
	}

	@Override
	public MedicalSuppliesModel getMedicalSuppliesDetailById(long id) {
		return medicalSuppliesDb.findById(id);
	}

	@Override
	public void addMedsup(MedicalSuppliesModel medsup) {
		medicalSuppliesDb.save(medsup);
	}
	@Override
	public String kirimKeRawatJalan(MedicalSuppliesModel target,int jumlahDitambah) {
		String finalResponse = "";
		
		ObatModel obatDikirim = new ObatModel();
		obatDikirim.setJumlah(jumlahDitambah);
		obatDikirim.setNama(target.getNama());
		obatDikirim.setId(target.getId());
		
		String path = Setting.urlRawatJalan + "/rawat-jalan/obat/tambah";
		RestTemplate template = new RestTemplate();
		HttpEntity<ObatModel> requestEntity= new HttpEntity<ObatModel>(obatDikirim);
//		System.out.println(requestEntity.toString());
		String response = "";

		System.out.println(path);
		System.out.println("nama = " + obatDikirim.getNama());
		System.out.println("jumlah = " + obatDikirim.getJumlah());

		
		try{
	       ResponseEntity<String> responseEntity = template.exchange(path, HttpMethod.POST, requestEntity,  String.class);
	       response = responseEntity.getBody();
	    }
	    catch(Exception e){
	       response = e.getMessage();
	    }
		
//		System.out.println(response);
		finalResponse = response;

		
		return finalResponse;
	}

}
