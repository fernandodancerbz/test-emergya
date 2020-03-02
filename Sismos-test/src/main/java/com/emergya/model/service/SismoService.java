package com.emergya.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emergya.model.dao.ISismoDao;
import com.emergya.model.entitys.Sismo;


@Service
public class SismoService implements ISismoService {
	
	 @Autowired
	private ISismoDao sismoDao;
	
	/**
	 * Method to get all the task
	 * @return
	 */
	public List<Sismo> getSismo() {
		return (List<Sismo>) sismoDao.findAll();
	}

	@Override
	public Sismo addSismo(Sismo sismo) {
		/*sismo.setFechaSismo(new Date());
		sismo.setMagnitud("");	
		sismo.setPlace("");*/
		return sismoDao.save(sismo);
	}

	@Override
	public void removeSismo(Long id) {
		sismoDao.deleteById(id);
	}

	@Override
	public Sismo updateSismo(Sismo sismo) {	
		return sismoDao.save(sismo);
	}


}
