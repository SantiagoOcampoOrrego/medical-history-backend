package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureTypeDTO;

import java.util.List;

public interface ProcedureTypeService {
    ProcedureTypeDTO getProcedureType(Long typeId);

    ProcedureTypeDTO saveProcedureType(ProcedureTypeDTO procedureTypeDTO);

    boolean updateProcedureType(ProcedureTypeDTO procedureTypeDTO);

    boolean deleteProcedureType(Long typeId);

    List<ProcedureTypeDTO> getAllProcedureTypes();
}
