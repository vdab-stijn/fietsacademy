package be.vdab.academy.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.academy.entities.Teacher;
import be.vdab.academy.exceptions.TeacherNotFoundException;
import be.vdab.academy.repositories.TeacherRepository;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultTeacherService implements TeacherService {

	private final TeacherRepository teacherRepository;
	
	public DefaultTeacherService(final TeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}
	
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public void raise(long id, BigDecimal percentage) {
		Optional<Teacher> teacher = teacherRepository.readWithLock(id);
		
		if (teacher.isPresent())
			teacher.get().raise(percentage);
		else
			throw new TeacherNotFoundException(
					"Teacher with id = " + id + " not found");
	}
}
