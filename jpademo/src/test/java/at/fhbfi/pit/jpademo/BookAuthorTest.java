package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class BookAuthorTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testAuthorPersistence() {

        List<AuthorEntity> authors = new ArrayList<>();

        authors.add(AuthorEntity.builder()
                .name("Wolfgang")
                .mail("wolfgang@goethe.de")
                .build());

        authors.add(AuthorEntity.builder()
                .name("Friedrich")
                .mail("friedrich@schiller.de")
                .build());

        authorRepository.saveAll(authors);
        authorRepository.findAll().forEach(System.out::println);
    }
    @Test
    void testBookPersistance() {

        List<BookEntity> books = new ArrayList<>();
        books.add(BookEntity.builder()
                .title("Faust")
                        .isbn(1234567890123L)
                .build());

        books.add(BookEntity.builder()
                .title("Raeuber")
                .isbn(2345678901234L)
                .build());

        bookRepository.saveAll(books);
        bookRepository.findAll().forEach(System.out::println);

    }



    @Test
    void testAuthorBookRelationship() {
        // Erstellen eines Autors und eines Buchs
        AuthorEntity goethe = AuthorEntity.builder()
                .name("Johan Goethe")
                .mail("johann@goethe.de")
                .build();
        authorRepository.save(goethe);

        BookEntity faust = BookEntity.builder()
                .title("Faust")
                .isbn(1234567890L)
                .build();
        bookRepository.save(faust);

        // Autoren und Bücher verknüpfen
        faust.getLinked_authors().add(goethe);
        goethe.getLinked_books().add(faust);



        // Speichern der Änderungen
        authorRepository.save(goethe);
        bookRepository.save(faust);

        /*
        // Ausgabe der verknüpften Autoren und Bücher
        System.out.println("************");
        System.out.println("Autoren des Buchs " + book.getTitle());
      bookRepository.findBooksByLinked_authors(author).forEach(System.out::println);

        System.out.println("************");
        System.out.println("Bücher des Autors " + author.getName());
       authorRepository.findAuthorsByLinked_books(book).forEach(System.out::println);
*/
    }
}
