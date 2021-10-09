package com.prueba.negocio.modelos;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductoFinal {

	private Long idCadena;
	
	private Long codigoProducto;
	
	private int idTarifaAplicar;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaInicioAplicacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaFinAplicacion;
	
	private double precioFinal;

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

	public Long getIdCadena() {
		return idCadena;
	}

	public void setIdCadena(Long idCadena) {
		this.idCadena = idCadena;
	}

	public int getIdTarifaAplicar() {
		return idTarifaAplicar;
	}

	public void setIdTarifaAplicar(int idTarifaAplicar) {
		this.idTarifaAplicar = idTarifaAplicar;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaFinAplicacion, fechaInicioAplicacion, idCadena, codigoProducto, idTarifaAplicar,
				precioFinal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoFinal other = (ProductoFinal) obj;
		return Objects.equals(fechaFinAplicacion, other.fechaFinAplicacion)
				&& Objects.equals(fechaInicioAplicacion, other.fechaInicioAplicacion)
				&& Objects.equals(idCadena, other.idCadena) && Objects.equals(codigoProducto, other.codigoProducto)
				&& idTarifaAplicar == other.idTarifaAplicar
				&& Double.doubleToLongBits(precioFinal) == Double.doubleToLongBits(other.precioFinal);
	}

	
}
