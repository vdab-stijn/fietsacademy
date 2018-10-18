package be.vdab.academy.entities.tableperclass;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
@Entity
@DiscriminatorValue("G")
*/
public class GroupCourse extends Course {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Column(name = "van")
	private LocalDate from;
	@Column(name = "tot")
	private LocalDate to;
	
	protected GroupCourse() {}
	public GroupCourse(
			final String name,
			final LocalDate from,
			final LocalDate to) {
		super(name);
		
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return from;
	}
	
	public LocalDate getTo() {
		return to;
	}
}
