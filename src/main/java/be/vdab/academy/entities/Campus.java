package be.vdab.academy.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.academy.valueobjects.Address;
import be.vdab.academy.valueobjects.PhoneNumber;

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

	@ElementCollection(targetClass = PhoneNumber.class)
	@CollectionTable(name = "campussentelefoonnrs",
		joinColumns = @JoinColumn(
				name = "campusId", referencedColumnName = "id"))
	@OrderBy("fax")
	private Set<PhoneNumber> phoneNumbers;
	
	/*@OneToMany(fetch = FetchType.LAZY)*/
	@OneToMany(mappedBy = "campus")
	/*@JoinColumn(name = "campusId")*/
	@OrderBy("voornaam, familienaam")
	private Set<Teacher> teachers;
	
	protected Campus() {}
	public Campus(final String name, final Address address) {
		this.name = name;
		this.address = address;
		
		this.phoneNumbers = new LinkedHashSet<>();
		this.teachers = new LinkedHashSet<>();
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return Collections.unmodifiableSet(phoneNumbers);
	}
	
	public boolean addTeacher(final Teacher teacher) {
		if (teacher == null) throw new NullPointerException();
		
		final boolean added = teachers.add(teacher);
		
		final Campus campus = teacher.getCampus();
		
		if (campus != null && this != campus)
			campus.teachers.remove(teacher);
		
		if (this != campus)
			teacher.setCampus(this);
		
		return added;
	}
	
	public Set<Teacher> getTeachers() {
		return Collections.unmodifiableSet(teachers);
	}
	
	@Override
	public boolean equals(final Object object) {
		if (object == null || !(object instanceof Campus)) return false;
		
		final Campus campus = (Campus)object;
		
		return	getName().equalsIgnoreCase(campus.getName());
	}
	
	@Override
	public int hashCode() {
		return 37 * (getName().toUpperCase().hashCode());
	}
}
