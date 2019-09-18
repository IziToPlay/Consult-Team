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
import com.hampcode.model.entity.Departamento;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class DepartamentoController implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DepartamentoBusiness departamentoBusiness;
	
	private Departamento departamento;
	private List<Departamento> departamentos;
	private Departamento departamentoSelect;
	
	@PostConstruct
	public void init() {
		departamento = new Departamento();
		departamentos = new ArrayList<Departamento>();
		getAllDepartamentos();
	}
	
	public void getAllDepartamentos() {
		try {
			departamentos = departamentoBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Departamentos:" + e.getMessage());
		}
	}

	public void selectDepartamento(SelectEvent e) {
		this.departamentoSelect = (Departamento) e.getObject();
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Departamento getDepartamentoSelect() {
		return departamentoSelect;
	}

	public void setDepartamentoSelect(Departamento departamentoSelect) {
		this.departamentoSelect = departamentoSelect;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
