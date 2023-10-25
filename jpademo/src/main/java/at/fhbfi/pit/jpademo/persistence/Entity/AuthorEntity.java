package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class AuthorEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "auth_id")
    private long id;

    @Column(name = "auth_name")
    private String name;

    @Column(name = "auth_age")
    private int age;






}
