package com.prueba.persistencia.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private CadenaEntity cadena;
	
	@Column(name = "codigoproducto")
	private Long codigoProducto;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "fechainicioaplicacion")
	private Date fechaInicioAplicacion;
	
	@Column(name = "fechafinaplicacion")
	private Date fechaFinAplicacion;
	
	@Column(name = "moneda")
	private String moneda;
	
	@Column(name = "identificadortarifa")
	private int identificadorTarifa;	
	
	@Column(name = "prioridad")
	private int prioridad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CadenaEntity getCadena() {
		return cadena;
	}

	public void setCadena(CadenaEntity cadena) {
		this.cadena = cadena;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaInicioAplicacion() {
		return fechaInicioAplicacion;
	}

	public void setFechaInicioAplicacion(Date fechaInicioAplicacion) {
		this.fechaInicioAplicacion = fechaInicioAplicacion;
	}

	public Date getFechaFinAplicacion() {
		return fechaFinAplicacion;
	}

	public void setFechaFinAplicacion(Date fechaFinAplicacion) {
		this.fechaFinAplicacion = fechaFinAplicacion;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public int getIdentificadorTarifa() {
		return identificadorTarifa;
	}

	public void setIdentificadorTarifa(int identificador) {
		this.identificadorTarifa = identificador;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	
}
