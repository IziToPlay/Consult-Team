package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.BusBusiness;
import com.hampcode.business.DepartamentoBusiness;
import com.hampcode.business.ViajeBusiness;
import com.hampcode.model.entity.Bus;
import com.hampcode.model.entity.Departamento;
import com.hampcode.model.entity.Viaje;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ViajeController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ViajeBusiness viajeBusiness;

	@Inject
	private DepartamentoBusiness departamentoBusiness;
	
	@Inject
	private BusBusiness busBusiness;
	

	private Viaje viaje;
	private List<Viaje> viajes;
	private Viaje viajeSelect;
	private String filterName;
	String filterNameOrigen;
	

	private Departamento departamentoOrigen;
	private Departamento departamentoDestino;
	private List<Departamento> departamentos;
	private Departamento departamentoSelect;
	
	private Bus bus;
	private List<Bus> buses;

	@PostConstruct
	public void init() {
		viaje = new Viaje();
		departamentoOrigen=new Departamento();
		departamentoDestino=new Departamento();
		bus = new Bus();
		
		

		viajes = new ArrayList<Viaje>();
		departamentos = new ArrayList<Departamento>();
	    buses = new ArrayList<Bus>();

		getAllViajes();
		getAllDepartamentos();
		getAllBuses();
	}

	public String newViaje() {
		resetForm();
		return "new.xhtml";
	}

	public String listViaje() {
		return "list.xhtml";
	}

	public String saveViaje() throws Exception {

		String view = "";
		try {
			if (viaje.getId() != null) {
				
				
				viaje.setDptoDestino(departamentoDestino);
				viaje.setDptoOrigen(departamentoOrigen);
				
				viajeBusiness.update(viaje);
				Message.messageInfo("Registro actualizado exitosamente");
				view = "list";
			} else {
				if(departamentoDestino.getNombre()==departamentoOrigen.getNombre()) Message.messageError("Origen y Destino no deben ser iguales");
				else {
					viaje.setBus(bus);
					viaje.setDptoDestino(departamentoDestino);
					viaje.setDptoOrigen(departamentoOrigen);
					
					viajeBusiness.insert(viaje);				
					Message.messageInfo("El viaje se ha registrado exitosamente");
					view = "list";
				}
			}
			this.getAllViajes();
			this.getAllBuses();
			resetForm();
			
		} catch (Exception e) {
			Message.messageError("Error Viaje:" + e.getMessage());
		}
		return view;
	}

	public String editViaje() {
		String view = "";
		try {
			if (this.viajeSelect != null) {
				getAllDepartamentos();
			    getAllBuses();
				this.viaje = viajeSelect;
				this.viaje.setDptoOrigen(viajeSelect.getDptoOrigen());
				this.viaje.setDptoDestino(viajeSelect.getDptoDestino());

				view = "update";
			} else {
				Message.messageInfo("Debe seleccionar un viaje");
			}

		} catch (Exception e) {
			Message.messageError("Error Viaje:" + e.getMessage());
		}
		return view;
	}

	public void getAllViajes() {
		try {
			viajes = viajeBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Rutas de Viaje:" + e.getMessage());
		}
	}
	
	public void getAllDepartamentos() {
		try {
			this.departamentos= departamentoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Departamentos " + e.getMessage());
		}
	}

	public void getAllBuses() {
		try {
			this.buses = busBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Buses "+ e.getMessage());
		}
	}
	
	public void selectViaje(SelectEvent e) {
		this.viajeSelect = (Viaje) e.getObject();
	}

	public String deleteViaje() {
		String view = "";
		try {
			if (this.viajeSelect != null) {
				this.viaje = viajeSelect;
				viajes.remove(viaje);

				Message.messageInfo("Registro eliminado correctamente");
			} else {
				Message.messageInfo("Debe seleccionar una ruta de viaje");
			}
			this.getAllViajes();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Ruta de Viaje: " + e.getStackTrace());
		}
		return view;
	}

	public void searchViajeByName() {
		try {

			viajes = viajeBusiness.getViajesByName(this.filterName.trim());
			resetForm();
			if (viajes.isEmpty()) {
				Message.messageInfo("No se encontraron viajes");
			}
		} catch (Exception e) {
			Message.messageError("Error Viaje Search :" + e.getMessage());
		}
	}

	public void searchViajeByDptoOrigen() {
		try {

			viajes = viajeBusiness.getViajesByName(this.filterNameOrigen.trim());
			resetForm();
			if (viajes.isEmpty()) {
				Message.messageInfo("No se encontraron viajes");
			}
		} catch (Exception e) {
			Message.messageError("Error Viaje Search :" + e.getMessage());
		}
	}

	public void resetForm() {
		this.filterName = "";
		this.filterNameOrigen = "";
		this.viaje = new Viaje();
		this.departamentoOrigen = new Departamento();
		this.departamentoDestino = new Departamento();
		this.bus = new Bus();
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Viaje getViajeSelect() {
		return viajeSelect;
	}

	public void setViajeSelect(Viaje viajeSelect) {
		this.viajeSelect = viajeSelect;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public ViajeBusiness getViajeBusiness() {
		return viajeBusiness;
	}

	public void setViajeBusiness(ViajeBusiness viajeBusiness) {
		this.viajeBusiness = viajeBusiness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DepartamentoBusiness getDepartamentoBusiness() {
		return departamentoBusiness;
	}

	public void setDepartamentoBusiness(DepartamentoBusiness departamentoBusiness) {
		this.departamentoBusiness = departamentoBusiness;
	}

	
	

	public Departamento getDepartamentoOrigen() {
		return departamentoOrigen;
	}

	public void setDepartamentoOrigen(Departamento departamentoOrigen) {
		this.departamentoOrigen = departamentoOrigen;
	}

	public Departamento getDepartamentoDestino() {
		return departamentoDestino;
	}

	public void setDepartamentoDestino(Departamento departamentoDestino) {
		this.departamentoDestino = departamentoDestino;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Departamento getDepartamentoSelect() {
		return departamentoSelect;
	}

	public void setDepartamentoSelect(Departamento departamentoSelect) {
		this.departamentoSelect = departamentoSelect;
	}

	

	public String getFilterNameOrigen() {
		return filterNameOrigen;
	}

	public void setFilterNameOrigen(String filterNameOrigen) {
		this.filterNameOrigen = filterNameOrigen;
	}

}