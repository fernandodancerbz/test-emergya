package com.emergya.bean;

public class RespuestaCliente {
	
	private float magnitud;
	private String fecha;
	private String place;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public float getMagnitud() {
		return magnitud;
	}
	public void setMagnitud(float f) {
		this.magnitud = f;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String dateString) {
		this.fecha = dateString;
	}
	
	

}
