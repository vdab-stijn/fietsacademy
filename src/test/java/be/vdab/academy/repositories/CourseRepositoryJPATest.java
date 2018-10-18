package be.vdab.academy.repositories;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.EntityManager;

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

import be.vdab.academy.entities.Course;
import be.vdab.academy.entities.GroupCourse;
import be.vdab.academy.entities.IndividualCourse;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(CourseRepositoryJPA.class)
@Sql("/insertCourseTablePerConcreteClass.sql")
public class CourseRepositoryJPATest 
extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String COURSES_GROUP = "groepscursussen";
	private static final String COURSES_INDIVIDUAL = "individuelecursussen";
	
	private static final LocalDate DATE = LocalDate.of(2019, 1, 1);
	
	@Autowired
	private CourseRepositoryJPA repository;
	@Autowired
	private EntityManager manager;
	
	private final String idOfTestGroupCourse() {
		/*
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM cursussen WHERE naam='testGroep'", Long.class);
		*/
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM groepscursussen WHERE naam='testGroep'",
				String.class);
	}
	
	private final String idOfTestIndividualCourse() {
		/*
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM cursussen WHERE naam='testIndividueel'",
				Long.class);
		*/
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM individuelecursussen " +
				"WHERE naam='testIndividueel'",
				String.class);
	}
	
	@Test
	public void readGroupCourse() {
		Optional<Course> course = repository.read(idOfTestGroupCourse());
		
		assertEquals("testGroep", ((GroupCourse)course.get()).getName());
	}
	
	@Test
	public void readIndividualCourse() {
		Optional<Course> course = repository.read(idOfTestIndividualCourse());
		
		assertEquals("testIndividueel",
				((IndividualCourse)course.get()).getName());
	}
	
	@Test
	public void createGroup() {
		int countGroupCourses = super.countRowsInTable(COURSES_GROUP);
		
		final GroupCourse course = new GroupCourse("testGroep2", DATE, DATE);
		repository.create(course);
		manager.flush();
		
		assertEquals(countGroupCourses + 1,
				super.countRowsInTable(COURSES_GROUP));
		
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES_GROUP, "id='" + course.getId() + "'"));
	}
	
	@Test
	public void createIndividual() {
		int countIndividualCourses = super.countRowsInTable(COURSES_INDIVIDUAL);
		
		final IndividualCourse course
		= new IndividualCourse("testIndividueel2", 7);
		repository.create(course);
		manager.flush();
		
		assertEquals(countIndividualCourses + 1,
				super.countRowsInTable(COURSES_INDIVIDUAL));
		
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES_INDIVIDUAL, "id='" + course.getId() + "'"));
	}
}
