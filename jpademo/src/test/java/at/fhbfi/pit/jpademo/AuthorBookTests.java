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

    authors.add(AuthorEntity.builder()
        .name("Tolkien")
        .mail("tolkien@tolkien.com")
        .build());

    authors.add(AuthorEntity.builder()
        .name("Tolkien")
        .mail("jrr@tolkien.com")
        .build());

    authorRepository.saveAll(authors);
    System.out.println("****** Alle Authors *****");
    authorRepository.findAll().forEach(System.out::println);
    System.out.println("****** Authors mit name Tolkien ASC *****");
    authorRepository.findByNameOrderByMailAsc("Tolkien").forEach(System.out::println);
    System.out.println("***********");

  }

  @Test
  void testBookPersistence() {
    List<BookEntity> books = new ArrayList<>();

    books.add(BookEntity.builder()
        .title("Faust")
        .isbn(12345L)
        .build());

    books.add(BookEntity.builder()
        .title("Die Verwandlung")
        .isbn(123456789L)
        .build());

    books.add(BookEntity.builder()
        .title("Lord of the Rings: Die Gefährten")
        .isbn(3589745L)
        .build());

    books.add(BookEntity.builder()
        .title("Lord of the Rings: Die zwei Türme")
        .isbn(3811477L)
        .build());

    books.add(BookEntity.builder()
        .title("Lord of the Rings: Die Rückkehr des Königs")
        .isbn(998251474L)
        .build());

    bookRepository.saveAll(books);
    System.out.println("****** Alle Bücher *****");
    bookRepository.findAll().forEach(System.out::println);
    System.out.println("***** Bücher mit im Titel Verwandl ******");
    bookRepository.findByTitleContaining("Verwandl").forEach(System.out::println);
    System.out.println("****** Bücher mit im Title Lord ASC *****");
    bookRepository.findByTitleContainingOrderByTitleAsc("Lord").forEach(System.out::println);
    System.out.println("***********");

  }


  @Test
  void testAuthorBook() {
    BookEntity faust = BookEntity.builder()
        .title("Faust")
        .isbn(489745614679L)
        .build();

    BookEntity leidensWerthers = BookEntity.builder()
        .title("Die Leiden des jungen Werthers")
        .isbn(89786543146L)
        .build();

    bookRepository.saveAll(List.of(faust, leidensWerthers));

    AuthorEntity goethe = AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        .build();
    authorRepository.save(goethe);


    goethe.getWritten_books().add(faust);
    goethe.getWritten_books().add(leidensWerthers);

    authorRepository.save(goethe);


    // faust.getWritten_by().add(goethe);
    // leidensWerthers.getWritten_by().add(goethe);
    // bookRepository.saveAll(List.of(faust, leidensWerthers));

    // bookRepository.findAll().forEach(System.out::println);
    // authorRepository.findAll().forEach(System.out::println);


//    System.out.println("Bücher von " + goethe.getName() + ":");
//    for (BookEntity book : goethe.getWritten_books()) {
//      System.out.println(book.getTitle());
//    }
//
//    System.out.println("Autoren von " + faust.getTitle() + ":");
//    for (AuthorEntity author : faust.getWritten_by()) {
//      System.out.println(author.getName());
//    }


  }


}
