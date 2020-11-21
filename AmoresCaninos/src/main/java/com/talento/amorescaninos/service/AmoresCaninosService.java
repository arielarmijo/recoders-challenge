package com.talento.amorescaninos.service;

import java.util.List;

import com.talento.amorescaninos.domain.Preferencia;
import com.talento.amorescaninos.domain.entity.Caracteristica;
import com.talento.amorescaninos.domain.entity.Perfil;
import com.talento.amorescaninos.domain.entity.Raza;

public interface AmoresCaninosService {
	
	List<Raza> obtenerRazas();
	int obtenerEdadMaxima();
	List<String> obtenerGeneros();
	List<Caracteristica> obtenerCaracteristicas();
	List<Perfil> obtenerPerfiles();
	List<Perfil> filtrarPerfiles(Preferencia preferencias);
	Perfil buscarPerfirPorId(int id);

}
