package at.fhbfi.pit.jpademo.persistence.Entity;

import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "auth_id")
  private Long id;

  @Column(name = "auth_name")
  private String name;

  @Column(name = "auth_mail")
  private String mail;

  @ManyToMany
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "auth_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  Set<BookEntity> written_books = new HashSet<>();;


}
