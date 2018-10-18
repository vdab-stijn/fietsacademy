package be.vdab.academy.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import be.vdab.academy.entities.Responsibility;

@Repository
public class ResponsibilityRepositoryJPA implements ResponsibilityRepository {

	@Autowired
	private final EntityManager manager;
	
	public ResponsibilityRepositoryJPA(final EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Responsibility> read(long id) {
		return Optional.ofNullable(manager.find(Responsibility.class, id));
	}

	@Override
	public void create(Responsibility responsibility) {
		manager.persist(responsibility);
	}

}
