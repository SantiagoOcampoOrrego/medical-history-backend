package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO getDoctor(Long doctorId);
    DoctorDTO saveDoctor(DoctorDTO doctorDto);
    boolean updateDoctor(DoctorDTO doctorDto);
    boolean deleteDoctor(Long doctorId);
    List<DoctorDTO> getAllDoctors();
}
