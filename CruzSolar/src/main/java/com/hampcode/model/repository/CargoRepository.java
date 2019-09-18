package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Cargo;


@Named

public class CargoRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public List<Cargo> findAll() throws Exception{
		List<Cargo> cargos=new ArrayList<>();
		
		TypedQuery<Cargo> query=em.createQuery("FROM Cargo c"
				,Cargo.class);
		cargos=query.getResultList();
		
		return cargos;
	}

}
