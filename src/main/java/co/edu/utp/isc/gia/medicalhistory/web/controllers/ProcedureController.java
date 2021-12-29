package co.edu.utp.isc.gia.medicalhistory.web.controllers;

import co.edu.utp.isc.gia.medicalhistory.services.ProcedureService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("procedimiento")
public class ProcedureController {
    @Autowired
    private ProcedureService procedureService;

    @GetMapping()
    public ProcedureDto get(@RequestParam("id") Long procedureId){
        return procedureService.getProcedure(procedureId);
    }

    @PostMapping()
    public ProcedureDto save(@RequestBody ProcedureDto procedureDto){
        return procedureService.saveProcedure(procedureDto);
    }

    @PutMapping()
    public boolean update(@RequestBody ProcedureDto procedureDto){
        return procedureService.updateProcedure(procedureDto);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam("id") Long procedureId){
        return procedureService.deleteProcedure(procedureId);
    }

    @GetMapping("historia")
    public List<ProcedureDto> getAllByHistoryId(@RequestParam("id") Long historyId){
        return procedureService.getAllProceduresByHistoryId(historyId);
    }
}
