package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DrugAllergyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugAllergyRepository extends CrudRepository<DrugAllergyEntity, Long> {
    List<DrugAllergyEntity> findAll();
}
