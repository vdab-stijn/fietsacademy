package be.vdab.academy.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Column(name = "straat")
	private String street;
	@Column(name = "huisNr")
	private String number;
	@Column(name = "postCode")
	private String postalCode;
	@Column(name = "gemeente")
	private String municipality;
	
	protected Address() {}
	public Address(
			final String street,
			final String number,
			final String postalCode,
			final String municipality) {
		this.street = street;
		this.number = number;
		this.postalCode = postalCode;
		this.municipality = municipality;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getMunicipality() {
		return municipality;
	}
}
