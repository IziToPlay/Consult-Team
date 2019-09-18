package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Asiento;
import com.hampcode.model.repository.AsientoRepository;

@Named
public class AsientoBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AsientoRepository asientoRepository;

	@Transactional
	public void insert(Asiento asiento) throws Exception {
		asientoRepository.insert(asiento);
	}

	@Transactional
	public void update(Asiento asiento) throws Exception {
		asientoRepository.update(asiento);
	}

	@Transactional
	public void delete(Asiento asiento) throws Exception {
		asientoRepository.delete(asiento);
	}

	public List<Asiento> getAll() throws Exception {
		return asientoRepository.findAll();
	}
}
