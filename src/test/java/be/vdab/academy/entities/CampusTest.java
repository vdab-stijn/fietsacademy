package be.vdab.academy.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.academy.enums.Gender;
import be.vdab.academy.valueobjects.Address;

public class CampusTest {

	private Teacher teacher1;
	private Campus campus1;
	private Campus campus2;
	
	@Before
	public void before() {
		campus1 = new Campus("test1",
				new Address("test1", "test1", "test1", "test1"));
		campus2 = new Campus("test2",
				new Address("test2", "test2", "test2", "test2"));
		teacher1 = new Teacher("test", "test", Gender.MALE,
				BigDecimal.TEN, "test@fietsacademy.be", campus1);
	}
	
	@Test
	public void teacher1WorksAtCampus1() {
		assertEquals(campus1, teacher1.getCampus());
		assertEquals(1, campus1.getTeachers().size());
		assertTrue(campus1.getTeachers().contains(teacher1));
	}
	
	@Test
	public void teacher1MovesToCampus2() {
		assertTrue(campus2.addTeacher(teacher1));
		assertTrue(campus1.getTeachers().isEmpty());
		assertEquals(1, campus2.getTeachers().size());
		assertTrue(campus2.getTeachers().contains(teacher1));
		assertEquals(campus2, teacher1.getCampus());
	}
}
