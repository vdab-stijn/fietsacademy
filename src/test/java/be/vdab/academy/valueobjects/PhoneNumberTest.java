package be.vdab.academy.valueobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class PhoneNumberTest {

	private PhoneNumber number1, number1Duplicate, number2, number2Fax;
	
	@Before
	public void before() {
		number1 = new PhoneNumber("1", false, "");
		number1Duplicate = new PhoneNumber("1", false, "");
		number2 = new PhoneNumber("2", false, "");
		number2Fax = new PhoneNumber("2", true, "");
	}
	
	@Test
	public void phoneNumbersAreEqualIfTheirNumbersAndFaxAreEqual() {
		assertEquals(number1, number1Duplicate);
	}
	
	@Test
	public void phoneNumbersAreDifferentIfTheyHaveADifferentNumber() {
		assertNotEquals(number1, number2);
	}
	
	@Test
	public void aPhoneNumberIsNotNull() {
		assertNotEquals(number1, null);
	}
	
	@Test
	public void aPhoneNumberIsDifferentFromADifferentTypeOfObject() {
		assertNotEquals(number1, "1");
	}
	
	@Test
	public void identicalNumbersReturnTheSameHashcode() {
		assertEquals(number1.hashCode(), number1Duplicate.hashCode());
	}
	
	@Test
	public void sameNumberButDifferentFaxStatusAreNotTheSamePhoneNumbers() {
		assertNotEquals(number2, number2Fax);
		assertNotEquals(number2.hashCode(), number2Fax.hashCode());
	}
}
