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
import com.hampcode.util.Message;

@Named
@SessionScoped
public class BoletaController  implements Serializable  {

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
	
	public void getAllBoletas() {
		try {
			boletas = boletaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Boletas de Ventas:" + e.getMessage());
		}
	}
	
	public String newBoleta() {
		resetForm();
		return "list.xhtml";
	}
	
	public void resetForm() {
		this.boleta = new Boleta();
	}
	
	public String saveBoleta() {
		String view = "";
		try {
			if (boleta.getId() != null) {
				boletaBusiness.update(boleta);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				boletaBusiness.insert(boleta);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllBoletas();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Boleta:" + e.getMessage());
		}
		return view;
	}
}
