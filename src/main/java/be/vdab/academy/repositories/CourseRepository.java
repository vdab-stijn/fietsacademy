package be.vdab.academy.repositories;

import java.util.Optional;

import be.vdab.academy.entities.Course;

public interface CourseRepository {

	/*Optional<Course> read(final long id);*/
	Optional<Course> read(final String id);
	void create(final Course course);
}
