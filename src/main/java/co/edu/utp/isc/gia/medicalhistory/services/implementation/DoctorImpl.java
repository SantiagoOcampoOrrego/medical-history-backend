package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DoctorEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.DoctorRepository;
import co.edu.utp.isc.gia.medicalhistory.services.DoctorService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.DoctorDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public DoctorImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorDto getDoctor(Long doctorId) {
        if(doctorRepository.existsById(doctorId)){
            return modelMapper.map(doctorRepository.findById(doctorId).get(), DoctorDto.class);
        }
        else return new DoctorDto();
    }

    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        if(doctorRepository.existsById(doctorDto.getDoctorId())){
            return new DoctorDto();
        }
        else{
            return modelMapper.map(doctorRepository.save(modelMapper.map(doctorDto, DoctorEntity.class)), DoctorDto.class);
        }
    }

    @Override
    public boolean updateDoctor(DoctorDto doctorDto) {
        if(doctorRepository.existsById(doctorDto.getDoctorId())){
            doctorRepository.save(modelMapper.map(doctorDto, DoctorEntity.class));
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(Long doctorId) {
        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
            return true;
        }
        else return false;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<DoctorDto> doctorDtos = new ArrayList<>();
        doctorRepository.findAll().forEach(doctorEntity -> {
            doctorDtos.add(modelMapper.map(doctorEntity, DoctorDto.class));
        });
        return doctorDtos;
    }
}
