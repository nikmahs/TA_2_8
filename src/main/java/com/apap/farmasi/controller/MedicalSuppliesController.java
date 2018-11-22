package com.apap.farmasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.farmasi.model.JadwalJagaModel;
import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.repository.MedicalSuppliesDb;
import com.apap.farmasi.service.JadwalService;
import com.apap.farmasi.service.MedicalSuppliesService;

import com.apap.farmasi.model.JadwalJagaModel;

@Controller
@RequestMapping("/medical-supplies")
public class MedicalSuppliesController {
//	@Autowired MedicalSuppliesService medicalSuppliesService;
	
//	@Autowired	private JadwalService jadwalService;
	/**
	 * fitur 3 melihat daftar medical supplies
	 * @param model
	 * @return tampilan daftar seluruh medical supplies
	 */	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	private String viewAllDaftarMedicalSupplies(Model model) {
//		MedicalSuppliesDb medsupRepo = medicalSuppliesService.viewAllDaftarMedicalSupplies();
//		List<MedicalSuppliesModel> allMedSup = medsupRepo.findAll();
//		model.addAttribute("allMedSup", allMedSup);
//		
//		return "view-all-medical-supplies";
//	}

	@RequestMapping(value = "/perencanaan", method = RequestMethod.GET)
	private String viewPerencanaan(Model model) {
		return "view-perencanaan";
	}
	

//	//TAMBAH JADWAL BARU
//		@RequestMapping(value = "/medical-supplies/jadwal-staf/tambah", method = RequestMethod.GET)
//		private String add(Model model) {
//			model.addAttribute("jadwal", new JadwalJagaModel());
//			return "addNewJadwal";
//		}
//		
//		//HARUSNYA BIAR BISA TAMBAH DICEK DULU PADA TANGGAL DAN WAKTU TERSEBUT TERSEDIA ATAU ENGGA
//		@RequestMapping(value = "/medical-supplies/jadwal-staf/", method = RequestMethod.POST)
//		private String addNewJadwalSubmit(@ModelAttribute JadwalJagaModel jadwal, Model model) {
//			jadwalService.addJadwal(jadwal);
//			model.addAttribute("tanggal", jadwal.getTanggal());
//			return "addNewJadwalSuccess";
//		}
//		
//		//UBAH JADWAL Jadwal staf apoteker jaga tidak bisa diubah jika tanggalnya sudah lewat
//		@RequestMapping(value = "/medical-supplies/jadwal-staf/{idJadwaL}", method = RequestMethod.GET)
//		private String updateJadwal(@PathVariable(value = "idJadwal") String idJadwal, Model model) {
//			JadwalJagaModel jadwal = JadwalService.getJadwalDetailById(Long.parseLong(idJadwal));
//			model.addAttribute("jadwal", jadwal);
//			model.addAttribute("newJadwal", new JadwalJagaModel());
//			return "updateJadwal";
//		}
//		
//		@RequestMapping(value = "/jabatan/update/{id_jabatan}", method = RequestMethod.POST)
//		private String updateJadwalSubmit(@ModelAttribute JadwalJagaModel newJadwal, 
//			@PathVariable(value = "idJadwal") String idJadwal, Model model) {
//			JadwalService.updateJadwal(Long.parseLong(idJadwal), newJadwal);
//			model.addAttribute("id", newJadwal.getId());
//			return "updateJadwalSuccess";
//		}

}
