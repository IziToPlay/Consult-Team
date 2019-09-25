package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.ClienteBusiness;

import com.hampcode.model.entity.Boleta;
import com.hampcode.model.entity.Cliente;
import com.hampcode.model.entity.Empleado;
import com.hampcode.model.entity.Viaje;
import com.hampcode.util.Message; 

@Named
@SessionScoped
public class ClienteController implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ClienteBusiness clienteBusiness;
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private Cliente clienteSelect;
	private String filterName;
	
	@PostConstruct
	public void init() {
		cliente= new Cliente();
		clientes=new ArrayList<Cliente>();
		getAllClientes();
	}
	
	public void selectCliente(SelectEvent e) {
		this.clienteSelect = (Cliente) e.getObject();
	}
	
	public void getAllClientes() {
		try {
			clientes = clienteBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Carga de Clientes:" + e.getMessage());
		}
	}
	
	//Enlazar cliente seleccionado a la Boleta
		public void enlazarCliente() {
			try {
				if (this.clienteSelect != null) {
					this.cliente = clienteSelect;
					Message.messageInfo("Cliente seleccionado correctamente");
					getAllClientes();
				} else {
					Message.messageInfo("Debe seleccionar un cliente");
				}

			} catch (Exception e) {
				Message.messageError("Error Cliente:" + e.getMessage());
			}
		}
		
		//Buscar cliente por DNI
		public void searchClienteByDNI() {
				try {
					if(filterName.isEmpty() == true) {
						Message.messageInfo("Debe completar los campos de busqueda");
						} else {
							if (clientes.isEmpty()==false) {
								clientes = clienteBusiness.getClienteByDNI(this.filterName.trim());
								this.filterName="";
								Message.messageInfo("Búsqueda realizada correctamente");
								}
							else{
									Message.messageInfo("No se han encontrado coincidencias");
									//getAllClientes();
								}
						}
				} catch (Exception e) {
					
					Message.messageError("Error Cliente Search :" + e.getMessage());
				}
		}

		public ClienteBusiness getClienteBusiness() {
			return clienteBusiness;
		}

		public void setClienteBusiness(ClienteBusiness clienteBusiness) {
			this.clienteBusiness = clienteBusiness;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(List<Cliente> clientes) {
			this.clientes = clientes;
		}

		public Cliente getClienteSelect() {
			return clienteSelect;
		}

		public void setClienteSelect(Cliente clienteSelect) {
			this.clienteSelect = clienteSelect;
		}

		public String getFilterName() {
			return filterName;
		}

		public void setFilterName(String filterName) {
			this.filterName = filterName;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}
