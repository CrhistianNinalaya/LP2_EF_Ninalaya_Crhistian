package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/menu")
	public String showMenu(HttpSession session, Model model) {
//		if(session.getAttribute("usuario") == null) {
//			return "redirect:/";
//		}
		
//		String correo = session.getAttribute("usuario").toString();
//		UsuarioEntity usuarioEntity = usuarioService.buscarUsuarioPorCorreo(correo);
//		model.addAttribute("foto", usuarioEntity.getUrlImagen());
				
		List<ProductoEntity>productos = productoService.findAllProductos();

		model.addAttribute("productos", productos);			

		// push
		return "mantener_productos";
	}
	@PostMapping("/filtrarProducto")
	public String filtrarPorId(@RequestParam("inputId") Integer inputId, Model model) {
	    System.out.println("Valor introducido: " + inputId);
	    ProductoEntity productoBuscado = productoService.findByIdProducto(inputId);
	    System.out.println(productoBuscado);
	    
	    if(productoBuscado !=null) {
	    	model.addAttribute("productos",productoBuscado);	    
	    } else {
	    	model.addAttribute("msgRetorno", "No existe ningun producto con ese ID");
	    }
	    
	    return "mantener_productos";
	}
	
	
	@GetMapping("/agregarProducto")
	public String showagregarProducto(Model model) {	
		model.addAttribute("producto", new ProductoEntity());
		List<CategoriaEntity> lstCategorias = categoriaService.getlstCategorias();
		model.addAttribute("lstCategorias", lstCategorias);
		return "agregar_producto";
	}
	@PostMapping("/agregarProducto")
	public String agregarProducto(ProductoEntity productoEntity , Model model) {
		String ruta="agregar_producto"; 
		 CategoriaEntity categoriaEntity = productoEntity.getCategoriaEntity();
		if(categoriaEntity == null) {
			List<CategoriaEntity> lstCategorias = categoriaService.getlstCategorias();
			model.addAttribute("lstCategorias", lstCategorias);
			model.addAttribute("msgRetorno", "Seleccione una categoria");
			model.addAttribute("classRetorno", "alert alert-danger");
			model.addAttribute("producto", productoEntity);
			
			return ruta;
		}
		System.out.println(categoriaEntity.toString());
		System.out.println(productoEntity.toString());
		productoService.crearProducto(productoEntity, model);
		model.addAttribute("producto", new ProductoEntity());
		return "/agregar_producto";
	}	
	
	@GetMapping("/editarProducto/{id}")
	public String showeditarProducto(Model model, @PathVariable("id")Integer id) {
				
		List<CategoriaEntity> lstCategorias = categoriaService.getlstCategorias();
		ProductoEntity productoEncontrado = productoService.findByIdProducto(id);

		model.addAttribute("lstCategorias", lstCategorias);
		model.addAttribute("producto",productoEncontrado);
		return "editar_producto";
	}
	@PostMapping("/editarProducto")
	public String editarProducto(ProductoEntity productoEntity , Model model) {
		String ruta="editar_producto"; 
		 CategoriaEntity categoriaEntity = productoEntity.getCategoriaEntity();
		if(categoriaEntity == null) {
			List<CategoriaEntity> lstCategorias = categoriaService.getlstCategorias();
			model.addAttribute("lstCategorias", lstCategorias);
			model.addAttribute("msgRetorno", "Seleccione una categoria");
			model.addAttribute("classRetorno", "alert alert-danger");
			model.addAttribute("producto", productoEntity);
			
			return ruta;
		}
		productoService.editarProducto(productoEntity,model);
		return "redirect:/menu";
	}
	@GetMapping("/verProducto/{id}")
	public String showVerProducto(Model model, @PathVariable("id")Integer id) {
		ProductoEntity productoEncontrado = productoService.findByIdProducto(id);
		
		model.addAttribute("producto",productoEncontrado);
		return "detalle_producto";
	}
	@GetMapping("/borrarProducto/{id}")
	public String eliminarEmpleado(@PathVariable("id")Integer id) {
		productoService.borrarProducto(id);
		return "redirect:/menu";
	}
	
}
