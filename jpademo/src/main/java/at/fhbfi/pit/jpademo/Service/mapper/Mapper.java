package at.fhbfi.pit.jpademo.Service.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Mapper<DTO, ENTITY> {

  // s = source
  ENTITY toEntity(DTO s);

  DTO toDto(ENTITY s);

  default List<ENTITY> toEntity(Collection<DTO> s) {
    List<ENTITY> entities = new ArrayList<>();
    s.forEach(d -> entities.add(toEntity(d)));
    return entities;
  }

  default List<DTO> toDto(Collection<ENTITY> s) {
    List<DTO> dtos = new ArrayList<>();
    s.forEach(e -> dtos.add(toDto(e)));
    return dtos;
  }

}
