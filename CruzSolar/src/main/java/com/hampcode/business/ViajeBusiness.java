package com.hampcode.business;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Viaje;
import com.hampcode.model.repository.ViajeRepository;

@Named
public class ViajeBusiness implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ViajeRepository viajeRepository;
	
	
	@Transactional
	public void insert(Viaje viaje) throws Exception {
		viajeRepository.insert(viaje);
	}
	
	@Transactional
	public void update(Viaje viaje)throws Exception{
		 viajeRepository.update(viaje);
	}
	
	@Transactional
	public void delete(Viaje viaje) throws Exception{
		 viajeRepository.delete(viaje);
	}
	
	public List<Viaje> getAll() throws Exception {
		return viajeRepository.findAll();
	}
	
	
	
	public Optional<Viaje> getViajesById(long id) throws Exception{
		return viajeRepository.findById(id);
	}
	
	public List<Viaje> getViajesByName(String destino) throws Exception{
		return viajeRepository.findByName(destino);
	}
	
}
