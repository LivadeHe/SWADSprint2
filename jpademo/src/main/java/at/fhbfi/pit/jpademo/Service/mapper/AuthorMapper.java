package at.fhbfi.pit.jpademo.Service.mapper;

import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper implements Mapper<AuthorDto, AuthorEntity> {

  @Override
  public AuthorEntity toEntity(final AuthorDto s) {
    if (s == null) {
      return null;
    }
    return AuthorEntity.builder()
        .id(s.getId())
        .name(s.getName())
        .mail(s.getMail())
        .build();
  }

  @Override
  public AuthorDto toDto(final AuthorEntity s) {
    if (s == null) {
      return null;
    }
    return AuthorDto.builder()
        .id(s.getId())
        .name(s.getName())
        .mail(s.getMail())
        .build();
  }


}
