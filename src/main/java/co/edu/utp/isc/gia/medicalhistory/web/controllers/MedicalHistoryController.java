package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historia-clinica")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping()
    public MedicalHistoryDTO getMedicalHistory(@RequestParam("id") Long doctorId){
        return medicalHistoryService.getMedicalHistory(doctorId);
    }

    @PostMapping()
    public MedicalHistoryDTO saveMedicalHistory(@RequestBody MedicalHistoryDTO medicalHistoryDto){
        return medicalHistoryService.saveMedicalHistory(medicalHistoryDto);
    }

    @PutMapping()
    public boolean updateMedicalHistory(@RequestBody MedicalHistoryDTO medicalHistoryDto){
        return medicalHistoryService.updateMedicalHistory(medicalHistoryDto);
    }

    @DeleteMapping()
    public boolean deleteMedicalHistory(@RequestParam("id") Long doctorId){
        return medicalHistoryService.deleteMedicalHistory(doctorId);
    }

    @GetMapping("paciente")
    public MedicalHistoryDTO getByPatientId(@RequestParam("id") Long patientId){
        return medicalHistoryService.getHistoryByPatientEntity(patientId);
    }

}
