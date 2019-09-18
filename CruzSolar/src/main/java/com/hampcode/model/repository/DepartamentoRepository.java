package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Departamento;

@Named
public class DepartamentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public List<Departamento> findAll() throws Exception {
		List<Departamento> departamentos = new ArrayList<>();

		TypedQuery<Departamento> query = em.createQuery("FROM Departamento", Departamento.class);
		departamentos = query.getResultList();

		return departamentos;
	}
}