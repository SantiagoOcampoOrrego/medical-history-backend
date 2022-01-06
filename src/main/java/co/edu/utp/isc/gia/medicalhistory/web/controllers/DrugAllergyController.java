package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.DrugAllergyService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.DrugAllergyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicamento-alergia")
public class DrugAllergyController {

    @Autowired
    private DrugAllergyService drugAllergyService;

    @GetMapping()
    public DrugAllergyDTO getDrugAllergy(@RequestParam("id") Long drugAllergyId){
        return drugAllergyService.getDrugAllergy(drugAllergyId);
    }

    @PostMapping()
    public DrugAllergyDTO saveDrugAllergy(@RequestBody DrugAllergyDTO drugAllergyDTO){
        return drugAllergyService.saveDrugAllergy(drugAllergyDTO);
    }

    @PutMapping()
    public boolean updateDrugAllergy(@RequestBody DrugAllergyDTO drugAllergyDTO){
        return drugAllergyService.updateDrugAllergy(drugAllergyDTO);
    }

    @DeleteMapping()
    public boolean deleteDrugAllergy(@RequestParam("id") Long drugAllergyId){
        return drugAllergyService.deleteDrugAllergy(drugAllergyId);
    }

    @GetMapping("todos")
    public List<DrugAllergyDTO> getAllDrugsAllergies(){
        return drugAllergyService.getAllDrugsAllergies();
    }

    @GetMapping("historia")
    public List<DrugAllergyDTO> getAllDrugAllergiesByHistoryId(@RequestParam("id") Long historyId) {
        return drugAllergyService.getAllDrugsAllergiesByHistoryId(historyId);
    }

}
