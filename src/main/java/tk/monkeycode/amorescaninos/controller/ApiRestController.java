package tk.monkeycode.amorescaninos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.monkeycode.amorescaninos.domain.entity.Caracteristica;
import tk.monkeycode.amorescaninos.domain.entity.Perfil;
import tk.monkeycode.amorescaninos.domain.entity.Raza;
import tk.monkeycode.amorescaninos.service.AmoresCaninosService;

@RestController
@RequestMapping("/api")
public class ApiRestController {

	@Autowired
	private AmoresCaninosService service;
	
	@GetMapping("/razas")
	public List<Raza> mostrarRazas() {
		return service.obtenerRazas();
	}
	
	@GetMapping("/caracteristicas")
	public List<Caracteristica> mostrarCaracateristicas() {
		return service.obtenerCaracteristicas();
	}
	
	@GetMapping("/perfiles")
	public List<Perfil> mostrarPerfiles() {
		return service.obtenerPerfiles();
	}
	
	@GetMapping("/perfil/{id}")
	public Perfil mostrarPerfil(@PathVariable(name="id") int id) {
		return service.buscarPerfirPorId(id);
	}
	
}
