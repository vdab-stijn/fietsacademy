package be.vdab.academy.repositories;

import java.util.Optional;

import be.vdab.academy.entities.Campus;

public interface CampusRepository {

	Optional<Campus> read(final long id);
	void create(final Campus campus);
}
