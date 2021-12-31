package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.ProcedureTypeService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tipo-procedimiento")
public class ProcedureTypeController {

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @GetMapping()
    public ProcedureTypeDTO getProcedureType(@RequestParam("id") Long typeId){
        return procedureTypeService.getProcedureType(typeId);
    }

    @PostMapping()
    public ProcedureTypeDTO saveProcedureType(@RequestBody ProcedureTypeDTO procedureTypeDTO){
        return procedureTypeService.saveProcedureType(procedureTypeDTO);
    }

    @PutMapping()
    public boolean updateProcedureType(@RequestBody ProcedureTypeDTO procedureTypeDTO){
        return procedureTypeService.updateProcedureType(procedureTypeDTO);
    }

    @DeleteMapping()
    public boolean deleteProcedureType(@RequestParam("id") Long typeId){
        return procedureTypeService.deleteProcedureType(typeId);
    }

    @GetMapping("todos")
    public List<ProcedureTypeDTO> getAllProcedureTypes(){
        return procedureTypeService.getAllProcedureTypes();
    }

}
