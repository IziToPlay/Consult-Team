package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.DepartamentoBusiness;
import com.hampcode.business.ViajeBusiness;

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
	

	private Viaje viaje;
	private List<Viaje> viajes;
	private Viaje viajeSelect;
	private String filterName; // Por el momento se busca por Destino

	private Departamento departamento;
	@PostConstruct
	public void init() {
		viaje = new Viaje();
		departamento=new Departamento();
		viajes = new ArrayList<Viaje>();
		getAllViajes();
	}
	
	public String newViaje() {		
		resetForm();
		return "viaje/insert.xhtml";
	}
	
	public String listViaje() {
		return "viaje/list.xhtml";
	}


	public String saveViaje() {
		String view = "";
		try {
			if (viaje.getId() != null) {
				viajeBusiness.update(viaje);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				viajeBusiness.insert(viaje);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllViajes();
			resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Viaje:" + e.getMessage());
		}
		return view;
	}

	
	public String editViaje() {
		String view = "";
		try {
			if (this.viajeSelect != null) {
				this.viaje = viajeSelect;

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

	public void selectViaje(SelectEvent e) {
		this.viajeSelect = (Viaje) e.getObject();
	}

	public String deleteViaje() {
		String view = "";
		try {
			if (this.viajeSelect != null) {
				this.viaje=viajeSelect;
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
	public void resetForm() {
		this.filterName = "";
		this.viaje = new Viaje();
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}