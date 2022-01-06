package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DrugAllergyEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrugAllergyRepository extends CrudRepository<DrugAllergyEntity, Long> {
    List<DrugAllergyEntity> findAll();
    List<DrugAllergyEntity> findAllByMedicalHistoryEntity(MedicalHistoryEntity medicalHistoryEntity);
}
