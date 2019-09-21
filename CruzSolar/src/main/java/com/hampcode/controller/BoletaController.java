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
	private Viaje viaje;
	@PostConstruct
	public void init() {
		boleta = new Boleta();
		empleado=new Empleado();
		asientoViaje = new AsientoViaje();
		cliente= new Cliente();
		viaje= new Viaje();
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

	public String saveBoleta() {
		String view = "";
		try {
			if (boleta.getId() != null) {
				boletaBusiness.update(boleta);
				Message.messageInfo("Boleta de viaje actualizada correctamente");
			} else {
				boletaBusiness.insert(boleta);
				Message.messageInfo("Boleta de viaje registrada correctamente");
			}
			this.getAllBoletas();
			resetForm();
			view = "boleta/list.xhtml";
		} catch (Exception e) {
			Message.messageError("Error Boleta de Viaje:" + e.getMessage());
		}
		return view;
	}
	
	public String newBoleta() {
		resetForm();
		return "boleta/insert.xhtml";
	}
	
	public String listBoleta() {
		resetForm();
		return "boleta/list.xhtml";
	}
	public void resetForm() {
		this.boleta = new Boleta();
	}

	public BoletaBusiness getBoletaBusiness() {
		return boletaBusiness;
	}

	public void setBoletaBusiness(BoletaBusiness boletaBusiness) {
		this.boletaBusiness = boletaBusiness;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public List<Boleta> getBoletas() {
		return boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Boleta getBoletaSelect() {
		return boletaSelect;
	}

	public void setBoletaSelect(Boleta boletaSelect) {
		this.boletaSelect = boletaSelect;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public AsientoViaje getAsientoViaje() {
		return asientoViaje;
	}

	public void setAsientoViaje(AsientoViaje asientoViaje) {
		this.asientoViaje = asientoViaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
