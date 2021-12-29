package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping()
    public PatientDto get(@RequestParam("id") Long patientId){
        return patientService.getPatient(patientId);
    }

    @PostMapping()
    public PatientDto save(@RequestBody PatientDto patientDto){
        return patientService.savePatient(patientDto);
    }

    @PutMapping()
    public boolean update(@RequestBody PatientDto patientDto){
        return patientService.updatePatient(patientDto);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam("id") Long patientId){
        return patientService.deletePatient(patientId);
    }

    @GetMapping("todos")
    public List<PatientDto> getAll(){
        return patientService.getAllPatients();
    }
}
