package at.fhbfi.pit.jpademo.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class HobbyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "hob_id")
  private Long id;

  @Column(name = "hob_name")
  private String name;

  @Column(name = "hob_cost")
  private float cost;

  @ManyToOne
  private PersonEntity person;

}
