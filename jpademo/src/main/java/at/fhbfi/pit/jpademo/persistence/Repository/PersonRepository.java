package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

  List<PersonEntity> findByName(String name);

  List<PersonEntity> findByNameAndAge(String name, int age);

}
