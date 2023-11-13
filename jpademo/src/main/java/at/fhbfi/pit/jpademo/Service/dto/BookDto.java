package at.fhbfi.pit.jpademo.Service.dto;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

  private Long id;
  private String title;
  private long isbn;
  private List<AuthorEntity> writtenBy;

}
