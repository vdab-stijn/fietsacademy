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

import be.vdab.academy.entities.Campus;
import be.vdab.academy.entities.Teacher;
import be.vdab.academy.enums.Gender;
import be.vdab.academy.exceptions.TeacherNotFoundException;
import be.vdab.academy.repositories.TeacherRepository;
import be.vdab.academy.valueobjects.Address;

@RunWith(MockitoJUnitRunner.class)
public class DefaultTeacherServiceTest {

	private DefaultTeacherService service;
	
	@Mock
	private TeacherRepository teacherRepository;
	private Teacher teacher;
	private Campus campus;
	
	@Before
	public void before() {
		campus = new Campus("", new Address("", "", "", ""));
		teacher = new Teacher("test", "test", Gender.MALE,
				BigDecimal.valueOf(100L), "test@fietsacademy.be", campus);
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
