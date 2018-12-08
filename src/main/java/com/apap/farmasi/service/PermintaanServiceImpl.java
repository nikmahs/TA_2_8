package com.apap.farmasi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.model.PermintaanMedicalSuppliesModel;
import com.apap.farmasi.model.PermintaanModel;
import com.apap.farmasi.model.StatusPermintaanModel;
import com.apap.farmasi.repository.PermintaanDb;
import com.apap.farmasi.repository.MedicalSuppliesDb;
import com.apap.farmasi.repository.StatusPermintaanDb;
import com.apap.farmasi.rest.BillingDetail;
import com.apap.farmasi.rest.PasienModel;
import com.apap.farmasi.rest.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class PermintaanServiceImpl implements PermintaanService{

	@Autowired
	private PermintaanDb permintaanDb;

	@Autowired
	private MedicalSuppliesDb medicalSuppliesDb;

	@Autowired
	private StatusPermintaanDb statusPermintaanDb;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	
	@Override
	public Optional<PermintaanModel> getPermintaanDetailById(Long id) {		
		return permintaanDb.findById(id);
	}

	@Override
	public List<PermintaanModel> getPermintaanList() {
		return permintaanDb.findAll();
	}

	@Override
	public void addPermintaan(PermintaanModel permintaan) {
		permintaanDb.save(permintaan);
		
	}

	@Override
	public String postBilling(PermintaanModel targetPermintaan) {
		
		List<MedicalSuppliesModel> targetMedSuplst = new ArrayList<MedicalSuppliesModel>();
		
		String finalResponse = "";
		
		//cek cukup ato ga
		for (PermintaanMedicalSuppliesModel temp : targetPermintaan.getListPermintaanMedicalSupplies()) {
			MedicalSuppliesModel medSupIterasi = temp.getMedicalSupplies();
			MedicalSuppliesModel medSupDiDb = medicalSuppliesDb.findById(medSupIterasi.getId());
			
			targetMedSuplst.add(medSupIterasi);
			if(targetPermintaan.getJumlahMedicalSupplies() > medSupDiDb.getJumlah()) {
				return "gagal";
			}
			
		}
		//ngurangin di db, bikin billing
		List<BillingDetail> billinglst = new ArrayList<BillingDetail>();
		int jumlahDipesan = (int)targetPermintaan.getJumlahMedicalSupplies();
		for (MedicalSuppliesModel temp : targetMedSuplst) {
			MedicalSuppliesModel medSupDiDb = medicalSuppliesDb.findById(temp.getId());
			int jumlahBaru = medSupDiDb.getJumlah()-jumlahDipesan;
			
			medSupDiDb.setJumlah(jumlahBaru);
			
			medicalSuppliesDb.save(medSupDiDb);

			BillingDetail billingTemp = new BillingDetail();
			PasienModel pasienTarget = new PasienModel();
			pasienTarget.setId(targetPermintaan.getIdPasien());
			billingTemp.setPasien(pasienTarget);
			billingTemp.setJumlahTagihan((int)medSupDiDb.getPrice()*jumlahDipesan);
			billingTemp.setTanggalTagihan(targetPermintaan.getTanggal().toString());
			billinglst.add(billingTemp);
		}
		//kirim billing
		RestTemplate rt = rest();
		List<String> responselst = new ArrayList<>();
		int responseCounter = 0;
		String path = Setting.urlApt + "/2/addBilling";
		System.out.println(path);
		for(BillingDetail temp : billinglst) {			
			System.out.print(temp.getJumlahTagihan() + " ");
			System.out.print(temp.getTanggalTagihan().toString() + " ");
			System.out.println(temp.getPasien());

			RestTemplate template = new RestTemplate();
			HttpEntity<BillingDetail> requestEntity= new HttpEntity<BillingDetail>(temp);
			System.out.println(requestEntity.toString());
			String response = "";
		    try{
		       ResponseEntity<String> responseEntity = template.exchange(path, HttpMethod.POST, requestEntity,  String.class);
		       response = responseEntity.getBody();
		    }
		    catch(Exception e){
		       response = e.getMessage();
		    }
		    responselst.add(response);
		    
			System.out.println(response);
			
			
		}
		
		//masukin string response ke response final
		for(String temp : responselst ) {
			finalResponse = finalResponse + temp + " ";
		}

		
//		StatusPermintaanModel diterima = statusPermintaanDb.findById(2).get();
//		targetPermintaan.setStatusPermintaan(diterima);
		permintaanDb.save(targetPermintaan);

		return finalResponse;
	}

}
