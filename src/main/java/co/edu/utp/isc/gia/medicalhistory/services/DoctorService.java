package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto getDoctor(Long doctorId);
    DoctorDto saveDoctor(DoctorDto doctorDto);
    boolean updateDoctor(DoctorDto doctorDto);
    boolean deleteDoctor(Long doctorId);
    List<DoctorDto> getAllDoctors();
}
