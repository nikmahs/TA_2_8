package com.apap.farmasi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "perencanaan_medical_supplies")
public class PerencanaanMedicalSuppliesModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perencanaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private PerencanaanModel perencanaan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_medical_supplies", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private MedicalSuppliesModel medicalSupplies;
	
	@NotNull
	@Column(name = "jumlah", nullable = false)
	private Integer jumlah;

	public long getId() {
		return id;
	}

	public PerencanaanModel getPerencanaan() {
		return perencanaan;
	}

	public void setPerencanaan(PerencanaanModel perencanaan) {
		this.perencanaan = perencanaan;
	}

	public MedicalSuppliesModel getMedicalSupplies() {
		return medicalSupplies;
	}

	public void setMedicalSupplies(MedicalSuppliesModel medicalSupplies) {
		this.medicalSupplies = medicalSupplies;
	}
	
	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
}
