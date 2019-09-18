package com.hampcode.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Cliente;
import com.hampcode.model.entity.Viaje;

@Named
public class ClienteRepository  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	List<Cliente> clientes=new ArrayList<>();
	Cliente cliente;

	public void ingresarCliente(long cantidad) throws Exception{
		
		for (long i=1; i<=cantidad; i++){
			cliente=new Cliente();
			clientes.add(cliente); 
		}
	}
}
