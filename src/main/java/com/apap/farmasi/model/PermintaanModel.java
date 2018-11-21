package com.apap.farmasi.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.farmasi.model.JenisMedicalSuppliesModel;
import com.apap.farmasi.model.MedicalSuppliesModel;
import com.apap.farmasi.model.StatusPermintaanModel;
import com.apap.farmasi.model.FlagUrgentModel;
import com.apap.farmasi.model.PerencanaanModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permintaan")
public class PermintaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Column(name = "jumlah_medical_supplies", nullable = false)
	private long jumlahMedicalSupplies;
	
	@NotNull
	@Column(name = "id_pasien", nullable = false)
	private int idPasien;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "permintaan_medical_supplies",
            joinColumns = { @JoinColumn(name = "id_medical_supplies") },
            inverseJoinColumns = { @JoinColumn(name = "id_permintaan") })
    private List<MedicalSuppliesModel> listMedicalSupplies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status_permintaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private StatusPermintaanModel statusPermintaan;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_jadwal_jaga", referencedColumnName = "id", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private JadwalJagaModel jadwalJaga;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public long getJumlahMedicalSupplies() {
		return jumlahMedicalSupplies;
	}

	public void setJumlahMedicalSupplies(long jumlahMedicalSupplies) {
		this.jumlahMedicalSupplies = jumlahMedicalSupplies;
	}

	public int getIdPasien() {
		return idPasien;
	}

	public void setIdPasien(int idPasien) {
		this.idPasien = idPasien;
	}

	public List<MedicalSuppliesModel> getListMedicalSupplies() {
		return listMedicalSupplies;
	}

	public void setListMedicalSupplies(List<MedicalSuppliesModel> listMedicalSupplies) {
		this.listMedicalSupplies = listMedicalSupplies;
	}

	public StatusPermintaanModel getStatusPermintaan() {
		return statusPermintaan;
	}

	public void setStatusPermintaan(StatusPermintaanModel statusPermintaan) {
		this.statusPermintaan = statusPermintaan;
	}

//	public JadwalJagaModel getJadwalJaga() {
//		return jadwalJaga;
//	}
//
//	public void setJadwalJaga(JadwalJagaModel jadwalJaga) {
//		this.jadwalJaga = jadwalJaga;
//	}
//	
}
