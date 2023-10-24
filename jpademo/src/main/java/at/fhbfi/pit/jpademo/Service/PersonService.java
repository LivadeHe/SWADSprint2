package at.fhbfi.pit.jpademo.Service;

import at.fhbfi.pit.jpademo.Service.dto.PersonDto;

import java.util.List;



public interface PersonService {
/*  Component = managed Bean --> Zugreifen auf einer Klasse
  die Daten müssen zur Verfügung stehen, wenn eine andere Klasse mit autowired auf diese Klasse zugegriffen wird.
  Alle Methoden zu "Person"*/

  List<PersonDto> getPersonList();

  void save(PersonDto person);

  PersonDto getPerson(long id);

  //  void delete(PersonDto person);
}
