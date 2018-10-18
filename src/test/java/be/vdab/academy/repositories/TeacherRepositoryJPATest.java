package be.vdab.academy.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
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
import be.vdab.academy.queryresults.CountTeachersByWages;
import be.vdab.academy.queryresults.IdAndEmailAddress;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Sql("/insertTeacher.sql")
@Import(TeacherRepositoryJPA.class)
public class TeacherRepositoryJPATest
extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TeacherRepositoryJPA repository;
	
	@Autowired
	private EntityManager manager;
	
	private static final String TEACHERS = "docenten";
	
	private Teacher teacher;
	
	@Before
	public void before() {
		teacher = new Teacher("test", "test", Gender.MALE,
				BigDecimal.TEN, "test@fietsacademy.be");
	}
	
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
	public void findAll() {
		List<Teacher> teachers = repository.findAll();
		
		assertEquals(super.countRowsInTable(TEACHERS), teachers.size());
		
		BigDecimal previousWages = BigDecimal.ZERO;
		
		for (Teacher teacher : teachers) {
			assertTrue(teacher.getWages().compareTo(previousWages) >= 0);
			
			previousWages = teacher.getWages();
		}
	}
	
	@Test
	public void findByWagesBetween() {
		final BigDecimal thousand = BigDecimal.valueOf(1_000L);
		final BigDecimal twoThousand = BigDecimal.valueOf(2_000L);
		
		final List<Teacher> teachers
		= repository.findByWagesBetween(thousand, twoThousand);
		
		final long countTeachers = super.countRowsInTableWhere(TEACHERS,
				"wedde BETWEEN 1000 AND 2000");
		
		assertEquals(countTeachers, teachers.size());
		
		teachers.forEach(teacher -> {
			assertTrue(teacher.getWages().compareTo(thousand) >= 0);
			assertTrue(teacher.getWages().compareTo(twoThousand) <= 0);
		});
	}
	
	@Test
	public void findEmailAddresses() {
		final List<String> emailAddresses = repository.findEmailAddresses();
		final long count = super.jdbcTemplate.queryForObject(
				"SELECT COUNT(DISTINCT emailadres) FROM docenten", Long.class);
		
		assertEquals(count, emailAddresses.size());
		
		emailAddresses.forEach(address -> assertTrue(address.contains("@")));
	}
	
	@Test
	public void findIdsAndEmailAddresses() {
		final List<IdAndEmailAddress> idsAndEmailAddresses
		= repository.findIdsAndEmailAddresses();
		
		assertEquals(super.countRowsInTable(TEACHERS),
				idsAndEmailAddresses.size());
	}
	
	@Test
	public void findBiggestWages() {
		final BigDecimal biggest = repository.findBiggestWages();
		final BigDecimal compare = super.jdbcTemplate.queryForObject(
				"SELECT MAX(wedde) FROM docenten", BigDecimal.class);
		
		assertEquals(0, biggest.compareTo(compare));
	}
	
	@Test
	public void countTeachersByWages() {
		final List<CountTeachersByWages> teachers
		= repository.countTeachersByWages();
		final long uniqueWages = super.jdbcTemplate.queryForObject(
				"SELECT COUNT(DISTINCT wedde) FROM docenten", Long.class);
		
		assertEquals(uniqueWages, teachers.size());
		
		final long teachersWithWages1000 = super.countRowsInTableWhere(
				TEACHERS, "wedde = 1000");
		
		final BigDecimal thousand = BigDecimal.valueOf(1000L);
		
		teachers.stream()
			.filter(countByWages ->
				countByWages.getWages().compareTo(thousand) == 0)
			.forEach(countByWages ->
				assertEquals(teachersWithWages1000, countByWages.getCount()));
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
	
	@Test
	public void generalRaise() {
		final int affected = repository.generalRaise(BigDecimal.TEN);
		
		assertEquals(super.countRowsInTable(TEACHERS), affected);
		
		BigDecimal newWages = super.jdbcTemplate.queryForObject(
				"SELECT wedde FROM docenten WHERE id=?",
				BigDecimal.class, idOfTestTeacher());
		
		assertEquals(0, BigDecimal.valueOf(1_100).compareTo(newWages));
	}
	
	@Test
	public void create() {
		int countTeachers = super.countRowsInTable(TEACHERS);
		repository.create(teacher);
		
		assertEquals(countTeachers + 1, super.countRowsInTable(TEACHERS));
		assertNotEquals(0, teacher.getId());
		assertEquals(1, 
				super.countRowsInTableWhere(TEACHERS, "id=" + teacher.getId()));
	}
	
	@Test
	public void delete() {
		final long id = idOfTestTeacher();
		final int countTeachers = super.countRowsInTable(TEACHERS);
		
		repository.delete(id);
		manager.flush();
		
		assertEquals(countTeachers - 1, super.countRowsInTable(TEACHERS));
		assertEquals(0, super.countRowsInTableWhere(TEACHERS, "id=" + id));
	}
	
	@Test
	public void readNicknames() {
		final Teacher teacher = repository.read(idOfTestTeacher()).get();
		
		assertEquals(1, teacher.getNicknames().size());
		assertTrue(teacher.getNicknames().contains("test"));
	}
	
	@Test
	public void addNickname() {
		repository.create(teacher);
		teacher.addNickname("test");
		manager.flush();
		
		assertEquals("test", super.jdbcTemplate.queryForObject(
				"SELECT bijnaam FROM docentenbijnamen WHERE docentid=?",
				String.class, teacher.getId()));
	}
}
