package be.vdab.academy.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import be.vdab.academy.entities.Campus;

@Repository
public class CampusRepositoryJPA implements CampusRepository {

	private final EntityManager manager;
	
	public CampusRepositoryJPA(final EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public Optional<Campus> read(long id) {
		return Optional.ofNullable(manager.find(Campus.class, id));
	}

	@Override
	public void create(Campus campus) {
		manager.persist(campus);
	}

}
