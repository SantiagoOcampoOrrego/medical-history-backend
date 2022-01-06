package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.FamiliarDiseaseService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.FamiliarDiseaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enfermedad-familiar")
public class FamiliarDiseaseController {

    @Autowired
    private FamiliarDiseaseService familiarDiseaseService;

    @GetMapping()
    public FamiliarDiseaseDTO getFamiliarDisease(@RequestParam("id") Long familiarDiseaseId){
        return familiarDiseaseService.getFamiliarDisease(familiarDiseaseId);
    }

    @PostMapping()
    public FamiliarDiseaseDTO saveFamiliarDisease(@RequestBody FamiliarDiseaseDTO familiarDiseaseDTO){
        return familiarDiseaseService.saveFamiliarDisease(familiarDiseaseDTO);
    }

    @PutMapping()
    public boolean updateFamiliarDisease(@RequestBody FamiliarDiseaseDTO familiarDiseaseDTO){
        return familiarDiseaseService.updateFamiliarDisease(familiarDiseaseDTO);
    }

    @DeleteMapping()
    public boolean deleteFamiliarDisease(@RequestParam("id") Long familiarDiseaseId){
        return familiarDiseaseService.deleteFamiliarDisease(familiarDiseaseId);
    }

    @GetMapping("todos")
    public List<FamiliarDiseaseDTO> getAllFamiliarDiseases(){
        return familiarDiseaseService.getAllFamiliarDiseases();
    }

    @GetMapping("historia")
    public List<FamiliarDiseaseDTO> getAllFamiliarDiseasesByHistoryId(@RequestParam("id") Long historyId) {
        return familiarDiseaseService.getAllFamiliarDiseasesByHistoryId(historyId);
    }

}
