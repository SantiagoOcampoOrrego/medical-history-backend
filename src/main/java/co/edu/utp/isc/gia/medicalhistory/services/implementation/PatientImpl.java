package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.PatientEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.PatientRepository;
import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDTO;
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
    public PatientDTO getPatient(Long patientId) {
        if(patientRepository.existsById(patientId)){
            return modelMapper.map(patientRepository.findById(patientId).get(), PatientDTO.class);
        }
        else{
            return new PatientDTO();
        }
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDto) {
        if(patientRepository.existsById(patientDto.getPatientId())){
            return null;
        }
        else{
            return modelMapper.map(patientRepository.save(modelMapper.map(patientDto, PatientEntity.class)), PatientDTO.class);
        }
    }

    @Override
    public boolean updatePatient(PatientDTO patientDto) {
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
    public List<PatientDTO> getAllPatients() {
        List<PatientDTO> patientDTOS = new ArrayList<>();

        patientRepository.findAll().forEach(patientEntity -> {
            patientDTOS.add(modelMapper.map(patientEntity, PatientDTO.class));
        });

        return patientDTOS;
    }
}
