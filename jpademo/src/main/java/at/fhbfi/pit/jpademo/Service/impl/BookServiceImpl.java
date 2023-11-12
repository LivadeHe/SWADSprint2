package at.fhbfi.pit.jpademo.Service.impl;

import at.fhbfi.pit.jpademo.Service.BookService;
import at.fhbfi.pit.jpademo.Service.dto.BookDto;
import at.fhbfi.pit.jpademo.Service.mapper.BookMapper;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private BookMapper bookMapper;

  @Override
  public List<BookDto> getBookList() {
    return bookMapper.toDto(bookRepository.findAll());
  }

  @Override
  public void save(final BookDto bookDto) {
    bookRepository.save(bookMapper.toEntity(bookDto));
  }

  @Override
  public BookDto getBook(final long id) {
    return bookMapper.toDto(bookRepository.findById(id).orElseGet(null));
  }

  @Override
  public void updateBook(long id, BookDto bookDto) {
    Optional<BookEntity> optionalBook = bookRepository.findById(id);
    if (optionalBook.isPresent()) {
      BookEntity book = optionalBook.get();
      book.setTitle(bookDto.getTitle());
      book.setIsbn(bookDto.getIsbn());
      book.setWrittenBy(bookDto.getWrittenBy());
      bookRepository.save(book);
    } else {
      System.out.println("Book not found");
    }
  }

  @Override
  public void deleteBook(long id) {
    bookRepository.deleteById(id);
  }

}
