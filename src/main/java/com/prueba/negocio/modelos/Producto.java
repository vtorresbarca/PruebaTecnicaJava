package com.prueba.negocio.modelos;

import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1100732103185714539L;

	private Long id;
	
	private Cadena cadena;
	
	private Long codigoProducto;
	
	private double precio;
	
	private Date fechaInicioAplicacion;
	
	private Date fechaFinAplicacion;
	
	private String moneda;
	
	private int identificadorTarifa;
	
	private int prioridad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cadena getCadena() {
		return cadena;
	}

	public void setCadena(Cadena cadena) {
		this.cadena = cadena;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
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

	public void setIdentificadorTarifa(int identificadorTarifa) {
		this.identificadorTarifa = identificadorTarifa;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
}
