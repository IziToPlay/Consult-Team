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
	public Long insert(Viaje viaje) throws Exception {
		return viajeRepository.insert(viaje);
	}
	
	@Transactional
	public Long delete(Viaje viaje) throws Exception{
		return viajeRepository.delete(viaje);
	}
	
	@Transactional
	public Long update(Viaje viaje)throws Exception{
		return viajeRepository.update(viaje);
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
