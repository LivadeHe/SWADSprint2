package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorBookTests {

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private AuthorRepository authorRepository;

  @Test
  void contextLoads() {
  }

  @Test
  void testAuthorPersistence() {
    List<AuthorEntity> authors = new ArrayList<>();

    authors.add(AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        .build());

    authors.add(AuthorEntity.builder()
        .name("Kafka")
        .mail("franz@kafka.com")
        .build());

    authorRepository.saveAll(authors);
    authorRepository.findAll().forEach(System.out::println);
    System.out.println("***********");

  }

  @Test
  void testBookPersistence() {
    List<BookEntity> books = new ArrayList<>();

    books.add(BookEntity.builder()
        .title("Faust")
        .isbn(789765413216L)
        .build());

    books.add(BookEntity.builder()
        .title("Die Verwandlung")
        .isbn(1478598547782755L)
        .build());

    bookRepository.saveAll(books);
    bookRepository.findAll().forEach(System.out::println);
    System.out.println("***********");

  }

  @Test
  void testAuthorBook() {
    AuthorEntity goethe = AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        .build();
    authorRepository.save(goethe);

    BookEntity faust = BookEntity.builder()
        .title("Faust")
        .isbn(489745614679L)
        .build();

    BookEntity leidensWerthers = BookEntity.builder()
        .title("Die Leiden des jungen Werthers")
        .isbn(89786543146L)
        .build();

    bookRepository.saveAll(List.of(faust, leidensWerthers));
    goethe.getWritten_books().add(faust);
    goethe.getWritten_books().add(leidensWerthers);
    bookRepository.saveAll(List.of(faust, leidensWerthers));
    faust.getWritten_by().add(goethe);
    leidensWerthers.getWritten_by().add(goethe);
    authorRepository.save(goethe);


    System.out.println("Bücher von " + goethe.getName() + ":");
    for (BookEntity book : goethe.getWritten_books()) {
      System.out.println(book.getTitle());
    }

    System.out.println("Autoren von " + faust.getTitle() + ":");
    for (AuthorEntity author : faust.getWritten_by()) {
      System.out.println(author.getName());
    }


  }


}
