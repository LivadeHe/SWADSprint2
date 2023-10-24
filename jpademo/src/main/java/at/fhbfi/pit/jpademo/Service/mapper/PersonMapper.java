package at.fhbfi.pit.jpademo.Service.mapper;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<PersonDto, PersonEntity> {

  @Override
  public PersonEntity toEntity(final PersonDto s) {
    if (s == null) {
      return null;
    }
    return PersonEntity.builder()
        .id(s.getId())
        .name(s.getName())
        .age(s.getAge())
        .build();
  }

  @Override
  public PersonDto toDto(final PersonEntity s) {
    if (s == null) {
      return null;
    }
    return PersonDto.builder()
        .id(s.getId())
        .name(s.getName())
        .age(s.getAge())
        .build();
  }
}
