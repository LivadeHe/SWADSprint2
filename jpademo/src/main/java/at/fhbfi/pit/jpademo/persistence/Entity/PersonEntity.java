package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PersonEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "per_id")
  private Long id;

  @Column(name = "per_name")
  private String name;

  @Column(name = "per_age")
  private int age;

}
