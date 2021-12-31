package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.PatientEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.MedicalHistoryRepository;
import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryImpl implements MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ModelMapper modelMapper;

    public MedicalHistoryImpl(MedicalHistoryRepository medicalHistoryRepository, PatientService patientService, ModelMapper modelMapper) {
        this.medicalHistoryRepository = medicalHistoryRepository;
        this.patientService = patientService;
        this.modelMapper = modelMapper;
    }

    @Override
    public MedicalHistoryDTO getMedicalHistory(Long medicalHistoryId) {
        if(medicalHistoryRepository.existsById(medicalHistoryId)){
            return modelMapper.map(medicalHistoryRepository.findById(medicalHistoryId).get(), MedicalHistoryDTO.class);
        }
        else return new MedicalHistoryDTO();
    }

    @Override
    public MedicalHistoryDTO saveMedicalHistory(MedicalHistoryDTO medicalHistoryDto) {
        MedicalHistoryEntity medicalHistoryEntity = modelMapper.map(medicalHistoryDto, MedicalHistoryEntity.class);
        medicalHistoryEntity.setPatientEntity(modelMapper.map(patientService.getPatient(medicalHistoryDto.getPatientId()), PatientEntity.class));
        return modelMapper.map(medicalHistoryRepository.save(medicalHistoryEntity), MedicalHistoryDTO.class);
    }

    @Override
    public boolean updateMedicalHistory(MedicalHistoryDTO medicalHistoryDto) {
        if(medicalHistoryRepository.existsById(medicalHistoryDto.getHistoryId())){
            medicalHistoryRepository.save(modelMapper.map(medicalHistoryDto, MedicalHistoryEntity.class));
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteMedicalHistory(Long medicalHistoryId) {
        if(medicalHistoryRepository.existsById(medicalHistoryId)){
            medicalHistoryRepository.deleteById(medicalHistoryId);
            return true;
        }
        else return false;
    }

    @Override
    public MedicalHistoryDTO getHistoryByPatientEntity(Long patientId) {
        PatientEntity patientEntity = modelMapper.map(patientService.getPatient(patientId), PatientEntity.class);
        return modelMapper.map(medicalHistoryRepository.findByPatientEntity(patientEntity), MedicalHistoryDTO.class);
    }
}
