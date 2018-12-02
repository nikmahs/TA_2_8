package com.apap.farmasi.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "perencanaan")
public class PerencanaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "status", nullable = false)
	private String status;
	
	@OneToMany(mappedBy = "perencanaan")
	private List<PerencanaanMedicalSuppliesModel> listPerencanaanMedicalSupplies;
	
	
	
	

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PerencanaanMedicalSuppliesModel> getListPerencanaanMedicalSupplies() {
		return listPerencanaanMedicalSupplies;
	}

	public void setListPerencanaanMedicalSupplies(List<PerencanaanMedicalSuppliesModel> listPerencanaanMedicalSupplies) {
		this.listPerencanaanMedicalSupplies = listPerencanaanMedicalSupplies;
	}
	
	
}