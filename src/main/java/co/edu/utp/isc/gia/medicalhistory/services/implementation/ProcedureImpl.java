package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DoctorEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureTypeEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.ProcedureRepository;
import co.edu.utp.isc.gia.medicalhistory.services.DoctorService;
import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.services.ProcedureService;
import co.edu.utp.isc.gia.medicalhistory.services.ProcedureTypeService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedureImpl implements ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @Autowired
    private ProcedureTypeService procedureTypeService;

    @Autowired
    private ModelMapper modelMapper;

    public ProcedureImpl(ProcedureRepository procedureRepository, DoctorService doctorService, MedicalHistoryService medicalHistoryService, ModelMapper modelMapper) {
        this.procedureRepository = procedureRepository;
        this.doctorService = doctorService;
        this.medicalHistoryService = medicalHistoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProcedureDTO getProcedure(Long procedureId) {
        return modelMapper.map(procedureRepository.findById(procedureId).get(), ProcedureDTO.class);
    }

    @Override
    public ProcedureDTO saveProcedure(ProcedureDTO procedureDto) {
        ProcedureEntity procedureEntity = modelMapper.map(procedureDto, ProcedureEntity.class);
        procedureEntity.setDoctorEntity(modelMapper.map(doctorService.getDoctor(procedureDto.getDoctorId()), DoctorEntity.class));
        procedureEntity.setMedicalHistoryEntity(modelMapper.map(medicalHistoryService.getMedicalHistory(procedureDto.getHistoryId()), MedicalHistoryEntity.class));
        procedureEntity.setProcedureTypeEntity(modelMapper.map(procedureTypeService.getProcedureType(procedureDto.getProcedureTypeId()), ProcedureTypeEntity.class));
        return modelMapper.map(procedureRepository.save(procedureEntity), ProcedureDTO.class);
    }

    @Override
    public boolean updateProcedure(ProcedureDTO procedureDto) {
        if(procedureRepository.existsById(procedureDto.getProcedureId())){
            procedureRepository.save(modelMapper.map(procedureDto, ProcedureEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProcedure(Long procedureId) {
        if(procedureRepository.existsById(procedureId)){
            procedureRepository.deleteById(procedureId);
            return true;
        }
        return false;
    }

    @Override
    public List<ProcedureDTO> getAllProceduresByHistoryId(Long historyId) {
        List<ProcedureDTO> procedureDTOS = new ArrayList<>();
        MedicalHistoryEntity medicalHistoryEntity = modelMapper.map(medicalHistoryService.getMedicalHistory(historyId), MedicalHistoryEntity.class);
        procedureRepository.findAllByMedicalHistoryEntity(medicalHistoryEntity).forEach(procedureEntity -> {
            procedureDTOS.add(modelMapper.map(procedureEntity, ProcedureDTO.class));
        });
        return procedureDTOS;
    }

    @Override
    public List<ProcedureDTO> getAllProceduresByDoctorId(Long doctorId) {
        List<ProcedureDTO> procedureDTOS = new ArrayList<>();
        DoctorEntity doctorEntity = modelMapper.map(doctorService.getDoctor(doctorId), DoctorEntity.class);
        procedureRepository.findAllByDoctorEntity(doctorEntity).forEach(procedureEntity -> {
            procedureDTOS.add(modelMapper.map(procedureEntity, ProcedureDTO.class));
        });
        return procedureDTOS;
    }
}
