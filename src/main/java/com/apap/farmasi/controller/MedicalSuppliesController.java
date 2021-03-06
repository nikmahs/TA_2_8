package com.apap.farmasi.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.apap.farmasi.model.JadwalJagaModel;
import com.apap.farmasi.model.JenisMedicalSuppliesModel;
import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.model.PerencanaanMedicalSuppliesModel;
import com.apap.farmasi.model.PerencanaanModel;
import com.apap.farmasi.model.PermintaanModel;
import com.apap.farmasi.model.StatusPermintaanModel;
import com.apap.farmasi.rest.StaffDetail;
import com.apap.farmasi.service.JadwalService;
import com.apap.farmasi.service.JenisMedicalSuppliesService;
import com.apap.farmasi.service.MedicalSuppliesService;
import com.apap.farmasi.service.PerencanaanMedicalSuppliesService;
//import com.apap.farmasi.service.PerencanaanMedicalSuppliesService;
import com.apap.farmasi.service.PerencanaanService;
import com.apap.farmasi.service.PermintaanService;
import com.apap.farmasi.service.RestService;
import com.apap.farmasi.service.StatusPermintaanService;
//import com.apap.farmasi.model.JadwalJagaModel;


@Controller
@RequestMapping("/medical-supplies")
public class MedicalSuppliesController {

	@Autowired 
	private MedicalSuppliesService medicalSuppliesService;
	
	@Autowired 
	private PermintaanService permintaanService;
	
	@Autowired
	private PerencanaanService perencanaanService;
	
	@Autowired 
	private RestService restService;

	@Autowired
	private StatusPermintaanService statusPermintaanService;
	
	@Autowired 
	private JadwalService jadwalService;
	
	@Autowired
	private PerencanaanMedicalSuppliesService perencanaanMedsupService;

	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	
	
	@Autowired
	private JenisMedicalSuppliesService jenisMedicalSuppliesService;
	
	/**
	 * fitur 3 melihat daftar medical supplies
	 * @param model
	 * @return tampilan daftar seluruh medical supplies
	 */	
	@RequestMapping(value = "", method = RequestMethod.GET)
	private String viewAllDaftarMedicalSupplies(Model model) {
		List<MedicalSuppliesModel> allMedSup = medicalSuppliesService.viewAllDaftarMedicalSupplies();

		if (!allMedSup.isEmpty()) {
			model.addAttribute("allMedSup", allMedSup);
			
			return "view-all-medical-supplies";
		}
		return "medsup-kosong";

	}
	
	/**
	 * fitur 5 melihat detail medical supplies
	 * @param id, model
	 * @return tampilan detail medical supplies
	 */	
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	private String detailMedicalSupplies(@PathVariable (value = "id") long id, Model model) {
		MedicalSuppliesModel medsup = medicalSuppliesService.getMedicalSuppliesDetailById(id);
		model.addAttribute("medsup", medsup);

		return "view-detail-medical-supplies";
	}
	
//	/**
//	 * Mengecek apakah medical supplies yang akan direncanakan untuk dibeli valid atau tidak.
//	 * @param idMedsup 	: id medical supplies yang direncanakan untuk dibeli
//	 * @param date 		: waktu yang dipilih untuk merencanakan pembelian medical supplies
//	 * @param model
//	 * @return status valid atau tidaknya medical supplies yang direncanakan untuk dibeli
//	 */
//	@RequestMapping(value = "/getById", method = RequestMethod.GET)
//	@ResponseBody
//	private boolean isMedsupValid(	@RequestParam(value = "idMedsup", required = true) long idMedsup, 
//									@RequestParam(value = "date", required = true) Date date,
//									Model model) {
//		MedicalSuppliesModel medsup = medicalSuppliesService.getMedicalSuppliesDetailById(idMedsup);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		
//		int day = cal.get(Calendar.DAY_OF_MONTH);
//		
//		// flagUrgent = 0  --> NON URGENT
//		if (medsup.getJenisMedicalSupplies().getIdUrgent().getFlag() == 0) {
//			if (day < 7 || (day > 13 && day < 21)) {
//				return true;
//			}
//			return false;
//		}
//		return true;
//	}
	
	@RequestMapping(value = "/getListMedsupByDate", method = RequestMethod.GET)
	@ResponseBody
	private List<MedicalSuppliesModel> getListMedsupByDate(@RequestParam(value = "date", required = true) Date date, Model model) {
		
		List<MedicalSuppliesModel> listMedsup = medicalSuppliesService.viewAllDaftarMedicalSupplies();
		
		List<MedicalSuppliesModel> newList = medicalSuppliesService.getAllMedsupByDate(date, listMedsup);
		
		return newList;
	}
	
	/**
	 * fitur 6 menambahkan medical supplies
	 * @param medsup, model
	 * @return tampilan form menambahkan medical supplies
	 */	
	@RequestMapping(value = "/tambah", method = RequestMethod.POST)
	private String addMedsupSubmission(@ModelAttribute MedicalSuppliesModel medsup, Model model) {
		if (medsup.getPrice() != 0) {
			medicalSuppliesService.addMedsup(medsup);
			model.addAttribute("msg", "Berhasil ditambahkan");
			return "success";
		}
		model.addAttribute("msg", "Harga tidak bisa bernilai nol");
		return "gagal";
	}
	
	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	private String addMedsup(Model model) {
		model.addAttribute("medsup", new MedicalSuppliesModel());
		List<JenisMedicalSuppliesModel> listJenis = jenisMedicalSuppliesService.getAllJenisMedicalSuppliesById();
		model.addAttribute("listJenis", listJenis);
		return "add-medsup";
	}
	
	/**
	 * fitur 7 mengubah medical supplies
	 * @param medsup, model
	 * @return tampilan form mengubah medical supplies
	 */	
	@RequestMapping(value = "/ubah", method = RequestMethod.POST)
	private String updateMedsupSubmission(@ModelAttribute MedicalSuppliesModel medsup, Model model) {
		medicalSuppliesService.addMedsup(medsup);
		model.addAttribute("msg", "Berhasil diperbaharui");
		return "success";
	}
	
	@RequestMapping(value = "/ubah/{id}", method = RequestMethod.GET)
	private String updateMedsup(@PathVariable (value = "id") long id, Model model) {
		MedicalSuppliesModel medsup = medicalSuppliesService.getMedicalSuppliesDetailById(id);
		model.addAttribute("medsup", medsup);
		List<JenisMedicalSuppliesModel> listJenis = jenisMedicalSuppliesService.getAllJenisMedicalSuppliesById();
		model.addAttribute("listJenis", listJenis);
		return "update-medical-supplies";
	}
	
	@RequestMapping(value = "/perencanaan", method = RequestMethod.GET)
	private String viewPerencanaan(Model model) {
		List<PerencanaanModel> listPerencanaan = perencanaanService.getAllPerencanaan();
		
		if (!listPerencanaan.isEmpty()) {
			model.addAttribute("listPerencanaan", listPerencanaan);
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String authority = auth.getAuthorities().iterator().next().getAuthority();
			model.addAttribute("authority", authority);
			
			PerencanaanModel perencanaan = listPerencanaan.get(0);
			model.addAttribute("aPerencanaan", perencanaan);
			
			String status = perencanaan.getStatus();
			model.addAttribute("status", status);
			
			List<PerencanaanMedicalSuppliesModel> listPerencanaanMedicalSupplies = perencanaan.getListPerencanaanMedicalSupplies();
			model.addAttribute("listPerencanaanMedSup", listPerencanaanMedicalSupplies);
			
			return "view-perencanaan";
		}
		
		return "perencanaan-kosong";
	}
	
	@RequestMapping(value = "/perencanaan/getPerencanaanById", method = RequestMethod.GET)
	@ResponseBody
	private PerencanaanModel getPerencanaanById(@RequestParam(value = "idPerencanaan", required = true) long idPerencanaan, Model model) {
		return perencanaanService.getPerencanaanDetailById(idPerencanaan).get();
	}
	
	
	
	@RequestMapping(value = "/perencanaan/tambah", method = RequestMethod.GET)
	private String tambahPerencanaan(Model model) {
		PerencanaanModel newPerencanaan = new PerencanaanModel();
		
		List<PerencanaanMedicalSuppliesModel> listPerencanaanMedsup = new ArrayList<PerencanaanMedicalSuppliesModel>();
		listPerencanaanMedsup.add(new PerencanaanMedicalSuppliesModel());
		model.addAttribute("listPerencanaanMedsup", listPerencanaanMedsup);
		
		newPerencanaan.setListPerencanaanMedicalSupplies(listPerencanaanMedsup);

		model.addAttribute("perencanaan", newPerencanaan);
		
		return "add-perencanaan";
	}
	
	@RequestMapping(value = "/perencanaan/tambah", method = RequestMethod.POST, params={"addRow"})
	private String addRowPerencanaan(@ModelAttribute PerencanaanModel perencanaan, Model model) {
		PerencanaanMedicalSuppliesModel perencanaanMedsup = new PerencanaanMedicalSuppliesModel();
		List<PerencanaanMedicalSuppliesModel> listPerencanaanMedsup = null;
		
		if (perencanaan.getListPerencanaanMedicalSupplies() != null) {
			listPerencanaanMedsup = perencanaan.getListPerencanaanMedicalSupplies();
		}
		else {
			listPerencanaanMedsup = new ArrayList<PerencanaanMedicalSuppliesModel>();
		}
		listPerencanaanMedsup.add(perencanaanMedsup);
		perencanaan.setListPerencanaanMedicalSupplies(listPerencanaanMedsup);
		model.addAttribute("perencanaan", perencanaan);
		
		List<MedicalSuppliesModel> listMedsup = medicalSuppliesService.viewAllDaftarMedicalSupplies();
		model.addAttribute("listMedsup", listMedsup);
		
		return "add-perencanaan";
	}
	
//	@RequestMapping(value = "/perencanaan/tambah", method = RequestMethod.POST, params={"addRow"})
//	@ResponseBody
//	private PerencanaanModel addRowPerencanaan(@RequestParam(value = "idPerencanaan", required = true) long idPerencanaan) {
//		
//		PerencanaanModel perencanaan = perencanaanService.getPerencanaanDetailById(idPerencanaan).get();
//		PerencanaanMedicalSuppliesModel perencanaanMedsup = new PerencanaanMedicalSuppliesModel();
//		List<PerencanaanMedicalSuppliesModel> listPerencanaanMedsup = null;
//		
//		if (perencanaan.getListPerencanaanMedicalSupplies() != null) {
//			listPerencanaanMedsup = perencanaan.getListPerencanaanMedicalSupplies();
//		}
//		else {
//			listPerencanaanMedsup = new ArrayList<PerencanaanMedicalSuppliesModel>();
//		}
//		listPerencanaanMedsup.add(perencanaanMedsup);
//		perencanaan.setListPerencanaanMedicalSupplies(listPerencanaanMedsup);
//		
//		return perencanaan;
//	}
	
	@RequestMapping(value = "/perencanaan/tambah", method = RequestMethod.POST, params= {"removeRow"})
	private String removeRow(@ModelAttribute PerencanaanModel perencanaan, Model model, HttpServletRequest req) {
		Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
		perencanaan.getListPerencanaanMedicalSupplies().remove(rowId.intValue());
		model.addAttribute("perencanaan", perencanaan);
		
		List<MedicalSuppliesModel> listMedsup = medicalSuppliesService.viewAllDaftarMedicalSupplies();
		model.addAttribute("listMedsup", listMedsup);
		
		return "add-perencanaan";
	}
	
	@RequestMapping(value = "/perencanaan/tambah", method = RequestMethod.POST)
	private String tambahPerencanaanSubmit(@ModelAttribute PerencanaanModel perencanaan, Model model) {
		perencanaanService.addPerencanaan(perencanaan);
		
		for (PerencanaanMedicalSuppliesModel perencanaanMedsup : perencanaan.getListPerencanaanMedicalSupplies()) {
			perencanaanMedsup.setPerencanaan(perencanaan);
			perencanaanMedsupService.addPerencanaanMedsup(perencanaanMedsup);
		}
		
		String status = perencanaan.getStatus();
		model.addAttribute("status", status);
		
		List<PerencanaanModel> listPerencanaan = perencanaanService.getAllPerencanaan();
		model.addAttribute("listPerencanaan", listPerencanaan);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String authority = auth.getAuthorities().iterator().next().getAuthority();
		model.addAttribute("authority", authority);
		
		model.addAttribute("aPerencanaan", perencanaan);
		
		List<PerencanaanMedicalSuppliesModel> listPerencanaanMedicalSupplies = perencanaan.getListPerencanaanMedicalSupplies();
		model.addAttribute("listPerencanaanMedSup", listPerencanaanMedicalSupplies);
		
		return "view-perencanaan";
	}
	
//	@RequestMapping(value = "/perencanaan/ubah", method = RequestMethod.POST)
//	@ResponseBody
//	private boolean ubahStatusPerancanaan(@RequestParam(value = "status", required = true) String status, @ModelAttribute PerencanaanModel perencanaan) {
//		
//		// update status perencanaan
//		perencanaan.setStatus(status);
//		perencanaanService.addPerencanaan(perencanaan);
//		
//		MedicalSuppliesModel medSup;
//		int jumlah = 0;
//		
//		for (PerencanaanMedicalSuppliesModel perencanaanMedsup : perencanaan.getListPerencanaanMedicalSupplies()) {
//			
//			medSup = perencanaanMedsup.getMedicalSupplies();
//			jumlah = perencanaanMedsup.getJumlah();
//			medSup.setJumlah(medSup.getJumlah() + jumlah);
//			
//			medicalSuppliesService.addMedsup(medSup);
//			
//			
//		}
//		
//		return true;
//	}
	
	@RequestMapping(value = "/perencanaan/ubah", method = RequestMethod.GET)
	private String ubahStatusPerancanaan(@RequestParam(value = "id", required = true) long id, Model model) {
		
		
		PerencanaanModel perencanaan = perencanaanService.getPerencanaanDetailById(id).get();
		
		
		model.addAttribute("perencanaan", perencanaan);
		
		return "perencanaan-ubah-status";
	}
	
	@RequestMapping(value = "/perencanaan/ubah", method = RequestMethod.POST)
	private String submitUbahStatusPerancanaan(	@RequestParam(value = "status", required = true) String status, 
												@RequestParam(value = "id", required = true) long id,
												Model model) {
		
		//cari perencanaan berd ID 
		PerencanaanModel oldPerencanaan = perencanaanService.getPerencanaanDetailById(id).get();
		
		System.out.println("ID PERENCANAAN: " + id);
		System.out.println("STATUS: " + oldPerencanaan.getStatus());
		
		
		// ganti statusnya 
		oldPerencanaan.setStatus(status);
		oldPerencanaan.setTanggal(oldPerencanaan.getTanggal());
		
		List<PerencanaanMedicalSuppliesModel> lstPerencanaanMedsup = oldPerencanaan.getListPerencanaanMedicalSupplies();
		perencanaanService.addPerencanaan(oldPerencanaan);
		System.out.println("LENGTH LIST: " + oldPerencanaan.getListPerencanaanMedicalSupplies().size());
		
		if (status.equals("tersedia")) {
			MedicalSuppliesModel medSup;
			int jumlah = 0;
			
			for (PerencanaanMedicalSuppliesModel perencanaanMedsup : lstPerencanaanMedsup) {
				
				medSup = perencanaanMedsup.getMedicalSupplies();
				jumlah = perencanaanMedsup.getJumlah();
				medSup.setJumlah(medSup.getJumlah() + jumlah);
				
				medicalSuppliesService.addMedsup(medSup);
			}
		}
		
		List<PerencanaanModel> listPerencanaan = perencanaanService.getAllPerencanaan();
		model.addAttribute("listPerencanaan", listPerencanaan);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String authority = auth.getAuthorities().iterator().next().getAuthority();
		model.addAttribute("authority", authority);
		model.addAttribute("status", status);
		model.addAttribute("aPerencanaan", oldPerencanaan);
		
		
		return "view-perencanaan";
	}

	//kerjaan awl
	//fitur 13
	//lebih ribet daripada yg aing bayangin
	@RequestMapping(value = "/permintaan/ubah/{id}", method = RequestMethod.GET)
	private String terimaPermintaan(@PathVariable(value="id") Long id, Model model) {
		
		PermintaanModel targetPermintaan = permintaanService.getPermintaanDetailById(id).get();
		
		targetPermintaan.setId(id);
		model.addAttribute("permintaan", targetPermintaan);
		List<StatusPermintaanModel> listStatus = statusPermintaanService.getAllPermintaan();
		StatusPermintaanModel untukselect = new StatusPermintaanModel();
		model.addAttribute("statusModel", untukselect);
		model.addAttribute("listStatus",listStatus);
		
		return "gantiStatus";
	}

	
	@RequestMapping(value = "/permintaan/ubah/{id}", method = RequestMethod.POST)
	private String terimaPermintaan(@PathVariable(value="id") Long id,@ModelAttribute StatusPermintaanModel statusDipilih, Model model) {
		
		System.out.println(statusDipilih.getId());
		System.out.println(id);
		
		PermintaanModel targetPermintaan = permintaanService.getPermintaanDetailById(id).get();
		StatusPermintaanModel targetStatus = statusPermintaanService.getStatusPermintaanDetailById(statusDipilih.getId());
		System.out.println(targetStatus.getId());
		//0 = pending
		//1 = diterima
		//2 = ditolak
		if(targetPermintaan.getStatusPermintaan().getNama().equals("pending")) {
			if (targetStatus.getNama().equals("diterima")) {			
				String response = permintaanService.postBilling(targetPermintaan);
				
				if (response.equals("gagal")) {				
					model.addAttribute("message", "Gagal mengubah status");
				}
				else {
					model.addAttribute("message","Berhasil mengubah status dan mengirim billing");
				}
			}
			else {
				targetPermintaan.setStatusPermintaan(targetStatus);
				permintaanService.addPermintaan(targetPermintaan);
				model.addAttribute("message","Berhasil mengubah status");
			}
		}
		else {
			model.addAttribute("message","Gagal mengubah status, permintaan sudah diterima atau ditolak");
		}
		List<StaffDetail> listStaff = restService.getAllStaff().getResult();
		List<PermintaanModel> listPermintaan = permintaanService.getPermintaanList();
		//ditambah awl
		List<StatusPermintaanModel> listStatus = statusPermintaanService.getAllPermintaan();
		StatusPermintaanModel untukselect = new StatusPermintaanModel();
		model.addAttribute("statusModel", untukselect);
		model.addAttribute("listStatus",listStatus);
		model.addAttribute("listPermintaan", listPermintaan);
		model.addAttribute("listStaff", listStaff);

		return "viewall-permintaan";
		
//		if(response.equals("gagal")) {
//			redirectAttributes.addFlashAttribute("message", "Gagal mengubah status");
//			return "redirect:/medical-supplies/permintaan";
//		}
//		else {
//			redirectAttributes.addFlashAttribute("message", "Berhasil mengubah status");		
//			return "redirect:/medical-supplies/permintaan";
//		}
	}
	//fitur 8
	//lebih ribet daripada yg aing bayangin juga
	@RequestMapping(value = "/kirim", method = RequestMethod.POST)
	private String kirimMedSup(@ModelAttribute MedicalSuppliesModel medSup,Model model, RedirectAttributes redirectAttributes) {
		
//		System.out.println("hay aul");
		//inisiasi dan kurangin jumlah
		int jumlahDitambah = medSup.getJumlah();
		MedicalSuppliesModel target = medicalSuppliesService.getMedicalSuppliesDetailById(medSup.getId());
		if(target.getJumlah() < jumlahDitambah || jumlahDitambah == 0) {
			System.out.println("gagal awl");
			redirectAttributes.addFlashAttribute("message", "Jumlah eror");
			return "redirect:/medical-supplies";
		}
		else {
			
	
			String response = medicalSuppliesService.kirimKeRawatJalan(target, jumlahDitambah);
			System.out.println(response);
			if(response.equals("")) {
				redirectAttributes.addFlashAttribute("message", "Tidak dapat konek dengan api rawat jalan");

				return "redirect:/medical-supplies";
			}
			else {
				target.setJumlah(target.getJumlah()-jumlahDitambah);
				medicalSuppliesService.addMedsup(target);
		
				List<MedicalSuppliesModel> allMedSup = medicalSuppliesService.viewAllDaftarMedicalSupplies();
				model.addAttribute("allMedSup", allMedSup);
				redirectAttributes.addFlashAttribute("message", "Berhasil mengirim ke rawat jalan");
				return "redirect:/medical-supplies";				
			}
		}
	}
	
	
	//bukan kerjaan awl lagi
	
	@GetMapping(value = "/permintaan")
	private String viewAllPermintaan(Model model) {
		List<StaffDetail> listStaff = restService.getAllStaff().getResult();
		List<PermintaanModel> listPermintaan = permintaanService.getPermintaanList();
		//ditambah awl
		List<StatusPermintaanModel> listStatus = statusPermintaanService.getAllPermintaan();
		StatusPermintaanModel untukselect = new StatusPermintaanModel();
		model.addAttribute("statusModel", untukselect);
		model.addAttribute("listStatus",listStatus);
		model.addAttribute("listPermintaan", listPermintaan);
		model.addAttribute("listStaff", listStaff);
		return "viewall-permintaan";
	}

		
	//LIHAT JADWAL JAGA
			@RequestMapping(value = "/jadwal-staf", method = RequestMethod.GET)
			private String viewJadwalJaga(Model model) {
				List<JadwalJagaModel> listJadwalJaga = jadwalService.findAllJadwal();
				List<StaffDetail> listStaff = restService.getAllStaff().getResult();
				model.addAttribute("listJadwalJaga", listJadwalJaga);
				model.addAttribute("listStaff", listStaff);
				return "view-jadwal-jaga";
			}
			
		//TAMBAH JADWAL BARU
			@RequestMapping(value = "/jadwal-staf/tambah", method = RequestMethod.GET)
			private String add(Model model) {
				model.addAttribute("jadwal", new JadwalJagaModel());
				List<StaffDetail> listStaff = restService.getAllStaff().getResult();
				model.addAttribute("listStaff", listStaff);
				return "addNewJadwal";
			}	
			@RequestMapping(value = "/jadwal-staf/tambah", method = RequestMethod.POST)
			private String addNewJadwalSubmit(@ModelAttribute JadwalJagaModel jadwal, Model model) {
				jadwalService.addJadwal(jadwal);
				model.addAttribute("msg", "Jadwal Berhasil Ditambah");
				return "success";
			}
		
		//UBAH JADWAL  (tidak bisa diubah jika tanggalnya sudah lewat)
		@RequestMapping(value = "/jadwal-staf/{id}", method = RequestMethod.GET)
		private String updateJadwal(@PathVariable(value="id") long id, Model model) {
			JadwalJagaModel listJadwalJaga = jadwalService.getJadwalDetailById(id).get();
			Date request= listJadwalJaga.getTanggal();
			Date sekarang= new Date(System.currentTimeMillis());
			
			List<StaffDetail> listStaff = restService.getAllStaff().getResult();
			
			if (!listJadwalJaga.getTanggal().after(sekarang)){
				return"invalidUpdate";
			}
			else{
				model.addAttribute("listJadwalJaga", listJadwalJaga);
				model.addAttribute("listStaff", listStaff);
			return "updateJadwal";
			}
		}
		
		@RequestMapping(value = "/jadwal-staf/{idJadwal}", method = RequestMethod.POST)
		private String updateJadwalSubmit(@PathVariable(value = "idJadwal")long idJadwal,@ModelAttribute JadwalJagaModel jadwal, Model model) {
			jadwal.setId(idJadwal);
			jadwalService.updateJadwal(jadwal);
			model.addAttribute("msg", "Jadwal Berhasil Diupdate");
			return "success";
		}
}
