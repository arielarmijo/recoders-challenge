package tk.monkeycode.amorescaninos.domain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="caracteristica")
@SequenceGenerator(name="razaSeq", sequenceName = "caracteristica_seq", allocationSize = 1)
public class Caracteristica {

	@Id
	@Column(name="id")
	@GeneratedValue(generator="razaSeq", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "caracteristicas", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Perfil> perfiles;
	
	public Caracteristica() {
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

	public Set<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(Set<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
}
