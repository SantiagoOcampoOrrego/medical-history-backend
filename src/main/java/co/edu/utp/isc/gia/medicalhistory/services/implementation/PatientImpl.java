package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.PatientEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.PatientRepository;
import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PatientImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto getPatient(Long patientId) {
        if(patientRepository.existsById(patientId)){
            return modelMapper.map(patientRepository.findById(patientId).get(), PatientDto.class);
        }
        else{
            return new PatientDto();
        }
    }

    @Override
    public PatientDto savePatient(PatientDto patientDto) {
        if(patientRepository.existsById(patientDto.getPatientId())){
            return null;
        }
        else{
            return modelMapper.map(patientRepository.save(modelMapper.map(patientDto, PatientEntity.class)), PatientDto.class);
        }
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) {
        if(patientRepository.existsById(patientDto.getPatientId())){
            patientRepository.save(modelMapper.map(patientDto, PatientEntity.class));
            return true;
        }
        else return false;
    }

    @Override
    public boolean deletePatient(Long patientId) {
        if(patientRepository.existsById(patientId)){
            patientRepository.deleteById(patientId);
            return true;
        }
        else return false;
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patientDtos = new ArrayList<>();

        patientRepository.findAll().forEach(patientEntity -> {
            patientDtos.add(modelMapper.map(patientEntity, PatientDto.class));
        });

        return patientDtos;
    }
}
