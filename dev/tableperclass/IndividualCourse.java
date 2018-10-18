package be.vdab.academy.entities.tableperclass;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
@Entity
@DiscriminatorValue("I")
*/
public class IndividualCourse extends Course {

	/** Implements Serializable. */
	private static final long serialVersionUID = -2152663213264949852L;

	@Column(name = "duurtijd")
	private int duration;
	
	protected IndividualCourse() {}
	public IndividualCourse(final String name, final int duration) {
		super(name);
		
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
}
