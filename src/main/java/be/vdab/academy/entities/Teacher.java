package be.vdab.academy.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import be.vdab.academy.enums.Gender;

@Entity
@Table(name="docenten")
@NamedQuery(
	name="Teacher.findWagesBetween", 
	query="SELECT d FROM Teacher d WHERE d.wages BETWEEN :from AND :to " +
			"ORDER BY d.wages, d.id")
public class Teacher implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column(name = "voornaam")
	private String firstName;
	@Column(name = "familienaam")
	private String lastName;
//	@Column(name = "geslacht")
//	private Gender gender;
//	@Column(name="geslacht")
//	@Enumerated(EnumType.STRING)
//	private Gender gender;
	@Column(name="geslacht")
	private String gender;
	@Column(name = "wedde")
	private BigDecimal wages;
	@Column(name = "emailAdres")
	private String emailAddress;
	
	protected Teacher() {}
	
	public Teacher(
			final String firstName,
			final String lastName,
			final Gender gender,
			final BigDecimal wages,
			final String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender.toString();
		this.wages = wages;
		this.emailAddress = emailAddress;
	}
	
	public long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return Gender.parse(gender);
	}
	
	public BigDecimal getWages() {
		return wages;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void raise(final BigDecimal percentage) {
		if (percentage.compareTo(BigDecimal.ZERO) <= 0)
			throw new IllegalArgumentException(
					"Raise percentage must be positive");
		
		final BigDecimal factor
		= BigDecimal.ONE.add(percentage.divide(BigDecimal.valueOf(100L)));
		
		wages = wages.multiply(factor, new MathContext(2, RoundingMode.HALF_UP));
	}
}
