package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.MedicalHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historia-clinica")
public class MedicalHistoryController {
    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping()
    public MedicalHistoryDto get(@RequestParam("id") Long doctorId){
        return medicalHistoryService.getMedicalHistory(doctorId);
    }

    @PostMapping()
    public MedicalHistoryDto save(@RequestBody MedicalHistoryDto medicalHistoryDto){
        return medicalHistoryService.saveMedicalHistory(medicalHistoryDto);
    }

    @PutMapping()
    public boolean update(@RequestBody MedicalHistoryDto medicalHistoryDto){
        return medicalHistoryService.updateMedicalHistory(medicalHistoryDto);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam("id") Long doctorId){
        return medicalHistoryService.deleteMedicalHistory(doctorId);
    }

    @GetMapping("paciente")
    public MedicalHistoryDto getByPatientId(@RequestParam("id") Long patientId){
        return medicalHistoryService.getHistoryByPatientEntity(patientId);
    }

}
