package at.fhbfi.pit.jpademo.Service;

import at.fhbfi.pit.jpademo.Service.dto.BookDto;

import java.util.List;


public interface BookService {

  List<BookDto> getBookList();

  BookDto getBook(long id);

  void save(BookDto bookDto);

  void updateBook(long id, BookDto bookDto);

  void deleteBook(long id);

}
