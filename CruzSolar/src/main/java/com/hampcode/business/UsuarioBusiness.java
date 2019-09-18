package com.hampcode.business;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.model.entity.Usuario;
import com.hampcode.model.repository.UsuarioRepository;

@Named
public class UsuarioBusiness implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;

	
	public Usuario getByUsuarioAndContrasenia(String nombre, String clave)throws Exception
	{
		return usuarioRepository.findByUsuarioAndContrasenia(nombre, clave);
	}
}
