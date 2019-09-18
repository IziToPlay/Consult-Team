package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Bus;
@Named
public class BusRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public Long update(Bus bus) throws Exception {
		em.merge(bus);
		return bus.getId();
	}
	
	public List<Bus> findAll() throws Exception {
		List<Bus> buses = new ArrayList<>();

		TypedQuery<Bus> query = em.createQuery("FROM Bus b where b.disponible=true", Bus.class);
		buses = query.getResultList();
		return buses;
	}

}