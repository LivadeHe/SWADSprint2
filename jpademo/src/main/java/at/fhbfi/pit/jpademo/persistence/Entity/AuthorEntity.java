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

//public class AuthorEntity extends PersonEntity {

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

    Set<BookEntity> linked_books;

}
