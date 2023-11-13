package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.Service.mapper.AuthorMapper;
import at.fhbfi.pit.jpademo.Service.mapper.BookMapper;
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
public class MapperTestsAuthorBook {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private AuthorMapper authorMapper;

  @Autowired
  private BookRepository bookRepository;
  @Autowired
  private BookMapper bookMapper;

  @Test
  void contextLoads() {
  }

  @Test
  void testAuthorPersistence() {
    List<AuthorEntity> authorsList = new ArrayList<>();
    authorsList.add(AuthorEntity.builder()
        .name("Goethe")
        .mail("wolfgang@goethe.com")
        .build());

    authorsList.add(AuthorEntity.builder()
        .name("Kafka")
        .mail("franz@kafka.com")
        .build());

    authorsList.add(AuthorEntity.builder()
        .name("Tolkien")
        .mail("tolkien@tolkien.com")
        .build());

    authorsList.add(AuthorEntity.builder()
        .name("Tolkien")
        .mail("jrr@tolkien.com")
        .build());

    authorRepository.saveAll(authorsList);

    authorMapper.toDto(authorRepository.findAll()).forEach(System.out::println);
    System.out.println("AuthorsList: " + authorsList);
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
        .title("Die Leiden des jungen Werthers")
        .isbn(89786543146L)
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

    bookMapper.toDto(bookRepository.findAll()).forEach(System.out::println);

  }

}
