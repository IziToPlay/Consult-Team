package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.AsientoViaje;

@Named
public class AsientoViajeRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public void insert(AsientoViaje asientoViaje) throws Exception {
		em.persist(asientoViaje);
	}
	
	public void update(AsientoViaje asientoViaje) throws Exception{
		em.merge(asientoViaje);
	}
	
	public void delete(AsientoViaje asientoViaje) throws Exception {
		em.remove(asientoViaje);
	}
	
	public List<AsientoViaje> findAll() throws Exception{
		List<AsientoViaje> asientosViaje=new ArrayList<>();
		
		TypedQuery<AsientoViaje> query=em.createQuery("FROM Viaje",AsientoViaje.class);
		asientosViaje=query.getResultList();
	
		return asientosViaje;
	}
}
