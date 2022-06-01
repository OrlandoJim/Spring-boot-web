package com.bolsadeideas.springboot.web.app.controllers;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping({"/index","/", "/home","/1"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@GetMapping({ "/home","/2"})
	public String index(ModelMap model) {
		model.addAttribute("titulo","Hola spring framework modelmap");
		return "index";
	}
	
	@GetMapping({"/home","/3"})
	public String index(Map<String, Object> map) {
		map.put("titulo","Hola spring framework map");
		return "index";
	}
	
	@GetMapping({ "/home","/4"})
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo","Hola spring framework modelAndView");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/perfil")
	public String perfil (Model model) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre("Orlando");
		usuario.setApellido("Jiménez");
		usuario.setEmail("orlandoj922@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar (Model model) {
		
		model.addAttribute("titulo",textoListar);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		//De esta forma se agregan elementos a la lista mediante el Arrays.asList()
				List<Usuario> usuarios = Arrays.asList(new Usuario("Orlando","Jiménez","Orlando.jimenez@correo.mx"),
						new Usuario("Gustavo","Jiménez","Gustavo.jimenez@correo.mx"),
						new Usuario("Mariel","Jiménez","Mariel.jimenez@correo.mx"));
				
				//Esta es una forma de agregar elementos a la lista usando ArrayList
				/*List<Usuario> usuarios = new ArrayList<>();
				usuarios.add(new Usuario("Orlando","Jiménez","Orlando.jimenez@correo.mx"));
				usuarios.add(new Usuario("Gustavo","Jiménez","Gustavo.jimenez@correo.mx"));
				usuarios.add(new Usuario("Mariel","Jiménez","Mariel.jimenez@correo.mx"));*/
		
		return usuarios;
		
	}
}
