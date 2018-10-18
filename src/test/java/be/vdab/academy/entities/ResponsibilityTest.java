package be.vdab.academy.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.academy.enums.Gender;
import be.vdab.academy.valueobjects.Address;


public class ResponsibilityTest {

	private Responsibility responsibility1;
	private Responsibility responsibility2;
	private Responsibility responsibility1Duplicate;
	private Teacher teacher1;
	private Campus campus1;
	
	@Before
	public void before() {
		responsibility1 = new Responsibility("test1");
		responsibility1Duplicate = new Responsibility("test1");
		responsibility2 = new Responsibility("test2");
		
		campus1 = new Campus("test",
				new Address("test", "test", "test", "test"));
		teacher1 = new Teacher("test", "test", Gender.MALE,
				BigDecimal.TEN, "test@fietsacademy.be", campus1);
	}
	
	@Test
	public void equalNameEqualObject() {
		assertEquals(responsibility1, responsibility1Duplicate);
	}
	
	@Test
	public void differentNamesDifferentObjects() {
		assertNotEquals(responsibility1, responsibility2);
	}
	
	@Test
	public void sameObjectReturnSameHashCode() {
		assertEquals(responsibility1.hashCode(),
				responsibility1Duplicate.hashCode());
	}
	
	@Test
	public void addTeacher() {
		assertTrue(responsibility1.getTeachers().isEmpty());
		assertTrue(responsibility1.addTeacher(teacher1));
		assertEquals(1,
				responsibility1.getTeachers().size());
		assertTrue(responsibility1.getTeachers().contains(teacher1));
		assertEquals(1,
				teacher1.getResponsibilities().size());
		assertTrue(teacher1.getResponsibilities().contains(responsibility1));
	}
	
	@Test
	public void removeTeacher() {
		assertTrue(responsibility1.addTeacher(teacher1));
		assertTrue(responsibility1.removeTeacher(teacher1));
		assertTrue(responsibility1.getTeachers().isEmpty());
		assertTrue(teacher1.getResponsibilities().isEmpty());
	}
}
