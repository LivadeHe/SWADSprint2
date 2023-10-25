package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class AuthorEntity extends PersonEntity {

@ManyToMany
    Set<BookEntity> linkedAuthorBooks;






}
