package at.fhbfi.pit.jpademo;

import at.fhbfi.pit.jpademo.persistence.Entity.AuthorEntity;
import at.fhbfi.pit.jpademo.persistence.Repository.AuthorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpademoApplication {
	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@PostConstruct
	public void insertFakeData() {
		saveThreeAuthors();
	}

	private void saveThreeAuthors() {
      List<AuthorEntity> authors = new ArrayList<>();

      authors.add(AuthorEntity.builder()
          .name("Goethe")
          .mail("wolfgang@goethe.com")
          .build());

      authors.add(AuthorEntity.builder()
          .name("Kafka")
          .mail("franz@kafka.com")
          .build());

      authors.add(AuthorEntity.builder()
          .name("Tolkien")
          .mail("tolkien@tolkien.com")
          .build());

      authorRepository.saveAll(authors);
    }


}
