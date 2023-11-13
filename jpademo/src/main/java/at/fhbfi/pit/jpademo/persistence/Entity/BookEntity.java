package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long id;

    @Column(name = "book_isbn")
    private Long isbn;

    @Column(name = "book_title")
    private String title;

   @ManyToMany (fetch = FetchType.EAGER)
   @JoinTable(
           name = "author_book",
           joinColumns = @JoinColumn(name = "book_id"),
           inverseJoinColumns = @JoinColumn(name = "auth_id"))
    Set<AuthorEntity> linked_authors = new HashSet<>(); //initialisieren von linked authors

}
