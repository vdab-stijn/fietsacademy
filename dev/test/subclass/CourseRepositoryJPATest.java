package be.vdab.academy.repositories.subclass;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

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

import be.vdab.academy.entities.tableperclass.Course;
import be.vdab.academy.entities.tableperclass.GroupCourse;
import be.vdab.academy.entities.tableperclass.IndividualCourse;
import be.vdab.academy.repositories.CourseRepositoryJPA;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(CourseRepositoryJPA.class)
@Sql("/insertCourseSubclass.sql")
public class CourseRepositoryJPATest 
extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String COURSES = "cursussen";
	private static final String COURSES_GROUP = "groepscursussen";
	private static final String COURSES_INDIVIDUAL = "individuelecursussen";
	
	private static final LocalDate DATE = LocalDate.of(2019, 1, 1);
	
	@Autowired
	private CourseRepositoryJPA repository;
	
	private final long idOfTestGroupCourse() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM cursussen WHERE naam='testGroep'", Long.class);
	}
	
	private final long idOfTestIndividualCourse() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM cursussen WHERE naam='testIndividueel'",
				Long.class);
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
		int countCourses = super.countRowsInTable(COURSES);
		int countGroupCourses = super.countRowsInTable(COURSES_GROUP);
		
		final GroupCourse course = new GroupCourse("testGroep2", DATE, DATE);
		repository.create(course);
		
		assertEquals(countCourses + 1,
				super.countRowsInTable(COURSES));
		assertEquals(countGroupCourses + 1,
				super.countRowsInTable(COURSES_GROUP));
		
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES, "id=" + course.getId()));
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES_GROUP, "id=" + course.getId()));
	}
	
	@Test
	public void createIndividual() {
		int countCourses = super.countRowsInTable(COURSES);
		int countIndividualCourses = super.countRowsInTable(COURSES_INDIVIDUAL);
		
		final IndividualCourse course
		= new IndividualCourse("testIndividueel2", 7);
		repository.create(course);
		
		assertEquals(countCourses + 1,
				super.countRowsInTable(COURSES));
		assertEquals(countIndividualCourses + 1,
				super.countRowsInTable(COURSES_INDIVIDUAL));
		
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES, "id=" + course.getId()));
		assertEquals(1,
				super.countRowsInTableWhere(
						COURSES_INDIVIDUAL, "id=" + course.getId()));
	}
}
