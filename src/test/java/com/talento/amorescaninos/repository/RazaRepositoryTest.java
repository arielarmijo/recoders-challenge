package com.talento.amorescaninos.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tk.monkeycode.amorescaninos.config.AppConfig;
import tk.monkeycode.amorescaninos.domain.entity.Raza;
import tk.monkeycode.amorescaninos.repository.RazaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
//@Sql(scripts = {"/amorescaninos_datos.sql"})
public class RazaRepositoryTest {
	
	@Autowired
	private RazaRepository razaRepo;

	@Test
	public void testFindAll() {
		List<Raza> razas = razaRepo.findAllByOrderByNombre();
		System.out.println(razaRepo.count());
		razas.forEach(raza -> System.out.println(raza.getNombre()));
		assertEquals(22, razaRepo.count());
	}

}
