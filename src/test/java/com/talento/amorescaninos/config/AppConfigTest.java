package com.talento.amorescaninos.config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import tk.monkeycode.amorescaninos.config.AppConfig;

// Probando conexión a base de datos
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class AppConfigTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManager;
	
	@Autowired
	JpaTransactionManager transactionManager;

	@Test
	public void testDataSource() throws SQLException {
		System.out.println(dataSource.toString());
		assertNotNull(dataSource);
		Connection conn = dataSource.getConnection();
		assertFalse(dataSource.getConnection().isClosed());
		conn.close();
		assertTrue(conn.isClosed());
	}

	@Test
	public void testSessionFactory() {
		System.out.println(entityManager.toString());
		assertNotNull(entityManager);
		assertTrue(entityManager.isSingleton());
	}

	@Test
	public void testTransactionManager() {
		System.out.println(transactionManager.toString());
		assertNotNull(transactionManager);
	}

}
