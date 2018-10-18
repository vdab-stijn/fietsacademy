package be.vdab.academy.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.academy.entities.Course;

@Repository
public class CourseRepositoryJPA implements CourseRepository {

	private final EntityManager manager;
	
	public CourseRepositoryJPA(final EntityManager manager) {
		this.manager = manager;
	}
	
	/*
	@Override
	public Optional<Course> read(long id) {
		return Optional.ofNullable(manager.find(Course.class, id));
	}
	*/
	@Override
	public Optional<Course> read(final String id) {
		return Optional.ofNullable(manager.find(Course.class, id));
	}

	@Override
	public void create(Course course) {
		manager.persist(course);
	}

}
