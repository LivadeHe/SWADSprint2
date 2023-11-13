package at.fhbfi.pit.jpademo.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class AuthorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "auth_id")
  private Long id;

  @Column(name = "auth_name")
  private String name;

  @Column(name = "auth_mail")
  private String mail;

  //@ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "author_book",
      joinColumns = @JoinColumn(name = "auth_id"),
      inverseJoinColumns = @JoinColumn(name = "book_id"))
  //@JsonIgnore
  private List<BookEntity> writtenBooks = new ArrayList<>();

/*  @Override
  public String toString() {
    return "AuthorEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", mail='" + mail + '\'' +
        ", written books=" + writtenBooks +
        '}';
  }*/

  public List<BookEntity> getWrittenBooks() {
    return writtenBooks;
  }

}
