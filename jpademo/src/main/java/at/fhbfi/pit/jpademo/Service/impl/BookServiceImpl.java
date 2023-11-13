package at.fhbfi.pit.jpademo.Service.impl;

import at.fhbfi.pit.jpademo.Service.BookService;
import at.fhbfi.pit.jpademo.Service.dto.BookDto;
import at.fhbfi.pit.jpademo.Service.mapper.BookMapper;
import at.fhbfi.pit.jpademo.persistence.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void save(final BookDto book) {
        bookRepository.save(bookMapper.toEntity(book));

    }

    @Override
    public BookDto getBook(final long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseGet(null));
    }
}
