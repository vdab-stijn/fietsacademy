package be.vdab.academy.repositories;

import java.util.Optional;

import be.vdab.academy.entities.Teacher;

public interface TeacherRepository {

	Optional<Teacher> read(final long id);
}
