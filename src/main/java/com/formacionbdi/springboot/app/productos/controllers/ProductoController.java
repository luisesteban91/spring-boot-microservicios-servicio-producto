package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController
public class ProductoController {
	
	/*
	 * obtene los datos del enviroment
	 */
	private Environment env;
	
	@Autowired
	private IProductoService productoService;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.finAll()
				.stream().map(
					producto -> {
						producto.setPort(Integer.parseInt(port));
						return producto;
					}
				).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findByID(id);
		producto.setPort(Integer.parseInt(port));
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}*/
		return producto;
	}
}
