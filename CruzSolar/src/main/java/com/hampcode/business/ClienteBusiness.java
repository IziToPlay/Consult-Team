package com.hampcode.business;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.model.entity.Cliente;
import com.hampcode.model.repository.ClienteRepository;

@Named
public class ClienteBusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteRepository clienteRepository;

	@Transactional
	public void insert(Cliente cliente) throws Exception {
		clienteRepository.insert(cliente);
	}

	@Transactional
	public void update(Cliente cliente) throws Exception {
		clienteRepository.update(cliente);
	}

	@Transactional
	public void delete(Cliente cliente) throws Exception {
		clienteRepository.delete(cliente);
	}
	
	public List<Cliente> getAll() throws Exception {
		return clienteRepository.findAll();
	}
	
	public List<Cliente> getClienteByDNI(String dni) throws Exception{
		return clienteRepository.findByDNI(dni);
	}
	
}
