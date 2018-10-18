package be.vdab.academy.repositories;

import java.util.Optional;

import be.vdab.academy.entities.Responsibility;

public interface ResponsibilityRepository {

	Optional<Responsibility> read(final long id);
	void create(final Responsibility responsibility);
}
