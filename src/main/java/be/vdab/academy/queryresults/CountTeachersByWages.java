package be.vdab.academy.queryresults;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Transient;

public class CountTeachersByWages {

	@Column(name = "wedde")
	private final BigDecimal wages;
	@Transient
	private final long count;
	
	public CountTeachersByWages(
			final BigDecimal wages,
			final long count) {
		this.wages = wages;
		this.count = count;
	}
	
	public final BigDecimal getWages() {
		return wages;
	}
	
	public final long getCount() {
		return count;
	}
}
