package at.fhbfi.pit.jpademo.persistence.Entity;

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
@Table(name = "book")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "book_id")
  private Long id;
  @Column(name = "book_title")
  private String title;

  @Column(name = "book_isbn")
  private Long isbn;

  @ManyToMany(fetch = FetchType.EAGER, mappedBy = "written_books", cascade = {CascadeType.ALL})
  @Builder.Default
  private List<AuthorEntity> written_by = new ArrayList<>();


  public List<AuthorEntity> getWrittenBy() {
    return written_by;
  }


  // Wenn eingeblendet --> Endlosschleife
  @Override
  public String toString() {
    return "BookEntity{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", isbn=" + isbn +
        //", written_by=" + written_by +
        '}';
  }

}
