package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.FamiliarDiseaseEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.FamiliarDiseaseRepository;
import co.edu.utp.isc.gia.medicalhistory.services.FamiliarDiseaseService;
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
    private ModelMapper modelMapper;

    public FamiliarDiseaseImpl(FamiliarDiseaseRepository familiarDiseaseRepository, ModelMapper modelMapper) {
        this.familiarDiseaseRepository = familiarDiseaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FamiliarDiseaseDTO getFamiliarDisease(Long familiarDiseaseId) {
        return modelMapper.map(familiarDiseaseRepository.findById(familiarDiseaseId).get(), FamiliarDiseaseDTO.class);
    }

    @Override
    public FamiliarDiseaseDTO saveFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO) {
        FamiliarDiseaseEntity familiarDiseaseEntity = modelMapper.map(familiarDiseaseDTO, FamiliarDiseaseEntity.class);
        return modelMapper.map(familiarDiseaseRepository.save(familiarDiseaseEntity), FamiliarDiseaseDTO.class);
    }

    @Override
    public boolean updateFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO) {
        FamiliarDiseaseEntity familiarDiseaseEntity = modelMapper.map(familiarDiseaseDTO, FamiliarDiseaseEntity.class);
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
}
