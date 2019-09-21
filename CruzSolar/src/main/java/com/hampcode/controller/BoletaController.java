package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.BoletaBusiness;
import com.hampcode.model.entity.AsientoViaje;
import com.hampcode.model.entity.Boleta;
import com.hampcode.model.entity.Cliente;
import com.hampcode.model.entity.Departamento;
import com.hampcode.model.entity.Empleado;
import com.hampcode.model.entity.Viaje;

@Named
@SessionScoped
public class BoletaController {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private BoletaBusiness boletaBusiness;
	
	private Boleta boleta;
	private List<Boleta> boletas;
	private Boleta boletaSelect;
	
	private Empleado empleado;
	private AsientoViaje asientoViaje;
	private Cliente cliente;
	@PostConstruct
	public void init() {
		boleta = new Boleta();
		empleado=new Empleado();
		asientoViaje = new AsientoViaje();
		cliente= new Cliente();
		boletas=new ArrayList<Boleta>();
		//getAllBoletas();
	}
}
