package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DoctorEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedureRepository extends CrudRepository<ProcedureEntity, Long> {
    List<ProcedureEntity> findAllByMedicalHistoryEntity(MedicalHistoryEntity medicalHistoryEntity);
    List<ProcedureEntity> findAllByDoctorEntity(DoctorEntity doctorEntity);
}
