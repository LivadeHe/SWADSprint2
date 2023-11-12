package at.fhbfi.pit.jpademo.Service.impl;

import at.fhbfi.pit.jpademo.Service.AuthorService;
import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.Service.mapper.AuthorMapper;
import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private AuthorMapper authorMapper;


  @Override
  public List<AuthorDto> getAuthorList() {
    return authorMapper.toDto(authorRepository.findAll());
  }

  @Override
  public AuthorDto getAuthor(final long id) {
    return authorMapper.toDto(authorRepository.findById(id).orElseGet(null));
  }

  @Override
  public void save(final AuthorDto authorDto) {
    authorRepository.save(authorMapper.toEntity(authorDto));
  }

  @Override
  public void updateAuthor(long id, AuthorDto authorDto) {
    Optional<AuthorEntity> optionalAuthor = authorRepository.findById(id);
    if (optionalAuthor.isPresent()) {
      AuthorEntity author = optionalAuthor.get();
      author.setName(authorDto.getName());
      author.setMail(authorDto.getMail());
      author.setWrittenBooks(authorDto.getWrittenBooks());
      authorRepository.save(author);
    } else {
      System.out.println("User not existing");
    }
  }

  @Override
  public void delete(long id) {
    authorRepository.deleteById(id);
  }
}
