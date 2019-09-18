package com.hampcode.business;

import java.io.Serializable;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.Empleado;
import com.hampcode.model.repository.EmpleadoRepository;


@Named
public class EmpleadoBusiness  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	
	private  EmpleadoRepository empleadoRepository;
	
	public Optional<Empleado> getEmpleadoByIdANDContraseña(Long id, String Contraseña) throws Exception{
		return empleadoRepository.findByIdAndContraseña(id,Contraseña);
	}
}