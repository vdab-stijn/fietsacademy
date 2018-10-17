package be.vdab.academy.enums;

public enum Gender {

	MALE, FEMALE;
	
	Gender() {}
	
	public static Gender parse(final String gender) {
		if (gender.equalsIgnoreCase("VROUW"))
			return FEMALE;
		
		return MALE;
	}
	
	public String toString() {
		if (this == FEMALE)
			return "VROUW";
		
		return "MAN";
	}
}
