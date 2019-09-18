package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Boleta;
import com.hampcode.model.repository.BoletaRepository;
@Named
public class BoletaBusiness implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private BoletaRepository boletaRepository;
	
	@Transactional 
	public void insert(Boleta boleta) throws Exception {
		boletaRepository.insert(boleta);
	}
	
	@Transactional
	public void update(Boleta boleta)throws Exception{
		 boletaRepository.update(boleta);
	}
	
	@Transactional
	public void delete(Boleta boleta) throws Exception{
		 boletaRepository.delete(boleta);
	}
	
	public List<Boleta> getAll() throws Exception {
		return boletaRepository.findAll();
	}
}
