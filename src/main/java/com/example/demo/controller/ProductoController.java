package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;

@Controller
public class ProductoController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/menu")
	public String showMenu(jakarta.servlet.http.HttpSession session, Model model) {
//		if(session.getAttribute("usuario") == null) {
//			return "redirect:/";
//		}
		
		String correo = session.getAttribute("usuario").toString();
		UsuarioEntity usuarioEntity = usuarioService.buscarUsuarioPorCorreo(correo);
		model.addAttribute("foto", usuarioEntity.getUrlImagen());
				
		List<ProductoEntity>productos = productoService.findAllProductos();
		if(productos != null) {
			model.addAttribute("productos", productos);						
		} else {
			List<ProductoEntity> lstVacia = new ArrayList<ProductoEntity>();
			model.addAttribute("productos", lstVacia);
		}
		

		// push
		return "menu";
	}

}
