package at.fhbfi.pit.jpademo.api;

import at.fhbfi.pit.jpademo.Service.AuthorService;
import at.fhbfi.pit.jpademo.Service.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorRestController {

  @Autowired
  private AuthorService authorService;

  @GetMapping
  public List<AuthorDto> getAuthorList() {
    System.out.println("getAuthorList");
    List<AuthorDto> authors = authorService.getAuthorList();
    authors.forEach(System.out::println);
    return authors;
  }

  @PostMapping
  public void save(@RequestBody AuthorDto authorDto) {
    System.out.println(authorDto);
    authorService.save(authorDto);
  }

  @GetMapping("/{id}")
  public AuthorDto getAuthor(@PathVariable long id) {
    return authorService.getAuthor(id);
  }

  @PutMapping("/{id}")
  public void updateAuthor(@PathVariable long id, @RequestBody AuthorDto authorDto) {
    authorService.updateAuthor(id, authorDto);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable long id) {
    authorService.delete(id);
  }

}
