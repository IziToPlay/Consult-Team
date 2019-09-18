package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
@Table(name = "boletas")
public class Boleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "monto", nullable = false)
	private double monto;

	@Column(name = "fechaEmision", nullable = false)
	private String fechaEmision;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;

	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	@ManyToOne
	@JoinColumn(name = "asiento_id")
	private Asiento asiento;

	@ManyToOne
	@JoinColumn(name = "viaje_id")
	private Viaje viaje;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
