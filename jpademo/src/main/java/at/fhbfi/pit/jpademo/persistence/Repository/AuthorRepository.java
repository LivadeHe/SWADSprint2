package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

  List<AuthorEntity> findByName(String name);

  List<AuthorEntity> findByNameOrderByMailAsc(String name);

  List<AuthorEntity> findByMailContaining(String word);


}
