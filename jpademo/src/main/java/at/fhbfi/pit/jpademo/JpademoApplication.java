package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpademoApplication {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@PostConstruct
	public void insertFakeData() {
		saveTwoPersons();
	}

	private void saveTwoPersons() {
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
	}


}
