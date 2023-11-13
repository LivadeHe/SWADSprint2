package at.fhbfi.pit.jpademo.api;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;
import at.fhbfi.pit.jpademo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonRestController {

  @Autowired
  private PersonService personService;


  @GetMapping
  public List<PersonDto> getPersonList() {
    System.out.println("getPersonList");
    List<PersonDto> persons = personService.getPersonList();
    persons.forEach(System.out::println);
    return persons;
  }

  @PostMapping
  public void save(@RequestBody PersonDto person) {
    System.out.println(person);
    personService.save(person);
  }


  @GetMapping("/{id}")
  public PersonDto getPerson(@PathVariable long id) {
    return personService.getPerson(id);

  }
/*
  void delete(PersonDto person);
  PersonDto getPerson (long id);*/


}
