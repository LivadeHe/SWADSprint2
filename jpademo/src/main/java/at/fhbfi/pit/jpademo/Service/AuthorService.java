package at.fhbfi.pit.jpademo.Service;

import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;

import java.util.List;


public interface AuthorService {
  List<AuthorDto> getAuthorList();

  void save(AuthorDto authorDto);

  AuthorDto getAuthor(long id);

  void updateAuthor(long id, AuthorDto authorDto);

  void delete(long id);


}
