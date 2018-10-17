package be.vdab.academy.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.academy.entities.Teacher;
import be.vdab.academy.enums.Gender;
import be.vdab.academy.exceptions.TeacherNotFoundException;
import be.vdab.academy.repositories.TeacherRepository;

@RunWith(MockitoJUnitRunner.class)
public class DefaultTeacherServiceTest {

	private DefaultTeacherService service;
	
	@Mock
	private TeacherRepository teacherRepository;
	private Teacher teacher;
	
	@Before
	public void before() {
		teacher = new Teacher("test", "test", Gender.MALE,
				BigDecimal.valueOf(100L), "test@fietsacademy.be");
		when(teacherRepository.read(1)).thenReturn(Optional.of(teacher));
		when(teacherRepository.read(-1)).thenReturn(Optional.empty());
		
		service = new DefaultTeacherService(teacherRepository);
	}
	
	@Test
	public void raise() {
		service.raise(1, BigDecimal.TEN);
		assertEquals(0, BigDecimal.valueOf(110L).compareTo(teacher.getWages()));
		verify(teacherRepository).read(1);
	}
	
	@Test(expected = TeacherNotFoundException.class)
	public void raiseNonExistantTeacher() {
		service.raise(-1, BigDecimal.TEN);
		verify(teacherRepository).read(-1);
	}
}
