package com.prueba;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.negocio.modelos.Producto;
import com.prueba.negocio.modelos.ProductoFinal;
import com.prueba.service.ProductoService;

@SpringBootTest
class ProyectoPruebaTecnicaApplicationTests {

	@Autowired
	private ProductoService productoService;
	
	@Test
	public void getProductosConsultaOK() throws Exception {
		List<Producto> productos = productoService.getProductos();
		assertThat(productos.size()).isEqualTo(4);
	}
	
	@Test
	public void test1() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fecha = formatter.parse("2020-06-14 10:00:00");
		ProductoFinal producto = productoService.getProductoFinal(fecha, 35455L, 1L);
		
		ProductoFinal productoCorrecto = new ProductoFinal();
		productoCorrecto.setPrecioFinal(35.50);
		productoCorrecto.setIdCadena(1L);
		productoCorrecto.setIdTarifaAplicar(1);
		productoCorrecto.setFechaInicioAplicacion(formatter.parse("2020-06-14 00:00:00"));
		productoCorrecto.setFechaFinAplicacion(formatter.parse("2020-12-31 23:59:59"));
		productoCorrecto.setCodigoProducto(35455L);
		
		assertThat(producto.equals(productoCorrecto));	
	}
	
	@Test
	public void test2() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fecha = formatter.parse("2020-06-14 16:00:00");
		ProductoFinal producto = productoService.getProductoFinal(fecha, 35455L, 1L);
		
		ProductoFinal productoCorrecto = new ProductoFinal();
		productoCorrecto.setPrecioFinal(25.45);
		productoCorrecto.setIdCadena(1L);
		productoCorrecto.setIdTarifaAplicar(2);
		productoCorrecto.setFechaInicioAplicacion(formatter.parse("2020-06-14 15:00:00"));
		productoCorrecto.setFechaFinAplicacion(formatter.parse("2020-06-14 18:30:00"));
		productoCorrecto.setCodigoProducto(35455L);
		
		assertThat(producto.equals(productoCorrecto));
	}
	
	@Test
	public void test3() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fecha = formatter.parse("2020-06-14 21:00:00");
		ProductoFinal producto = productoService.getProductoFinal(fecha, 35455L, 1L);
		
		ProductoFinal productoCorrecto = new ProductoFinal();
		productoCorrecto.setPrecioFinal(35.50);
		productoCorrecto.setIdCadena(1L);
		productoCorrecto.setIdTarifaAplicar(1);
		productoCorrecto.setFechaInicioAplicacion(formatter.parse("2020-06-14 00:00:00"));
		productoCorrecto.setFechaFinAplicacion(formatter.parse("2020-12-31 23:59:59"));
		productoCorrecto.setCodigoProducto(35455L);
		
		assertThat(producto.equals(productoCorrecto));
	}
	
	@Test
	public void test4() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fecha = formatter.parse("2020-06-15 10:00:00");
		ProductoFinal producto = productoService.getProductoFinal(fecha, 35455L, 1L);
		
		ProductoFinal productoCorrecto = new ProductoFinal();
		productoCorrecto.setPrecioFinal(30.50);
		productoCorrecto.setIdCadena(1L);
		productoCorrecto.setIdTarifaAplicar(3);
		productoCorrecto.setFechaInicioAplicacion(formatter.parse("2020-06-15 00:00:00"));
		productoCorrecto.setFechaFinAplicacion(formatter.parse("2020-06-15 11:00:00"));
		productoCorrecto.setCodigoProducto(35455L);
		
		assertThat(producto.equals(productoCorrecto));
	}
	
	@Test
	public void test5() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fecha = formatter.parse("2020-06-16 21:00:00");
		ProductoFinal producto = productoService.getProductoFinal(fecha, 35455L, 1L);
		
		ProductoFinal productoCorrecto = new ProductoFinal();
		productoCorrecto.setPrecioFinal(38.95);
		productoCorrecto.setIdCadena(1L);
		productoCorrecto.setIdTarifaAplicar(4);
		productoCorrecto.setFechaInicioAplicacion(formatter.parse("2020-06-15 16:00:00"));
		productoCorrecto.setFechaFinAplicacion(formatter.parse("2020-12-31 23:59:59"));
		productoCorrecto.setCodigoProducto(35455L);
		
		assertThat(producto.equals(productoCorrecto));
	}
}
