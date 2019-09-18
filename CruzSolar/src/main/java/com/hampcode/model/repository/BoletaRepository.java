package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Boleta;
@Named
public class BoletaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public void insert(Boleta boleta) throws Exception {
		em.persist(boleta);
	}
	
	public void update(Boleta boleta) throws Exception{
		em.merge(boleta);
	}
	
	public void delete(Boleta boleta) throws Exception{
		em.remove(boleta);
	}
	
	public List<Boleta> findAll()throws Exception{
		List<Boleta> boletas=new ArrayList<>();
		
		TypedQuery<Boleta> query=em.createQuery("FROM Boleta", Boleta.class);
		boletas=query.getResultList();
		
		return boletas;
	}
}
