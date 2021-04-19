package com.talento.amorescaninos.service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talento.amorescaninos.domain.Preferencia;
import com.talento.amorescaninos.domain.Sexo;
import com.talento.amorescaninos.domain.entity.Caracteristica;
import com.talento.amorescaninos.domain.entity.Perfil;
import com.talento.amorescaninos.domain.entity.Raza;
import com.talento.amorescaninos.repository.CaracteristicaRepository;
import com.talento.amorescaninos.repository.PerfilRepository;
import com.talento.amorescaninos.repository.RazaRepository;

@Service
public class AmoresCaninosServiceImpl implements AmoresCaninosService {
	
	@Autowired
	private RazaRepository razaRepo;
	
	@Autowired
	private CaracteristicaRepository ccaRepo;
	
	@Autowired
	private PerfilRepository perfilRepo;
	
	private List<String> sexoEnumValues = Stream.of(Sexo.values()).map(Sexo::getValue).collect(Collectors.toList());

	@Override
	public List<Raza> obtenerRazas() {
		return razaRepo.findAllByOrderByNombre();
	}

	@Override
	public List<Caracteristica>  obtenerCaracteristicas() {
		return ccaRepo.findAllByOrderByNombre();
	}
	
	@Override
	public List<Perfil> obtenerPerfiles() {
		return perfilRepo.findAll();
	}
	
	@Override
	public int obtenerEdadMaxima() {
		return perfilRepo.findFirstByOrderByEdadDesc().getEdad();
	}

	// La complejidad del ejercicio está en aplicar los filtros
	@Override
	public List<Perfil> filtrarPerfiles(Preferencia preferencias) {
		// Recupera los filtros
		List<Raza> razas = razaRepo.findAllByIdIn(preferencias.getRazaIds());
		List<Integer> edades = preferencias.getEdades();
		List<String> generos = preferencias.getGeneros();
		List<Caracteristica> caracteristicas = ccaRepo.findAllByIdIn(preferencias.getCcaIds());
		// Si hay filtros vación se rellenan con todas las opciones
		razas = razas.size() == 0 ? razaRepo.findAll() : razas;
		edades = edades.size() == 0 ? generarEdades() : edades;
		generos = generos.size() == 0 ? sexoEnumValues : generos;
		caracteristicas = caracteristicas.size() == 0 ? ccaRepo.findAll() : caracteristicas;
		// Depuración
		System.out.println("Filtros");
		System.out.println("razas: " + razas.size() + ", " + razas);
		System.out.println("edad: " + edades.size() + ", " + edades);
		System.out.println("generos: " + generos.size() + ", " + generos);
		System.out.println("caracteristicas: " + caracteristicas.size() + ", " + caracteristicas);
		System.out.println();
		// Aplica el filtro
		return perfilRepo.findDistinctByRazaInAndEdadInAndGeneroInAndCaracteristicasIn(razas, edades, generos, caracteristicas);
	}

	@Override
	public List<String> obtenerGeneros() {
		return sexoEnumValues;
	}
	
	private List<Integer> generarEdades() {
		List<Integer> edades = new ArrayList<>();
		for (int i = 1; i <= obtenerEdadMaxima(); i++)
			edades.add(i);
		return edades;
	}

	@Override
	public Perfil buscarPerfirPorId(int id) {
		return perfilRepo.findById(id);
	}

}
