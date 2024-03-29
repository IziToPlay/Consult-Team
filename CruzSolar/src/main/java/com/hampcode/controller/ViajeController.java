package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Convert;

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
	
	@Inject
	private AsientoController asientoController;

	private Viaje viaje;
	private List<Viaje> viajes;
	private Viaje viajeSelect;
	private String filterName;
	private String filterNameOrigen;
	private Long busID;

	private Departamento departamentoOrigen;
	private Departamento departamentoDestino;
	private List<Departamento> departamentos;
	private Departamento departamentoSelect;

	private Bus bus;
	private List<Bus> buses;

	@PostConstruct
	public void init() {
		viaje = new Viaje();
		departamentoOrigen = new Departamento();
		departamentoDestino = new Departamento();
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
		return "/viaje/new.xhtml";
	}

	public String listViaje() {
		return "/viaje/list.xhtml";
	}

	public String saveViaje() throws Exception {

		String view = "";
		try {
			if (viaje.getId() != null) {
				if (viaje.getFechaFinal().toString() != "" && viaje.getFechaInicio().toString() != "") {
					if (viaje.getPrecio() > 0) {
						if (departamentoDestino.getNombre() == departamentoOrigen.getNombre())
							Message.messageError("Origen y Destino no deben ser iguales");
						else {
							viaje.setBus(bus);
							viaje.setDptoDestino(departamentoDestino);
							viaje.setDptoOrigen(departamentoOrigen);
							
							viajeBusiness.update(viaje);
							Message.messageInfo("Registro actualizado exitosamente");
							view = "list";
							resetForm();
						}
					} else {
						Message.messageInfo("El valor del precio debe ser mayor a 0");
					}
				}
				else {
					Message.messageInfo("Rellene los campos faltantes");
				}
			} else {
				if (departamentoDestino.getNombre() == departamentoOrigen.getNombre()) {
					Message.messageError("Origen y Destino no deben ser iguales");
				}
				else {
					viaje.setBus(bus);
					viaje.setDptoDestino(departamentoDestino);
					viaje.setDptoOrigen(departamentoOrigen);

					viajeBusiness.insert(viaje);
					Message.messageInfo("El viaje se ha registrado exitosamente");
					view = "list";
					resetForm();
				}
			}
			this.getAllViajes();
			this.getAllBuses();

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
//<<<<<<< HEAD
			    getAllBuses();
//=======
				getAllBuses();
//>>>>>>> d9fdde43c4f5481d0cacde203c304e3d433a6abd
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

	// Seleccionar ruta de viaje para enlazarla a la boleta (Rol: Recepcionista)
		public String enlazarViaje() {
			String view = "";
			try {
				if (this.viajeSelect != null) {
					this.viaje = viajeSelect;
					view = "/boleta/insert.xhtml";
					Message.messageInfo("Ruta de viaje seleccionada correctamente");
				} else {
					Message.messageInfo("Debe seleccionar una ruta de viaje");
				}

			} catch (Exception e) {
				Message.messageError("Error Viaje:" + e.getMessage());
			}
			return view;
		}
		
		
		//Metodo para enlazar Viaje con Asiento (Se usa en el AsientoController)
		public Long EnlazarViajeConAsiento() {
			
			busID=this.viaje.getBus().getId();
			return busID;
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
			this.departamentos = departamentoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Departamentos " + e.getMessage());
		}
	}

	public void getAllBuses() {
		try {
			this.buses = busBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Cargar de Buses " + e.getMessage());
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
				view = "/viaje/list.xhtml";
				Message.messageInfo("Ruta de viaje eliminada correctamente");
			} else {
				Message.messageInfo("Debe seleccionar una ruta de viaje");
			}
			//this.getAllViajes();
			
		} catch (Exception e) {
			Message.messageError("Error Ruta de Viaje: " + e.getStackTrace());
		}
		return view;
	}

	//Buscar ruta de viaje por Destino (Rol: Consultor de Viajes, Recepcionista)
		public void searchViajeByName() {
			try {
				if(filterName.isEmpty()== true) {
					
					Message.messageInfo("Debe completar los campos de busqueda");

					}else {
						if (viajes.isEmpty()==false) {
							viajes = viajeBusiness.getViajesByName(this.filterName.trim());
							resetForm();
							Message.messageInfo("B�squeda realizada correctamente");
							}else{
								Message.messageInfo("No se han encontrado coincidencias");
								getAllViajes();
							}
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

	public BusBusiness getBusBusiness() {
		return busBusiness;
	}

	public void setBusBusiness(BusBusiness busBusiness) {
		this.busBusiness = busBusiness;
	}

	public AsientoController getAsientoController() {
		return asientoController;
	}

	public void setAsientoController(AsientoController asientoController) {
		this.asientoController = asientoController;
	}

	public Long getBusID() {
		return busID;
	}

	public void setBusID(Long busID) {
		this.busID = busID;
	}

}