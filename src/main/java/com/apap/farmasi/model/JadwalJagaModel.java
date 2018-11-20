package com.apap.farmasi.model;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.apap.farmasi.rest.*;

@Entity
@Table(name = "jadwal_jaga")

public class JadwalJagaModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "tanggal", nullable = false)
	private Date tanggal;
	
	@NotNull
	@Column(name = "waktu_mulai", nullable = false)
	private Time waktuMulai;
	
	@NotNull
	@Column(name = "waktu_selesai", nullable = false)
	private Time waktuSelesai;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id_staff", referencedColumnName = "id_staff", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private StaffDetail staff;

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

	public Time getWaktuMulai() {
		return waktuMulai;
	}

	public void setWaktuMulai(Time waktuMulai) {
		this.waktuMulai = waktuMulai;
	}

	public Time getWaktuSelesai() {
		return waktuSelesai;
	}

	public void setWaktuSelesai(Time waktuSelesai) {
		this.waktuSelesai = waktuSelesai;
	}

	public StaffDetail getStaff() {
		return staff;
	}

	public void setStaff(StaffDetail staff) {
		this.staff = staff;
	}
	
//	public Object getTanggal() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Object getId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}