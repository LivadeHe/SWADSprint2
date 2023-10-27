package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

 List<BookEntity> findByTitle(String title);


}
