package at.fhbfi.pit.jpademo.Service.impl;

import at.fhbfi.pit.jpademo.Service.AuthorService;
import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import at.fhbfi.pit.jpademo.Service.mapper.AuthorMapper;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorBookImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> getAuthorList() {
        return authorMapper.toDto(authorRepository.findAll());
    }

    @Override
    public void save(final AuthorDto author) {
        authorRepository.save(authorMapper.toEntity(author));

    }

    @Override
    public AuthorDto getAuthor(final long id) {
        return authorMapper.toDto(authorRepository.findById(id).orElseGet(null));
    }


}
