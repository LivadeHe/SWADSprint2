package at.fhbfi.pit.jpademo.Service.mapper;


import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.Service.dto.BookDto;
import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookDto, BookEntity> {

    @Override
    public BookEntity toEntity(final BookDto s) {
        if (s == null) {
            return null;
        }
        return BookEntity.builder()
                .id(s.getId())
                .isbn(s.getIsbn())
                .title(s.getTitle())
                .build();
    }

    @Override
    public BookDto toDto(final BookEntity s) {
        if (s == null) {
            return null;
        }
        return BookDto.builder()
                .id(s.getId())
                .isbn(s.getIsbn())
                .title(s.getTitle())
                .build();
    }
}
