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
import com.talento.amorescaninos.domain.entity.Caracteristica;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
//@Sql(scripts = {"/amorescaninos_datos.sql"})
public class CaracteristicaRepositoryTest {

	@Autowired
	private CaracteristicaRepository ccaRepo;
	@Test
	public void testFindAll() {
		List<Caracteristica> ccas = ccaRepo.findAll();
		System.out.println(ccaRepo.count());
		ccas.forEach(cca -> System.out.println(cca.getNombre()));
		assertEquals(52, ccaRepo.count());
	}

}
