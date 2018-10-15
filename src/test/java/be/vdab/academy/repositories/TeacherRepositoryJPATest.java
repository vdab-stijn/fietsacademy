package be.vdab.academy.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

import be.vdab.academy.entities.Teacher;
import be.vdab.academy.enums.Gender;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Sql("/insertTeacher.sql")
@Import(TeacherRepositoryJPA.class)
public class TeacherRepositoryJPATest
extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TeacherRepositoryJPA repository;
	
	private final long idOfTestTeacher() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM docenten WHERE voornaam = 'testM'", Long.class);	
	}
	
	private final long idOfTestTeacherFemale() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM docenten WHERE voornaam = 'testV'", Long.class);
	}
	
	@Test
	public void read() {
		Teacher teacher = repository.read(idOfTestTeacher()).get();
		
		assertEquals("testM", teacher.getFirstName());
	}
	
	@Test
	public void readNonExistant() {
		assertFalse(repository.read(-1L).isPresent());
	}
	
	@Test
	public void male() {
		assertEquals(Gender.MALE,
				repository.read(idOfTestTeacher()).get().getGender());
	}
	
	@Test
	public void female() {
		assertEquals(Gender.FEMALE,
				repository.read(idOfTestTeacherFemale()).get().getGender());
	}
}
