package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDto;

import java.util.List;

public interface ProcedureService {
    ProcedureDto getProcedure(Long procedureId);
    ProcedureDto saveProcedure(ProcedureDto procedureDto);
    boolean updateProcedure(ProcedureDto procedureDto);
    boolean deleteProcedure(Long procedureId);
    List<ProcedureDto> getAllProceduresByHistoryId(Long historyId);
}
