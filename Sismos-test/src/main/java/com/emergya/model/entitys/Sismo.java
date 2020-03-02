package com.emergya.model.entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sismos")
public class Sismo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private float magnitud;
	private String place;
	
	@Column(name="fecha_sismo")
	private String fechaSismo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMagnitud() {
		return magnitud;
	}

	public void setMagnitud(float f) {
		this.magnitud = f;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFechaSismo() {
		return fechaSismo;
	}

	public void setFechaSismo(String string) {
		this.fechaSismo = string;
	}



}
