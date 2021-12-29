package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDto;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDto;

import java.util.List;

public interface MedicalHistoryService {
    MedicalHistoryDto getMedicalHistory(Long medicalHistoryId);
    MedicalHistoryDto saveMedicalHistory(MedicalHistoryDto medicalHistoryDto);
    boolean updateMedicalHistory(MedicalHistoryDto medicalHistoryDto);
    boolean deleteMedicalHistory(Long medicalHistoryId);
    MedicalHistoryDto getHistoryByPatientEntity(Long patientId);
}
