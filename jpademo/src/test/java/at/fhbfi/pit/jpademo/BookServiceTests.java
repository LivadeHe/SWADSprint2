package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.Service.BookService;
import at.fhbfi.pit.jpademo.Service.dto.BookDto;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookServiceTests {

  @Autowired
  private BookService bookService;
  @Autowired
  private BookRepository bookRepository;

  @Test
  void contextLoads() {
  }

  @Test
  void testSaveBook(){
    saveMoreBooks();
    BookDto newBook = BookDto.builder()
        .title("Im Schatten des Lichts")
        .isbn(4333654365L)
        .build();
    bookService.save(newBook);
    bookService.getBookList().forEach(System.out::println);
    //Assertions.assertEquals(3, bookRepository.count());

  }

  @Test
  void testGetBookList() {
    List<BookDto> books = bookService.getBookList();
    System.out.println(books.size());
    System.out.println("List of books: " + books);
  }

  @Test
  void testGetOneBook() {
    saveMoreBooks();
    BookDto book = bookService.getBook(4);
    System.out.println("One book: " + book);
    //Assertions.assertNotNull(oneBook);
    //Assertions.assertEquals("Faust", oneBook.getTitle());

  }


  void saveMoreBooks() {
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
  }



}
