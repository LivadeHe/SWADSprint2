package at.fhbfi.pit.jpademo.Service.dto;

import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

  private Long id;
  private String name;
  private String mail;
  private List<BookEntity> writtenBooks;

}
