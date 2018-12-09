package com.apap.farmasi.service;

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
	public MedicalSuppliesDb viewAllDaftarMedicalSupplies() {
		return medicalSuppliesDb;
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
		
		String path = Setting.urlMock + "/obat/tambah";

		RestTemplate template = new RestTemplate();
		HttpEntity<ObatModel> requestEntity= new HttpEntity<ObatModel>(obatDikirim);
		System.out.println(requestEntity.toString());
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
		
		System.out.println(response);

		
		return finalResponse;
	}

}
