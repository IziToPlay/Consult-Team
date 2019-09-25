package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Cliente;

@Named
public class ClienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="pwPU")
	private EntityManager em;

	public void insert(Cliente cliente) throws Exception {
      em.persist(cliente);
	}
	
	public void update(Cliente cliente) throws Exception{
		em.merge(cliente);
	}
	
	public void delete(Cliente cliente) throws Exception{
		em.remove(cliente);
	}
	
	public List<Cliente> findAll()throws Exception{
		List<Cliente> clientes=new ArrayList<>();
		
		TypedQuery<Cliente> query=em.createQuery("FROM Cliente", Cliente.class);
		clientes=query.getResultList();
		
		return clientes;
	}
	
	public List<Cliente> findByDNI(String dni) throws Exception{
		List<Cliente> clientes=new ArrayList<>();
		
		TypedQuery<Cliente> query=em.createQuery("FROM Cliente c WHERE c.dni LIKE ?1",Cliente.class);
		query.setParameter(1, "%"+dni+"%");
		clientes=query.getResultList();
		
		return clientes;
	}

}
