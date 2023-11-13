package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByTitle(String title);

    //List<BookEntity> findBooksByLinked_authors(AuthorEntity author);

}
