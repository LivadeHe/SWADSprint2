package at.fhbfi.pit.jpademo.Service;

import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.Service.dto.PersonDto;

import java.util.List;

public interface AuthorService {

    List<PersonDto> getAuthorList();

    void save(AuthorDto author);

    AuthorDto getAuthor(long id);

}
