package co.edu.utp.isc.gia.medicalhistory.data.repositories;

import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProcedureTypeRepository extends CrudRepository<ProcedureTypeEntity, Long> {
    List<ProcedureTypeEntity> findAll();
}
