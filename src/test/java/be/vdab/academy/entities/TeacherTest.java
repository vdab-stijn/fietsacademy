package be.vdab.academy.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.academy.enums.Gender;
import be.vdab.academy.valueobjects.Address;

public class TeacherTest {

	private static final BigDecimal ORIGINAL_WAGES = BigDecimal.valueOf(200L);
	
	private Teacher teacher1;
	private Teacher teacher1Duplicate;
	private Teacher teacher2;
	private Campus campus1;
	private Campus campus2;
	private Responsibility responsibility1;
	
	@Before
	public void before() {
		campus1 = new Campus("test",
				new Address("", "", "", ""));
		campus2 = new Campus("test2",
				new Address("test2", "test2", "test2", "test2"));
		teacher1 = new Teacher("test", "test", Gender.MALE,
				ORIGINAL_WAGES, "test@fietsacademy.be", campus1);
		teacher1Duplicate = new Teacher("test", "test", Gender.MALE,
				ORIGINAL_WAGES, "test@fietsacademy.be", campus1);
		teacher2 = new Teacher("test2", "test2", Gender.MALE,
				ORIGINAL_WAGES, "test2@fietsacademy.be", campus1);
		
		responsibility1 = new Responsibility("EHBO");
	}
	
	@Test
	public void raise() {
		teacher1.raise(BigDecimal.TEN);
		assertEquals(0,
				BigDecimal.valueOf(220L).compareTo(teacher1.getWages()));
	}
	
	@Test(expected = NullPointerException.class)
	public void raiseWithNullThrowsException() {
		teacher1.raise(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void raiseWith0ThrowsException() {
		teacher1.raise(BigDecimal.ZERO);
		assertEquals(0,
				ORIGINAL_WAGES.compareTo(teacher1.getWages()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void raiseWithNegativeThrowsException() {
		teacher1.raise(BigDecimal.valueOf(-1L));
		assertEquals(0,
				ORIGINAL_WAGES.compareTo(teacher1.getWages()));
	}
	
	@Test
	public void newTeachersDontHaveNicknames() {
		assertTrue(teacher1.getNicknames().isEmpty());
	}
	
	@Test
	public void addNickname() {
		assertTrue(teacher1.addNickname("test"));
		
		assertEquals(1, teacher1.getNicknames().size());
		assertTrue(teacher1.getNicknames().contains("test"));
	}
	
	@Test
	public void cantAddSameNicknameTwice() {
		assertTrue(teacher1.addNickname("test"));
		assertFalse(teacher1.addNickname("test"));
		assertEquals(1, teacher1.getNicknames().size());
	}
	
	@Test(expected = NullPointerException.class)
	public void cantAddNullNickname() {
		assertFalse(teacher1.addNickname(null));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cantAddEmptyNickname() {
		assertFalse(teacher1.addNickname(""));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cantAddOnlyBlanksNickname() {
		assertFalse(teacher1.addNickname("   "));
	}
	
	@Test
	public void removeNickname() {
		teacher1.addNickname("test");
		
		assertTrue(teacher1.removeNickname("test"));
		assertTrue(teacher1.getNicknames().isEmpty());
	}
	
	@Test
	public void cantRemoveNonExistantNickname() {
		teacher1.addNickname("test");
		
		assertFalse(teacher1.removeNickname("test2"));
		assertEquals(1, teacher1.getNicknames().size());
		assertTrue(teacher1.getNicknames().contains("test"));
	}
	
	@Test
	public void aCampusCanHaveMoreThanOneTeacher() {
		assertTrue(campus1.getTeachers().contains(teacher1));
		assertTrue(campus1.getTeachers().contains(teacher2));
	}
	
	@Test
	public void teachersAreEqualIfTheyHaveTheSameEmailAddress() {
		assertEquals(teacher1, teacher1Duplicate);
	}
	
	@Test
	public void teachersAreDifferentIfTheyHaveDifferentEmailAddresses() {
		assertNotEquals(teacher1, teacher2);
	}
	
	@Test
	public void aTeacherDiffersFromNull() {
		assertNotEquals(teacher1, null);
	}
	
	@Test
	public void aTeacherDiffersFromAnotherTypeOfObject() {
		assertNotEquals(teacher1, "");
	}
	
	@Test
	public void equalTeachersReturnTheSameHashcode() {
		assertEquals(teacher1.hashCode(), teacher1Duplicate.hashCode());
	}
	
	@Test
	public void teacher1WorksAtCampus1() {
		assertEquals(teacher1.getCampus(), campus1);
		assertEquals(2, campus1.getTeachers().size());
		assertTrue(campus1.getTeachers().contains(teacher1));
	}
	
	@Test
	public void teacher1MovesToCampus2() {
		teacher1.setCampus(campus2);
		assertEquals(teacher1.getCampus(), campus2);
		assertEquals(1, campus1.getTeachers().size());
		assertEquals(1, campus2.getTeachers().size());
		assertTrue(campus2.getTeachers().contains(teacher1));
	}
	
	@Test
	public void addResponsibility() {
		assertTrue(teacher1.getResponsibilities().isEmpty());
		assertTrue(teacher1.addResponsibility(responsibility1));
		assertEquals(1,
				teacher1.getResponsibilities().size());
		assertTrue(teacher1.getResponsibilities().contains(responsibility1));
		assertEquals(1,
				responsibility1.getTeachers().size());
		assertTrue(responsibility1.getTeachers().contains(teacher1));
	}
}
