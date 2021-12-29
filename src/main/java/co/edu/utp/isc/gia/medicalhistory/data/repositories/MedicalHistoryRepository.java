package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.PatientEntity;
import org.springframework.data.repository.CrudRepository;

public interface MedicalHistoryRepository extends CrudRepository<MedicalHistoryEntity, Long> {
    MedicalHistoryEntity findByPatientEntity(PatientEntity patientEntity);
}
