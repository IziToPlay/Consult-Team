package com.hampcode.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
@Table(name="buses")
public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="placa", nullable=false)
	private String placa;
	
	@Column(name="cantAsiento", nullable=false)
	private int cantAsiento;
	
	@Column(name="disponible", nullable=false)
	private boolean disponible;
	
	public boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	public int getCantAsiento() {
		return cantAsiento;
	}
	public void setCantAsiento(int cantAsiento) {
		this.cantAsiento = cantAsiento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}