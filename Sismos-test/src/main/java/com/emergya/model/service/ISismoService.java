package com.emergya.model.service;

import java.util.List;

import com.emergya.model.entitys.Sismo;

public interface ISismoService {
	
	public List<Sismo> getSismo();
	public Sismo addSismo(Sismo sismos);
	public void removeSismo(Long id);
	public Sismo updateSismo(Sismo sismo);

}
