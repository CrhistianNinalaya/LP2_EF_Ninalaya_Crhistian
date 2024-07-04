package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.ProductoEntity;

import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> findAllProductos() {		
		return productoRepository.findAll();
	}

	@Override
	public void crearProducto(ProductoEntity productoEntity, Model model) {
		productoRepository.save(productoEntity);

		model.addAttribute("msgRetorno", "Registro Correcto");
		model.addAttribute("classRetorno", "alert alert-success");
		model.addAttribute("producto", new ProductoEntity());
	}

	@Override
	public ProductoEntity findByIdProducto(Integer id) {
		return productoRepository.findByIdProducto(id);
	}

	@Override
	public void editarProducto(ProductoEntity productoEntity, Model model) {
		productoRepository.save(productoEntity);
		model.addAttribute("msgRetorno", "Actualizacion realizada");
	}

	@Override
	public void borrarProducto(Integer idProducto) {
		productoRepository.deleteById(idProducto);
	}
}
