package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.DrugAllergyDTO;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.FamiliarDiseaseDTO;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDTO;

public interface MedicalHistoryService {
    MedicalHistoryDTO getMedicalHistory(Long medicalHistoryId);
    MedicalHistoryDTO saveMedicalHistory(MedicalHistoryDTO medicalHistoryDto);
    boolean updateMedicalHistory(MedicalHistoryDTO medicalHistoryDto);
    boolean deleteMedicalHistory(Long medicalHistoryId);
    MedicalHistoryDTO getHistoryByPatientEntity(Long patientId);
}
