package com.apap.farmasi.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@Column(name = "id_jadwal", nullable = false)
	private long idJadwal;
	
	@OneToMany(mappedBy = "permintaan")
	private List<PermintaanMedicalSuppliesModel> listPermintaanMedicalSupplies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_status_permintaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private StatusPermintaanModel statusPermintaan;
		
	@NotNull
	@Column(name = "id_pasien", nullable = false)
	private int idPasien;
	
		
	
	public long getIdJadwal() {
		return idJadwal;
	}

	public void setIdJadwal(long idJadwal) {
		this.idJadwal = idJadwal;
	}

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

	public StatusPermintaanModel getStatusPermintaan() {
		return statusPermintaan;
	}

	public void setStatusPermintaan(StatusPermintaanModel statusPermintaan) {
		this.statusPermintaan = statusPermintaan;
	}

	public List<PermintaanMedicalSuppliesModel> getListPermintaanMedicalSupplies() {
		return listPermintaanMedicalSupplies;
	}

	public void setListPermintaanMedicalSupplies(List<PermintaanMedicalSuppliesModel> listPermintaanMedicalSupplies) {
		this.listPermintaanMedicalSupplies = listPermintaanMedicalSupplies;
	}
	
}
