package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
class JpademoApplicationTests {

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
    System.out.println("****** Alle mit Name goethe *****");
    authorRepository.findByName("Goethe").forEach(System.out::println);
    System.out.println("****** Authors mit name Tolkien ASC *****");
    authorRepository.findByNameOrderByMailAsc("Tolkien").forEach(System.out::println);
    System.out.println("****** Authors finden bei Teil vom Mailadresse *****");
    authorRepository.findByMailContaining("kien@to");
    System.out.println("***********");
    System.out.println("***********");
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
    System.out.println("***********");
    System.out.println("***********");
  }


  @Transactional
  @Test
  void testAuthorBook() {
    AuthorEntity goethe = AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        .build();

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

    BookEntity lord1 = BookEntity.builder()
        .title("Lord of the Rings - Die Gefährten")
        .isbn(3589745L)
        .build();

    bookRepository.saveAll(List.of(faust, leidensWerthers, lord1));

    // Speichern von written_books bei Author
    ArrayList<BookEntity> bookLord1 = new ArrayList<>();
    bookLord1.add(lord1);
    tolkien.setWrittenBooks(bookLord1);
    kafka.setWrittenBooks(bookLord1);

    ArrayList<BookEntity> bookFaust = new ArrayList<>();
    bookFaust.add(faust);
    goethe.setWrittenBooks(bookFaust);

    authorRepository.saveAll(List.of(tolkien, kafka, goethe));
    authorRepository.findAll().forEach(System.out::println);
    bookRepository.findAll().forEach(System.out::println);


    // Speichern von written_by bei Books
 /*   ArrayList<AuthorEntity> authorGoethe = new ArrayList<>();
    authorGoethe.add(goethe);

    ArrayList<AuthorEntity> authors = new ArrayList<>();
    authors.add(kafka);
    authors.add(tolkien);

    faust.setWrittenBy(authorGoethe);
    leidensWerthers.setWrittenBy((authorGoethe));
    lord1.setWrittenBy(authors);

    bookRepository.saveAll((List.of(faust, leidensWerthers, lord1)));
    bookRepository.findAll().forEach(System.out::println);
    authorRepository.findAll().forEach(System.out::println);*/

  }

}
