package co.edu.utp.isc.gia.medicalhistory.services;

import co.edu.utp.isc.gia.medicalhistory.web.dtos.DrugAllergyDTO;

import java.util.List;

public interface DrugAllergyService {
    DrugAllergyDTO getDrugAllergy(Long drugAllergyId);

    DrugAllergyDTO saveDrugAllergy(DrugAllergyDTO drugAllergyDTO);

    boolean updateDrugAllergy(DrugAllergyDTO drugAllergyDTO);

    boolean deleteDrugAllergy(Long drugAllergyId);

    List<DrugAllergyDTO> getAllDrugsAllergies();

    List<DrugAllergyDTO> getAllDrugsAllergiesByHistoryId(Long historyId);
}
