package be.vdab.academy.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.academy.entities.Campus;
import be.vdab.academy.valueobjects.Address;
import be.vdab.academy.valueobjects.PhoneNumber;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(CampusRepositoryJPA.class)
@Sql("/insertCampus.sql")
public class CampusRepositoryTest
extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String CAMPUSSES = "campussen";
	
	@Autowired
	private CampusRepositoryJPA repository;
	private Campus campus;
	
	@Before
	public void before() {
		campus = new Campus("test", new Address("test", "test", "test", "test"));
	}
	
	private final long idOfTestCampus() {
		return super.jdbcTemplate.queryForObject(
				"SELECT id FROM campussen WHERE naam='test'", Long.class);
	}
	
	@Test
	public void read() {
		final Campus campus = repository.read(idOfTestCampus()).get();
		
		assertEquals("test", campus.getName());
		assertEquals("test", campus.getAddress().getMunicipality());
	}
	
	@Test
	public void create() {
		final int count = super.countRowsInTable(CAMPUSSES);
		
		repository.create(campus);
		
		assertEquals(count + 1 ,
				super.countRowsInTable(CAMPUSSES));
		assertEquals(1,
				super.countRowsInTableWhere(CAMPUSSES, "id=" + campus.getId()));
	}
	
	@Test
	public void readPhoneNumbers() {
		final Campus campus = repository.read(idOfTestCampus()).get();
		
		assertEquals(1, campus.getPhoneNumbers().size());
		assertTrue(campus.getPhoneNumbers().contains(
				new PhoneNumber("1", false, "test")));
	}
}
