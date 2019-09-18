package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GenerationType;

@Entity
@Table(name = "cuentas")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "clave", nullable = false)
	private String clave;

	@ManyToOne
	@Column(name = "cargo_id", nullable = false)
	private Cargo cargo;

	@ManyToOne
	@Column(name = "empleado_id", nullable = false)
	private Empleado empleado;

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (empleado == null) {
			if (other.empleado != null)
				return false;
		} else if (!empleado.equals(other.empleado))
			return false;
		return true;
	}

}
