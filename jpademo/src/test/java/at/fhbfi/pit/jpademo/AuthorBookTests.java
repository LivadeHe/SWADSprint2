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
    AuthorEntity goethe = AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        //.written_books(new HashSet<>())
        .build();
    //authorRepository.save(goethe);

    AuthorEntity kafka = AuthorEntity.builder()
        .name("Kafka")
        .mail("franz@kafka.com")
        .build();

    AuthorEntity tolkien = AuthorEntity.builder()
        .name("Tolkien")
        .mail("tolkien@tolkien.com")
        .build();

    authorRepository.saveAll(List.of(goethe, kafka, tolkien));


    BookEntity faust = BookEntity.builder()
        .title("Faust")
        .isbn(489745614679L)
        .build();

    BookEntity leidensWerthers = BookEntity.builder()
        .title("Die Leiden des jungen Werthers")
        .isbn(89786543146L)
        .build();

    List<BookEntity> books = new ArrayList<>();

    BookEntity lord1 = BookEntity.builder()
        .title("Lord of the Rings: Die Gefährten")
        .isbn(3589745L)
        .build();

    BookEntity lord2 = BookEntity.builder()
        .title("Lord of the Rings: Die zwei Türme")
        .isbn(3811477L)
        .build();

    BookEntity lord3 = BookEntity.builder()
        .title("Lord of the Rings: Die Rückkehr des Königs")
        .isbn(998251474L)
        .build();

    bookRepository.saveAll(List.of(faust, leidensWerthers, lord1, lord2, lord3));

    goethe.getWritten_books().add(faust);
    goethe.getWritten_books().add(leidensWerthers);
    goethe.getWritten_books().add(lord1);
    authorRepository.save(goethe);
    tolkien.getWritten_books().add(lord1);
    tolkien.getWritten_books().add(lord2);
    tolkien.getWritten_books().add(lord3);
    authorRepository.save(tolkien);

    System.out.println("****** Alle Bücher von Goethe ******");
    authorRepository.findByNameOrderByMailAsc("Goethe").forEach(System.out::println);


    System.out.println("****** Alle Autoren mit Bücher ******");
    authorRepository.findAll().forEach(System.out::println);

    // Funktioniert noch nicht - weil getWritten_by is null
    // (im toString ergänzen verursacht endlosschleife)
    /*System.out.println("****** Alle Bücher mit Autoren ******");
    bookRepository.findAll().forEach(System.out::println);*/

    System.out.println("Bücher von " + goethe.getName() + ":");
    for (BookEntity book : goethe.getWritten_books()) {
      System.out.println(book.getTitle());
    }

    System.out.println("Bücher von " + tolkien.getName() + ":");
    for (BookEntity book : tolkien.getWritten_books()) {
      System.out.println(book.getTitle());
    }

    // Funktioniert noch nicht - weil getWritten_by is null
    // (im toString ergänzen verursacht endlosschleife)
    System.out.println("Autoren von " + lord1.getTitle() + ":");
    for (AuthorEntity author : lord1.getWritten_by()) {
      System.out.println(author.getName());
    }


  /*  AuthorEntity author = authorRepository.findByName("Goethe").get(0);
    faust.setWritten_by(author);
    bookRepository.save(faust);*/


    //goethe.getWritten_books().add(faust);
    // goethe.getWritten_books().add(leidensWerthers);

    // authorRepository.save(goethe);


    // faust.getWritten_by().add(goethe);
    // leidensWerthers.getWritten_by().add(goethe);
    // bookRepository.saveAll(List.of(faust, leidensWerthers));


  }


}
