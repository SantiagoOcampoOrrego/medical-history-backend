package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureTypeEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.ProcedureTypeRepository;
import co.edu.utp.isc.gia.medicalhistory.services.ProcedureTypeService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedureTypeImpl implements ProcedureTypeService {

    @Autowired
    private ProcedureTypeRepository procedureTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProcedureTypeDTO getProcedureType(Long typeId) {
        return modelMapper.map(procedureTypeRepository.findById(typeId).get(), ProcedureTypeDTO.class);
    }

    @Override
    public ProcedureTypeDTO saveProcedureType(ProcedureTypeDTO procedureTypeDTO) {
        ProcedureTypeEntity procedureTypeEntity = modelMapper.map(procedureTypeDTO, ProcedureTypeEntity.class);
        return modelMapper.map(procedureTypeRepository.save(procedureTypeEntity), ProcedureTypeDTO.class);
    }

    @Override
    public boolean updateProcedureType(ProcedureTypeDTO procedureTypeDTO) {
        ProcedureTypeEntity procedureTypeEntity = modelMapper.map(procedureTypeDTO, ProcedureTypeEntity.class);
        modelMapper.map(procedureTypeRepository.save(procedureTypeEntity), ProcedureTypeDTO.class);
        return true;
    }

    @Override
    public boolean deleteProcedureType(Long typeId) {
        procedureTypeRepository.deleteById(typeId);
        return true;
    }

    @Override
    public List<ProcedureTypeDTO> getAllProcedureTypes() {
        List<ProcedureTypeEntity> procedureTypeEntities = procedureTypeRepository.findAll();
        List<ProcedureTypeDTO> procedureTypeDTOS = new ArrayList<>();

        procedureTypeEntities.forEach(procedureTypeEntity -> {
            procedureTypeDTOS.add(modelMapper.map(procedureTypeEntity, ProcedureTypeDTO.class));
        });

        return procedureTypeDTOS;
    }
}
