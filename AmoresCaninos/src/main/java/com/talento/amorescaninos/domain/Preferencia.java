package com.talento.amorescaninos.domain;

import java.util.ArrayList;
import java.util.List;

public class Preferencia {

	private List<Integer> razaIds  = new ArrayList<>();
	private List<Integer> edades = new ArrayList<>();
	private List<String> generos = new ArrayList<>();
	private List<Integer> ccaIds  = new ArrayList<>();
	
	public Preferencia() {
	}

	public List<Integer> getRazaIds() {
		return razaIds;
	}

	public void setRazaIds(List<Integer> razaIds) {
		// El valor 0 corresponde a "Seleccionar Raza" en la lista desplegable de la vista
		if (razaIds.contains(0))
			razaIds.remove((Integer) 0);
		this.razaIds = razaIds;
	}

	public List<Integer> getEdades() {
		return edades;
	}

	public void setEdades(List<Integer> edades) {
		this.edades = edades;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}

	public List<Integer> getCcaIds() {
		return ccaIds;
	}

	public void setCcaIds(List<Integer> ccaIds) {
		this.ccaIds = ccaIds;
	}

	@Override
	public String toString() {
		return "Preferencias: razaIds=" + razaIds + ", edades=" + edades + ", generos=" + generos + ", ccaIds=" + ccaIds;
	}

}
