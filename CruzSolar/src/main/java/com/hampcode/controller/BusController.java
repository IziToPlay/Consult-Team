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
import com.hampcode.model.entity.Bus;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class BusController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private BusBusiness busBusiness;
	
	private Bus bus;
	private List<Bus> buses;
	private Bus busSelect;
	
	@PostConstruct
	public void init() {
		bus = new Bus();
		buses = new ArrayList<Bus>();
		getAllBuses();
	}
	
	public void getAllBuses() {
		try {
			buses = busBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Buses:" + e.getMessage());
		}
	}
		
	public void selectBus(SelectEvent e) {
		this.busSelect = (Bus) e.getObject();
	}

	public BusBusiness getBusBusiness() {
		return busBusiness;
	}

	public void setBusBusiness(BusBusiness busBusiness) {
		this.busBusiness = busBusiness;
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

	public Bus getBusSelect() {
		return busSelect;
	}

	public void setBusSelect(Bus busSelect) {
		this.busSelect = busSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
