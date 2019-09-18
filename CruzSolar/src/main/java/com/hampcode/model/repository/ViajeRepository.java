package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Viaje;

@Named
public class ViajeRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Long insert(Viaje viaje) throws Exception {
		em.persist(viaje);
		return viaje.getId();
	}
	
	public Long delete(Viaje viaje) throws Exception {
		return viaje.getId();
	}
	
	
	public List<Viaje> findAll() throws Exception{
		List<Viaje> viajes=new ArrayList<>();
		
		TypedQuery<Viaje> query=em.createQuery("FROM Viaje v"
				,Viaje.class);
		viajes=query.getResultList();
		
		return viajes;
	}
	
	
	public Long update(Viaje viaje) throws Exception{
		em.merge(viaje);
		return viaje.getId();
	}
	
	public Optional<Viaje> findById(Long id) throws Exception{
		Viaje viajeFound;
		
		TypedQuery<Viaje> query=em.createQuery("FROM Viaje v WHERE v.id=?1"
				,Viaje.class);
		
		
		
		query.setParameter(1, id);
		viajeFound=query.getSingleResult();
		
		return Optional.of(viajeFound);
	}
	
	
	public List<Viaje> findByName(String destino) throws Exception{
		List<Viaje> viajes=new ArrayList<>();
		
		TypedQuery<Viaje> query=em.createQuery("FROM Viaje v WHERE v.departamentoDestino.name LIKE ?1"
				,Viaje.class);
		query.setParameter(1, "%"+destino+"%");
		viajes=query.getResultList();
		
		return viajes;
	}
}
