package be.vdab.academy.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.academy.entities.Teacher;
import be.vdab.academy.queryresults.CountTeachersByWages;
import be.vdab.academy.queryresults.IdAndEmailAddress;

@Repository
public class TeacherRepositoryJPA implements TeacherRepository {

	private final EntityManager manager;
	
	public TeacherRepositoryJPA(final EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Teacher> read(final long id) {
		return Optional.ofNullable(manager.find(Teacher.class, id));
	}
	
	@Override
	public List<Teacher> findAll() {
		return manager.createQuery("SELECT d FROM Teacher d ORDER BY d.wages",
				Teacher.class).getResultList();
	}

	@Override
	public List<Teacher> findByWagesBetween(BigDecimal from, BigDecimal to) {
//		return manager.createQuery(
//				"SELECT d FROM Teacher d WHERE d.wages BETWEEN :from AND :to",
//				Teacher.class)
//				.setParameter("from",  from)
//				.setParameter("to",  to)
//				.getResultList();
		return manager.createNamedQuery(
				"Teacher.findByWagesBetween", Teacher.class)
				.setParameter("from",  from)
				.setParameter("to", to)
				.setHint("javax.persistance.loadgraph", 
						manager.createEntityGraph(Teacher.WITH_CAMPUS))
				.getResultList();
	}
	
	@Override
	public List<String> findEmailAddresses() {
		return manager.createQuery(
				"SELECT d.emailAddress FROM Teacher d", String.class)
				.getResultList();
	}
	
	@Override
	public List<IdAndEmailAddress> findIdsAndEmailAddresses() {
		return manager.createQuery(
			"SELECT new be.vdab.academy.queryresults.IdAndEmailAddress" +
			"(d.id, d.emailAddress) from Teacher d",
			IdAndEmailAddress.class).getResultList();
	}
	
	@Override
	public BigDecimal findBiggestWages() {
		return manager.createQuery(
				"SELECT MAX(d.wages) FROM Teacher d", BigDecimal.class)
				.getSingleResult();
	}
	
	@Override
	public List<CountTeachersByWages> countTeachersByWages() {
		return manager.createQuery(
			"SELECT new be.vdab.academy.queryresults.CountTeachersByWages" +
			"(d.wages, COUNT(d)) FROM Teacher d GROUP BY d.wages",
			CountTeachersByWages.class).getResultList();
	}
	
	@Override
	public int generalRaise(final BigDecimal percentage) {
		final BigDecimal factor =
				BigDecimal.ONE.add(percentage.divide(BigDecimal.valueOf(100L)));
		
		return manager.createNamedQuery(
				"Teacher.generalRaise")
				.setParameter("factor", factor)
				.executeUpdate();
	}
	
	@Override
	public void create(final Teacher teacher) {
		manager.persist(teacher);
	}
	
	@Override
	public void delete(final long id) {
		read(id)
			.ifPresent(teacher -> manager.remove(teacher));
	}
}
