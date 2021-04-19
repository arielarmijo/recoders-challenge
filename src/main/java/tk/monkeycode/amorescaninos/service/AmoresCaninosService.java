package tk.monkeycode.amorescaninos.service;

import java.util.List;

import tk.monkeycode.amorescaninos.domain.Preferencia;
import tk.monkeycode.amorescaninos.domain.entity.Caracteristica;
import tk.monkeycode.amorescaninos.domain.entity.Perfil;
import tk.monkeycode.amorescaninos.domain.entity.Raza;

public interface AmoresCaninosService {
	
	List<Raza> obtenerRazas();
	int obtenerEdadMaxima();
	List<String> obtenerGeneros();
	List<Caracteristica> obtenerCaracteristicas();
	List<Perfil> obtenerPerfiles();
	List<Perfil> filtrarPerfiles(Preferencia preferencias);
	Perfil buscarPerfirPorId(int id);

}
