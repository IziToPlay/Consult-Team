package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viajes")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fechaInicio", nullable = false)
	private String fechaInicio;

	@Column(name = "fechaFinal", nullable = false)
	private String fechaFinal;

	@Column(name = "precio", nullable = false)
	private double precio;

	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	@ManyToOne
	@JoinColumn(name = "dptoOrigen_id")
	private Departamento dptoOrigen;

	@ManyToOne
	@JoinColumn(name = "dptoDestino_id")
	private Departamento dptoDestino;

	@ManyToOne
	@JoinColumn(name = "empleado_id")
	private Empleado empleado;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
