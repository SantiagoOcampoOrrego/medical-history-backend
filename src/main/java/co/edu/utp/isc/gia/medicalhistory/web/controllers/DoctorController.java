package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.DoctorService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public DoctorDto get(@RequestParam("id") Long doctorId){
        return doctorService.getDoctor(doctorId);
    }

    @PostMapping()
    public DoctorDto save(@RequestBody DoctorDto doctorDto){
        return doctorService.saveDoctor(doctorDto);
    }

    @PutMapping()
    public boolean update(@RequestBody DoctorDto doctorDto){
        return doctorService.updateDoctor(doctorDto);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam("id") Long doctorId){
        return doctorService.deleteDoctor(doctorId);
    }

    @GetMapping("todos")
    public List<DoctorDto> getAll(){
        return doctorService.getAllDoctors();
    }
}
