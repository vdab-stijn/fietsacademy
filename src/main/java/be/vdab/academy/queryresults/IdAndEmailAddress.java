package be.vdab.academy.queryresults;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class IdAndEmailAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final long id;
	@Column(name = "emailadres")
	private final String emailAddress;
	
	public IdAndEmailAddress(
			final long id,
			final String emailAddress) {
		this.id = id;
		this.emailAddress = emailAddress;
	}
	
	public long getId() {
		return id;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
}
