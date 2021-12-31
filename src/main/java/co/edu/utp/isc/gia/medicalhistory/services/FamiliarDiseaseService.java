package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.FamiliarDiseaseDTO;

import java.util.List;

public interface FamiliarDiseaseService {
    FamiliarDiseaseDTO getFamiliarDisease(Long familiarDiseaseId);

    FamiliarDiseaseDTO saveFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO);

    boolean updateFamiliarDisease(FamiliarDiseaseDTO familiarDiseaseDTO);

    boolean deleteFamiliarDisease(Long familiarDiseaseId);

    List<FamiliarDiseaseDTO> getAllFamiliarDiseases();
}
