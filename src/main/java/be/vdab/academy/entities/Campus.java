package be.vdab.academy.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import be.vdab.academy.valueobjects.Address;

@Entity
@Table(name = "campussen")
public class Campus implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "naam")
	private String name;
	@Embedded
	private Address address;
	
	protected Campus() {}
	public Campus(final String name, final Address address) {
		this.name = name;
		this.address = address;
	}
	
	public final long getId() {
		return id;
	}
	
	public final String getName() {
		return name;
	}
	
	public final Address getAddress() {
		return address;
	}
}
