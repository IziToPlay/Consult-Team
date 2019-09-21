package com.hampcode.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.UsuarioBusiness;
import com.hampcode.model.entity.Usuario;
import com.hampcode.util.Message;


@Named
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBusiness usuarioBusiness;
	
	private Usuario usuario;
	private String filterNombre;
	private String filterClave;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	public String iniciarSesion() {
		return "/viaje/list.xhtml";
	}
	
	public void searchUsuarioByNombreyClave() {
		try {
			this.usuario = usuarioBusiness.getByUsuarioAndContrasenia(this.filterNombre.trim(), this.filterClave.trim());
			if (usuario == null) { 
				Message.messageError("Las credenciales no son correctas. Por favor, ingrese su cuenta nuevamente");
			} else { 
				Message.messageInfo("Bienvenido");
			}
		} catch(Exception e) {
				Message.messageError("Error Usuario search :" + e.getMessage());
		}
	}
}
				
			
		
			
		
	
	
	


