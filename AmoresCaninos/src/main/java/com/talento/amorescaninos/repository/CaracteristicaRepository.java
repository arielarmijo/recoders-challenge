package com.talento.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talento.amorescaninos.domain.entity.Caracteristica;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Integer> {
	
	List<Caracteristica> findAllByOrderByNombre();
	List<Caracteristica> findAllByIdIn(List<Integer> ids);
}
