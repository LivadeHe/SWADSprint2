package at.fhbfi.pit.jpademo.Service.impl;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;
import at.fhbfi.pit.jpademo.Service.mapper.PersonMapper;
import at.fhbfi.pit.jpademo.Service.PersonService;
import at.fhbfi.pit.jpademo.persistence.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private PersonMapper personMapper;


  @Override
  public List<PersonDto> getPersonList() {
    return personMapper.toDto(personRepository.findAll());

    //Ohne Mapper:
    /*    List<PersonEntity> entities = personRepository.findAll();
    List<PersonDto> dtos = new ArrayList<>();
    for (PersonEntity e : entities) {
      PersonDto dto = PersonDto.builder()
          .id(e.getId())
          .name(e.getName())
          .age(e.getAge())
          .build();
      dtos.add(dto);
    }
    return dtos;*/
  }

  @Override
  public void save(final PersonDto person) {
    personRepository.save(personMapper.toEntity(person));

  }

  @Override
  public PersonDto getPerson(final long id) {
    return personMapper.toDto(personRepository.findById(id).orElseGet(null));
  }

/*  @Override
  public void delete(final PersonDto person) {
    personRepository.delete(personMapper.toEntity(person));
  }*/
}
