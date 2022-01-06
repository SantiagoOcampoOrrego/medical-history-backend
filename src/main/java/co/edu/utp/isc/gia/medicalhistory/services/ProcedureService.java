package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDTO;

import java.util.List;

public interface ProcedureService {
    ProcedureDTO getProcedure(Long procedureId);
    ProcedureDTO saveProcedure(ProcedureDTO procedureDto);
    boolean updateProcedure(ProcedureDTO procedureDto);
    boolean deleteProcedure(Long procedureId);
    List<ProcedureDTO> getAllProceduresByHistoryId(Long historyId);
    List<ProcedureDTO> getAllProceduresByDoctorId(Long doctorId);
}
