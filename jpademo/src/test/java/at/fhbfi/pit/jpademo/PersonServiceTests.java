package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;
import at.fhbfi.pit.jpademo.Service.PersonService;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PersonServiceTests {

  @Autowired
  private PersonService personService;

  @Autowired
  private PersonRepository personRepository;

  @Test
  void testGetPersonList() {
    saveTwoPersons();
    List<PersonDto> persons = personService.getPersonList();
    System.out.println(persons.size());
    //Assertions.assertEquals(2, persons.size());

  }

  @Test
  void testGetOnePerson() {
    saveTwoPersons();
    PersonDto person = personService.getPerson(1);
    Assertions.assertNotNull(person);
    Assertions.assertEquals("Sara", person.getName());

    // Test mit ungültigem ID
    //PersonDto person = personService.getPerson(11);
    //Assertions.assertNotNull(person);
  }

  @Test
  void testSavePerson(){
    saveTwoPersons();
    PersonDto newPerson = PersonDto.builder()
        .name("Lisa")
        .age(25)
        .build();
    personService.save(newPerson);
    personService.getPersonList().forEach(System.out::println);
    //Assertions.assertEquals(3, personRepository.count());
  }

  void saveTwoPersons() {

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
