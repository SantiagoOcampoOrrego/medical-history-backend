package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.PatientService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping()
    public PatientDTO getPatient(@RequestParam("id") Long patientId){
        return patientService.getPatient(patientId);
    }

    @PostMapping()
    public PatientDTO savePatient(@RequestBody PatientDTO patientDto){
        return patientService.savePatient(patientDto);
    }

    @PutMapping()
    public boolean updatePatient(@RequestBody PatientDTO patientDto){
        return patientService.updatePatient(patientDto);
    }

    @DeleteMapping()
    public boolean deletePatient(@RequestParam("id") Long patientId){
        return patientService.deletePatient(patientId);
    }

    @GetMapping("todos")
    public List<PatientDTO> getAllPatients(){
        return patientService.getAllPatients();
    }
}
