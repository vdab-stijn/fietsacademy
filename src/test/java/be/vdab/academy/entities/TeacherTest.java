package be.vdab.academy.entities;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.academy.enums.Gender;

public class TeacherTest {

	private static final BigDecimal ORIGINAL_WAGES = BigDecimal.valueOf(200L);
	
	private Teacher teacher1;
	
	@Before
	public void before() {
		teacher1 = new Teacher("test", "test", Gender.MALE,
				ORIGINAL_WAGES, "test@fietsacademy.be");
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
}
