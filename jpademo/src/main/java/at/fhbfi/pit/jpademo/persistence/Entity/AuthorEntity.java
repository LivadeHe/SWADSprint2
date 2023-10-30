package at.fhbfi.pit.jpademo.persistence.Entity;

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
import java.util.Objects;
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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "auth_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  @Builder.Default
  private Set<BookEntity> written_books = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AuthorEntity that = (AuthorEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "AuthorEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", mail='" + mail + '\'' +
        ", written_books=" + written_books +
        '}';
  }


}
