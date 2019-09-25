package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Asiento;

@Named
public class AsientoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public void insert(Asiento asiento) throws Exception {
		em.persist(asiento);
	}

	public void update(Asiento asiento) throws Exception {
		em.merge(asiento);
	}

	public void delete(Asiento asiento) throws Exception {
		em.remove(asiento);
	}

	public List<Asiento> findAll() throws Exception {
		List<Asiento> asientos = new ArrayList<>();

		TypedQuery<Asiento> query = em.createQuery("FROM Asiento", Asiento.class);
		asientos = query.getResultList();

		return asientos;
	}
	
	//Buscar asientos del bus, según mismo bus entre viaje y asiento
	public List<Asiento> findByBus(Long id) throws Exception{
		List<Asiento> asientos = new ArrayList<>();
		
		TypedQuery<Asiento> query = em.createQuery("FROM Asiento a WHERE a.bus.id=?1", Asiento.class);
		query.setParameter(1, id);
		asientos=query.getResultList();
		return asientos;
		
	}
}
