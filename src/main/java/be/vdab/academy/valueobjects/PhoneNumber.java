package be.vdab.academy.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Column(name = "nummer")
	private String number;
	@Column(name = "fax")
	private boolean fax;
	@Column(name = "opmerking")
	private String remarks;
	
	protected PhoneNumber() {}
	public PhoneNumber(
			final String number,
			final boolean fax,
			final String remarks) {
		this.number = number;
		this.fax = fax;
		this.remarks = remarks;
	}
	
	public String getNumber() {
		return number;
	}
	
	public boolean isFax() {
		return fax;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	@Override
	public boolean equals(final Object object) {
		if (!(object instanceof PhoneNumber)) return false;
		
		final PhoneNumber phoneNumber = (PhoneNumber)object;
		
		return getNumber().equalsIgnoreCase(phoneNumber.getNumber()) &&
				isFax() == phoneNumber.isFax();
	}
	
	@Override
	public int hashCode() {
		return getNumber().toUpperCase().hashCode() * (isFax() ? 7 : 13);
	}
}
