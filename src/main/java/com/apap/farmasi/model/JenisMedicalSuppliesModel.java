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
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jenis_medical_supplies")
public class JenisMedicalSuppliesModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	@Column(name = "jenis_medical_supplies", nullable = false, unique = true)
	private String jenisMedicalSupplies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_urgent", referencedColumnName = "id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private FlagUrgentModel idUrgent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJenisMedicalSupplies() {
		return jenisMedicalSupplies;
	}

	public void setJenisMedicalSupplies(String jenisMedicalSupplies) {
		this.jenisMedicalSupplies = jenisMedicalSupplies;
	}

	public FlagUrgentModel getIdUrgent() {
		return idUrgent;
	}

	public void setIdUrgent(FlagUrgentModel idUrgent) {
		this.idUrgent = idUrgent;
	}
	
	
}
