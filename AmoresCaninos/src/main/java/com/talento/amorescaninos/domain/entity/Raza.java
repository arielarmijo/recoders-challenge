package com.talento.amorescaninos.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="raza")
@SequenceGenerator(name="razaSeq", sequenceName = "raza_seq", allocationSize = 1)
public class Raza {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="razaSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy = "raza", fetch = FetchType.EAGER)
	Set<Perfil> perfiles;
	
	public Raza() {
		super();
	}

	public Raza(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
