package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;

import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
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

}
