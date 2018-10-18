package be.vdab.academy.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "verantwoordelijkheden")
public class Responsibility implements Serializable {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "naam")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "docentenverantwoordelijkheden",
			joinColumns = @JoinColumn(name = "verantwoordelijkheidid"),
			inverseJoinColumns = @JoinColumn(name = "docentid"))
	private Set<Teacher> teachers = new LinkedHashSet<>();
	
	protected Responsibility() {}
	public Responsibility(final String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addTeacher(final Teacher teacher) {
		final boolean added = teachers.add(teacher);
		
		if (!teacher.getResponsibilities().contains(this))
			teacher.addResponsibility(this);
		
		return added;
	}
	
	public boolean removeTeacher(final Teacher teacher) {
		final boolean removed = teachers.remove(teacher);
		
		if (teacher.getResponsibilities().contains(this))
			teacher.removeResponsibility(this);
		
		return removed;
	}
	
	public Set<Teacher> getTeachers() {
		return Collections.unmodifiableSet(teachers);
	}
	
	@Override
	public boolean equals(final Object object) {
		if (this == object) return true;
		
		if (object == null || !(object instanceof Responsibility)) return false;
		
		final Responsibility responsibility = (Responsibility)object;
		
		return getName().equalsIgnoreCase(responsibility.getName());
	}
	
	@Override
	public int hashCode() {
		return 37 * getName().toUpperCase().hashCode();
	}
}
