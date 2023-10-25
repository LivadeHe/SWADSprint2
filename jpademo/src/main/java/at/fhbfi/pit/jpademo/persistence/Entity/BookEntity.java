package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_isbn")
    private Long isbn;

    @Column(name = "book_title")
    private String title;

   // @Column(name = "book_author")
   // private String author;

    @ManyToMany (mappedBy = "book_id")
    Set<AuthorEntity> linkedAuthors;
}
