package at.fhbfi.pit.jpademo.Service;

import at.fhbfi.pit.jpademo.Service.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getBookList();

    void save(BookDto book);

    BookDto getBook(long id);

}
