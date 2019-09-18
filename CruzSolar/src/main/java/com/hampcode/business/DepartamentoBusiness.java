package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Departamento;
import com.hampcode.model.repository.DepartamentoRepository;


@Named
public class DepartamentoBusiness implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> getAll() throws Exception {
		return departamentoRepository.findAll();
	}
}
