package be.vdab.academy.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.academy.enums.Gender;

@Entity
@Table(name="docenten")
public class Teacher implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Id
	private long id;
	@Column(name = "voornaam")
	private String firstName;
	@Column(name = "familienaam")
	private String lastName;
//	@Column(name = "geslacht")
//	private Gender gender;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "wedde")
	private BigDecimal wages;
	@Column(name = "emailAdres")
	private String emailAddress;
	
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
		return gender;
	}
	
	public BigDecimal getWages() {
		return wages;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
}
