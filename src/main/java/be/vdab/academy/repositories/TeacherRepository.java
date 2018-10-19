package be.vdab.academy.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.academy.entities.Teacher;
import be.vdab.academy.queryresults.CountTeachersByWages;
import be.vdab.academy.queryresults.IdAndEmailAddress;

public interface TeacherRepository {

	Optional<Teacher> read(final long id);
	Optional<Teacher> readWithLock(final long id);
	
	List<Teacher> findAll();
	List<Teacher> findByWagesBetween(
			final BigDecimal from, final BigDecimal to);
	List<String> findEmailAddresses();
	List<IdAndEmailAddress> findIdsAndEmailAddresses();
	BigDecimal findBiggestWages();
	List<CountTeachersByWages> countTeachersByWages();
	
	int generalRaise(final BigDecimal percentage);
	
	void create(final Teacher teacher);
	void delete(final long id);
}
