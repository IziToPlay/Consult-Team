package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.AsientoBusiness;
import com.hampcode.business.BoletaBusiness;
import com.hampcode.model.entity.Asiento;
//import com.hampcode.model.entity.AsientoViaje;
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
	
	@Inject
	private AsientoBusiness asientoBusiness;
	
	@Inject
	private ClienteController clienteController;
	
	@Inject 
	private ViajeController viajeController;
	
	private Boleta boleta;
	private Asiento asiento;
	private List<Boleta> boletas;
	private Boleta boletaSelect;
	private Empleado empleado;
	private Cliente cliente;
	private Viaje viaje;
	//private AsientoController asientoController;
	private List<Asiento> asientos;
	@PostConstruct
	public void init() {
		boleta = new Boleta();
		empleado=new Empleado();
		asiento = new Asiento();
		cliente= new Cliente();
		viaje=new Viaje();
		//setViaje(new Viaje());
		boletas=new ArrayList<Boleta>();
		asientos =new ArrayList<Asiento>();
		//asientoController= new AsientoController();
		getAllBoletas();
		//getAsientosporBus(1); 
		
		
	}
	
	public void getAllBoletas() {
		try {
			boletas = boletaBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Boletas de Ventas:" + e.getMessage());
		}
	}

	public void enlazarCliente() {
		//resetForm();
		this.clienteController.enlazarCliente();
		//resetForm();
	}
	
	public String saveBoleta() {
		String view = "";
		try {
			if (boleta.getId() != null) {
				boleta.setAsiento(asiento);
				boletaBusiness.update(boleta);
				Message.messageInfo("Boleta de viaje actualizada correctamente");
				view = "listboletas.xhtml";
				return view;
			} else {
				boletaBusiness.insert(boleta);
				Message.messageInfo("Boleta de viaje registrada correctamente");
			}
			this.getAllBoletas();
			resetForm();
			view = "/boleta/list.xhtml";
		} catch (Exception e) {
			Message.messageInfo("Rellene los campos faltantes");
			Message.messageError("Error Boleta de Viaje:" + e.getMessage());
		}
		return view;
	}
	
	// Ir a vista Registrar Boleta y registrarla
	public String newBoleta() {
		resetForm();
		return "/boleta/insert.xhtml";
	}
	
	// Ir a vista Listar Viajes y verlas todas
		public String listViaje() {
			//resetForm();
			return "/boleta/list.xhtml";	
		}
		
	// Ir a vista Listar Boletas y verlas todas
	public String listBoleta() {
		return "/boleta/listboletas.xhtml";
	}
	
	// Inicializar nueva boleta a crear
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

	/*
	 * public AsientoViaje getAsientoViaje() { return asientoViaje; }
	 * 
	 * public void setAsientoViaje(AsientoViaje asientoViaje) { this.asientoViaje =
	 * asientoViaje; }
	 */

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String editBoleta() {
		String view = "";
		try {
			if (this.boletaSelect != null) {
				this.boleta =  boletaSelect;
			    getAsientosporBus(boleta.getViaje().getBus().getId());
				//getAsientosporBus(1);
				view = "/boleta/update";	
			} 
			else {
				Message.messageInfo("Debe seleccionar una boleta");
			}
		} catch (Exception e) {
			Message.messageError("Error Boleta :" + e.getMessage());
		}
		return view;
	}

	public Viaje getViaje() {
		return viaje;
	}
    public void getAsientosporBus(long id) {
    	  try {
  			asientos = asientoBusiness.getAsientosByBus(id);
  		 } catch (Exception e) {
  			Message.messageError("Error Asiento :" + e.getMessage());
  		}
    }
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}



	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public AsientoBusiness getAsientoBusiness() {
		return asientoBusiness;
	}

	public void setAsientoBusiness(AsientoBusiness asientoBusiness) {
		this.asientoBusiness = asientoBusiness;
	}
}
