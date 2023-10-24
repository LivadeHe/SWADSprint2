package at.fhbfi.pit.jpademo.persistence.Repository;

import at.fhbfi.pit.jpademo.persistence.Entity.HobbyEntity;
import at.fhbfi.pit.jpademo.persistence.Entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {

  List<HobbyEntity> findByCost (float cost);
  List<HobbyEntity> findByName (String name);
  List<HobbyEntity> findByPerson (PersonEntity person);
  List<HobbyEntity> findByCostGreaterThan (float value);
  List<HobbyEntity> findAllByOrderByCostAsc();

  //@Query("Select *  from hobby where hob_cost > 10.0")
  //List<HobbyEntity> findByBiggerTen();


}
