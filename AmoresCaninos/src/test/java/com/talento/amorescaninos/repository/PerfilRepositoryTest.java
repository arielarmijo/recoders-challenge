package com.talento.amorescaninos.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.talento.amorescaninos.config.AppConfig;
import com.talento.amorescaninos.domain.entity.Perfil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
//@Sql(scripts = {"/amorescaninos_datos.sql"})
public class PerfilRepositoryTest {
	
	@Autowired
	private PerfilRepository perfilRepo;

	@Test
	public void testFindAll() {
		List<Perfil> perfiles = perfilRepo.findAll();
		System.out.println(perfilRepo.count());
		perfiles.forEach(perfil -> System.out.println(perfil.getNombre()));
		assertEquals(25, perfilRepo.count());
	}
	
	@Test
	public void testFindFirstByOrderByEdadDesc() {
		Perfil p = perfilRepo.findFirstByOrderByEdadDesc();
		System.out.println("Edad máxima " + p.getEdad());
	}

}
