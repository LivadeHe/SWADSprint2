package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;
import at.fhbfi.pit.jpademo.Service.mapper.PersonMapper;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.HobbyRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MapperTestsPersonHobby {



  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private HobbyRepository hobbyRepository;

  @Autowired
  private PersonMapper personMapper;

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

    //List<PersonDto> personDtos = new ArrayList<>();

    List<PersonEntity> personEntities = personRepository.findAll();


    //personEntities.forEach(e ->personDtos.add(personMapper.toDto(e)));
    /* for(PersonEntity e : personEntities) {
      personDtos.add(personMapper.toDto(e));*/

    List<PersonDto> personDtos = personMapper.toDto(personEntities);
    personDtos.forEach(System.out::println);

    //Noch Kompakter
    //personMapper.toDto(personRepository.findAll().forEach(System.out::println));
  }



}
