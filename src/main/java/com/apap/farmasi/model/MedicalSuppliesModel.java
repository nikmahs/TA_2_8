package com.apap.farmasi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "medical_supplies")
public class MedicalSuppliesModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "nama", nullable = false, unique = true)
	private String nama;
	
	@NotNull
	@Column(name = "price", nullable = false)
	private long price;
	
	@NotNull
	@Column(name = "jumlah", nullable = false)
	private int jumlah;
	
	@NotNull
	@Column(name = "deskripsi", nullable = false)
	private String deskripsi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jenis_medical_supplies", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private JenisMedicalSuppliesModel jenisMedicalSupplies;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_perencanaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private PerencanaanModel perencanaan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_permintaan", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private PermintaanModel permintaan;
	
	public PerencanaanModel getPerencanaan() {
		return perencanaan;
	}

	public void setPerencanaan(PerencanaanModel perencanaan) {
		this.perencanaan = perencanaan;
	}

	public PermintaanModel getPermintaan() {
		return permintaan;
	}

	public void setPermintaan(PermintaanModel permintaan) {
		this.permintaan = permintaan;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public JenisMedicalSuppliesModel getJenisMedicalSupplies() {
		return jenisMedicalSupplies;
	}

	public void setJenisMedicalSupplies(JenisMedicalSuppliesModel jenisMedicalSupplies) {
		this.jenisMedicalSupplies = jenisMedicalSupplies;
	}
	
}
