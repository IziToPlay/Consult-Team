package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Empleado;


@Named

public class EmpleadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pwPU")
	private EntityManager em;
	
	public Optional<Empleado> findByIdAndContraseña(Long id, String Contraseña) throws Exception {
		Empleado empleadoFound;
		
		TypedQuery<Empleado> query=em.createQuery("FROM Empleado p WHERE p.id=?1 AND p.contraseña LIKE ?2"
				,Empleado.class);
		
		query.setParameter(1, id);
		query.setParameter(2, "%"+Contraseña+"%");
		
		empleadoFound=query.getSingleResult();
		
		return Optional.of(empleadoFound);
	}
}
