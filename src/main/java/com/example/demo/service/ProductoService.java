package com.example.demo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.demo.entity.ProductoEntity;

public interface ProductoService {
	void crearProducto(ProductoEntity productoEntity, Model model);
	void editarProducto(ProductoEntity productoEntity, Model model);
	void borrarProducto(Integer idProducto);
	List<ProductoEntity>findAllProductos();
	ProductoEntity findByIdProducto(Integer id);
}
