package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.Service.AuthorService;
import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AuthorServiceTests {

  @Autowired
  private AuthorRepository authorRepository;
  @Autowired
  private AuthorService authorService;


  @Test
  void contextLoads() {
  }

  @Test
  void testGetAuthorList() {
    List<AuthorDto> authors = authorService.getAuthorList();
    System.out.println("Alle Autoren: " + authors);
    System.out.println("Anzahl Autoren: " + authors.size());
    //Assertions.assertEquals(3, authors.size());
  }

  @Test
  void testGetOneAuthor() {
    //saveThreeAuthors();
    AuthorDto author = authorService.getAuthor(2);
    System.out.println(author);
    //Assertions.assertNotNull(author);
    //Assertions.assertEquals("Goethe", author.getName());
  }

  @Test
  void testSaveAuthor() {
    //saveThreeAuthors();
    AuthorDto newAuthor = AuthorDto.builder()
        .name("Jojo Moyes")
        .mail("jojo@moyes.com")
        .build();
    authorService.save(newAuthor);
    authorService.getAuthorList().forEach(System.out::println);
    System.out.println("New Author: " + newAuthor);
    //Assertions.assertEquals(3, authorRepository.count());
  }

  void saveThreeAuthors() {
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

    authorRepository.saveAll(authors);
  }




}
