package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.ProcedureService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("procedimiento")
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;

    @GetMapping()
    public ProcedureDTO getProcedure(@RequestParam("id") Long procedureId){
        return procedureService.getProcedure(procedureId);
    }

    @PostMapping()
    public ProcedureDTO saveProcedure(@RequestBody ProcedureDTO procedureDto){
        return procedureService.saveProcedure(procedureDto);
    }

    @PutMapping()
    public boolean updateProcedure(@RequestBody ProcedureDTO procedureDto){
        return procedureService.updateProcedure(procedureDto);
    }

    @DeleteMapping()
    public boolean deleteProcedure(@RequestParam("id") Long procedureId){
        return procedureService.deleteProcedure(procedureId);
    }

    @GetMapping("historia")
    public List<ProcedureDTO> getAllProceduresByHistoryId(@RequestParam("id") Long historyId){
        return procedureService.getAllProceduresByHistoryId(historyId);
    }
}
