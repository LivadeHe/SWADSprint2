package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.HobbyEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.HobbyRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JpademoApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private HobbyRepository hobbyRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testPersonPersistence() {

		List<PersonEntity> persons = new ArrayList<>();

		persons.add(PersonEntity.builder()
				.name("Sara")
				.age(30)
				.build());

		persons.add(PersonEntity.builder()
				.name("Marc")
				.age(40)
				.build());

		personRepository.saveAll(persons);
		personRepository.findAll().forEach(System.out::println);


		//personRepository.deleteById(1L);
		personRepository.findAll().forEach(System.out::println);
		// nur 1 versteht er nicht --> deshalb 1L --> somit type Long
//    personRepository.deleteAll();


	}

	@Test
	void testHobbyPersistence() {

		List<HobbyEntity> hobbies = new ArrayList<>();

		hobbies.add(HobbyEntity.builder()
				.name("Jogging")
				.cost(0F)
				.build());

		hobbies.add(HobbyEntity.builder()
				.name("Reading")
				.cost(10.0F)
				.build());

		hobbies.add(HobbyEntity.builder()
				.name("Cycling")
				.cost(30.0F)
				.build());

		hobbyRepository.saveAll(hobbies);
		System.out.println("************");
		hobbyRepository.findAll().forEach(System.out::println);
		System.out.println("************");
		hobbyRepository.findByCost(10.0F).forEach(System.out::println);
		System.out.println("************");
		hobbyRepository.findByCostGreaterThan(8.0F).forEach(System.out::println);
		System.out.println("************");
		hobbyRepository.findAllByOrderByCostAsc();
	}

	@Test
	void testPersonHobby() {

		PersonEntity person = PersonEntity.builder()
				.name("anna")
				.build();
		personRepository.save(person);

		HobbyEntity running = HobbyEntity.builder()
				.name("running")
				.build();
		HobbyEntity swimming = HobbyEntity.builder()
				.name("swimming")
				.build();

		hobbyRepository.saveAll(List.of(running, swimming));

		PersonEntity anna = personRepository.findByName("anna").get(0);
		running.setPerson(anna);
		hobbyRepository.save(running);
		swimming.setPerson(anna);  //Set überschreibt Person in DB
		hobbyRepository.save(swimming);

		hobbyRepository.findAll().forEach(System.out::println);
		System.out.println("************");
		System.out.println("Hobbies von " + anna);
		hobbyRepository.findByPerson(anna).forEach(System.out::println);

	}

}
