package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

  List<BookEntity> findByTitle(String title);

  //Bücher suchen nach ISBN - mit Sortierung nach Title
  List<BookEntity> findByTitleContainingOrderByTitleAsc(String word);

  // Suchen nach einem Wort im Title
  List<BookEntity> findByTitleContaining(String word);

}
