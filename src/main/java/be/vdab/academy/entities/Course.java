package be.vdab.academy.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Course implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Id
	private String id;
	@Column(name = "naam")
	private String name;
	
	protected Course() {}
	public Course(final String name) {
		id = UUID.randomUUID().toString();
		
		this.name = name;
	}
	
	public final String getId() {
		return id;
	}
	
	public final String getName() {
		return name;
	}
}
