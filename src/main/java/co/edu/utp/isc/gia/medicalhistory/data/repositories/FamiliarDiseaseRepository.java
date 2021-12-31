package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.FamiliarDiseaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FamiliarDiseaseRepository extends CrudRepository<FamiliarDiseaseEntity, Long> {
    List<FamiliarDiseaseEntity> findAll();
}
