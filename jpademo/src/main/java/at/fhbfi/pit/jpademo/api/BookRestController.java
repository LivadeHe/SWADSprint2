package at.fhbfi.pit.jpademo.api;

import at.fhbfi.pit.jpademo.Service.BookService;
import at.fhbfi.pit.jpademo.Service.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookRestController {

  @Autowired
  private BookService bookService;

  @GetMapping
  public List<BookDto> getBookList() {
    List<BookDto> books = bookService.getBookList();
    books.forEach(System.out::println);
    return books;
  }

  @PostMapping
  public void save(@RequestBody BookDto book) {
    //System.out.println(book);
    bookService.save(book);
  }

  @GetMapping("/{id}")
  public BookDto getBook(@PathVariable long id) {
    return bookService.getBook(id);
  }

  @PutMapping("/{id}")
  public void updateBook(@PathVariable long id, @RequestBody BookDto bookDto) {
    bookService.updateBook(id, bookDto);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable long id) {
    bookService.deleteBook(id);
  }
}
