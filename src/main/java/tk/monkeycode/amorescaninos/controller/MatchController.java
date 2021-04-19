package tk.monkeycode.amorescaninos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tk.monkeycode.amorescaninos.domain.Preferencia;
import tk.monkeycode.amorescaninos.service.AmoresCaninosService;

@Controller
public class MatchController {
	
	@Autowired
	private AmoresCaninosService service;
	
	@GetMapping("/buscarPerfil")
	public String buscador(Model modelo) {
		modelo.addAttribute("preferencias", new Preferencia());
		modelo.addAttribute("razas", service.obtenerRazas());
		modelo.addAttribute("edadMaxima", service.obtenerEdadMaxima());
		modelo.addAttribute("generos", service.obtenerGeneros());
		modelo.addAttribute("caracteristicas", service.obtenerCaracteristicas());
		return "preferencias";
	}
	
	@PostMapping("/buscarPerfil")
	public String procesaBusqueda(@ModelAttribute(name="preferencias") Preferencia preferencias, Model modelo) {
		System.out.println(preferencias);
		modelo.addAttribute("perfiles", service.filtrarPerfiles(preferencias));
		return "perfiles";
	}
	
	@GetMapping("/perfiles")
	public String mostrarTodosLosPerfiles(Model modelo) {
		modelo.addAttribute("perfiles", service.obtenerPerfiles());
		return "perfiles";
	}
	
}
