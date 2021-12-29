package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.PatientEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.MedicalHistoryRepository;
import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDto;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDto;
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
    public MedicalHistoryDto getMedicalHistory(Long medicalHistoryId) {
        if(medicalHistoryRepository.existsById(medicalHistoryId)){
            return modelMapper.map(medicalHistoryRepository.findById(medicalHistoryId).get(), MedicalHistoryDto.class);
        }
        else return new MedicalHistoryDto();
    }

    @Override
    public MedicalHistoryDto saveMedicalHistory(MedicalHistoryDto medicalHistoryDto) {
        MedicalHistoryEntity medicalHistoryEntity = modelMapper.map(medicalHistoryDto, MedicalHistoryEntity.class);
        medicalHistoryEntity.setPatientEntity(modelMapper.map(patientService.getPatient(medicalHistoryDto.getPatientId()), PatientEntity.class));
        return modelMapper.map(medicalHistoryRepository.save(medicalHistoryEntity), MedicalHistoryDto.class);
    }

    @Override
    public boolean updateMedicalHistory(MedicalHistoryDto medicalHistoryDto) {
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
    public MedicalHistoryDto getHistoryByPatientEntity(Long patientId) {
        PatientEntity patientEntity = modelMapper.map(patientService.getPatient(patientId), PatientEntity.class);
        return modelMapper.map(medicalHistoryRepository.findByPatientEntity(patientEntity), MedicalHistoryDto.class);
    }
}
