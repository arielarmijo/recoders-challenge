package tk.monkeycode.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import tk.monkeycode.amorescaninos.domain.entity.Caracteristica;
import tk.monkeycode.amorescaninos.domain.entity.Perfil;
import tk.monkeycode.amorescaninos.domain.entity.Raza;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
	
	Perfil findById(int id);
	Perfil findFirstByOrderByEdadDesc();
	List<Perfil> findDistinctByRazaInAndEdadInAndGeneroInAndCaracteristicasIn(@Nullable List<Raza> razas,
																			  @Nullable List<Integer> edades,
																			  @Nullable List<String> generos,
																		      @Nullable List<Caracteristica> caracteristicas);

}
