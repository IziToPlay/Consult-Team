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
@Table(name = "asientos_viajes")
public class AsientoViaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "bus_id", nullable = false)
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name = "asiento_id", nullable = false)
	private Asiento asiento;
	
	@ManyToOne
	@JoinColumn(name = "viaje_id", nullable = false)
	private Viaje viaje;
	
	@Column(name = "disponible", nullable = false)
	private boolean disponible;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asiento == null) ? 0 : asiento.hashCode());
		result = prime * result + ((bus == null) ? 0 : bus.hashCode());
		result = prime * result + ((viaje == null) ? 0 : viaje.hashCode());
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
		AsientoViaje other = (AsientoViaje) obj;
		if (asiento == null) {
			if (other.asiento != null)
				return false;
		} else if (!asiento.equals(other.asiento))
			return false;
		if (bus == null) {
			if (other.bus != null)
				return false;
		} else if (!bus.equals(other.bus))
			return false;
		if (viaje == null) {
			if (other.viaje != null)
				return false;
		} else if (!viaje.equals(other.viaje))
			return false;
		return true;
	}
	
	
}
