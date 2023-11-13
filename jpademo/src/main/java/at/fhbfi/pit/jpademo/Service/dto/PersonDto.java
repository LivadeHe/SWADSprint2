package at.fhbfi.pit.jpademo.Service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
  //DTO = Data Transfer Objekt
  // Wie Entity, aber ohne Datenbank connection da nur Transfer Objekt

  private Long id;
  private String name;
  private int age;


}
