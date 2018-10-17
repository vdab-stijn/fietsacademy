package be.vdab.academy.services;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/insertTeacher.sql")
public class DefaultTeacherServiceIntegrationTest
extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DefaultTeacherService service;
	@Autowired
	private EntityManager manager;
	
	private long idOfTestTeacherMale() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM docenten WHERE voornaam='testM'", Long.class);
	}
	
	@Test
	public void raise() {
		final long id = idOfTestTeacherMale();
		service.raise(id, BigDecimal.TEN);
		manager.flush();
		
		BigDecimal newWages = super.jdbcTemplate.queryForObject(
				"SELECT wedde FROM docenten WHERE id=?", BigDecimal.class, id);
		
		assertEquals(0, BigDecimal.valueOf(1_100L).compareTo(newWages));
	}
}
