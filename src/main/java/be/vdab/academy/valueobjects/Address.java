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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result +
				((municipality == null) ? 0 : municipality.hashCode());
		result = prime * result +
				((number == null) ? 0 : number.hashCode());
		result = prime * result +
				((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result +
				((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		if (municipality == null) {
			if (other.municipality != null)
				return false;
		} else if (!municipality.equals(other.municipality))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
