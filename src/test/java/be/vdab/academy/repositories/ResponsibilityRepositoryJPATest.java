package be.vdab.academy.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.academy.entities.Responsibility;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Sql("/insertResponsibility.sql")
@Import(ResponsibilityRepositoryJPA.class)
public class ResponsibilityRepositoryJPATest
extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ResponsibilityRepositoryJPA repository;
	
	private final long idOfResponsibility() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM verantwoordelijkheden WHERE naam=?",
				Long.class, "test");
	}
	
	@Test
	public void read() {
		final Responsibility responsibility
		= repository.read(idOfResponsibility()).get();
		
		assertEquals("test", responsibility.getName());
	}
}
