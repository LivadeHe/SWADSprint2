package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "book_id")
  private Long id;
  @Column(name = "book_title")
  private String title;

  @Column(name = "book_isbn")
  private Long isbn;

  //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "written_books",  cascade = {CascadeType.ALL})
  //private Set<AuthorEntity> written_by = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "auth_id"))
  private Set<AuthorEntity> written_by = new HashSet<>();

}
