package be.vdab.academy.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.academy.enums.Gender;
import be.vdab.academy.valueobjects.Address;

public class TeacherTest {

	private static final BigDecimal ORIGINAL_WAGES = BigDecimal.valueOf(200L);
	
	private Teacher teacher1;
	private Campus campus1;
	
	@Before
	public void before() {
		campus1 = new Campus("test", new Address("", "", "", ""));
		teacher1 = new Teacher("test", "test", Gender.MALE,
				ORIGINAL_WAGES, "test@fietsacademy.be", campus1);
	}
	
	@Test
	public void raise() {
		teacher1.raise(BigDecimal.TEN);
		assertEquals(0, BigDecimal.valueOf(220L).compareTo(teacher1.getWages()));
	}
	
	@Test(expected = NullPointerException.class)
	public void raiseWithNullThrowsException() {
		teacher1.raise(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void raiseWith0ThrowsException() {
		teacher1.raise(BigDecimal.ZERO);
		assertEquals(0, ORIGINAL_WAGES.compareTo(teacher1.getWages()));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void raiseWithNegativeThrowsException() {
		teacher1.raise(BigDecimal.valueOf(-1L));
		assertEquals(0, ORIGINAL_WAGES.compareTo(teacher1.getWages()));
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
}
