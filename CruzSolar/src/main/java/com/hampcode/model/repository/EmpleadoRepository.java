package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Empleado;

@Named
public class EmpleadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pwPU")
	private EntityManager em;

	public List<Empleado> findAll() throws Exception {
		List<Empleado> empleados = new ArrayList<>();

		TypedQuery<Empleado> query = em.createQuery("FROM Empleado", Empleado.class);
		empleados = query.getResultList();

		return empleados;
	}
}
