package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.DoctorService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public DoctorDTO getDoctor(@RequestParam("id") Long doctorId){
        return doctorService.getDoctor(doctorId);
    }

    @PostMapping()
    public DoctorDTO saveDoctor(@RequestBody DoctorDTO doctorDto){
        return doctorService.saveDoctor(doctorDto);
    }

    @PutMapping()
    public boolean updateDoctor(@RequestBody DoctorDTO doctorDto){
        return doctorService.updateDoctor(doctorDto);
    }

    @DeleteMapping()
    public boolean deleteDoctor(@RequestParam("id") Long doctorId){
        return doctorService.deleteDoctor(doctorId);
    }

    @GetMapping("todos")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
}
