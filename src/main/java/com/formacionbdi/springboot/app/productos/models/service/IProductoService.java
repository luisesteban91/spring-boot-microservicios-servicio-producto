package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> finAll();
	public Producto findByID(Long id);
}
