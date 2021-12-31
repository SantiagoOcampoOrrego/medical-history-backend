package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO getPatient(Long patientId);
    PatientDTO savePatient(PatientDTO patientDto);
    boolean updatePatient(PatientDTO patientDto);
    boolean deletePatient(Long patientId);
    List<PatientDTO> getAllPatients();
}
