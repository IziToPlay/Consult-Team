package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ClienteBusiness;
import com.hampcode.model.entity.AsientoViaje;
import com.hampcode.model.entity.Boleta;
import com.hampcode.model.entity.Cliente;
import com.hampcode.model.entity.Empleado;
import com.hampcode.model.entity.Viaje;
import com.hampcode.util.Message; 

@Named
@SessionScoped
public class ClienteController implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	@PostConstruct
	public void init() {
		cliente= new Cliente();
		clientes=new ArrayList<Cliente>();
		//getAllClientes();
	}
	
	public void getAllClientes() {
		try {
			clientes = clienteBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Clientes:" + e.getMessage());
		}
	}
}
