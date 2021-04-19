package com.talento.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.amorescaninos.domain.entity.Raza;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {
	
	List<Raza> findAllByOrderByNombre();
	List<Raza> findAllByIdIn(List<Integer> ids);
	
}
