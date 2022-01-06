package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.FamiliarDiseaseEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.FamiliarDiseaseRepository;
import co.edu.utp.isc.gia.medicalhistory.services.FamiliarDiseaseService;
import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.FamiliarDiseaseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamiliarDiseaseImpl implements FamiliarDiseaseService {

    @Autowired
    private FamiliarDiseaseRepository familiarDiseaseRepository;

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private ModelMapper modelMapper;

    public FamiliarDiseaseImpl(FamiliarDiseaseRepository familiarDiseaseRepository, MedicalHistoryService medicalHistoryService, ModelMapper modelMapper) {
        this.familiarDiseaseRepository = familiarDiseaseRepository;
        this.medicalHistoryService = medicalHistoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public FamiliarDiseaseDTO getFamiliarDisease(Long familiarDiseaseId) {
        return modelMapper.map(familiarDiseaseRepository.findById(familiarDiseaseId).get(), FamiliarDiseaseDTO.class);
    }

    @Override
    public FamiliarDiseaseDTO saveFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO) {
        FamiliarDiseaseEntity familiarDiseaseEntity = modelMapper.map(familiarDiseaseDTO, FamiliarDiseaseEntity.class);
        familiarDiseaseEntity.setMedicalHistoryEntity(modelMapper.map(medicalHistoryService.getMedicalHistory(familiarDiseaseDTO.getHistoryId()), MedicalHistoryEntity.class));
        return modelMapper.map(familiarDiseaseRepository.save(familiarDiseaseEntity), FamiliarDiseaseDTO.class);
    }

    @Override
    public boolean updateFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO) {
        FamiliarDiseaseEntity familiarDiseaseEntity = modelMapper.map(familiarDiseaseDTO, FamiliarDiseaseEntity.class);
        familiarDiseaseEntity.setMedicalHistoryEntity(modelMapper.map(medicalHistoryService.getMedicalHistory(familiarDiseaseDTO.getHistoryId()), MedicalHistoryEntity.class));
        familiarDiseaseRepository.save(familiarDiseaseEntity);
        return true;
    }

    @Override
    public boolean deleteFamiliarDisease(Long familiarDiseaseId) {
        familiarDiseaseRepository.deleteById(familiarDiseaseId);
        return true;
    }

    @Override
    public List<FamiliarDiseaseDTO> getAllFamiliarDiseases() {
        List<FamiliarDiseaseEntity> familiarDiseaseEntities = familiarDiseaseRepository.findAll();
        List<FamiliarDiseaseDTO> familiarDiseaseDTOS = new ArrayList<>();
        familiarDiseaseEntities.forEach(familiarDiseaseEntity -> {
            familiarDiseaseDTOS.add(modelMapper.map(familiarDiseaseEntity, FamiliarDiseaseDTO.class));
        });
        return familiarDiseaseDTOS;
    }

    @Override
    public List<FamiliarDiseaseDTO> getAllFamiliarDiseasesByHistoryId(Long historyId) {
        MedicalHistoryEntity medicalHistoryEntity = modelMapper.map(medicalHistoryService.getMedicalHistory(historyId), MedicalHistoryEntity.class);
        List<FamiliarDiseaseEntity> familiarDiseaseEntities = familiarDiseaseRepository.findAllByMedicalHistoryEntity(medicalHistoryEntity);
        List<FamiliarDiseaseDTO> familiarDiseaseDTOS = new ArrayList<>();
        familiarDiseaseEntities.forEach(familiarDiseaseEntity -> {
            familiarDiseaseDTOS.add(modelMapper.map(familiarDiseaseEntity, FamiliarDiseaseDTO.class));
        });
        return familiarDiseaseDTOS;
    }
}
