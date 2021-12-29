package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto getPatient(Long patientId);
    PatientDto savePatient(PatientDto patientDto);
    boolean updatePatient(PatientDto patientDto);
    boolean deletePatient(Long patientId);
    List<PatientDto> getAllPatients();
}
