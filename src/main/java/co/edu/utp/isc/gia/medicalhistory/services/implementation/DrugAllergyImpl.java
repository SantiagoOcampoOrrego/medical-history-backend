package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DrugAllergyEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.DrugAllergyRepository;
import co.edu.utp.isc.gia.medicalhistory.services.DrugAllergyService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.DrugAllergyDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugAllergyImpl implements DrugAllergyService {

    @Autowired
    private DrugAllergyRepository drugAllergyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DrugAllergyDTO getDrugAllergy(Long drugAllergyId) {
        return modelMapper.map(drugAllergyRepository.findById(drugAllergyId).get(), DrugAllergyDTO.class);
    }

    @Override
    public DrugAllergyDTO saveDrugAllergy(DrugAllergyDTO drugAllergyDTO) {
        DrugAllergyEntity drugAllergyEntity = modelMapper.map(drugAllergyDTO, DrugAllergyEntity.class);
        return modelMapper.map(drugAllergyRepository.save(drugAllergyEntity), DrugAllergyDTO.class);
    }

    @Override
    public boolean updateDrugAllergy(DrugAllergyDTO drugAllergyDTO) {
        DrugAllergyEntity drugAllergyEntity = modelMapper.map(drugAllergyDTO, DrugAllergyEntity.class);
        modelMapper.map(drugAllergyRepository.save(drugAllergyEntity), DrugAllergyDTO.class);
        return true;
    }

    @Override
    public boolean deleteDrugAllergy(Long drugAllergyId) {
        drugAllergyRepository.deleteById(drugAllergyId);
        return true;
    }

    @Override
    public List<DrugAllergyDTO> getAllDrugsAllergies() {
        List<DrugAllergyEntity> drugAllergyEntities = drugAllergyRepository.findAll();
        List<DrugAllergyDTO> drugAllergyDTOS = new ArrayList<>();
        drugAllergyEntities.forEach(drugAllergyEntity -> {
            drugAllergyDTOS.add(modelMapper.map(drugAllergyEntity, DrugAllergyDTO.class));
        });
        return drugAllergyDTOS;
    }
}
