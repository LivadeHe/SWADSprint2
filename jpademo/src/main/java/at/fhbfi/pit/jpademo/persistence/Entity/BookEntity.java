package at.fhbfi.pit.jpademo.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
//@Table(name = "book")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "book_id")
  private Long id;
  @Column(name = "book_title")
  private String title;
  @Column(name = "book_isbn")
  private Long isbn;

  //@ToString.Exclude
  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "writtenBooks")
  //@JsonIgnore
  private List<AuthorEntity> writtenBy = new ArrayList<>();

  public List<AuthorEntity> getWrittenBy() {
    return writtenBy;
  }

/*  @Override
  public String toString() {
    return "BookEntity{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn=" + isbn +
        ", written by=" + writtenBy +
        '}';
  }*/

}
