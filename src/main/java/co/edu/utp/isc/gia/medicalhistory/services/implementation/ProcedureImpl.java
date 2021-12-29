package co.edu.utp.isc.gia.medicalhistory.services.implementation;

import co.edu.utp.isc.gia.medicalhistory.data.entities.DoctorEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.MedicalHistoryEntity;
import co.edu.utp.isc.gia.medicalhistory.data.entities.ProcedureEntity;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.MedicalHistoryRepository;
import co.edu.utp.isc.gia.medicalhistory.data.repositories.ProcedureRepository;
import co.edu.utp.isc.gia.medicalhistory.services.DoctorService;
import co.edu.utp.isc.gia.medicalhistory.services.MedicalHistoryService;
import co.edu.utp.isc.gia.medicalhistory.services.ProcedureService;
import co.edu.utp.isc.gia.medicalhistory.web.dtos.ProcedureDto;
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
    private ModelMapper modelMapper;

    public ProcedureImpl(ProcedureRepository procedureRepository, DoctorService doctorService, MedicalHistoryService medicalHistoryService, ModelMapper modelMapper) {
        this.procedureRepository = procedureRepository;
        this.doctorService = doctorService;
        this.medicalHistoryService = medicalHistoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProcedureDto getProcedure(Long procedureId) {
        return modelMapper.map(procedureRepository.findById(procedureId).get(), ProcedureDto.class);
    }

    @Override
    public ProcedureDto saveProcedure(ProcedureDto procedureDto) {
        ProcedureEntity procedureEntity = modelMapper.map(procedureDto, ProcedureEntity.class);
        procedureEntity.setDoctorEntity(modelMapper.map(doctorService.getDoctor(procedureDto.getDoctorId()), DoctorEntity.class));
        procedureEntity.setMedicalHistoryEntity(modelMapper.map(medicalHistoryService.getMedicalHistory(procedureDto.getHistoryId()), MedicalHistoryEntity.class));
        return modelMapper.map(procedureRepository.save(procedureEntity), ProcedureDto.class);
    }

    @Override
    public boolean updateProcedure(ProcedureDto procedureDto) {
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
    public List<ProcedureDto> getAllProceduresByHistoryId(Long historyId) {
        List<ProcedureDto> procedureDtos = new ArrayList<>();
        MedicalHistoryEntity medicalHistoryEntity = modelMapper.map(medicalHistoryService.getMedicalHistory(historyId), MedicalHistoryEntity.class);
        procedureRepository.findAllByMedicalHistoryEntity(medicalHistoryEntity).forEach(procedureEntity -> {
            procedureDtos.add(modelMapper.map(procedureEntity, ProcedureDto.class));
        });
        return procedureDtos;
    }
}
