package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.Bus;
import com.hampcode.model.repository.BusRepository;

@Named
public class BusBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BusRepository busRepository;

	public List<Bus> getAll() throws Exception {
		return busRepository.findAll();
	}
}