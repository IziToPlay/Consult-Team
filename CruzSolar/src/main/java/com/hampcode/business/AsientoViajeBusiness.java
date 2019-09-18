package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.AsientoViaje;
import com.hampcode.model.repository.AsientoViajeRepository;
@Named
public class AsientoViajeBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AsientoViajeRepository asientoViajeRepository;
	
	@Transactional
	public void insert(AsientoViaje asientoViaje) throws Exception {
		asientoViajeRepository.insert(asientoViaje);
	}
	
	@Transactional
	public void update(AsientoViaje asientoViaje)throws Exception{
		asientoViajeRepository.update(asientoViaje);
	}
	
	@Transactional
	public void delete(AsientoViaje asientoViaje) throws Exception{
		asientoViajeRepository.delete(asientoViaje);
	}
	
	public List<AsientoViaje> getAll() throws Exception {
		return asientoViajeRepository.findAll();
	}
}
