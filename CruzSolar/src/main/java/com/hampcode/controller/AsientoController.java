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
import com.hampcode.business.BusBusiness;
import com.hampcode.model.entity.Asiento;
import com.hampcode.model.entity.Bus;
import com.hampcode.util.Message;

@Named

@SessionScoped
public class AsientoController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private AsientoBusiness asientoBusiness;
	private Asiento asiento;
	private List<Asiento> asientos;
	private Asiento asientoSelect;
	
	int busidfilter;
	
	@PostConstruct
	public void init() {
		asiento = new Asiento();
		asientos = new ArrayList<Asiento>();
		//getAllAsientos();
		getAsientosByBus(busidfilter);
	}
	
	public void getAllAsientos() {
		try {
			asientos = asientoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Asientos:" + e.getMessage());
		}
	}
	
	public void getAsientosByBus(long id) {
         try {
			asientos = asientoBusiness.getAsientosByBus(id);
		 } catch (Exception e) {
			Message.messageError("Error Asiento :" + e.getMessage());
		}
	}
	
	public void selectAsiento(SelectEvent e) {
		this.asiento = (Asiento) e.getObject();
	}

	public AsientoBusiness getAsientoBusiness() {
		return asientoBusiness;
	}

	public void setAsientoBusiness(AsientoBusiness asientoBusiness) {
		this.asientoBusiness = asientoBusiness;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public Asiento getAsientoSelect() {
		return asientoSelect;
	}

	public void setAsientoSelect(Asiento asientoSelect) {
		this.asientoSelect = asientoSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

	