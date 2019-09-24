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
	private String filterName;
	private String filterNameOrigen;

	private Departamento dptoOrigen;
	private Departamento dptoDestino;

	private List<Departamento> departamentosOrigen;
	private List<Departamento> departamentosDestino;
	private Departamento departamentoSelect;

	@PostConstruct
	public void init() {
		viaje = new Viaje();

		dptoOrigen = new Departamento();
		dptoDestino = new Departamento();

		viajes = new ArrayList<Viaje>();

		departamentosOrigen = new ArrayList<Departamento>();
		departamentosDestino = new ArrayList<Departamento>();

		getAllViajes();

		getAllDepartamentosOrigen();
		getAllDepartamentosDestino();

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

				viaje.setDptoDestino(dptoDestino);
				viaje.setDptoOrigen(dptoOrigen);

				viajeBusiness.update(viaje);
				Message.messageInfo("Registro actualizado exitosamente");
				view = "list";

			} else {
				if (dptoDestino.getNombre() == dptoOrigen.getNombre()) {
					Message.messageError("Origen y Destino no deben ser iguales");
				} else {

					Departamento dptoDestino = new Departamento();

					viaje.setDptoDestino(dptoDestino);
					viaje.setDptoOrigen(dptoOrigen);

					viajeBusiness.insert(viaje);
					Message.messageInfo("El viaje se ha registrado exitosamente");
					view = "list";
				}
			}
			this.getAllViajes();
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

	public void getAllDepartamentosDestino() {
		try {
			this.departamentosDestino = departamentoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Departamentos " + e.getMessage());
		}
	}

	public void getAllDepartamentosOrigen() {
		try {
			this.departamentosOrigen = departamentoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Departamentos " + e.getMessage());
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
		this.dptoOrigen = new Departamento();
		this.dptoDestino = new Departamento();
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

	public List<Departamento> getDepartamentosOrigen() {
		return departamentosOrigen;
	}

	public void setDepartamentosOrigen(List<Departamento> departamentosOrigen) {
		this.departamentosOrigen = departamentosOrigen;
	}

	public List<Departamento> getDepartamentosDestino() {
		return departamentosDestino;
	}

	public void setDepartamentosDestino(List<Departamento> departamentosDestino) {
		this.departamentosDestino = departamentosDestino;
	}

	public Departamento getDepartamentoSelect() {
		return departamentoSelect;
	}

	public void setDepartamentoSelect(Departamento departamentoSelect) {
		this.departamentoSelect = departamentoSelect;
	}

	public Departamento getDptoOrigen() {
		return dptoOrigen;
	}

	public void setDptoOrigen(Departamento dptoOrigen) {
		this.dptoOrigen = dptoOrigen;
	}

	public Departamento getDptoDestino() {
		return dptoDestino;
	}

	public void setDptoDestino(Departamento dptoDestino) {
		this.dptoDestino = dptoDestino;
	}

	public String getFilterNameOrigen() {
		return filterNameOrigen;
	}

	public void setFilterNameOrigen(String filterNameOrigen) {
		this.filterNameOrigen = filterNameOrigen;
	}

}