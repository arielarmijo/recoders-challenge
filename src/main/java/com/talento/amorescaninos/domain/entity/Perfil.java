package com.talento.amorescaninos.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="perfil")
@SequenceGenerator(name="perfilSeq", sequenceName = "perfil_seq", allocationSize = 1)
public class Perfil {
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator="perfilSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@Column(name="genero", length=15, nullable=false)
	private String genero;
	
	@Column(name="edad", nullable=false)
	private int edad;
	
	@Column(name="frase", length=100, nullable=false)
	private String frase;
	
	@Column(name="url_imagen", length=200, nullable=false)
	private String urlImagen;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="raza_id")
	private Raza raza;
	
	@ManyToMany(fetch=FetchType.EAGER,
			    cascade={CascadeType.DETACH,
			    		 CascadeType.MERGE,
			    		 CascadeType.PERSIST,
			    		 CascadeType.PERSIST,
			    		 CascadeType.REFRESH})
	@JoinTable(name="perfil_has_caracteristica", 
			   joinColumns=@JoinColumn(name="perfil_id"), 
			   inverseJoinColumns=@JoinColumn(name="caracteristica_id"))
	private Set<Caracteristica> caracteristicas;

	public Perfil() {
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nombre=" + nombre + ", genero=" + genero + ", edad=" + edad + ", frase=" + frase
				+ ", urlImagen=" + urlImagen + ", raza=" + raza + ", caracteristicas=" + caracteristicas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
