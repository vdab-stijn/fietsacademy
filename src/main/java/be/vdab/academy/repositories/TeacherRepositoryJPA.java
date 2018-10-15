package be.vdab.academy.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.academy.entities.Teacher;

@Repository
public class TeacherRepositoryJPA implements TeacherRepository {

	private final EntityManager manager;
	
	public TeacherRepositoryJPA(final EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Teacher> read(final long id) {
		return Optional.ofNullable(manager.find(Teacher.class,  id));
	}
}
